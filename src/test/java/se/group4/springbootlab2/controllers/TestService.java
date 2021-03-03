package se.group4.springbootlab2.controllers;

import se.group4.springbootlab2.dtos.GenreDto;
import se.group4.springbootlab2.services.Service;

import java.util.List;
import java.util.Optional;

public class TestService implements Service {
    @Override
    public List<GenreDto> getAllGenres() {
        return List.of(new GenreDto(1,"Namn1"), new GenreDto(2,"Namn2"));
    }

    @Override
    public Optional<GenreDto> getOne(int id) {
        if(id == 1)
            return Optional.of(new GenreDto(1,"TestNamn"));
        return Optional.empty();
    }

    @Override
    public GenreDto createGenre(GenreDto genre) {
        return null;
    }

    @Override
    public void delete(int id) {     }

    @Override
    public GenreDto replace(int id, GenreDto genreDto) {
        return null;
    }

    @Override
    public GenreDto update(int id, GenreDto genreDto) {
        return null;
    }
}
