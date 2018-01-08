package cn.myth.MoodBlog.test;

import java.util.Date;

import cn.myth.MoodBlog.utils.DateFormat;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelHandlerAdapter{
	private int count = 0;
	
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("connect success!");
		TestRequest req = getRequest();
		ctx.writeAndFlush(req);
		
		Thread.sleep(3000);
		TestRequest req2= getRequest();
		ctx.writeAndFlush(req2);
		
		
	}




	private TestRequest getRequest() {
		TestRequest req = new TestRequest();
		req.setId((count++) + "");
		String str = DateFormat.FORMAT_FULL_CN.format(new Date());
		str += Thread.currentThread().getName() + Thread.currentThread().getId();
		req.setMsg(str);
		return req;
	}
	
	
	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		if(msg instanceof TestResponse) {
			try {
				TestResponse rep = (TestResponse) msg;
				System.out.println(rep);
			} finally {
				ReferenceCountUtil.release(msg);
			}
		}else{
			System.out.println("client decode fail");
		}
		
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		super.exceptionCaught(ctx, cause);
		ctx.close();
	}
}
