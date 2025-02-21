package com.example.springdatajpa4;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "job_history")
@Getter
@Setter
@NoArgsConstructor
public class JobHistory {
    @Id
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;
    @Id
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department; }
