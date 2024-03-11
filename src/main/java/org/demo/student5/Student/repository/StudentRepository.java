package org.demo.student5.Student.repository;

import org.demo.student5.Student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByOrderByGpaDesc();

    List<Student> findByCountryOrderByGpaDesc(String country);

    Optional<Student> findById(Long id);
}
