package com.emt.library.model.dto;

import com.emt.library.model.domain.Country;
import jakarta.validation.constraints.NotBlank;

public record CreateCountryDto(
        @NotBlank
        String name,
        @NotBlank
        String continent
) {
    public Country toCountry(){
        return new Country(name,continent);
    }
}
