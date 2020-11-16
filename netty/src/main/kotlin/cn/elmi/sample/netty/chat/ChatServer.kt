package cn.elmi.sample.netty.chat

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel

/**
 * @version 1.0
 * @authur Arthur
 */
object ChatServer {
    @JvmStatic
    fun main(args: Array<String>) {
        val bossGroup: EventLoopGroup = NioEventLoopGroup()
        val workerGroup: EventLoopGroup = NioEventLoopGroup()
        try {
            val serverBootstrap = ServerBootstrap()
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel::class.java)
                .childHandler(ChatServerInitializer())
            val channelFuture = serverBootstrap.bind(8800).sync()
            channelFuture.channel().closeFuture().sync()
        } catch (e: Exception) {
//            log.error(e.message)
        } finally {
            bossGroup.shutdownGracefully()
            workerGroup.shutdownGracefully()
        }
    }
}