package cn.myth.MoodBlog.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiscardServer {
	private int port;

	public DiscardServer(int port) {
		this.port = port;
	}

	public void run() {
		EventLoopGroup bossGroup = new NioEventLoopGroup();// ���ڴ���������˽��տͻ�������
		EventLoopGroup workerGroup = new NioEventLoopGroup();// ��������ͨ�ţ���д��
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							socketChannel.pipeline().addLast(new DiscardServerHandler());

						}
					}).option(ChannelOption.SO_BACKLOG, 128) // ����TCP������
					.option(ChannelOption.SO_SNDBUF, 32 * 1024) // ���÷������ݻ����С
					.option(ChannelOption.SO_RCVBUF, 32 * 1024) // ���ý������ݻ����С
					.childOption(ChannelOption.SO_KEEPALIVE, true); // ��������

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
		new DiscardServer(8379).run();
	}
}
