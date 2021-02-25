package se.group4.springbootlab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController {

    private GenreRepository genreRepository;


    @Autowired
    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/hello")
    public Optional<Genre> sayHello(){

        genreRepository.save(new Genre(0,"Dans"));

        return genreRepository.findById(1);
    }

    @GetMapping("/genres")
    public List<Genre> all(){
        return genreRepository.findAll();
    }

    @GetMapping("/genres/{id}")
    public Genre one(@PathVariable int id){
        return genreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " not found."));      // Returnerar om Genre finns, annars en exception

//        return genreRepository.findById(id)
//                .orElse(new Genre());                                                                                 // Returnerar om Genre finns, annars en ny person
    }

}