package org.demo.student5.Student.controllers;

import org.demo.student5.Student.models.Department;
import org.demo.student5.Student.models.Student;
import org.demo.student5.Student.repository.StudentRepository;
import org.demo.student5.Student.service.DepartmentService;
import org.demo.student5.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentRepository studentRepository;


    //add student
//    @GetMapping("/student/add")
//    public String add(Model model) {
//        model.addAttribute("student", new Student());
//
//        List<Department> departments = departmentService.findAll();
//
//        model.addAttribute("departments", departments);
//        return "add-student";
//    }

    @PostMapping("api/v1/student/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/menu/student/add";
    }

    //delete student
//    @GetMapping("/student/delete")
//    public String deleteStudent(Model model) {
//        List<Student> students = studentService.findAll();
//        model.addAttribute("students", students);
//        return "delete-student";
//    }

    @PostMapping("/student/delete")
    public String deleteStudent(@RequestParam("studentId") Long studentId) {
        studentService.deleteById(studentId);
        return "redirect:/menu/student/delete";
    }
//    @GetMapping("/student/list")
//    public String displayListStudent() {
//        return "list-student";
//    }

    @GetMapping("/student/list/all")
    public List<Student> listStudent(Model model) {
        List<Student> students = studentService.findAll();
//        System.out.println("tim kiem student");
        model.addAttribute("students", students);
        return students;
    }

    @GetMapping("/student/list/order=gpa")
    public List<Student> listStudentsOrderByGpa(Model model) {
        List<Student> students = studentService.findAllOrderByGpa();
        model.addAttribute("students", students);
        return students;

    }

    @GetMapping("/student/list/address=HaNoi&order=gpa")
    public List<Student> listStudentsByAddress(Model model) {
        List<Student> students = studentService.findAllByAddressOrderByGpa("HaNoi");
        model.addAttribute("students", students);
        return students;

    }

    @GetMapping("/student/list/order=gpa&except=oldest")
    public List<Student> litStudentExceptOldest(Model model) {
        List<Student> students = studentService.findExceptOldestDepartment();
        model.addAttribute("students", students);
        return students;

    }

}
