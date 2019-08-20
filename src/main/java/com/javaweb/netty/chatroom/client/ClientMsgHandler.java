package com.javaweb.netty.chatroom.client;

import com.javaweb.netty.chatroom.Message;
import com.javaweb.netty.chatroom.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName ClientMsgHandler
 * @Description TODO
 * @Author YuKai Fan
 * @Date 2019/8/20 23:04
 * @Version 1.0
 **/
public class ClientMsgHandler extends SimpleChannelInboundHandler<Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Message message) throws Exception {


        try {
            Utils.printMsg(message);
            Scanner scanner = new Scanner(System.in);
            System.out.println("client, please input msg: ");
            String reply = scanner.nextLine();

            Message message1 = new Message("client", new Date(), reply);
            ByteBuf buffer = channelHandlerContext.alloc().buffer();
            String content = message1.getUserName() + ":::" + Utils.formatDateTime(message1.getSentTime()) + ":::" + message1.getMsg();
            buffer.writeBytes(content.getBytes(StandardCharsets.UTF_8));
            channelHandlerContext.writeAndFlush(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(message);
        }
    }
}
