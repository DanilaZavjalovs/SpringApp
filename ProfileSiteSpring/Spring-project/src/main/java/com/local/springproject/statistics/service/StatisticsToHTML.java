package com.local.springproject.statistics.service;

import com.local.springproject.JPA.UserStatisticsRepository;
import com.local.springproject.statistics.UserStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class StatisticsToHTML {

    @Autowired
    private UserStatisticsRepository userStatisticsRepository;

    public List<UserStatistics> getAllUserStatistics() {
        List<UserStatistics> list = userStatisticsRepository.findAll();

        Collections.sort(list);

        return list;
    }

}
