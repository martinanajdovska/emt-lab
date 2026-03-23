package com.emt.library.model.projection;

public interface BookProjection {
    Long getId();
    String getTitle();
    String getCategory();
    String getState();
    Integer getAvailableCopies();
}
