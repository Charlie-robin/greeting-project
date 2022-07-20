package com.nology.greeting;

import javax.persistence.EntityNotFoundException;

public class GreetingNotFoundException extends EntityNotFoundException {
    public GreetingNotFoundException() {
        super("Greeting has not been found");
    }


}
