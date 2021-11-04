package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Department;
import com.kodigo.agenda.demo.model.Person;

import java.util.List;

public interface IDepartmentService {
    List<Department> getDepartment();

    Department findDepartmentByID(Integer id_department);
    Department saveDepartment(Department department);
    Department updateDepartment(Department department);
    void deleteDepartmentById(Integer id_department);
}
