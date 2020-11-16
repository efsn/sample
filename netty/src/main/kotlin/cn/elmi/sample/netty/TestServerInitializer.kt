package cn.elmi.sample.netty

import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.http.HttpServerCodec

/**
 * @version 1.0
 * @authur Arthur
 */
class TestServerInitializer : ChannelInitializer<SocketChannel>() {
    @Throws(Exception::class)
    override fun initChannel(ch: SocketChannel) {
//        log.debug("TestServerInitializer.initChannel")
        val pipeline = ch.pipeline()
        pipeline.addLast("http-server-codec", HttpServerCodec())
    }
}