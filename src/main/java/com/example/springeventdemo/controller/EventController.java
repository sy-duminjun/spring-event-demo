package com.example.springeventdemo.controller;

import com.example.springeventdemo.event.NoticeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Author qsx
 * @Description
 * @Date 16:43 2021/11/11
 **/
@RestController
@RequestMapping("/event")
public class EventController {


    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/notice/{message}")
    public void notice(@PathVariable(name = "message") String message) {

        logger.info("begin >>>>>>");
        applicationEventPublisher.publishEvent(new NoticeEvent(message));
        logger.info("end <<<<<<");
    }
}
