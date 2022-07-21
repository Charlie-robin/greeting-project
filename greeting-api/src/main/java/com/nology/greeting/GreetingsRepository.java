package com.nology.greeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingsRepository extends JpaRepository<Greeting, String> {
    Greeting findByid(String id);

    void deleteByid(String id);
}
