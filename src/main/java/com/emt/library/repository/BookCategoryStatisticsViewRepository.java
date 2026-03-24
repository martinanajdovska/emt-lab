package com.emt.library.repository;

import com.emt.library.model.views.BookCategoryStatisticsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryStatisticsViewRepository extends JpaRepository<BookCategoryStatisticsView, Long> {
    @Modifying
    @Query(value = "call refresh_book_category_statistics_view()", nativeQuery = true)
    void refresh();
}
