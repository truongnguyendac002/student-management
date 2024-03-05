package org.demo.student5.Student.service;
import org.demo.student5.Student.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    void save(Student student);
    void deleteById(Long studentId);

    List<Student> findAll();
    List<Student> findAllOrderByGpa();
    List<Student> findAllByAddressOrderByGpa(String address);
    List<Student> findExceptOldestDepartment();
}
