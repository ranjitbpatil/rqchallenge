/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rqchallenge.model;

import java.math.BigDecimal;
import java.util.Currency;

/**
 *
 * @author ranjit
 */
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private Integer salary;
    public Employee(Integer id, String name, Integer age, Integer salary) {
        
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + '}';
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

}
