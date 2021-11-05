package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Department;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.utility.RegisterExistException;

import java.util.List;

public interface IDepartmentService {
    List<Department> getDepartment()throws Exception;

    Department getDepartmentByID(int id_department) throws Exception;

    Department create(Department department) throws Exception, RegisterExistException;

    void update(Department department, int id) throws Exception, RegisterExistException;

    void delete(int id) throws Exception, RegisterExistException;
}
