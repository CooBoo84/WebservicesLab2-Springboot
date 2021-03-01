package se.group4.springbootlab2.controllers;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import se.group4.springbootlab2.services.Service;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(GenreController.class)
@Import(TestService.class)
public class MvcTest {                                                                                                  //Test som bara startar upp det nödvändiga. Mellan Unittester och E2E (Integrationstest)

    @Autowired
    Service service;


    @Autowired
    private MockMvc mockMvc;


    //
    @Test
    void getAllUsersFromRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/genres")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getOneUserFromRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/genres/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    //Not working
    @Test
    void postOneGenreToRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/genres")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"genresName\":\"EfterPOST}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void deleteUserOneFromRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/genres/1"))
                .andExpect(status().isOk());
    }

    //Not working
    @Test
    void putOneGenreToRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/genres/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"genresName\":\"EfterPUT}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void patchUserWithNewGenrenameInRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .patch("/genres/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"genreName\":\"ThisIsNewUserSetInTest\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
