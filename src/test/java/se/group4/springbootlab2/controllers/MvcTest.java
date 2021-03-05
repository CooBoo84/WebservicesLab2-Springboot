package se.group4.springbootlab2.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.server.ResponseStatusException;
import se.group4.springbootlab2.dtos.GenreDto;
import se.group4.springbootlab2.services.Service;


import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(GenreController.class)
//@Import(TestService.class)
public class MvcTest {                                                                                                  //Test som bara startar upp det nödvändiga. Mellan Unittester och E2E (Integrationstest)

    @MockBean
    Service service;


    @Autowired
    private MockMvc mockMvc;



    @Test
    void getAllGenresFromRepository() throws Exception {
        when(service.getAllGenres()).thenReturn(List.of(
                new GenreDto(1, "Test"), new GenreDto(2, "Test2")));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/genres")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getOneGenreWithIdFromRepository() throws Exception {
        when(service.getOne(1)).thenReturn(Optional.of(
                new GenreDto(1, "test")));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/genres/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void postOneGenreToRepository() throws Exception {
        var newGenre = new GenreDto(1, "TestPost");
        when(service.createGenre(any(GenreDto.class)))
                .thenReturn(newGenre);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/genres")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(newGenre))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value(newGenre.getName()));
    }

    @Test
    void putOneGenreToRepository() throws Exception {
        var updatedGenrePut = new GenreDto(1, "TestPut");
        when(service.replace(any(Integer.class), any(GenreDto.class)))
                .thenReturn(updatedGenrePut);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/genres/{id}","1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updatedGenrePut))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value(updatedGenrePut.getName()));
    }

    @Test
    void patchGenreWithNewGenrenameInRepository() throws Exception {
        var updatedGenrePatch = new GenreDto(1, "Test");
        when(service.update(any(Integer.class), any(GenreDto.class)))
                .thenReturn(updatedGenrePatch);

        mockMvc.perform(MockMvcRequestBuilders
                .patch("/genres/{id}","1")
                .content(asJsonString(updatedGenrePatch))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value(updatedGenrePatch.getName()));
    }

    @Test
    void deleteUserOneFromRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/genres/1"))
                .andExpect(status().isOk());
    }


    @Test
    void searchForGenreWithCorrectName() throws Exception {

        List<GenreDto> list = List.of(
                new GenreDto(1, "Dans"),
                new GenreDto(2, "Rock")
        );

        when(service.getAllByName("Dans")).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/genres/search?name=Dans")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
