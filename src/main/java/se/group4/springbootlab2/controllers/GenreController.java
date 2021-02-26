package se.group4.springbootlab2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.group4.springbootlab2.dtos.GenreDto;
import se.group4.springbootlab2.services.Service;

import java.util.List;

@RestController("/genres")                                                                                              //Övergripande länk
public class GenreController {                                                                                          //Tar hand om inkommande anrop

    private Service service;

    public GenreController(Service service) {
        this.service = service;
    }

    @GetMapping()
    public List<GenreDto> all(){
        return service.getAllGenres();
    }

    @GetMapping("/{id}")
    public GenreDto one(@PathVariable int id){                                                                          //@PathVariable plockar ett värde från url-path
        return service.getOne(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " not found."));      // Returnerar om Genre finns, annars en exception

//        return genreRepository.findById(id)
//                .orElse(new Genre());                                                                                 // Returnerar om Genre finns, annars en ny person
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)                                                                                 //HttpStatus.CREATED - Ändrar kod till 201
    public GenreDto create(@RequestBody GenreDto genre){                                                                      //@RequestBody plockar info från json body
      return service.createGenre(genre);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @PutMapping("/{id}")                                                                                       //Uppdaterar hela objektet
    public GenreDto replace(@RequestBody GenreDto genreDto, @PathVariable int id){
       return service.replace(id, genreDto);
    }

    @PatchMapping("/{id}")                                                                                     //Uppdaterar en variabel (typ bara Email). Om man lägger till fler variabler, skapa fler klasser, se 20210219_111245 29:27
    public GenreDto update(@RequestBody GenreDto genreDto, @PathVariable int id){
        return service.update(id, genreDto);
    }

}