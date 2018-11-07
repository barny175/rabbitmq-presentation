package com.certicon.barny.presentation.rabbitmq.helloworld

import com.certicon.barny.presentation.rabbitmq.newConnection

fun main(args: Array<String>) {
    val connection = newConnection()
    val channel = connection.createChannel()
    val count:Int = messageCount(args)
    (1..count).forEach {
        channel.basicPublish("", "greeting", null, "hello world $it".toByteArray())
    }
    channel.close()
    connection.close()
}

private fun messageCount(args: Array<String>) = if (args.size > 0) args[0].toInt() else 1

