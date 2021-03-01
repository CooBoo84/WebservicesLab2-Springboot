package se.group4.springbootlab2.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import se.group4.springbootlab2.services.Service;



@WebMvcTest(GenreController.class)
@Import(TestService.class)
public class MvcTest {                                                                                                  //Test som bara startar upp det nödvändiga. Mellan Unittester och E2E (Integrationstest)

    @Autowired
    Service service;


    @Autowired
    private MockMvc mockMvc;


    @Test
    void callingWithUrlGenresShouldReturnAllGenresAsJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/genres")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
