package cn.elmi.sample.netty.chat

import io.netty.bootstrap.Bootstrap
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @version 1.0
 * @authur Arthur
 */
object ChatClient {
    @JvmStatic
    fun main(args: Array<String>) {
        val group: EventLoopGroup = NioEventLoopGroup()
        try {
            val bootstrap = Bootstrap().group(group)
                .channel(NioSocketChannel::class.java)
                .handler(ChatClientInitializer())
            val channel = bootstrap.connect("localhost", 8800).sync().channel()
            val `in` = BufferedReader(InputStreamReader(System.`in`))
            while (true) {
                channel.writeAndFlush(
                    """
    ${`in`.readLine()}
    
    """.trimIndent()
                )
            }


//            channelFuture.channel().closeFuture().sync();
        } catch (e: Exception) {
//            log.error(e.message)
        } finally {
            group.shutdownGracefully()
        }
    }
}