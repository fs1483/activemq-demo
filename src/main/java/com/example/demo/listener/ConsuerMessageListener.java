package com.example.demo.listener;

import com.example.demo.SerialBean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Component
public class ConsuerMessageListener  implements MessageListener {

    @Override
    @JmsListener(destination = "test")
    public void onMessage(Message message) {
        System.out.println("activemq 监听到消息，时间是"+new Date());
        try {
            SerialBean result = (SerialBean)((ObjectMessage)message).getObject();
            List<List<Object>> receiver = result.getList();
            Thread.sleep(1000*5);
            System.out.println("activemq 监听到消息，msg"+receiver);
        }catch (JMSException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
