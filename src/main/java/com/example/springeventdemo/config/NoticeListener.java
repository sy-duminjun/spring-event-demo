package com.example.springeventdemo.config;

import com.example.springeventdemo.event.NoticeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/*
 * @Author qsx
 * @Description
 * @Date 17:01 2021/11/11
 **/
@Component
public class NoticeListener implements ApplicationListener<NoticeEvent> {


    private static final Logger logger = LoggerFactory.getLogger(NoticeListener.class);

    @Async
    @Override
    public void onApplicationEvent(NoticeEvent noticeEvent) {

        logger.info("listener get event, sleep 2 second...");
        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        logger.info("event message is : {}", noticeEvent.getMessage());
    }
}