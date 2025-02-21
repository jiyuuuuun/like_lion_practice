package com.example.springdatajpa4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


    public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
        List<Employee> findByLastName(String lastName);

        List<Employee> findBySalaryGreaterThanEqual(Double salary);

        List<Employee> findBySalaryLessThanOrSalaryGreaterThan(Double salary1, Double salary2);

        List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

        List<Employee> findByDepartment_DepartmentIdIn(List<Integer> departmentIds);

        List<Employee> findByManager_IsNull();

        List<Employee> findByManager_IsNotNull();

        List<Employee> findByCommissionPctIsNotNullOrderBySalaryDescCommissionPctDesc();

        List<Employee> findByLastNameStartingWith(String prefix);

        Optional<Employee> findById(Integer employeeId);

        List<Employee> findBySalaryBetween(Double minSalary, Double maxSalary);

        @Query("SELECT e FROM Employee e JOIN FETCH e.department d WHERE d.departmentId IN :departmentIds AND e.salary BETWEEN :minSalary AND :maxSalary")
        List<Employee> findByDepartmentIdInAndSalaryBetween(
                @Param("departmentIds") List<Integer> departmentIds,
                @Param("minSalary") Double minSalary,
                @Param("maxSalary") Double maxSalary);
    }




