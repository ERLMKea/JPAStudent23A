package org.example.jpastudent23a.repositories;

import org.example.jpastudent23a.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
