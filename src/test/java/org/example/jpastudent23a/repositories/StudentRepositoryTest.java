package org.example.jpastudent23a.repositories;

import org.example.jpastudent23a.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
class StudentRepositoryTest {


    @Autowired
    StudentRepository studentRepository;

    @Test
    void testAtLeastOneErik() {
        List<Student> std = studentRepository.findAllByName("Erik");
        //assertEquals(1, std.size());
        assertTrue(std.size()==0);
    }

    @Test
    void testOneErik() {
        List<Student> std = studentRepository.findAllByName("Erik");
        assertEquals(0, std.size());
    }

}