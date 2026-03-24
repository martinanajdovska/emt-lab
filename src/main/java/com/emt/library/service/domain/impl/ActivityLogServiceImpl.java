package com.emt.library.service.domain.impl;

import com.emt.library.model.domain.ActivityLog;
import com.emt.library.repository.ActivityLogRepository;
import com.emt.library.service.domain.ActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository activityLogRepository;

    public ActivityLogServiceImpl(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @Override
    public Page<ActivityLog> findAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return this.activityLogRepository.findAll(pageable);
    }
}
