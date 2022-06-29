/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rqchallenge.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ranjit Patil
 */
public class Employees {
    
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        if(employeeList == null){
            return new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
