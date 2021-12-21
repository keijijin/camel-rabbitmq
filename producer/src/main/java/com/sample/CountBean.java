package com.sample;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.camel.Exchange;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class CountBean {

    Logger log = LoggerFactory.getLogger(CountBean.class);
    Integer count = Integer.valueOf(0);
    
    public void increment(Exchange exchange) {
        exchange.getIn().setHeader("count", ++count);
//        LocalTime now = new LocalTime();
//        exchange.getIn().setHeader("timer", now.getSecondOfMinute()/10);
    }
}
