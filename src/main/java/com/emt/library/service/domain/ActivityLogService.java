package com.emt.library.service.domain;

import com.emt.library.model.domain.ActivityLog;
import org.springframework.data.domain.Page;

public interface ActivityLogService {
    Page<ActivityLog> findAll(int size, int page);
}
