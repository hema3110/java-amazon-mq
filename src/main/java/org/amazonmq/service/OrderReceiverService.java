package org.amazonmq.service;

import lombok.extern.slf4j.Slf4j;
import org.amazonmq.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderReceiverService {
    @RabbitListener(queues = "order-queue")
    public void receiver(Order order) {
        log.info("received order -" + order.toString());
    }
}
