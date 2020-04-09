package com.example.rabbitmqtest;

import com.example.rabbitmqtest.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class RabbitmqTestApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {

            Map<String,Object> map = new HashMap<>();
            map.put("msg","Hello World");
            Book book = new Book("红楼梦","曹雪芹",999);
            rabbitTemplate.convertAndSend(
                    "exchange_test","direct",book);

    }

    @Test
    void recive() {

        Book book = (Book) rabbitTemplate.receiveAndConvert("queues_test");
        System.out.println(book);
    }

}
