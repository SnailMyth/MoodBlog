package cn.myth.MoodBlog.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {
	private int port;

	public Server(int port) {
		this.port = port;
	}

	public void run() {
		EventLoopGroup bossGroup = new NioEventLoopGroup();// 用于处理服务器端接收客户端连接
		EventLoopGroup workerGroup = new NioEventLoopGroup();// 进行网络通信（读写）
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChildChannelHandler())
					.option(ChannelOption.TCP_NODELAY, true) // 保持连接
			.childOption(ChannelOption.SO_KEEPALIVE, true); // 保持连接

			ChannelFuture future = b.bind(port).sync();
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}

	}

	public static void main(String[] args) {
		new Server(8379).run();
	}
}
