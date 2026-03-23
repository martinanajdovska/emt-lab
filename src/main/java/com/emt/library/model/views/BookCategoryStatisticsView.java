package com.emt.library.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
@Table(name = "book_category_statistics_view")
public class BookCategoryStatisticsView {
    @Id
    private String category;
    private Long totalBooks;
    private Long totalAvailableCopies;
    private Long totalBadConditionBooks;
}
