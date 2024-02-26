package org.demo.student5.Student.repository;

import org.demo.student5.Student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByOrderByGpaDesc();

    List<Student> findByCountryOrderByGpaDesc(String country);
}
