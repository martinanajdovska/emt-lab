package com.emt.library.web.controller;

import com.emt.library.model.views.BookCategoryStatisticsView;
import com.emt.library.service.application.BookCategoryStatisticsViewApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class BookCategoryStatisticsController {
    private final BookCategoryStatisticsViewApplicationService bookCategoryStatisticsViewApplicationService;

    public BookCategoryStatisticsController(BookCategoryStatisticsViewApplicationService bookCategoryStatisticsViewApplicationService) {
        this.bookCategoryStatisticsViewApplicationService = bookCategoryStatisticsViewApplicationService;
    }

    @GetMapping
    public List<BookCategoryStatisticsView> findAll() {
        return bookCategoryStatisticsViewApplicationService.findAll();
    }
}
