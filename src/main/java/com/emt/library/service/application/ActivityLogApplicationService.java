package com.emt.library.service.application;

import com.emt.library.model.domain.ActivityLog;
import org.springframework.data.domain.Page;

public interface ActivityLogApplicationService {
    Page<ActivityLog> findAll(int page, int size);
}
