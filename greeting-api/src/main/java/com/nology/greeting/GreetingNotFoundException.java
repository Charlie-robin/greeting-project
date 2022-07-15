package com.nology.greeting;

import javax.persistence.EntityNotFoundException;

// ADDING MESSAGE TO EXCEPTION CLASS
// - GET MESSAGE TO RETRIEVE IT
public class GreetingNotFoundException extends EntityNotFoundException {
    public GreetingNotFoundException() {
        super("Greeting has not been found");
    }


}
