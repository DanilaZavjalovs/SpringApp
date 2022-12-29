package com.local.springproject.statistics.service;


import com.local.springproject.JPA.UserStatisticsRepository;
import com.local.springproject.statistics.UserStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    @Autowired
    private UserStatisticsRepository userStatisticsRepository;

    public void addStatistics(String name) {
        if (userStatisticsRepository.findByName(name).isPresent()) {
            UserStatistics statistics = userStatisticsRepository.findByName(name).get();

            int count = statistics.getCount() + 1;

            statistics.setCount(count);

            userStatisticsRepository.save(statistics);
        }
    }
}
