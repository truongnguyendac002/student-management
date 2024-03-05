package org.demo.student5.Student.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column
    private int startYear;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Student> students;



}
