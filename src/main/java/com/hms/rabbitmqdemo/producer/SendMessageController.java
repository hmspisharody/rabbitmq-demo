package com.hms.rabbitmqdemo.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.hms.rabbitmqdemo.constants.RabbitProperties.EXCHANGE_NAME;

@RestController
@Slf4j
public class SendMessageController {

    private final RabbitTemplate rabbitTemplate;

    public SendMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "hms.rabbit-hello", message);
        return "Following message was published! : " + message;
    }
}
