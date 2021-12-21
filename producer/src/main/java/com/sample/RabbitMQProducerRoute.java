package com.sample;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class RabbitMQProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:foo?period=1000")
            .routeId("RabbitMqProducer")
            .bean("com.sample.CountBean", "increment")
//            .log("count : ${header.count}")
            .setBody().simple("{\"counter\":${header.count}}")
            .log("Trying to send : ${body}")
            .to("rabbitmq:testExchange?autoDelete=false&declare=false&hostname={{rabbitmq.hostname}}&portNumber={{rabbitmq.port}}&username={{rabbitmq.username}}&password={{rabbitmq.password}}")
            .log("Message Sent!");

    }
    
}
