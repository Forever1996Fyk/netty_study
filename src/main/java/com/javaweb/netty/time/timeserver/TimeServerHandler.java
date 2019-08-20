package com.javaweb.netty.time.timeserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TimeServerHandler
 * @Description TODO
 * @Author YuKai Fan
 * @Date 2019/8/20 22:22
 * @Version 1.0
 **/
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf timeBuf = ctx.alloc().buffer();
        timeBuf.writeBytes(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).getBytes());

        final ChannelFuture channelFuture = ctx.writeAndFlush(timeBuf);
        channelFuture.addListener(new GenericFutureListener<Future<? super Void>>() {
            public void operationComplete(Future<? super Void> future) throws Exception {
                assert channelFuture == future;
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        ctx.close();
    }
}
