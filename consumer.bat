set EXCHANGE=%1
set TYPE=%2
set QUEUE=%3
set ROUTING_KEY=%4
java -cp target/rabbitmq-examples-1.0-SNAPSHOT-jar-with-dependencies.jar com.certicon.barny.presentation.rabbitmq.ConsumerKt %EXCHANGE% %TYPE% %QUEUE% %ROUTING_KEY%