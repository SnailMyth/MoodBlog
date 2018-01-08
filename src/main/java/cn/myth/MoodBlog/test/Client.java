package cn.myth.MoodBlog.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class Client {
	private int port;
	private String host;

	public Client(int port, String host) {
		this.port = port;
		this.host = host;
	}

	public void run() throws InterruptedException {
		EventLoopGroup worker = new NioEventLoopGroup();

		Bootstrap server = new Bootstrap();
		server.group(worker).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel socketChannel) throws Exception {
				socketChannel.pipeline().addLast(new ClientHandler(), new ObjectEncoder(), new ObjectDecoder(
						1024 * 1024, ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));

			}

		}).option(ChannelOption.TCP_NODELAY, true).option(ChannelOption.SO_KEEPALIVE, true);
		ChannelFuture future = server.connect(host, port).sync();
		future.channel().closeFuture().sync();
		
	}

	public static void main(String[] args) {
		try {
			new Client(8379,"127.0.0.1").run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
