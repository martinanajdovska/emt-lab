package com.emt.library.model.dto;

import com.emt.library.model.domain.Book;

import java.util.List;

public record DisplayBookDto(
        Long id,
        String title,
        String category,
        Long authorId,
        String state,
        Integer availableCopies
) {
    public static DisplayBookDto from(Book book) {
        return new DisplayBookDto(
                book.getId(),
                book.getTitle(),
                book.getCategory().name(),
                book.getAuthor().getId(),
                book.getState().name(),
                book.getAvailableCopies()
        );
    }

    public static List<DisplayBookDto> from(List<Book> books) {
        return books
                .stream()
                .map(DisplayBookDto::from)
                .toList();
    }
}
