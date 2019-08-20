package com.javaweb.netty.chatroom.client;

import com.javaweb.netty.chatroom.Message;
import com.javaweb.netty.chatroom.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @ClassName ClientTransferMsgHandler
 * @Description TODO
 * @Author YuKai Fan
 * @Date 2019/8/20 23:07
 * @Version 1.0
 **/
public class ClientTransferMsgHandler extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list) throws Exception {
        byte[] buff = new byte[2024];
        int length = in.readableBytes();
        in.readBytes(buff, 0, length);

        String totalMsg = new String(buff, 0, length, StandardCharsets.UTF_8);
        String[] content = totalMsg.split(":::");
        list.add(new Message(content[0], Utils.parseDateTime(content[1]), content[2]));
    }
}
