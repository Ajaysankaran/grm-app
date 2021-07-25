package com.example.appservice.controller;

import com.example.appservice.config.MessageConfiguration;
import com.example.appservice.service.InvoiceService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1")
public class AppController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${rabbitMq.exchange-name}")
    public String exchangeName;

    @Value("${rabbitMq.binding-key}")
    public String bindingKey;

    @Value("${rabbitMq.queue-name")
    public String queueName;

    @GetMapping("invoice")
    public String getInvoice() {
        String invoice = invoiceService.getInvoice();
        return "App Service gets from invoice service. Message : " + invoice;
    }

    @GetMapping("rabbitTest")
    public boolean rabbitTest() {
        rabbitTemplate.convertAndSend(exchangeName, bindingKey, "Test");
        return true;
    }

    @RabbitListener(queues = {"grm-queue"})
    public void consumeFromQueue(){
        
    }
}
