package com.emt.library.listener;

import com.emt.library.events.BookUnavailableEvent;
import com.emt.library.model.domain.ActivityLog;
import com.emt.library.repository.ActivityLogRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class BookUnavailableListener {
    private final ActivityLogRepository activityLogRepository;

    public BookUnavailableListener(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void onBookUnavailable(BookUnavailableEvent event){
        var book = event.book();
        log.warn("Book '{}' (id={}) is now unavailable!", book.getTitle(), book.getId());
        activityLogRepository.save(new ActivityLog("BOOK_OUT_OF_STOCK", book.getTitle()));
    }
}
