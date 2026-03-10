package com.emt.library.service.domain.impl;

import com.emt.library.model.domain.Author;
import com.emt.library.repository.AuthorRepository;
import com.emt.library.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository
                .findById(id)
                .map((existing)-> {
                    existing.setName(author.getName());
                    existing.setSurname(author.getSurname());
                    existing.setCountry(author.getCountry());
                    return authorRepository.save(existing);
                });
    }

    @Override
    public Optional<Author> deleteById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        author.ifPresent(authorRepository::delete);
        return author;
    }
}
