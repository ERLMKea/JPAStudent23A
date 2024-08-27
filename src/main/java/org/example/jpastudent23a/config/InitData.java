package org.example.jpastudent23a.config;

import org.example.jpastudent23a.model.Student;
import org.example.jpastudent23a.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Bruce");
        s1.setBornDate(LocalDate.of(2010,11,12));
        s1.setBornTime(LocalTime.of(10,11,12));

        studentRepository.save(s1);
        studentRepository.save(s1);
        s1.setName("Erik");
        studentRepository.save(s1);
        studentRepository.save(s1);



    }
}
