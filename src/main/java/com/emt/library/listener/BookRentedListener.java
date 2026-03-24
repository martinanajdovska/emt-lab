package com.emt.library.listener;

import com.emt.library.events.BookRentedEvent;
import com.emt.library.model.domain.ActivityLog;
import com.emt.library.repository.ActivityLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class BookRentedListener {

    private final ActivityLogRepository activityLogRepository;

    public BookRentedListener(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void onBookRented(BookRentedEvent event) {
        var book = event.book();

        log.info("Book rented: '{}' (id={})", book.getTitle(), book.getId());

        var activityLog = new ActivityLog("BOOK_RENTED",
                book.getTitle());
        activityLogRepository.save(activityLog);

//        if (book.getAvailableCopies() == 0) {
//            log.warn("Book '{}' (id={}) is now out of stock!", book.getTitle(), book.getId());
//            var outOfStockLog = new ActivityLog("BOOK_OUT_OF_STOCK",
//                    "Book '%s' (id=%d) has no available copies remaining".formatted(book.getTitle(), book.getId()));
//            activityLogRepository.save(outOfStockLog);
//        }
    }
}