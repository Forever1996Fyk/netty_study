package com.javaweb.netty.chatroom.server;

import com.javaweb.netty.chatroom.Message;
import com.javaweb.netty.chatroom.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @ClassName ServerTransferMsgHandler
 * @Description 处理输入消息的handler
 * @Author YuKai Fan
 * @Date 2019/8/20 22:36
 * @Version 1.0
 **/
public class ServerTransferMsgHandler extends ByteToMessageDecoder {
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        String totalMsg = byteBuf.readCharSequence(byteBuf.readableBytes(), Charset.forName("UTF-8")).toString();
        String[] content = totalMsg.split(":::");
        list.add(new Message(content[0], Utils.parseDateTime(content[1]), content[2]));
    }
}
