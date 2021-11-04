package com.kodigo.agenda.demo.repository;

import com.kodigo.agenda.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
}
