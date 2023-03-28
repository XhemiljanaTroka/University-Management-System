package iei.al.lab.university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iei.al.lab.university.dao.PersonDAO;
import iei.al.lab.university.dao.StudentDAO;
import iei.al.lab.university.dao.TeacherDAO;
import iei.al.lab.university.entities.Person;
import iei.al.lab.university.entities.Student;
import iei.al.lab.university.entities.StudentId;
import iei.al.lab.university.entities.Teacher;
import iei.al.lab.university.entities.TeacherId;

@Service
public class TeacherService {
	@Autowired
	private TeacherDAO teacherDao;
	@Autowired
	private PersonDAO personDao;


	public TeacherService(TeacherDAO teacherDao) {
        this.teacherDao = teacherDao;
    }

    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teacherDao.findAll().forEach(teachers::add);
        return teachers;
    }

    public Teacher getTeacherById(Integer teacherId) {
    	
    	Optional<Person> person = personDao.findById(teacherId);
    	TeacherId id = new TeacherId();
    	id.setPerson(person.get());
        return teacherDao.findById(id).get();
    }

    public Teacher insert(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    
    public void update(Integer teacherId, Teacher teacher) {
    	Optional<Person> person = personDao.findById(teacherId);
    	TeacherId id = new TeacherId();
    	id.setPerson(person.get());
    	Teacher teachers = teacherDao.findById(id).get();
        System.out.println(teachers.toString());
        teachers.setRegistration_date(teacher.getRegistration_date());
        teachers.setCode(teacher.getCode());
        teacherDao.save(teachers);
    }
   
    public void deleteTeacher(Integer teacherId) {
    	Optional<Person> person = personDao.findById(teacherId);
        TeacherId id = new TeacherId();
        id.setPerson(person.get());
        teacherDao.deleteById(id);
    	//personDao.deleteById(personId);
    }

	
}
