/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rqchallenge;

/**
 *
 * @author Ranjit Patil
 */

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.example.rqchallenge.controller.EmployeeController;
import com.example.rqchallenge.dao.EmployeeDAO;
import com.example.rqchallenge.model.Employee;
import com.example.rqchallenge.model.Employees;
import java.io.IOException;
import java.util.List;
import org.mockito.Mockito;
import static org.mockito.Mockito.doReturn;
import org.springframework.http.HttpStatus;
 
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest 
{
    @InjectMocks
    EmployeeController employeeController;
     
    @Mock
    EmployeeDAO employeeDAO;
     
    @Test
    public void testCreateEmployee() throws IOException 
    {
        Employee newEmployee = new Employee(9, "Tom", 1234, 6789);
        
        Employee employee = new Employee(9, "Tom", 1234, 6789);
        
        Employee employeeRespose = employeeDAO.createEmployee(newEmployee); 
        Mockito.when(employeeDAO.createEmployee(newEmployee)).thenReturn(newEmployee);
        //doReturn(employeeRespose).when(newEmployee.getName().equals("Tom")).toString();
        
        ResponseEntity<Object> responseEntity = new ResponseEntity(employeeController.getAllEmployees(), HttpStatus.OK);
         
        //assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
     System.out.println("--"+employeeController.getAllEmployees().toString());
     
        assertThat(responseEntity.getBody()).isEqualTo("Tom");
    }
     
    @Test
    public void testFindAll() 
    {
        // given
        Employee employee1 = new Employee(9, "Tom", 1234, 6789);
        Employee employee2 = new Employee(10, "Jim", 4567, 12345);
        Employees employees = new Employees();
        employees.setEmployeeList(Arrays.asList(employee1, employee2));
 
        doReturn(employees).when(employeeDAO.getAllEmployees());
        
        // when
        //Employees result = employeeController.getAllEmployees();
        // then
        assertThat(employeeDAO.getAllEmployees().size()).isEqualTo(7);
    }
}
