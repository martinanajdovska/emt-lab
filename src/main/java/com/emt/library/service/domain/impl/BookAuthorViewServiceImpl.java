package com.emt.library.service.domain.impl;

import com.emt.library.model.projection.BookAuthorViewProjection;
import com.emt.library.repository.BookAuthorViewRepository;
import com.emt.library.service.domain.BookAuthorViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorViewServiceImpl implements BookAuthorViewService {
    private final BookAuthorViewRepository bookAuthorViewRepository;

    public BookAuthorViewServiceImpl(BookAuthorViewRepository bookAuthorViewRepository) {
        this.bookAuthorViewRepository = bookAuthorViewRepository;
    }

    @Override
    public List<BookAuthorViewProjection> findAllProjection() {
        return bookAuthorViewRepository.findAllProjection();
    }
}
