package com.sample;

import org.apache.camel.builder.RouteBuilder;

public class RabbitMqConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//        from("rabbitmq:testExchange?queue=testQueue&autoDelete=false&declare=false&hostname=localhost&portNumber=5672&username=guest&password=guest")
        from("rabbitmq:testExchange?queue=testQueue&autoDelete=false&declare=false&hostname={{rabbitmq.hostname}}&portNumber={{rabbitmq.port}}&username={{rabbitmq.username}}&password={{rabbitmq.password}}")
            .routeId("RabbitMqConsumer")
            .log("Received body: ${body}");
    }
    

}
