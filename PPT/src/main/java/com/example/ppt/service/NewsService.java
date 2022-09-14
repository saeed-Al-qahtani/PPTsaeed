package com.example.ppt.service;

import com.example.ppt.Repository.NewsRepository;
import com.example.ppt.model.Admin;
import com.example.ppt.model.News;
import com.example.ppt.model.Support; 
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;
    public List<News> getNews(){
        return newsRepository.findAll();
    }

    public void addNews(News news, Admin admin) {
        newsRepository.save(news);
    }


}
