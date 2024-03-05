package org.demo.student5.Student.service;

import org.demo.student5.Student.models.Department;
import org.demo.student5.Student.models.Student;
import org.demo.student5.Student.repository.DepartmentRepository;
import org.demo.student5.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public void save(Student student) {
        student.setAccess(true);
//        System.out.println("luu student");
        studentRepository.save(student);
    }

    @Override
    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllOrderByGpa() {
        return studentRepository.findAllByOrderByGpaDesc();
    }

    @Override
    public List<Student> findAllByAddressOrderByGpa(String address) {
        return studentRepository.findByCountryOrderByGpaDesc(address);
    }

    @Override
    public List<Student> findExceptOldestDepartment() {
        List<Student> students = studentRepository.findAll();
        Department oldestDepartment = departmentRepository.findTopByOrderByStartYearAsc();
        students.removeIf(student -> student.getDepartment().equals(oldestDepartment));
        return students;
    }


}
