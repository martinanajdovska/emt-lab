package com.emt.library.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "activity_logs")
public class ActivityLog extends BaseEntity{
    private String type;
    private String title;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public ActivityLog(String type, String title) {
        this.type = type;
        this.title = title;
        this.createdAt = LocalDateTime.now();
    }
}
