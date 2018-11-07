set exchange=%1
set routingKey=%2
set msg=%3
java -cp target/rabbitmq-examples-1.0-SNAPSHOT-jar-with-dependencies.jar com.certicon.barny.presentation.rabbitmq.SendKt %exchange% %routingKey% %msg%