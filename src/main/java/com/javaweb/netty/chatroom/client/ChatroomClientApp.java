package com.javaweb.netty.chatroom.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName ChatroomClientApp
 * @Description TODO
 * @Author YuKai Fan
 * @Date 2019/8/20 23:08
 * @Version 1.0
 **/
public class ChatroomClientApp {
    public static void main(String[] args) {
        NioEventLoopGroup workGroup = new NioEventLoopGroup();


        try {
            Bootstrap clientBootStrap = new Bootstrap();
            clientBootStrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new ClientTransferMsgHandler(), new ClientMsgHandler());
                        }
                    })
                    .option(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture channelFuture = clientBootStrap.connect("localhost", 8888).sync();

            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }
}
