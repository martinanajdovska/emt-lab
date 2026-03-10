package com.emt.library.service.domain.impl;

import com.emt.library.model.domain.Country;
import com.emt.library.repository.CountryRepository;
import com.emt.library.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        return countryRepository
                .findById(id)
                .map((existing)->{
                    existing.setName(country.getName());
                    existing.setContinent(country.getContinent());
                    return countryRepository.save(existing);
                });
    }

    @Override
    public Optional<Country> deleteById(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        country.ifPresent(countryRepository::delete);
        return country;
    }
}
