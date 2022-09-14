package com.example.ppt.controller;

import com.example.ppt.Dto.ApiResponse;
import com.example.ppt.model.Admin;
import com.example.ppt.model.News;
import com.example.ppt.model.Support;
import com.example.ppt.model.User;
import com.example.ppt.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/news")
@RestController
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public ResponseEntity getNews() {
        return ResponseEntity.status(200).body(newsService.getNews());
    }

    @PostMapping("/add")
    public ResponseEntity addNews(@RequestBody @Valid News news, @AuthenticationPrincipal Admin admin) {
        newsService.addNews(news,admin);
        return ResponseEntity.status(201).body(new ApiResponse("New News added !", 201));
    }


}