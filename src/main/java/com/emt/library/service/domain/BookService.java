package com.emt.library.service.domain;

import com.emt.library.model.domain.Book;
import com.emt.library.model.domain.BookCategory;
import com.emt.library.model.domain.BookState;
import com.emt.library.model.projection.BookProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Long id);

    List<Book> findAll();

    Book create(Book book);

    Optional<Book> update(Long id, Book book);

    Optional<Book> deleteById(Long id);

    Optional<Book> rent (Long id);

    Page<Book> findAll(int page, int size);

    List<Book> findAllByCategory(BookCategory category);

    List<Book> findAllByAuthorId(Long authorId);

    List<Book> findAllByAvailableCopiesGreaterThan(Integer availableCopies);

    List<BookProjection> findAllOrderByTitleAndCreatedAt();

    List<Book> findAllByState(BookState bookState);
}
