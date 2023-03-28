package iei.al.lab.university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iei.al.lab.university.dao.PersonDAO;
import iei.al.lab.university.dao.StudentDAO;
import iei.al.lab.university.entities.Person;
import iei.al.lab.university.entities.Student;
import iei.al.lab.university.entities.StudentId;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDao;
	@Autowired
	private PersonDAO personDao;


	public StudentService(StudentDAO studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        studentDao.findAll().forEach(students::add);
        return students;
    }

    public Student getStudentById(Integer studentId) {
    	
    	Optional<Person> person = personDao.findById(studentId);
    	StudentId id = new StudentId();
    	id.setPerson(person.get());
        return studentDao.findById(id).get();
    }

    public Student insert(Student student) {
        return studentDao.save(student);
    }

    
    public void update(Integer studentId, Student student) {
    	Optional<Person> person = personDao.findById(studentId);
    	StudentId id = new StudentId();
    	id.setPerson(person.get());
    	Student students = studentDao.findById(id).get();
        System.out.println(students.toString());
        students.setRegistration_date(student.getRegistration_date());
        students.setCode(student.getCode());
        studentDao.save(students);
    }
   
    public void deleteStudent(Integer studentId) {
    	Optional<Person> person = personDao.findById(studentId);
        StudentId id = new StudentId();
        id.setPerson(person.get());
        studentDao.deleteById(id);
    	//personDao.deleteById(personId);
    }
}
