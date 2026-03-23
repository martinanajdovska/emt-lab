package com.emt.library.repository;

import com.emt.library.model.views.BookCategoryStatisticsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryStatisticsViewRepository extends JpaRepository<BookCategoryStatisticsView, Long> {
}
