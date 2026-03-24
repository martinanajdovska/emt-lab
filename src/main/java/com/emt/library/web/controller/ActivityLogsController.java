package com.emt.library.web.controller;

import com.emt.library.model.domain.ActivityLog;
import com.emt.library.service.application.ActivityLogApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogsController {
    private final ActivityLogApplicationService activityLogApplicationService;

    public ActivityLogsController(ActivityLogApplicationService activityLogApplicationService) {
        this.activityLogApplicationService = activityLogApplicationService;
    }

    @GetMapping
    public Page<ActivityLog> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return activityLogApplicationService.findAll(size, page);
    }
}
