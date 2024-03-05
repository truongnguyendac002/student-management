package org.demo.student5.Student.repository;

import org.demo.student5.Student.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findTopByOrderByStartYearAsc();

}
