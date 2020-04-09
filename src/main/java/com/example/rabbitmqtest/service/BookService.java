package com.example.rabbitmqtest.service;

import com.example.rabbitmqtest.bean.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "queues_test")
    public void recive(Book book){
        System.out.println(book);
    }
}
