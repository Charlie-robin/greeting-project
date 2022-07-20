package com.nology.greeting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingsRepository extends JpaRepository<Greeting, String> {
}
