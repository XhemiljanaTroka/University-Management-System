package iei.al.lab.university.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import iei.al.lab.university.dao.PersonDAO;
import iei.al.lab.university.entities.Person;

@Service
public class PersonService {
	@Autowired
	private PersonDAO personDao;


	public PersonService(PersonDAO personDao) {
        this.personDao = personDao;
    }

    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        personDao.findAll().forEach(persons::add);
        return persons;
    }

    public Person getPersonById(Integer id) {
        return personDao.findById(id).get();
    }

    public Person insert(Person person) {
        return personDao.save(person);
    }

    
    public void update(Integer id, Person person) {
        Person persons = personDao.findById(id).get();
        System.out.println(persons.toString());
        persons.setName(person.getName());
        persons.setSurname(person.getSurname());
        persons.setBirthDate(person.getBirthDate());
        personDao.save(persons);
    }

   
    public void deletePerson(Integer personId) {
        personDao.deleteById(personId);
    }
	
	}