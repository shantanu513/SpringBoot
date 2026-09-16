package com.springboot.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.springboot.repository.PersonRepository;
import com.springboot.schema.Person;

@Service
@RequiredArgsConstructor
public class PersonService  {
    private final PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }
    
}
