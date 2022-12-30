package com.local.springproject.controllers;

import com.local.springproject.statistics.UserStatistics;
import com.local.springproject.statistics.service.StatisticsToHTML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/statistics")
public class StatisticsTable {

    Logger logger = LoggerFactory.getLogger(StatisticsTable.class);

    @Autowired
    private StatisticsToHTML statistics;

    @GetMapping
    public ModelAndView statisticsTable() {
        ModelAndView view = new ModelAndView("statisticsTable");

        view.addObject("listStatistics", statistics.getAllUserStatistics());

        for (int i = 0; i < view.getModel().size(); i++) {
            logger.info("object = " + view.getModel().get(i));
        }

        return view;
    }
}
