package com.example.demo.product;


import com.example.demo.SerialBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;


@Service
public class Producer {

    private final static Logger log= LoggerFactory.getLogger(Producer.class);
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String destination,final SerialBean msg) {
       jmsTemplate.send(destination, new MessageCreator() {
           @Override
           public Message createMessage(Session session) throws JMSException {
               return session.createObjectMessage(msg);
           }
       });
    }
}
