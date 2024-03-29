package org.demo.student5.Student.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 50)
    private String name;
    @Min(value = 18)
    private int age;
    @Min(value = 0)
    @Max(value = 4)
    private double gpa;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;


    private String major;

    private String country;

    private boolean access;


}
