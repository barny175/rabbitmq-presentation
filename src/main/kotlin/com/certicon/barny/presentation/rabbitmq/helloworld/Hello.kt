package com.certicon.barny.presentation.rabbitmq.helloworld

fun main(args: Array<String>) {
    val conn = newConnection()
    val channel = conn.createChannel()
    channel.basicPublish("", "greeting", null, "hello".toByteArray())
}

