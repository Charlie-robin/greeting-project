package com.nology.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingsController {

    @Autowired
    GreetingsRepository greetingsRepository;

    // CATCH OUR EXCEPTION AND SEND SOMETHING BACK TO THE VIEW / FE
    //
    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }


    @GetMapping("/greeting")
    public String getCustomGreeting(@RequestParam String name){
        return "Hello " + name;
    }

    // RESPONSE ENTITY -> MAKE A CUSTOM RESPONSE
    // - SET STATUS CODES -> HTTP STATUS -> STATUS CODES STORED
    // - PROVIDE BODY / DATA NEEDED
    @GetMapping("/greeting/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable String id){
        Greeting greeting = greetingsRepository.getGreetingById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(greeting);
    }

    @GetMapping("/greetings")
    public ResponseEntity<List<Greeting>> getGreetings(){
        List<Greeting> greetings = greetingsRepository.getAllGreetings();
        return ResponseEntity.status(HttpStatus.FOUND).body(greetings);
    }

    @GetMapping("/random")
    public ResponseEntity<Greeting> getRandomGreeting(){
       Greeting randomGreeting = greetingsRepository.getRandomGreeting();
        return ResponseEntity.status(HttpStatus.FOUND).body(randomGreeting);
    }

    @DeleteMapping("/greeting/{id}")
    public ResponseEntity<String> deleteGreetingById(@PathVariable String id) {
        greetingsRepository.deleteGreetingById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Greeting deleted");
    }

    @PostMapping("/greeting")
    public ResponseEntity<String> createGreeting(@RequestBody Greeting greeting){
        greetingsRepository.addGreeting(greeting);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created Greeting with ID : " + greeting.getId());
    }

    @PutMapping("/greeting/{id}")
    public ResponseEntity<String> updateGreeting(@RequestBody Greeting newGreeting, @PathVariable String id){
        greetingsRepository.updateGreeting(newGreeting, id);
        return ResponseEntity.status(HttpStatus.OK).body("Updated Greeting with ID : " + newGreeting.getId());
    }
}
