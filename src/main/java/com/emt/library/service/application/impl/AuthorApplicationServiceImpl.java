package com.emt.library.service.application.impl;

import com.emt.library.model.domain.Country;
import com.emt.library.model.dto.CreateAuthorDto;
import com.emt.library.model.dto.DisplayAuthorDto;
import com.emt.library.model.exception.CountryNotFoundException;
import com.emt.library.service.application.AuthorApplicationService;
import com.emt.library.service.domain.AuthorService;
import com.emt.library.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorApplicationServiceImpl  implements AuthorApplicationService {
    private final AuthorService authorService;
    private final CountryService countryService;

    public AuthorApplicationServiceImpl(AuthorService authorService, CountryService countryService) {
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @Override
    public Optional<DisplayAuthorDto> findById(Long id) {
        return authorService
                .findById(id)
                .map(DisplayAuthorDto::from);
    }

    @Override
    public List<DisplayAuthorDto> findAll() {
        return DisplayAuthorDto.from(authorService.findAll());
    }

    @Override
    public DisplayAuthorDto create(CreateAuthorDto createAuthorDto) {
        Country country = countryService
                .findById(createAuthorDto.countryId())
                .orElseThrow(() -> new CountryNotFoundException(createAuthorDto.countryId()));
        return DisplayAuthorDto.from(authorService.create(createAuthorDto.toAuthor(country)));
    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto createAuthorDto) {
        Country country = countryService
                .findById(createAuthorDto.countryId())
                .orElseThrow(() -> new CountryNotFoundException(createAuthorDto.countryId()));
        return authorService
                .update(id, createAuthorDto.toAuthor(country))
                .map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> deleteById(Long id) {
        return authorService
                .deleteById(id)
                .map(DisplayAuthorDto::from);
    }
}
