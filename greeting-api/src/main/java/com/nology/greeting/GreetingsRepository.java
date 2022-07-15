package com.nology.greeting;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class GreetingsRepository {

    private final List<Greeting> greetings = new ArrayList<>();


    // CREATE
    public void addGreeting(Greeting greeting){
        greetings.add(greeting);
    }

    // READ

    public Greeting getGreetingById(String id){
        for (Greeting greeting: greetings) {
            if(greeting.getId().equals(id)){
                return greeting;
            }
        }

        // USING OUR EXCEPTION -> BREAK OUT OF THE CODE -> HANDLE THE ERROR / EXCEPTION
        throw new GreetingNotFoundException();
    }

    public List<Greeting> getAllGreetings(){
        return greetings;
    }

    public Greeting getRandomGreeting(){
        Random rand = new Random();
        return greetings.get(rand.nextInt(greetings.size()));
    }

    // UPDATE

    public void updateGreeting(Greeting newGreeting, String id){
        for (int i = 0; i < greetings.size(); i++) {
            if(greetings.get(i).getId().equals(id)){
                greetings.set(i, newGreeting);
                return;
            }
        }

        throw new GreetingNotFoundException();
    }

    // DELETE

    public void deleteGreetingById(String id){
        for (int i = 0; i < greetings.size(); i++) {
            if(greetings.get(i).getId().equals(id)){
                greetings.remove(i);
                return;
            }
        }

        throw new GreetingNotFoundException();
    }



}
