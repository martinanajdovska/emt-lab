package com.emt.library.service.domain;

import com.emt.library.model.projection.BookAuthorViewProjection;

import java.util.List;

public interface BookAuthorViewService {
    List<BookAuthorViewProjection> findAllProjection();
}
