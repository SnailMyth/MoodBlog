package cn.myth.MoodBlog.test;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		socketChannel.pipeline().addLast(new ServerHandler(), new ObjectEncoder(), new ObjectDecoder(1024 * 1024,
				ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
	}

}
