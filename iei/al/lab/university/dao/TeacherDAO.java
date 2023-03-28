package iei.al.lab.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import iei.al.lab.university.entities.Teacher;
import iei.al.lab.university.entities.TeacherId;

public interface TeacherDAO extends JpaRepository<Teacher, TeacherId>{

}
