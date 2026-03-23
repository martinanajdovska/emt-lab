package com.emt.library.web.controller;

import com.emt.library.model.projection.BookAuthorViewProjection;
import com.emt.library.service.domain.BookAuthorViewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book-authors")
public class BookAuthorController {
    private final BookAuthorViewService bookAuthorViewService;

    public BookAuthorController(BookAuthorViewService bookAuthorViewService) {
        this.bookAuthorViewService = bookAuthorViewService;
    }

    @GetMapping
    public List<BookAuthorViewProjection> findAllProjection() {
        return bookAuthorViewService.findAllProjection();
    }
}
