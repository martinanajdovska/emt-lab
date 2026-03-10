package com.emt.library.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "books")
public class Book extends BaseAuditableEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookCategory category;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookState state;

    @Column(nullable = false)
    private Integer availableCopies;

    public Book(String name, BookCategory category, Author author, BookState state, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.state = state;
        this.availableCopies = availableCopies;
    }
}
