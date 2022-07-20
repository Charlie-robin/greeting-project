package com.nology.greeting;

import org.springframework.data.jpa.repository.JpaRepository;
// -> TYPE / CLASS IT IS STORING
// -> TYPE OF THE ID / PRIMARY KEY
public interface GreetingsRepository extends JpaRepository<Greeting, String> {
}
