package com.emt.library.model.projection;

public interface BookProjectionWithAuthor extends BookProjection {
    String getAuthorName();
    String getAuthorCountry();
}
