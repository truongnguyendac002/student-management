package org.demo.student5.Student.controllers;

import org.demo.student5.Student.repository.StudentRepository;
import org.demo.student5.Student.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    //add student
    @GetMapping("/addStudent")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/addStudent";
    }

    //delete student
    @GetMapping("/deleteStudent")
    public String showDeleteForm(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "delete-student";
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") Long studentId) {
        studentRepository.deleteById(studentId);
        return "redirect:/deleteStudent";
    }
    @GetMapping("/listOption")
    public String listOption(Model model) {
        return "list-option";
    }

    @GetMapping("/listStudents1")
    public String listStudents1(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "list-students";
    }

    @GetMapping("/listStudents2")
    public String listStudents2(Model model) {
        List<Student> students = studentRepository.findAllByOrderByGpaDesc();
        model.addAttribute("students", students);
        return "list-students";
    }

    @GetMapping("/listStudents3")
    public String listStudents3(Model model) {
        List<Student> students = studentRepository.findByCountryOrderByGpaDesc("HaNoi");
        model.addAttribute("students", students);
        return "list-students";
    }

    @GetMapping("/listStudents4")
    public String listStudents4(Model model) {
        List<Student> students = studentRepository.findAll();
        String oldestDepartment = findOldestDepartment(students);
        students.removeIf(student -> student.getDepartment().equals(oldestDepartment));
        model.addAttribute("students", students);
        return "list-students";
    }
    private String findOldestDepartment(List<Student> students) {
        String oldestDepartment= "";
        int oldestDepartmentNumber = Integer.MAX_VALUE;

        for (Student student : students) {
            StringBuilder department = new StringBuilder(student.getDepartment());
            System.out.println(department);
            int departmentNumber = Integer.parseInt(String.valueOf(department.replace(0,1,""))) ;
            if (departmentNumber < oldestDepartmentNumber) {
                oldestDepartmentNumber = departmentNumber;
                oldestDepartment = student.getDepartment();
            }
        }
        return oldestDepartment;
    }

}
