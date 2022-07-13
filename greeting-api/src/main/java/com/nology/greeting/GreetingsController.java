package com.nology.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class GreetingsController {

    List<String> greetings = new ArrayList<>();

    {
        greetings.addAll(List.of("Hello", "Hi", "Howdy", "Heya"));
    }

    @GetMapping("/")
    public String helloWorld(){
        return "Hello world!";
    }

    @GetMapping("/rob")
    public String helloRob(){
        return "THIS IS EXCITING!!!!";
    }

    @GetMapping("/greeting")
    public String getCustomGreeting(@RequestParam String name){
        return "Hello " + name;
    }

    @GetMapping("/greeting/{id}")
    public String getGreetingById(@PathVariable int id){
        return greetings.get(id);
    }

    @GetMapping("/greetings")
    public List<String> getGreetings(){
        return greetings;
    }

    @GetMapping("/random")
    public String getRandomGreeting(){
        Random rand = new Random();
        return greetings.get(rand.nextInt(greetings.size()));
    }

}
