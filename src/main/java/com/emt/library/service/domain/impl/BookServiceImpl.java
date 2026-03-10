package com.emt.library.service.domain.impl;

import com.emt.library.model.domain.Book;
import com.emt.library.model.domain.BookState;
import com.emt.library.model.exception.NoAvailableCopiesException;
import com.emt.library.repository.BookRepository;
import com.emt.library.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
                    existing.setName(book.getName());
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
    public Optional<Book> rent(Long id) {
        return bookRepository
                .findById(id)
                .map(book -> {
                    if (book.getAvailableCopies() <= 0) {
                        throw new NoAvailableCopiesException(id);
                    }
                    book.setAvailableCopies(book.getAvailableCopies() - 1);
                    return bookRepository.save(book);
                });
    }
}
