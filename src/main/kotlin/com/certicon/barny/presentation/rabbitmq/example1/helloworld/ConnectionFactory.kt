package com.certicon.barny.presentation.rabbitmq.example1.helloworld

import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory

fun newConnection(): Connection {
    val cf = ConnectionFactory()
    cf.host = "localhost"
    cf.port = 5672
    cf.username = "barny"
    cf.password = "heslo"
    cf.virtualHost = "sample"
    return cf.newConnection()
}