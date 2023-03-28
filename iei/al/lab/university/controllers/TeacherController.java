package iei.al.lab.university.controllers;

import java.util.List;


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
import iei.al.lab.university.entities.Student;
import iei.al.lab.university.entities.Teacher;
import iei.al.lab.university.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {


	TeacherService teacherService;
	
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
	public ResponseEntity<List<Teacher>> get() {
		return ResponseEntity.ok(teacherService.getTeachers());
    }
    
  
    @GetMapping({"/get/{teacherId}"})
	public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer teacherId) {
		return ResponseEntity.ok(teacherService.getTeacherById(teacherId));
    }
  
    @PostMapping("/save")
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        Teacher teacher1 = teacherService.insert(teacher);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("teacher", "/teacher" + teacher1.getId().toString());
        return new ResponseEntity<>(teacher1, httpHeaders, HttpStatus.CREATED);
    }
 
    
   @PutMapping({"/update/{teacherId}"})
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("teacherId") Integer teacherId, @RequestBody Teacher teacher) {
        teacherService.update(teacherId, teacher);
        return new ResponseEntity<>(teacherService.getTeacherById(teacherId), HttpStatus.OK);
    }
   
   
   @DeleteMapping({"/delete/{teacherId}"})
   public ResponseEntity<Student> deleteTeacher(@PathVariable("teacherId") Integer teacherId) {
       teacherService.deleteTeacher(teacherId);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}
