package com.certicon.barny.presentation.rabbitmq

fun main(args: Array<String>) {
    val connection = newConnection()
    val channel = connection.createChannel()
    val exchange = args[0]
    val routingKey = args[1]
    val msg = args[2]
    channel.basicPublish(exchange, routingKey, null, msg.toByteArray())
    channel.close()
    connection.close()
}