package com.shustov.spring.rest.service;



import com.shustov.spring.rest.dao.PersonDAO;
import com.shustov.spring.rest.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;
    @Override
    @Transactional
    public List<Person> getAllPerson() {
        return personDAO.getAllPerson();
    }

    @Override
    @Transactional
    public void savePerson(Person employee) {
        personDAO.savePerson(employee);
    }

    @Override
    @Transactional
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }

    @Override
    @Transactional
    public void deletePerson(int id) {
        personDAO.deletePerson(id);
    }
}
