package org.example.jpastudent23a.controller;

import org.example.jpastudent23a.model.Student;
import org.example.jpastudent23a.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/studentsxx")
    public List<Student> studentsxx() {
        List<Student> std = studentRepository.findAll();
        return std;
    }

    @GetMapping("/hellox")
    public String hellox() throws InterruptedException {
        return "Hello World";
    }


    @GetMapping("/hello/{sleep}")
    public String hellosleep(@PathVariable int sleep) throws InterruptedException {
        Thread.sleep(sleep);
        return "Hello World";
    }

    @GetMapping("/students")
    public List<Student> students() {
        List<Student> std = studentRepository.findAll();
        return std;
    }

    @GetMapping("/addstudent")
    public List<Student> addstudent() {
        Student std = new Student();
        std.setBornDate(LocalDate.now());
        std.setBornTime(LocalTime.now());
        std.setName("hej");
        studentRepository.save(std);
        std.setName("Autogenerated id=" + std.getId());
        studentRepository.save(std);
        return studentRepository.findAll();
    }

    @GetMapping("students/hej")
    public List<Student> getallstudentsbyhej(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }

    @GetMapping("students/{name}")
    public List<Student> getallstudentsbyname(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }

    @PutMapping("/student")
    public ResponseEntity<Student> putStudent(@RequestBody Student student) {
        Optional<Student> std = studentRepository.findById(student.getId());
        if (std.isPresent()) {
            System.out.println(student);
            studentRepository.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> std = studentRepository.findById(id);
        if (std.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }


}
