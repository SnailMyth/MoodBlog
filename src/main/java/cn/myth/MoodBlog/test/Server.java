package cn.myth.MoodBlog.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
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
					.childHandler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							socketChannel.pipeline().addLast(new ServerHandler());
						}
					}).option(ChannelOption.SO_BACKLOG, 128) // 设置TCP缓冲区
					.option(ChannelOption.SO_SNDBUF, 32 * 1024) // 设置发送数据缓冲大小
					.option(ChannelOption.SO_RCVBUF, 32 * 1024) // 设置接受数据缓冲大小
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
