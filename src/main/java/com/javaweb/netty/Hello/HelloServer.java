package com.javaweb.netty.Hello;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName HelloServer
 * @Description 基于主从线程组线程模型的Netty
 * @Author YuKai Fan
 * @Date 2019/8/21 20:58
 * @Version 1.0
 **/
public class HelloServer {

    public static void main(String[] args) throws InterruptedException {

        //定义一对线程组
        //主线程组, 用于接收客户端的连接，但是不做任何处理
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //从线程组, 主线程组会把业务丢给从线程组，做任务
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            //netty服务器的创建, ServerBootstrap服务端启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //设置主从线程组
            serverBootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class) //设置主从线程组后会产生channel通道, 并设置channel类型
                    .childHandler(new HelloServerInitializer()); // 针对从线程组 处理workGroup的任务

            //启动server，并设置端口号，同时启动方式为同步
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();

            //监听关闭的channel，设置为同步的方式
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
