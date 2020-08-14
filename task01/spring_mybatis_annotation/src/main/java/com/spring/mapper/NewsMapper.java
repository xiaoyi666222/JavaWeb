package com.spring.mapper;


import com.spring.entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {

    public List<News> findAll();
}

