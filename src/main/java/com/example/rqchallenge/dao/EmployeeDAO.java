/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ranjit Patil
 */
package com.example.rqchallenge.dao;

import com.example.rqchallenge.employees.IEmployeeController;
import com.example.rqchallenge.model.Employees;
import com.example.rqchallenge.model.Employee;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
Logger logger = LoggerFactory.getLogger(IEmployeeController.class);    
private static List<Employee> list = new ArrayList<Employee>();
final String DELETE_MESSAGE = "successfully! deleted Record";
static{
    list.add(new Employee(1, "Ranjit", 44, 888888899));
    list.add(new Employee(2, "Frank", 44, 777777777));
    list.add(new Employee(3, "Scott", 44, 4444444));
    list.add(new Employee(1, "John", 44, 555555555));
    list.add(new Employee(5, "Smith", 44, 565756));
}
    public List<Employee> getAllEmployees() {
        return list;
    }

    public List<Employee> getEmployeeByName(String name) {
        
        return  list.stream().filter(employee -> employee.getName().equals(name)).collect(Collectors.toList()); 
    }
    
    public Employee getEmployeeById(String id) {
        //return  list.stream().filter(employee -> employee.getId()==(id)).findFirst().;
       return list.stream()
        .filter(employee -> employee.getId().equals(new Integer(id)))
        .reduce((a, b) -> {
            throw new IllegalStateException("Multiple elements: " + a + ", " + b);
        }).get();
    }

    public Integer getHighestSalaryOfEmployees() {
        return list.stream().map(Employee :: getSalary)
        .max(Integer::compare).get();
    }

    public List<String> getTopTenHighestEarningEmployeeNames() {
        return list.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .limit(3).map(Employee:: getName).collect(Collectors.toList());
    }

    public Employee createEmployee(Employee employeeInput) {
        //return new ResponseEntity<Employee>(new Employee(1, "Ranjit", 44, 111111), HttpStatus.OK);
        System.out.println("-------:"+ list);
        Integer id = list.stream().map(Employee :: getId)
        .max(Integer::compare).get()+1;
        //Integer id = getAllEmployees().size() +1;
        logger.info(employeeInput.toString());
        employeeInput.setId(id);
        list.add(employeeInput);
        return employeeInput;
    }

    public String deleteEmployeeById(Employee employee) {
        list.remove(employee);
        return DELETE_MESSAGE;
    }
}
