package com.emt.library.web.controller;

import com.emt.library.model.dto.CreateBookDto;
import com.emt.library.model.dto.DisplayBookDto;
import com.emt.library.service.application.BookApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookApplicationService bookApplicationService;

    public BookController(BookApplicationService bookApplicationService) {
        this.bookApplicationService = bookApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookDto> findById(@PathVariable Long id) {
        return bookApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayBookDto>> findAll(){
        return ResponseEntity.ok(bookApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayBookDto> create(@RequestBody @Valid CreateBookDto createBookDto){
        return ResponseEntity.ok(bookApplicationService.create(createBookDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayBookDto> update(
            @PathVariable Long id,
            @RequestBody @Valid CreateBookDto createBookDto
    ) {
        return bookApplicationService
                .update(id, createBookDto)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayBookDto> deleteById(@PathVariable Long id) {
        return bookApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/rent")
    public ResponseEntity<DisplayBookDto> rent(@PathVariable Long id) {
        return bookApplicationService
                .rent(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
