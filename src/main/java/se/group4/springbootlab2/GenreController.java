package se.group4.springbootlab2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

}
