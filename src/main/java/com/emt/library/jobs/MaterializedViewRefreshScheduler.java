package com.emt.library.jobs;

import com.emt.library.repository.BookCategoryStatisticsViewRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MaterializedViewRefreshScheduler {
    private final BookCategoryStatisticsViewRepository bookCategoryStatisticsViewRepository;

    public MaterializedViewRefreshScheduler(BookCategoryStatisticsViewRepository bookCategoryStatisticsViewRepository) {
        this.bookCategoryStatisticsViewRepository = bookCategoryStatisticsViewRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void refreshBookCategoryStatisticsViews() {
        log.info("Refreshing BOOK_CATEGORY_STATISTICS_VIEW... " + LocalDateTime.now());
        bookCategoryStatisticsViewRepository.refresh();
        log.info("BOOK_CATEGORY_STATISTICS_VIEW refreshed... " + LocalDateTime.now());
    }
}
