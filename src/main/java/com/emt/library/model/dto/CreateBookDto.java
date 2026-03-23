package com.emt.library.model.dto;

import com.emt.library.model.domain.Author;
import com.emt.library.model.domain.Book;
import com.emt.library.model.domain.BookCategory;
import com.emt.library.model.domain.BookState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateBookDto (
        @NotBlank
        String title,
        @NotBlank
        String category,
        @NotNull
        Long authorId,
        @NotBlank
        String state,
        @Positive
        Integer availableCopies
        ) {
    public Book toBook(Author author){
        return new Book(title, BookCategory.valueOf(category), author, BookState.valueOf(state), availableCopies);
    }
}
