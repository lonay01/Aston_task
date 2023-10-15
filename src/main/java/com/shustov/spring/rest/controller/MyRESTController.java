package com.shustov.spring.rest.controller;


import com.shustov.spring.rest.entity.Person;

import com.shustov.spring.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> showAllPersons() {
        List<Person> allPerson = personService.getAllPerson();

        return allPerson;
    }

    @GetMapping("/{id}")
    public Person showPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @PutMapping("/add")
    public Person updatePerson(@RequestBody Person person) {
        personService.savePerson(person);

        return person;
    }

    @PostMapping("/add_money")
    public String updatePerson(@RequestParam  int id, @RequestParam  int money) {
        Person person = personService.getPerson(id);
        person.setMoney(person.getMoney() + money);
        personService.savePerson(person);
        return "OK!";
    }



    @PostMapping("/delete")
    public String addNewPerson(@RequestParam int  id1, @RequestParam int pin, @RequestParam int howMuch) throws Exception {

        Person person1 = personService.getPerson(id1);

        if (pin == person1.getPin() && person1.getMoney() >= howMuch)  {
            person1.setMoney(person1.getMoney() - howMuch);
            personService.savePerson(person1);
        }
        else
            throw new Exception();
        return "OK!";

    }


    @PostMapping("/transfer")
    public String addNewPerson(@RequestParam int  id1, @RequestParam int id2, @RequestParam int pin, @RequestParam int howMuch) throws Exception {

        Person person1 = personService.getPerson(id1);
        Person person2 = personService.getPerson(id2);
        if (pin == person1.getPin() && person1.getMoney() >= howMuch) {
            person1.setMoney(person1.getMoney() - howMuch);
            person2.setMoney(person2.getMoney() + howMuch);
            personService.savePerson(person1);
            personService.savePerson(person2);
        }
        else
            throw new Exception();
        return "OK!";

    }





}
