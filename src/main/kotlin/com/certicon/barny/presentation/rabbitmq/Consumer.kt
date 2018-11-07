package com.certicon.barny.presentation.rabbitmq

import com.rabbitmq.client.AMQP
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope

fun main(args: Array<String>) {
    val conn = newConnection()
    val channel = conn.createChannel()
    val exchange = args[0]
    val type = args[1]
    val queue = args[2]
    val routingKey = args[3]

    channel.exchangeDeclare(exchange, type)
    channel.queueDeclare(queue, false, false, false, null)
    channel.queueBind(queue, exchange, routingKey)
    channel.basicConsume(queue, false, object : DefaultConsumer(channel) {
        override fun handleDelivery(consumerTag: String, envelope: Envelope, properties: AMQP.BasicProperties, body: ByteArray) {
            println("$queue: ${String(body)}")
            channel.basicAck(envelope.deliveryTag, false)
        }
    })
}