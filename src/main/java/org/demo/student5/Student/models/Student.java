package org.demo.student5.Student.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
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
    @NotBlank
    @Size(max = 50)
    private String department;
    @NotBlank
    @Size(max = 50)
    private String major;
    @NotBlank
    @Size(max = 50)
    private String country;


    public Student(Long id, String name, int age, double gpa, String department, String major, String country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.department = department;
        this.major = major;
        this.country = country;
    }

}
