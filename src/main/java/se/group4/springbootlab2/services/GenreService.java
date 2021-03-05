package se.group4.springbootlab2.services;

import org.springframework.data.jpa.domain.Specification;
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
public class GenreService implements se.group4.springbootlab2.services.Service {

    private final GenreMapper genreMapper;
    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public List<GenreDto> getAllGenres(){
        return genreMapper.mapp(genreRepository.findAll());
    }

    @Override
    public Optional<GenreDto> getOne(int id){
        return genreMapper.mapp(genreRepository.findById(id));
    }

    @Override
    public GenreDto createGenre(GenreDto genre){
        if(genre.getName().isEmpty()){
            throw new RuntimeException();
        }
        return genreMapper.mapp(genreRepository.save(genreMapper.mapp(genre)));
    }

    @Override
    public void delete(int id) {
        genreRepository.deleteById(id);
    }

    //PutMapping
    @Override
    public GenreDto replace(int id, GenreDto genreDto) {
        Optional<Genre> genre = genreRepository.findById(id);
        if(genre.isPresent()){
            Genre updatedGenre = genre.get();
            updatedGenre.setName(genreDto.getName());
            return genreMapper.mapp(genreRepository.save(updatedGenre));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " +id +" not found.");
        }
    }
    //PatchMapping
    @Override
    public GenreDto update(int id, GenreDto genreDto) {
        Optional<Genre> genre = genreRepository.findById(id);
        if(genre.isPresent()){
            Genre updatedGenre = genre.get();
            if( genreDto.getName() != null){
                updatedGenre.setName(genreDto.getName());
            }
            return genreMapper.mapp(genreRepository.save(updatedGenre));
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " +id +" not found.");
        }
    }

    @Override
    public List<GenreDto> getAllByName(String name) {
        return genreMapper.mapp(genreRepository.findAllByNameContains(name));
    }
}
