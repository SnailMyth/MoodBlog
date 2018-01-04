package cn.myth.MoodBlog.test;

import java.util.Date;

import cn.myth.MoodBlog.utils.DateFormat;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler extends ChannelHandlerAdapter {
	private ByteBuf buf;
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		buf = ctx.alloc().buffer(20);
	}
	
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		buf.release();
		buf = null;
	}
	
	//读操作
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("ServerHandler read start~~~!!!");
        ByteBuf b = (ByteBuf)msg;
        buf.writeBytes(b);
        b.release();
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		super.channelReadComplete(ctx);
		System.out.println("ServerHandler read complete~~~!!!");
	}
	
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        cause.printStackTrace();  
        ctx.close();  
    } 
    
    //连接被建立并且准备进行通信时被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	System.out.println("ServerHandler channel active read:" + DateFormat.FORMAT_LONG_CN.format(new Date()));
    }
}
