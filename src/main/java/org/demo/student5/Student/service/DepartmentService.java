package org.demo.student5.Student.service;

import org.demo.student5.Student.models.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    List<Department>  findAll();
}
