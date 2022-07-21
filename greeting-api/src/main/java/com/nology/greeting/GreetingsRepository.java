package com.nology.greeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// <ReturnType> [operation]By[attribute]([parameter])
@Repository
public interface GreetingsRepository extends JpaRepository<Greeting, String> {
    Greeting findByid(String id);

    String deleteByid(String id);
}
