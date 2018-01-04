package cn.myth.MoodBlog.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class DiscardServerHandler extends ChannelHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("read start~~~!!!");
        //do something msg  
        ByteBuf buf = (ByteBuf)msg;  
        byte[] data = new byte[buf.readableBytes()];  
        buf.readBytes(data);  
        String request = new String(data, "utf-8");  
        System.out.println("Server: " + request);  
        //Ð´¸ø¿Í»§¶Ë  
        ctx.writeAndFlush(Unpooled.copiedBuffer("888".getBytes()));  
        //.addListener(ChannelFutureListener.CLOSE); 
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		super.channelReadComplete(ctx);
		System.out.println("read complete~~~!!!");
	}
	
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        cause.printStackTrace();  
        ctx.close();  
    } 
}
