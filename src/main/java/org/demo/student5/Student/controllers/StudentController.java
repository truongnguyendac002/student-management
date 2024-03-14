package org.demo.student5.Student.controllers;

import org.demo.student5.Student.models.Student;
import org.demo.student5.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/menu/student/add";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") Long studentId) {
        studentService.deleteById(studentId);
        return "redirect:/menu/student/delete";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/list/all")
    public List<Student> listStudent(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return students;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/list/order=gpa")
    public List<Student> listStudentsOrderByGpa(Model model) {
        List<Student> students = studentService.findAllOrderByGpa();
        model.addAttribute("students", students);
        return students;

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/list/address=HaNoi&order=gpa")
    public List<Student> listStudentsByAddress(Model model) {
        List<Student> students = studentService.findAllByAddressOrderByGpa("HaNoi");
        model.addAttribute("students", students);
        return students;

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/list/order=gpa&except=oldest")
    public List<Student> litStudentExceptOldest(Model model) {
        List<Student> students = studentService.findExceptOldestDepartment();
        model.addAttribute("students", students);
        return students;

    }

}
