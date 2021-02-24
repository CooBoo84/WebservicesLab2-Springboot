package se.group4.springbootlab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
//        GenreRepository genreRepository;
//
//        return "Hello";

        genreRepository.save(new Genre(0,"Dans"));

        return genreRepository.findById(1);
    }

}
