package com.example.springdatajpa4;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name="employee_id")
    private Integer employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "hire_date")
    private LocalDate hireDate;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    private double salary;
    @Column(name = "commission_pct")
    private Double commissionPct;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
//    @OneToMany(mappedBy = "manager")
//    private Set<Employee> subordinates;
//    @OneToMany(mappedBy = "employee")
//    private Set<JobHistory> jobHistories;




}
