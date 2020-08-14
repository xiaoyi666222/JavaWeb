package com.spring.service.impl;


import com.spring.entity.News;
import com.spring.mapper.NewsMapper;
import com.spring.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public List<News> findAll() {

        return newsMapper.findAll();
    }

}

