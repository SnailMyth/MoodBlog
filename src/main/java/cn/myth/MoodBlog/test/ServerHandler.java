package cn.myth.MoodBlog.test;

import java.util.Date;

import cn.myth.MoodBlog.utils.DateFormat;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler extends ChannelHandlerAdapter {
	private int count = 0;
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
	}
	
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
	}
	
	//读操作
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		count++;
		TestResponse rep = new TestResponse(String.valueOf(count));
		if (msg instanceof TestRequest) {
			System.out.println("server get:" + msg);
			rep.setRep("get str success!");
		}else {
			System.out.println("decode to request fail");
			rep.setRep("decode fail!");
		}

		ChannelFuture f = ctx.writeAndFlush(rep);
		f.addListener(new ChannelFutureListener() {
			
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				System.out.println("server respond back over!");
			}
		});
		
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
