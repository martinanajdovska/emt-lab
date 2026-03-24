package com.emt.library.service.application.impl;

import com.emt.library.model.domain.ActivityLog;
import com.emt.library.service.domain.ActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogApplicationServiceImpl implements com.emt.library.service.application.ActivityLogApplicationService {
    private final ActivityLogService activityLogService;

    public ActivityLogApplicationServiceImpl(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @Override
    public Page<ActivityLog> findAll(int page, int size) {
        return this.activityLogService.findAll(page, size);
    }
}
