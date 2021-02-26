package se.group4.springbootlab2.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.group4.springbootlab2.dtos.GenreDto;
import se.group4.springbootlab2.entities.Genre;
import se.group4.springbootlab2.mappers.GenreMapper;
import se.group4.springbootlab2.respositories.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreMapper genreMapper;
    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    public List<GenreDto> getAllGenres(){
        return genreMapper.mapp(genreRepository.findAll());
    }

    public Optional<GenreDto> getOne(int id){
        return genreMapper.mapp(genreRepository.findById(id));
    }

    public GenreDto createGenre(GenreDto genre){
        if(genre.getGenreName().isEmpty()){
            throw new RuntimeException();
        }
        return genreMapper.mapp(genreRepository.save(genreMapper.mapp(genre)));
    }

    public void delete(int id) {
        genreRepository.deleteById(id);
    }

    //PutMapping
    public GenreDto replace(int id, GenreDto genreDto) {
        Optional<Genre> genre = genreRepository.findById(id);
        if(genre.isPresent()){
            Genre updatedGenre = genre.get();
            updatedGenre.setGenreName(genreDto.getGenreName());
            return genreMapper.mapp(genreRepository.save(updatedGenre));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " +id +" not found.");
        }
    }
    //PatchMapping
    public GenreDto update(int id, GenreDto genreDto) {
        Optional<Genre> genre = genreRepository.findById(id);
        if(genre.isPresent()){
            Genre updatedGenre = genre.get();
            if( genreDto.getGenreName() != null){
                updatedGenre.setGenreName(genreDto.getGenreName());
            }
            return genreMapper.mapp(genreRepository.save(updatedGenre));
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " +id +" not found.");
        }
    }
}