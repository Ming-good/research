package org.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf in = (ByteBuf) msg;
        StringBuffer buffer = new StringBuffer();
        buffer.append(in.toString(Charset.forName("UTF-8")));

        ByteBuf resBuf = ctx.alloc().buffer();

        try {
            System.out.println(buffer.toString());
            resBuf.writeBytes("그래.. 반갑구나..   \n".getBytes(StandardCharsets.UTF_8));
            ctx.writeAndFlush(resBuf);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}