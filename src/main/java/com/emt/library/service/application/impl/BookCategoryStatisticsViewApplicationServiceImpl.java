package com.emt.library.service.application.impl;

import com.emt.library.model.views.BookCategoryStatisticsView;
import com.emt.library.service.application.BookCategoryStatisticsViewApplicationService;
import com.emt.library.service.domain.BookCategoryStatisticsViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryStatisticsViewApplicationServiceImpl implements BookCategoryStatisticsViewApplicationService {
    private final BookCategoryStatisticsViewService bookCategoryStatisticsViewService;

    public BookCategoryStatisticsViewApplicationServiceImpl(BookCategoryStatisticsViewService bookCategoryStatisticsViewService) {
        this.bookCategoryStatisticsViewService = bookCategoryStatisticsViewService;
    }

    @Override
    public List<BookCategoryStatisticsView> findAll() {
        return bookCategoryStatisticsViewService.findAll();
    }
}
