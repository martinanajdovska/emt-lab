package com.emt.library.repository;

import com.emt.library.model.domain.Book;
import com.emt.library.model.domain.BookCategory;
import com.emt.library.model.domain.BookState;
import com.emt.library.model.projection.BookProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(value = "book-entity-graph", type = EntityGraph.EntityGraphType.FETCH)
    Page<Book> findAll(Pageable pageable);

    @Query(value = "select id, title, category, state, available_copies from books order by title, created_at desc", nativeQuery = true)
    List<BookProjection> findAllOrderByTitleDescCreatedAtDesc();
    List<Book> findAllByCategory (BookCategory category);
    List<Book> findAllByAuthorId (Long authorId);
    List<Book> findAllByAvailableCopiesGreaterThan (Integer availableCopies);
    List<Book> findAllByState(BookState bookState);
}
