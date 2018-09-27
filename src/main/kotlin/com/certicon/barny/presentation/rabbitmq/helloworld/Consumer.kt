package com.certicon.barny.presentation.rabbitmq.helloworld

import com.rabbitmq.client.AMQP
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope

fun main(args: Array<String>) {
    val conn = newConnection()
    val channel = conn.createChannel()
    channel.queueDeclare("greetings", false, false, false, null)
    channel.basicConsume("greetings", object : DefaultConsumer(channel) {
        override fun handleDelivery(consumerTag: String, envelope: Envelope, properties: AMQP.BasicProperties, body: ByteArray) {
            println(String(body))
        }
    })
}