package com.emt.library.service.application;

import com.emt.library.model.views.BookCategoryStatisticsView;

import java.util.List;

public interface BookCategoryStatisticsViewApplicationService {
    List<BookCategoryStatisticsView> findAll();
}
