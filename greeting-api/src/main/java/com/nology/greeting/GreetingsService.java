package com.nology.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GreetingsService {
    @Autowired
    GreetingsRepository greetingsRepository;
    // CREATE
    public void createGreeting(Greeting greeting) {
        greetingsRepository.save(greeting);
    }

    
    // READ

    Greeting findGreetingById(String id){
        Greeting greeting = greetingsRepository.findByid(id);

        if(greeting == null){
            throw new GreetingNotFoundException();
        }

        return greeting;
    }

    public Greeting getRandomGreeting() {
        List<Greeting> greetings = greetingsRepository.findAll();
        Random rand = new Random();
        return greetings.get(rand.nextInt(greetings.size()));
    }

    public List<String> extractGreetingIds() {
        List<Greeting> greetings = greetingsRepository.findAll();

//        greetings.stream()
//                .map(greeting -> greeting.getId())
//                .collect(Collectors.toList());

        List<String> greetingIDs = greetings.stream()
                .map(Greeting::getId)
                .collect(Collectors.toList());

        return greetingIDs;
    }

    public List<Greeting> findAllGreetings() {
        return greetingsRepository.findAll();
    }

    // UPDATE
    public void updateGreeting(Greeting newGreeting, String id) {
        findGreetingById(id);
        greetingsRepository.save(newGreeting);
    }

    // DELETE
    void deleteGreetingById(String id){
        findGreetingById(id);
        greetingsRepository.deleteByid(id);
    }
}
