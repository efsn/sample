package cn.elmi.sample.reactor

import reactor.core.publisher.Hooks
import reactor.core.publisher.Mono

class Demo

fun main() {
    Hooks.onOperatorDebug()

    // Map flow
    val x = Mono.just("abc")
        .filter { it.matches("a.*".toRegex()) }
//        .filterWhen { Mono.just(it.matches("a.*".toRegex())) }
        .map { it + "d" }
//        .transform {  }
//        .publishOn()
        .log("DEMO-X")
        .subscribe { println(it) }

    val y = Mono.just("abc")
        .filter { it.matches("a.*".toRegex()) }
        .flatMap { Mono.just(it + "d") }
        .log("DEMO-Y")
        .subscribe { println(it) }


}