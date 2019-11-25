package cn.elmi.sample.feign.service

import cn.elmi.sample.feign.cmd.GreetingCommand
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient("sample-feign", fallback = RpcServiceImpl::class)
interface RpcService {
    @GetMapping("/rpc/hello")
    fun hello(@RequestBody cmd: GreetingCommand): String
}

@Service
class RpcServiceImpl : RpcService {
    override fun hello(cmd: GreetingCommand): String {
        return "error"
    }
}