package com.emt.library.service.application;

import com.emt.library.model.domain.Book;
import com.emt.library.model.domain.BookCategory;
import com.emt.library.model.domain.BookState;
import com.emt.library.model.dto.CreateBookDto;
import com.emt.library.model.dto.DisplayBookDto;
import com.emt.library.model.projection.BookProjection;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    Optional<DisplayBookDto> findById(Long id);

    List<DisplayBookDto> findAll();

    DisplayBookDto create (CreateBookDto createBookDto);

    Optional<DisplayBookDto> update(Long id, CreateBookDto createBookDto);

    Optional<DisplayBookDto> deleteById(Long id);

    Optional<DisplayBookDto> rent(Long id);

    Page<Book> findAll(int page, int size);

    List<BookProjection> findAllOrderByTitleAndCreatedAt();

    List<DisplayBookDto> findAllByState(String bookState);

    List<DisplayBookDto> findAllByCategory(String bookCategory);

    List<DisplayBookDto> findAllByAvailableCopiesGreaterThan(Integer availableCopies);

    List<DisplayBookDto> findAllByAuthorId(Long authorId);
}
