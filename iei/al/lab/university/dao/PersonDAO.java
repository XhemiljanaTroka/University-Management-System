package iei.al.lab.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import iei.al.lab.university.entities.Person;

public interface PersonDAO extends JpaRepository<Person, Integer>{

}
