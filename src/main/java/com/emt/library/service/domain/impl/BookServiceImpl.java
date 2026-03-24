package com.emt.library.service.domain.impl;

import com.emt.library.events.BookRentedEvent;
import com.emt.library.events.BookUnavailableEvent;
import com.emt.library.model.domain.Book;
import com.emt.library.model.domain.BookCategory;
import com.emt.library.model.domain.BookState;
import com.emt.library.model.exception.NoAvailableCopiesException;
import com.emt.library.model.projection.BookProjection;
import com.emt.library.repository.BookRepository;
import com.emt.library.service.domain.BookService;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public BookServiceImpl(BookRepository bookRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.bookRepository = bookRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return bookRepository
                .findById(id)
                .map((existing) -> {
                    existing.setTitle(book.getTitle());
                    existing.setAuthor(book.getAuthor());
                    existing.setCategory(book.getCategory());
                    existing.setAvailableCopies(book.getAvailableCopies());
                    existing.setState(book.getState());
                    return bookRepository.save(existing);
                });
    }

    @Override
    public Optional<Book> deleteById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        book.filter(b -> b.getState() == BookState.BAD)
                .ifPresent(bookRepository::delete);
        return book;
    }

    @Override
    @Transactional
    public Optional<Book> rent(Long id) {
        Optional<Book> book = bookRepository
                .findById(id)
                .map(b -> {
                    if (b.getAvailableCopies() <= 0) {
                        throw new NoAvailableCopiesException(id);
                    }
                    b.setAvailableCopies(b.getAvailableCopies() - 1);
                    return bookRepository.save(b);
                });
        book.ifPresent(b -> {
            applicationEventPublisher.publishEvent(new BookRentedEvent(b));
            if (b.getAvailableCopies() == 0) {
                applicationEventPublisher.publishEvent(new BookUnavailableEvent(b));
            }
        });
        return book;
    }

    @Override
    public Page<Book> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }

    @Override
    public List<Book> findAllByCategory(BookCategory category) {
        return bookRepository.findAllByCategory(category);
    }

    @Override
    public List<Book> findAllByAuthorId(Long authorId) {
        return bookRepository.findAllByAuthorId(authorId);
    }

    @Override
    public List<Book> findAllByAvailableCopiesGreaterThan(Integer availableCopies) {
        return bookRepository.findAllByAvailableCopiesGreaterThan(availableCopies);
    }

    @Override
    public List<BookProjection> findAllOrderByTitleAndCreatedAt() {
        return bookRepository.findAllOrderByTitleDescCreatedAtDesc();
    }

    @Override
    public List<Book> findAllByState(BookState bookState) {
        return bookRepository.findAllByState(bookState);
    }
}
