package com.howtodoinjava.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.service.EmployeeService;
import com.howtodoinjava.demo.config.RequestMappingConfig;
 
@RestController
public class EmployeeController
{
    @Autowired
    EmployeeService service;
 
    @GetMapping(RequestMappingConfig.EMPLOYEE_FETCH_ALL)
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping(RequestMappingConfig.EMPLOYEE_FETCH_ONE)
    public ResponseEntity<EmployeeEntity> getEmployeeById(@RequestBody EmployeeEntity employeeEntity)
                                                    throws RecordNotFoundException {
        EmployeeEntity entity = service.getEmployeeById(employeeEntity.getId());
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping(RequestMappingConfig.EMPLOYEE_CREATE)
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
                                                    throws RecordNotFoundException {
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping(RequestMappingConfig.EMPLOYEE_DELETE)
    public ResponseEntity<EmployeeEntity> deleteEmployeeById(@RequestBody EmployeeEntity employeeEntity)
                                                    throws RecordNotFoundException {
        service.deleteEmployeeById(employeeEntity.getId());
        return new ResponseEntity<EmployeeEntity>(employeeEntity, new HttpHeaders(), HttpStatus.OK);
    }
 
}