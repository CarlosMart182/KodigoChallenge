package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Department;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app/v1/department")
public class DepartmentController {
    @Autowired
    private final IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/api/department", method = RequestMethod.GET)
    public List<Department> getDepartment() {
        try{
            List<Department> test = departmentService.getDepartment();
            test.forEach(System.out::println);
            return test;
        } catch (Exception e){
            return (List<Department>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/department/{id}", method = RequestMethod.GET)
    public Department findDepartmentById(@PathVariable Integer id_department) {
        try{
            return departmentService.findDepartmentByID(id_department);
        } catch (Exception e){
            return new Department(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/department", method = RequestMethod.POST)
    public ResponseEntity<Object> saveDepartment(@RequestBody Department department) {
        try {
            Department departmentSaved = departmentService.saveDepartment(department);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(departmentSaved.getId_department()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/department", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDepartment(@RequestBody Department department, @PathVariable Department department1) {
        try {
            departmentService.updateDepartment(department1);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "api/department/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDepartment(@PathVariable Integer id_department) {
        try {
            departmentService.deleteDepartmentById(id_department);
            return ResponseEntity.status(HttpStatus.OK).build();
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
