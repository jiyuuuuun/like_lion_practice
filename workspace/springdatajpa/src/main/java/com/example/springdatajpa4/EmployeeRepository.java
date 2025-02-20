package com.example.springdatajpa4;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByLastName(String lastName);
    List<Employee> findBySalaryGreaterThanEqual(Double salary);
    List<Employee> findBySalaryLessThanOrSalaryGreaterThan(Double salary1, Double salary2);
    List<Employee> findByHireDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Employee> findByDepartmentIdIn(List<Integer> departmentIds);
    List<Employee> findByDepartmentIdInAndSalaryBetween(List<Integer> departmentIds, Double minSalary, Double maxSalary);
    List<Employee> findByManagerIdIsNull();
    List<Employee> findByManagerIdIsNotNull();
    List<Employee> findByCommissionPctNotNullOrderBySalaryDescCommissionPctDesc();
    List<Employee> findByLastNameStartingWith(String prefix);
    Optional<Employee> findById(Integer employeeId); // 추가된 부분


}
