package com.local.springproject.kafka;

import com.local.springproject.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    private StatisticsService statistics;

    @KafkaListener(topics = "test", groupId = "consumer")
    public void listener(String str) {

        statistics.addStatistics(str);
    }
}
