package com.emt.library.repository;

import com.emt.library.model.projection.BookAuthorViewProjection;
import com.emt.library.model.views.BookAuthorView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAuthorViewRepository extends JpaRepository<BookAuthorView, Long> {
    @Query(value = "select id, title, category, state, available_copies, author_fullname as authorFullName, author_country from book_author_view", nativeQuery = true)
    List<BookAuthorViewProjection> findAllProjection();
}
