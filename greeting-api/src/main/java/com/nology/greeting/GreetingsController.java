package com.nology.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// GIVES FUNCTIONALITY OF A REST CONTROLLER
// - SET UP END POINTS -> URLS -> MATCH THEM WITH A METHOD
// - A REQUEST GOES TO THAT ENDPOINT THE METHODS IS CALLED -> RETURNS IS THE RESPONSE

@RestController
public class GreetingsController {

    List<String> greetings = new ArrayList<>();

    {
        greetings.addAll(List.of("Hello", "Hi", "Howdy", "Heya"));
    }


    // GET REQUEST
    // ("/") -> URL THAT GETS THE REQUEST WILL CALL THE METHOD
    @GetMapping("/")
    public String helloWorld(){
        return "Hello world!";
    }

    @GetMapping("/rob")
    public String helloRob(){
        return "THIS IS EXCITING!!!!";
    }

    // REQUEST PARAM -> QUERY PARAMS
    // http://localhost:8080/greeting?name=Charlie
    // @RequestParam -> ? -> GET VALUES -> PARAMETERS HAVE TO MATCH
    @GetMapping("/greeting")
    public String getCustomGreeting(@RequestParam String name){
        return "Hello " + name;
    }

    // PATH VARIABLE
    // THIS NEED EXTRA INFORMATION FROM THE URL/ENDPOINT
    @GetMapping("/greeting/{id}")
    public String getGreetingById(@PathVariable int id){
        // return "ID: " + id;
        return greetings.get(id);
    }

    // DON'T HAVE TO RETURN STRINGS CAN RETURN ANY TYPE
    // SPRING ->JAVA TYPE -> JSON
    @GetMapping("/greetings")
    public List<String> getGreetings(){
        return greetings;
    }

    // CHALLENGE GET RANDOM GREETING
    @GetMapping("/random")
    public String getRandomGreeting(){
        Random rand = new Random();
        return greetings.get(rand.nextInt(greetings.size()));
    }

}
