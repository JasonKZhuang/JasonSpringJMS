package com.zhuangkaizhi.springjms;

import com.zhuangkaizhi.springjms.bean.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class JasonSpringJmsApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(JasonSpringJmsApplication.class, args);

        // JmsTemplate makes it simple to send messages to a JMS destination.
        // you can use jmsTemplate to send an Email POJO.
        // Because our custom MessageConverter has been automatically associated to it,

        // Spring’s JmsTemplate can receive messages directly through its receive method,
        // but that works only synchronously, meaning that it blocks.
        // That is why we recommend that you use a listener container such as DefaultMessageListenerContainer with a cache-based connection factory,
        // so you can consume messages asynchronously and with maximum connection efficiency.
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
    }

}
