package com.emt.library.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
@Table(name = "book_author_view")
public class BookAuthorView {
    @Id
    private Long id;

    private String title;
    private String category;
    private String state;
    private Integer availableCopies;
    private String authorFullName;
    private String authorCountry;
}
