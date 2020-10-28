package cn.elmi.sample.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = Channel<Int>()

    launch {
        for (i in 1..10) channel.send(i)
    }

    for (j in channel) println(j)
}

fun CoroutineScope.produceNumber() = produce<Int> {
    var x = 0
    while (true) send(x++)
}