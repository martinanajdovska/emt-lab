package com.emt.library.model.projection;

public interface BookAuthorViewProjection {
    Long getId();
    String getTitle();
    String getCategory();
    String getState();
    Integer getAvailableCopies();
    String getAuthorFullName();
    String getAuthorCountry();
}
