package com.example.StudentManagement.controller;

import com.example.StudentManagement.exception.ResourceNotFoundException;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //get all students
    @GetMapping("/fetch")
    public List<Student> getAllStudents(){

        return studentRepository.findAll();

    }

    //create student
    @PostMapping("/fetch")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //get student by id
    @GetMapping("/fetch/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with Id:" + id));
        return ResponseEntity.ok(student);
    }

    //update student
    @PutMapping("/fetch/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student studentDetails){
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" +id));

        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());
        student.setSubject(studentDetails.getSubject());

        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    //delete student
    @DeleteMapping("fetch/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable String id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" +id));

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);


    }














}
