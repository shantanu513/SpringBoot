package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.schema.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
