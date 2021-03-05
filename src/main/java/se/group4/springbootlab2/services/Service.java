package se.group4.springbootlab2.services;

import se.group4.springbootlab2.dtos.GenreDto;

import java.util.List;
import java.util.Optional;

public interface Service {
    List<GenreDto> getAllGenres();

    Optional<GenreDto> getOne(int id);

    GenreDto createGenre(GenreDto genre);

    void delete(int id);

    //PutMapping
    GenreDto replace(int id, GenreDto genreDto);

    //PatchMapping
    GenreDto update(int id, GenreDto genreDto);

    List<GenreDto> getAllByName(String name);
}
