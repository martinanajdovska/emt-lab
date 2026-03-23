package com.emt.library.service.application;

import com.emt.library.model.projection.BookAuthorViewProjection;

import java.util.List;

public interface BookAuthorViewApplicationService {
    List<BookAuthorViewProjection> findAllProjection();
}
