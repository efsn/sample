package cn.elmi.sample.netty.chat

import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.channel.group.ChannelGroup
import io.netty.channel.group.DefaultChannelGroup
import io.netty.util.concurrent.GlobalEventExecutor
import java.util.function.Consumer

/**
 * @version 1.0
 * @authur Arthur
 */
class ChatServerHandler : SimpleChannelInboundHandler<String>() {
    @Throws(Exception::class)
    override fun channelRead0(ctx: ChannelHandlerContext, msg: String) {
        val channel = ctx.channel()
        channelGroup.forEach(Consumer { c: Channel ->
            c.writeAndFlush(
                """
    ${if (c !== channel) channel.remoteAddress().toString() + " send message:" + msg else "[self]$msg"}.
    
    """.trimIndent()
            )
        })
    }

    @Throws(Exception::class)
    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        super.exceptionCaught(ctx, cause)
        ctx.close()
    }

    @Throws(Exception::class)
    override fun handlerAdded(ctx: ChannelHandlerContext) {
        val channel = ctx.channel()
        channelGroup.writeAndFlush(
            """[Server] - ${channel.remoteAddress()} added.
"""
        )
        channelGroup.add(channel)
    }

    @Throws(Exception::class)
    override fun handlerRemoved(ctx: ChannelHandlerContext) {
        val channel = ctx.channel()
        channelGroup.writeAndFlush(
            """[Server] - ${channel.remoteAddress()} leaved.
"""
        )
    }

    @Throws(Exception::class)
    override fun channelActive(ctx: ChannelHandlerContext) {
        val channel = ctx.channel()
        println(channel.remoteAddress().toString() + " online.")
    }

    @Throws(Exception::class)
    override fun channelInactive(ctx: ChannelHandlerContext) {
        val channel = ctx.channel()
        println(channel.remoteAddress().toString() + " offline.")
    }

    companion object {
        private val channelGroup: ChannelGroup = DefaultChannelGroup(GlobalEventExecutor.INSTANCE)
    }
}