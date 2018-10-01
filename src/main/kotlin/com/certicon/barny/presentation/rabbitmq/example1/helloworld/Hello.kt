package com.certicon.barny.presentation.rabbitmq.example1.helloworld

fun main(args: Array<String>) {
    val conn = newConnection()
    val channel = conn.createChannel()
    channel.basicPublish("", "greeting", null, "hi world".toByteArray())
    channel.close()
    conn.close()
}

