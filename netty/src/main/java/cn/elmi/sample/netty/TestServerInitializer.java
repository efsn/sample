package cn.elmi.sample.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.0
 * @authur Arthur
 */
@Slf4j
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        log.debug("TestServerInitializer.initChannel");
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("http-server-codec", new HttpServerCodec());

    }

}
