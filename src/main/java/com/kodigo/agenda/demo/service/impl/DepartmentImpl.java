package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Department;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IDepartmentRepository;
import com.kodigo.agenda.demo.service.IDepartmentService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class DepartmentImpl implements IDepartmentService {
    private final IDepartmentRepository departmentRepository;

    public DepartmentImpl(IDepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentByID(int id_department) throws Exception {
        Optional<Department> departmentDB = departmentRepository.findById(id_department);
        if (departmentDB.isPresent())
            return departmentDB.get();
        throw new RegisterExistException("The id of the Department no exist in the DataBase");
    }

    @Override
    public Department create(Department department) throws Exception, RegisterExistException {
        Optional<Department> department1 = departmentRepository.findById(department.getId_department());
        if (department1.isPresent())
            throw new RegisterExistException("The id of the Departmet already exist in the DataBase");
        return departmentRepository.save(department);
    }

    @Override
    public void update(Department department, int id) throws Exception, RegisterExistException {
        Optional<Department> department1 = departmentRepository.findById(id);
        if (department1.isPresent()) {
            department.setId_department(id);
            departmentRepository.save(department);
            return;
        }
        throw new RegisterExistException("The id of the Department no exist in the DataBase");
    }

    @Override
    public void delete(int id) throws Exception, RegisterExistException {
        Optional<Department> departmentDB = departmentRepository.findById(id);
        if (departmentDB.isPresent()) {
            departmentRepository.deleteById(id);
            return;
        }
        throw new RegisterExistException("The id of the Department no exist in the DataBase");
    }

}
