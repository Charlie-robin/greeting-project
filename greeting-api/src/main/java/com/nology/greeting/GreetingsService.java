package com.nology.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingsService {

    @Autowired
    GreetingsRepository greetingsRepository;

    Greeting findGreetingById(String id){
        Greeting greeting = greetingsRepository.findByid(id);

        if(greeting == null){
            throw new GreetingNotFoundException();
        }

        return greeting;
    }
}
