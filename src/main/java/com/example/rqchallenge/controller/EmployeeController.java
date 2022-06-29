package com.example.rqchallenge.controller;

import com.example.rqchallenge.model.Employee;
import com.example.rqchallenge.dao.EmployeeDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.rqchallenge.employees.IEmployeeController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path="/api/v1")
public class EmployeeController implements IEmployeeController{

    Logger logger = LoggerFactory.getLogger(IEmployeeController.class);
     @Autowired
     private EmployeeDAO employeDAO;
     
    @GetMapping(path="/employees", produces = "application/json")
    public ResponseEntity<List<Employee>> getAllEmployees() throws IOException{
        logger.info("");
        return new ResponseEntity<List<Employee>>(employeDAO.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<Employee>> getEmployeesByNameSearch(@PathVariable String searchString){
        return new ResponseEntity<List<Employee>>(employeDAO.getEmployeeByName(searchString), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id){
        return new ResponseEntity<Employee>(employeDAO.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/highestSalary")
    public ResponseEntity<Integer> getHighestSalaryOfEmployees(){
        return new ResponseEntity<Integer>(employeDAO.getHighestSalaryOfEmployees(), HttpStatus.OK);
    }

    @GetMapping("/topTenHighestEarningEmployeeNames")
    public ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames(){
        return new ResponseEntity<List<String>>(employeDAO.getTopTenHighestEarningEmployeeNames(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employeeInput){
        return new ResponseEntity<Employee>(employeDAO.createEmployee(employeeInput), HttpStatus.OK);
    }

    

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String id){
        return new ResponseEntity<String>(employeDAO.deleteEmployeeById(employeDAO.getEmployeeById(id)), HttpStatus.OK);
    }

}
