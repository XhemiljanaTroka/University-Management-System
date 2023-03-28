package iei.al.lab.university.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import iei.al.lab.university.entities.Person;
import iei.al.lab.university.entities.Student;
import iei.al.lab.university.entities.StudentId;

public interface StudentDAO extends JpaRepository<Student, StudentId> {

	Optional<Person> findById(Integer id);

}
