package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.dto.PassportResponseDto;
import com.springboot.dto.PersonResponseDto;
import com.springboot.repository.PassportRepository;
import com.springboot.schema.Passport;
import com.springboot.schema.Person;
import com.springboot.service.PersonService;

import lombok.RequiredArgsConstructor;

//OneToOne Relationship
@RestController
@RequestMapping("/api/v1/passports")
public class PassportController {   
    private final PersonService personService;
    private final PassportRepository passportRepository;

    @Qualifier("offlineOrder")
    private final Order order;

    public PassportController(PersonService personService,PassportRepository passportRepository
    ,@Qualifier("onlineOrder") Order order){
        this.personService=personService;
        this.passportRepository=passportRepository;
        this.order=order;
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        Passport passport=new Passport();
        passport.setPassportNo("ABCD123");

        Person person2=new Person();
        person2.setPassport(passport);
        person2.setName(person.getName());

        // passportRepository.save(passport);

        return personService.save(person2);
    }

    @GetMapping("/{id}")
    public PersonResponseDto getPersonById(@PathVariable Long id) {
        Person person=personService.findById(id);

        PersonResponseDto personResponseDto=new PersonResponseDto(person.getId(),person.getName(),person.getPassport().getPassportNo());
        return personResponseDto;
    }

    @GetMapping("/passport/{id}")
    public PassportResponseDto getPassportById(@PathVariable Long id){

        Passport passport=passportRepository.findById(id).get();

        PassportResponseDto passportResponseDto=new PassportResponseDto(passport.getId(),passport.getPassportNo(),passport.getPerson().getName());

        return passportResponseDto;
    }


    @GetMapping("/dummy")
    public String getPassportById1(){
        return "Shantanu";
    }

    
}

interface Order{
    public void createOrder();
}
@Component
@Qualifier("onlineOrder")
class OnlineOrder implements Order{

    @Override
    public void createOrder() {
        System.out.println("Creating Online Order");
    }
}
@Component
@Qualifier("offlineOrder")
class OfflineOrder implements Order{

    @Override
    public void createOrder() {
        System.out.println("Creating Offline Order");
    }
}