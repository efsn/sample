package cn.elmi.sample.netty.chat

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler

/**
 * @version 1.0
 * @authur Arthur
 */
class ChatClientHandler : SimpleChannelInboundHandler<String?>() {
    @Throws(Exception::class)
    override fun channelRead0(ctx: ChannelHandlerContext, msg: String?) {
        println(msg)
    }
}