package org.amazonmq.service;

import lombok.extern.slf4j.Slf4j;
import org.amazonmq.model.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class OrderSendService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public Order create(String[] products) {
        try {
            Order order = Order.builder().id(UUID.randomUUID().toString()).products(products).build();
            amqpTemplate.convertAndSend("direct-exchange", "order.key", order);
            log.info("order has been sent");
            return order;
        }catch(Exception e) {
            log.error("error in sending order " ,e);
            throw e;
        }
    }
}
