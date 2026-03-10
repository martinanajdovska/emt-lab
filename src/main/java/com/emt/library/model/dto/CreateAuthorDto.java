package com.emt.library.model.dto;

import com.emt.library.model.domain.Author;
import com.emt.library.model.domain.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAuthorDto(
        @NotBlank
        String name,
        @NotBlank
        String surname,
        @NotNull
        Long countryId
) {
    public Author toAuthor(Country country){
        return new Author(name, surname, country);
    }
}
