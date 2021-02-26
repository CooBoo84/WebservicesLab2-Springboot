package se.group4.springbootlab2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import se.group4.springbootlab2.dtos.GenreDto;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Springbootlab2ApplicationTests {

    @LocalServerPort
    int port;

    @Autowired                                                                                                                    //Client för att kunna ställa Http frågor, som en http client
    TestRestTemplate testClient;                                                                                            //RestTemplate används vill ansluta till andra webservices


    @Test
    void contextLoads() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/xml");
        var result = testClient.getForEntity("http://localhost:"+port+"/genres", GenreDto[].class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().length).isGreaterThan(0);

    }

}
