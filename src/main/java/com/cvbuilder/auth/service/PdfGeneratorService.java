package com.cvbuilder.auth.service;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PdfGeneratorService {

    @RabbitListener(queues = "cv-generation-queue")
    public void generate(String userId) {
        System.out.println("Generating CV for user: " + userId);
        // your PDF generation logic here
    }
}


