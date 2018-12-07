package com.example.springboottask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    /**
     * 秒，分，时，日，月，周
     * 0 * * * * MON-FRI  周一至周五每一分钟启动一次
     */
    //@Scheduled(cron = "0 * * * * MON-FRI")
    @Scheduled(cron = "0,1,2,3,4 * * * * MON-FRI")
    public void hello(){
        System.out.println("hello");
    }
}
