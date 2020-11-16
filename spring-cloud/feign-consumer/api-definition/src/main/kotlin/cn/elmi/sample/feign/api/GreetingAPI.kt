package cn.elmi.sample.feign.api

import cn.elmi.sample.feign.cmd.GreetingCommand
import cn.elmi.sample.feign.service.RpcService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class GreetingAPI(
    private val rpcService: RpcService
) {

    @PostMapping("hello")
    fun hello(@RequestBody cmd: GreetingCommand): String {

        return rpcService.hello(cmd)
    }
}