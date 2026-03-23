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
@NamedEntityGraph(
        name = "book-entity-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "author", subgraph = "book-author-subgraph"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "book-author-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("country")
                        }
                ),
        }
)
public class Book extends BaseAuditableEntity{
    @Column(nullable = false)
    private String title;

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
        this.title = name;
        this.category = category;
        this.author = author;
        this.state = state;
        this.availableCopies = availableCopies;
    }
}
