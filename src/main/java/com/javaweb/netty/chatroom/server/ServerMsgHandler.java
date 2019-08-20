package com.javaweb.netty.chatroom.server;

import com.javaweb.netty.chatroom.Message;
import com.javaweb.netty.chatroom.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName ServerMsgHandler
 * @Description TODO
 * @Author YuKai Fan
 * @Date 2019/8/20 22:38
 * @Version 1.0
 **/
public class ServerMsgHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("jsbintask-client进入聊天室");

        Message message = new Message("server", new Date(), "Hello, I'm YuKai Fan");
        ByteBuf buffer = ctx.alloc().buffer();
        String content = Utils.encodeMsg(message);
        buffer.writeBytes(content.getBytes());

        ctx.writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            Message message = (Message) msg;
            Utils.printMsg(message);
            Scanner scanner = new Scanner(System.in);
            System.out.println("server, please input msg: ");
            String reply = scanner.nextLine();

            Message message1 = new Message("server", new Date(), reply);
            ctx.writeAndFlush(message1);
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
