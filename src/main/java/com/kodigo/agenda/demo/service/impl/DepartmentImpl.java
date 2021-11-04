package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Department;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IDepartmentRepository;
import com.kodigo.agenda.demo.service.IDepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public Department findDepartmentByID(Integer id_department) {
        Department departmentTmp = departmentRepository.getById(id_department);
        return departmentTmp;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        Department departmentTmp = departmentRepository.getById(department.getId_department());
        return departmentRepository.save(departmentTmp);    }

    @Override
    public void deleteDepartmentById(Integer id_department) {
        Department departmentTmp = departmentRepository.getById(id_department);
        departmentRepository.delete(departmentTmp);
    }
}
