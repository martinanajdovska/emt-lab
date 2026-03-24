package com.emt.library.events;

import com.emt.library.model.domain.Book;

public record BookUnavailableEvent(Book book) {
}
