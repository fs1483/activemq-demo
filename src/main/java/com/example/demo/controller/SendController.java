package com.example.demo.controller;

import com.example.demo.SerialBean;
import com.example.demo.product.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class SendController {
    @Autowired
    Producer producer;
    @RequestMapping(value = "/SendMessageByQueue", method = RequestMethod.GET)
    @ResponseBody
    public String send() {
        try {
            System.out.println("开始发出一次请求，时间是"+new Date());
            SerialBean  msg = new SerialBean();
            List<List<Object>> list = new ArrayList<List<Object>>();
            List<Object> ls = new ArrayList<Object>();
            ls.add("zhangsan");
            Timestamp date = new Timestamp(System.currentTimeMillis());
            ls.add(date);
            list.add(ls);
            msg.setList(list);
            producer.sendMessage("test",msg);
            System.out.println(msg+"请求发送完成，时间是"+new Date());

        }catch (Exception e){
            e.printStackTrace();
        }
        return "acctivemq send successful";
    }
}
