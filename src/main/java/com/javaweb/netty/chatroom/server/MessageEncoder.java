package com.javaweb.netty.chatroom.server;

import com.javaweb.netty.chatroom.Message;
import com.javaweb.netty.chatroom.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName MessageEncoder
 * @Description TODO
 * @Author YuKai Fan
 * @Date 2019/8/20 22:57
 * @Version 1.0
 **/
public class MessageEncoder extends MessageToByteEncoder<Message> {
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        ByteBuf buffer = channelHandlerContext.alloc().buffer();
        String content = Utils.encodeMsg(message);
        buffer.writeBytes(content.getBytes(StandardCharsets.UTF_8));

        channelHandlerContext.writeAndFlush(buffer);
    }
}
