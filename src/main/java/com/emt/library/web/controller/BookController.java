package com.emt.library.web.controller;

import com.emt.library.model.domain.Book;
import com.emt.library.model.dto.CreateBookDto;
import com.emt.library.model.dto.DisplayBookDto;
import com.emt.library.model.projection.BookProjection;
import com.emt.library.service.application.BookApplicationService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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

    @GetMapping("/all")
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

    @GetMapping
    public ResponseEntity<Page<Book>> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(bookApplicationService.findAll(page, size));
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<BookProjection>> findAllSortedByNameAndCreatedAt(){
        return ResponseEntity.ok(bookApplicationService.findAllOrderByTitleAndCreatedAt());
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<DisplayBookDto>> findAllByAuthorId(@PathVariable Long id){
        return ResponseEntity.ok(bookApplicationService.findAllByAuthorId(id));
    }

    @GetMapping("/category")
    public ResponseEntity<List<DisplayBookDto>> findAllByCategory(@RequestParam String category){
        return ResponseEntity.ok(bookApplicationService.findAllByCategory(category));
    }

    @GetMapping("/state")
    public ResponseEntity<List<DisplayBookDto>> findAllByState(@RequestParam String state){
        return ResponseEntity.ok(bookApplicationService.findAllByState(state));
    }

    @GetMapping("/available")
    public ResponseEntity<List<DisplayBookDto>> findAllByAvailable(){
        return ResponseEntity.ok(bookApplicationService.findAllByAvailableCopiesGreaterThan(0));
    }
}
