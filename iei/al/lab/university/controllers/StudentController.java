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

import iei.al.lab.university.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	StudentService studentService;
	
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
	public ResponseEntity<List<Student>> get() {
		return ResponseEntity.ok(studentService.getStudents());
    }
    
  
    @GetMapping({"/get/{studentId}"})
	public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
		return ResponseEntity.ok(studentService.getStudentById(studentId));
    }
  
 
   @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student student1 = studentService.insert(student);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("student", "/student" + student1.getId().toString());
        return new ResponseEntity<>(student1, httpHeaders, HttpStatus.CREATED);
    }
 
    
   @PutMapping({"/update/{studentId}"})
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        studentService.update(studentId, student);
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }
   
   
   @DeleteMapping({"/delete/{studentId}"})
   public ResponseEntity<Student> deleteStudent(@PathVariable("studentId") Integer studentId) {
       studentService.deleteStudent(studentId);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}
