package com.shustov.spring.rest.dao;




import com.shustov.spring.rest.entity.Person;

import java.util.List;

public interface PersonDAO {
    public List<Person> getAllPerson();

    public void savePerson(Person person);

    public Person getPerson(int id);

    public void deletePerson(int id);
}
