package se.group4.springbootlab2.mappers;

import org.springframework.stereotype.Component;
import se.group4.springbootlab2.dtos.GenreDto;
import se.group4.springbootlab2.entities.Genre;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GenreMapper {
    public GenreMapper() {
    }

    public GenreDto mapp(Genre genre) {
        return new GenreDto((int) genre.getId(), genre.getGenreName());
    }

    public Genre mapp(GenreDto genreDto) {
        return new Genre(genreDto.getId(), genreDto.getGenreName());
    }

    public Optional<GenreDto> mapp(Optional<Genre> optionalGenre) {
        if (optionalGenre.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapp(optionalGenre.get()));
    }

    public List<GenreDto> mapp(List<Genre> all) {
        return all
                .stream()
                //.filter(genreDto -> genreDto.getId() < 5)                                                             // Filter
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}