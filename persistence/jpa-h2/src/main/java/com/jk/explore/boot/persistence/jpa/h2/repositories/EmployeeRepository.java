package com.jk.explore.boot.persistence.jpa.h2.repositories;


import com.jk.explore.boot.persistence.jpa.h2.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
