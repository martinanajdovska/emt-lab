package com.emt.library.service.domain.impl;

import com.emt.library.model.views.BookCategoryStatisticsView;
import com.emt.library.repository.BookCategoryStatisticsViewRepository;
import com.emt.library.service.domain.BookCategoryStatisticsViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryStatisticsViewServiceImpl implements BookCategoryStatisticsViewService {
    private final BookCategoryStatisticsViewRepository bookCategoryStatisticsViewRepository;

    public BookCategoryStatisticsViewServiceImpl(BookCategoryStatisticsViewRepository bookCategoryStatisticsViewRepository) {
        this.bookCategoryStatisticsViewRepository = bookCategoryStatisticsViewRepository;
    }

    @Override
    public List<BookCategoryStatisticsView> findAll() {
        return bookCategoryStatisticsViewRepository.findAll();
    }
}
