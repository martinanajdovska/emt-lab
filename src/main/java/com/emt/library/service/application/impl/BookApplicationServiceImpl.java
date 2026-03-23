package com.emt.library.service.application.impl;

import com.emt.library.model.domain.Author;
import com.emt.library.model.domain.Book;
import com.emt.library.model.domain.BookCategory;
import com.emt.library.model.domain.BookState;
import com.emt.library.model.dto.CreateBookDto;
import com.emt.library.model.dto.DisplayBookDto;
import com.emt.library.model.exception.AuthorNotFoundException;
import com.emt.library.model.projection.BookProjection;
import com.emt.library.service.application.BookApplicationService;
import com.emt.library.service.domain.AuthorService;
import com.emt.library.service.domain.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookApplicationServiceImpl implements BookApplicationService {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookApplicationServiceImpl(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public Optional<DisplayBookDto> findById(Long id) {
        return bookService
                .findById(id)
                .map(DisplayBookDto::from);
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return DisplayBookDto.from(bookService.findAll());
    }

    @Override
    public DisplayBookDto create(CreateBookDto createBookDto) {
        Author author = authorService.findById(createBookDto.authorId())
                .orElseThrow(()-> new AuthorNotFoundException(createBookDto.authorId()));
        return DisplayBookDto.from(bookService.create(createBookDto.toBook(author)));
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, CreateBookDto createBookDto) {
        Author author = authorService
                .findById(createBookDto.authorId())
                .orElseThrow(()-> new AuthorNotFoundException(createBookDto.authorId()));
        return bookService
                .update(id,createBookDto.toBook(author))
                .map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> deleteById(Long id) {
        return bookService
                .deleteById(id)
                .map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> rent(Long id) {
        return bookService
                .rent(id)
                .map(DisplayBookDto::from);
    }

    @Override
    public Page<Book> findAll(int page, int size) {
        return bookService
                .findAll(page, size);
    }

    @Override
    public List<BookProjection> findAllOrderByTitleAndCreatedAt() {
        return bookService.findAllOrderByTitleAndCreatedAt();
    }

    @Override
    public List<DisplayBookDto> findAllByState(String bookState) {
        return DisplayBookDto.from(bookService.findAllByState(BookState.valueOf(bookState)));
    }

    @Override
    public List<DisplayBookDto> findAllByCategory(String bookCategory) {
        return DisplayBookDto.from(bookService.findAllByCategory(BookCategory.valueOf(bookCategory)));
    }

    @Override
    public List<DisplayBookDto> findAllByAvailableCopiesGreaterThan(Integer availableCopies) {
        return DisplayBookDto.from(bookService.findAllByAvailableCopiesGreaterThan(availableCopies));
    }

    @Override
    public List<DisplayBookDto> findAllByAuthorId(Long authorId) {
        return DisplayBookDto.from(bookService.findAllByAuthorId(authorId));
    }


}
