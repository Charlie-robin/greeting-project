package com.nology.greeting;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
public class GreetingsController {

    List<Greeting> greetings = new ArrayList<>();

    {
        greetings.add(new Greeting(0, "Charlie", "Hello", "gb"));
    }

    @GetMapping("/greeting")
    public String getCustomGreeting(@RequestParam String name){
        return "Hello " + name;
    }

    @GetMapping("/greeting/{id}")
    public Greeting getGreetingById(@PathVariable int id){
        for (Greeting greeting: greetings) {
            if(greeting.getId() == id){
                return greeting;
            }
        }
        return null;
    }

    @GetMapping("/greetings")
    public List<Greeting> getGreetings(){
        return greetings;
    }

    @GetMapping("/random")
    public Greeting getRandomGreeting(){
        Random rand = new Random();
        return greetings.get(rand.nextInt(greetings.size()));
    }

    @DeleteMapping("/greeting/{id}")
    public String deleteGreetingById(@PathVariable int id) {
        for (int i = 0; i < greetings.size(); i++) {
            if(greetings.get(i).getId() == id){
                greetings.remove(i);
                return "Greetings removed";
            }
        }

        return "No Greeting found";
    }

    @PostMapping("/greeting")
    public String createGreeting(@RequestBody Greeting greeting){
        greetings.add(greeting);
        return "Greeting added";
    }

    @PutMapping("/greeting/{id}")
    public String updateGreeting(@RequestBody Greeting newGreeting, @PathVariable int id){
        for (int i = 0; i < greetings.size(); i++) {
            if(greetings.get(i).getId() == id){
                greetings.set(i, newGreeting);
                return "Updated greeting";
            }
        }
        return "No greeting found";
    }
}
