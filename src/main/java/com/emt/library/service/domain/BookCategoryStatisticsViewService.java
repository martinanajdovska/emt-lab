package com.emt.library.service.domain;

import com.emt.library.model.views.BookCategoryStatisticsView;

import java.util.List;

public interface BookCategoryStatisticsViewService {
    List<BookCategoryStatisticsView> findAll();
}
