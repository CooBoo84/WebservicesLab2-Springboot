package se.group4.springbootlab2.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GenreControllerTest {

    @Test
    void callingOneWithValidIdReturnsOneGenre(){
        GenreController genreController = new GenreController(new TestService());

        var genre = genreController.one(1);

        assertThat(genre.getId()).isEqualTo(1);
        assertThat(genre.getGenreName()).isEqualTo("TestNamn");
    }

    @Test
    void callingOneWithInvalidIdThrowsExeptionWithResponseStatus404(){
        GenreController genreController = new GenreController(new TestService());

        var exception = assertThrows(ResponseStatusException.class, () -> genreController.one(2));
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }

}