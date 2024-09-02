package org.example.jpastudent23a.repositories;

import org.example.jpastudent23a.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByName(String name);

}

