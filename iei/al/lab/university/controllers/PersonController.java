package iei.al.lab.university.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import iei.al.lab.university.entities.Person;
import iei.al.lab.university.service.PersonService;


@Controller
@RequestMapping("/person")
public class PersonController {
	
	    PersonService personService;

	    public PersonController(PersonService personService) {
	        this.personService = personService;
	    }

	    @GetMapping("/persons")
		public ResponseEntity<List<Person>> get() {
			return ResponseEntity.ok(personService.getPersons());
	    }
	    
	    
	    @GetMapping({"/get/{personId}"})
		public ResponseEntity<Person> getPersonById(@PathVariable Integer personId) {
			return ResponseEntity.ok(personService.getPersonById(personId));
	    }
	    
	    @PostMapping("/save")
	    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
	        Person person1 = personService.insert(person);
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.add("person", "/person" + person1.getId().toString());
	        return new ResponseEntity<>(person1, httpHeaders, HttpStatus.CREATED);
	    }
	    
	    @PutMapping({"/update/{personId}"})
	    public ResponseEntity<Person> updatePerson(@PathVariable("personId") Integer personId, @RequestBody Person person) {
	        personService.update(personId, person);
	        return new ResponseEntity<>(personService.getPersonById(personId), HttpStatus.OK);
	    }
	   
	    @DeleteMapping({"/delete/{personId}"})
	    public ResponseEntity<Person> deletePerson(@PathVariable("personId") Integer personId) {
	        personService.deletePerson(personId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

}
