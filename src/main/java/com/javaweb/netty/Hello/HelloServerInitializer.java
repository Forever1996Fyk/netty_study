package com.javaweb.netty.Hello;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @ClassName HelloServerInitializer
 * @Description 初始化器，channel注册后，会执行里面的相应的初始化方法
 * @Author YuKai Fan
 * @Date 2019/8/21 21:14
 * @Version 1.0
 **/

public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //通过SocketChannel获取管道
        ChannelPipeline pipeline = socketChannel.pipeline();
        //添加一个handler，并处理http请求与响应的编解码
        //HttpServerCodec是netty自己提供的助手类
        //当请求到服务端，我们需要做编解码，响应到客户端做编码
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());

        //添加自定义助手类，返回hello netty~
        pipeline.addLast("customHandler", new CustomHandler());
    }
}
