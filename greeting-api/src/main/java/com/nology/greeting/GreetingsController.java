package com.nology.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GreetingsController {

    @Autowired
    GreetingsService greetingsService;

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }


    // CREATE
    @PostMapping("/greeting")
    public ResponseEntity<String> createGreeting(@RequestBody Greeting greeting) {
        greetingsService.createGreeting(greeting);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created Greeting with ID : " + greeting.getId());
    }

    // READ
    @GetMapping("/greeting")
    public String getCustomGreeting(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("/greeting/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable String id) {
        Greeting greeting = greetingsService.findGreetingById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(greeting);
    }

    @GetMapping("/greetings")
    public ResponseEntity<List<Greeting>> getGreetings() {
        List<Greeting> greetings = greetingsService.findAllGreetings();
        return ResponseEntity.status(HttpStatus.FOUND).body(greetings);
    }

    @GetMapping("/random")
    public ResponseEntity<Greeting> getRandomGreeting() {
        Greeting randomGreeting = greetingsService.getRandomGreeting();
        return ResponseEntity.status(HttpStatus.FOUND).body(randomGreeting);
    }

    // UPDATE
    @PutMapping("/greeting/{id}")
    public ResponseEntity<String> updateGreeting(@RequestBody Greeting newGreeting, @PathVariable String id) {
        greetingsService.updateGreeting(newGreeting, id);
        return ResponseEntity.status(HttpStatus.OK).body("Updated Greeting with ID : " + newGreeting.getId());
    }

    // DELETE

    @DeleteMapping("/greeting/{id}")
    @Transactional
    public ResponseEntity<String> deleteGreetingById(@PathVariable String id) {
        greetingsService.deleteGreetingById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Greeting deleted");
    }


}
