package com.certicon.barny.presentation.rabbitmq.atleastonce

import com.certicon.barny.presentation.rabbitmq.newConnection
import com.rabbitmq.client.AMQP
import com.rabbitmq.client.BuiltinExchangeType
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope

fun main(args: Array<String>) {
    val conn = newConnection()
    val channel = conn.createChannel()
    val exchange = "scheduling-request"
    val queue = "scheduling-request"
    val routingKey = queue

    channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT)
    channel.queueDeclare(queue, false, false, false, null)
    channel.queueBind(queue, exchange, routingKey)
    channel.basicConsume(queue, false, object : DefaultConsumer(channel) {
        override fun handleDelivery(consumerTag: String, envelope: Envelope, properties: AMQP.BasicProperties, body: ByteArray) {
            println("Processing ${String(body)}")
            (1..10).forEach {
                print('.')
                Thread.sleep(1_000)
            }

            println("Done ${String(body)}")

            channel.basicAck(envelope.deliveryTag, false)
        }
    })
}