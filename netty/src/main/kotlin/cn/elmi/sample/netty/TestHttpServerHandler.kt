package cn.elmi.sample.netty

import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.*
import io.netty.util.CharsetUtil

/**
 * @version 1.0
 * @authur Arthur
 */
class TestHttpServerHandler : SimpleChannelInboundHandler<HttpObject?>() {
    @Throws(Exception::class)
    override fun channelRead0(ctx: ChannelHandlerContext, msg: HttpObject?) {
//        log.debug("TestHttpServerHandler.channelRead0")
        if (msg is HttpRequest) {
//            log.debug("TestHttpServerHandler.channelRead0 -> httprequest")
            val content = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8)
            val response: FullHttpResponse = DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content)
            response.headers()[HttpHeaderNames.CONTENT_TYPE] = "text/plain"
            response.headers()[HttpHeaderNames.CONTENT_LENGTH] = content.readableBytes()
            ctx.writeAndFlush(response)
        }
    }
}