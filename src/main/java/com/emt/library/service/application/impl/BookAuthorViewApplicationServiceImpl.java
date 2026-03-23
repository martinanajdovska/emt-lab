package com.emt.library.service.application.impl;

import com.emt.library.model.projection.BookAuthorViewProjection;
import com.emt.library.service.application.BookAuthorViewApplicationService;
import com.emt.library.service.domain.BookAuthorViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorViewApplicationServiceImpl implements BookAuthorViewApplicationService {
    private final BookAuthorViewService bookAuthorViewService;

    public BookAuthorViewApplicationServiceImpl(BookAuthorViewService bookAuthorViewService) {
        this.bookAuthorViewService = bookAuthorViewService;
    }

    @Override
    public List<BookAuthorViewProjection> findAllProjection() {
        return bookAuthorViewService.findAllProjection();
    }
}
