package com.zhuangkaizhi.springjms.bean;

/**
 * @author : Jason Zhuang
 * @date : 11/3/2022
 * @description :
 */

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    // The JmsListener annotation defines the name of the Destination which this method should listen to
    // so, the receiveMessage method is listening to mailbox destination
    // And the reference to the JmsListenerContainerFactory to use to create the underlying message listener container.
    // Strictly speaking, that last attribute is not necessary unless you need to customize the way the container is built, as Spring Boot registers a default factory if necessary.
    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }

}
