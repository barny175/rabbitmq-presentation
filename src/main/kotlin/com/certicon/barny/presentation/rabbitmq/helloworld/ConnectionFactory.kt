package com.certicon.barny.presentation.rabbitmq.helloworld

import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory

fun newConnection(): Connection {
    val cf = ConnectionFactory()
    cf.host = "localhost"
    cf.port = 5672
    cf.username = "kralik"
    cf.password = "nasmetane"
    cf.virtualHost = "/"
    return cf.newConnection()
}