package com.certicon.barny.presentation.rabbitmq.helloworld

fun main(args: Array<String>) {
    val conn = newConnection()
    val channel = conn.createChannel()
    (1..10).forEach {
        channel.basicPublish("", "greeting", null, "hello world $it".toByteArray())
    }
    channel.close()
    conn.close()
}

