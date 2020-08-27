package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class ComparatorObj {
	@Autowired
	private ComparatorClass comparator;
    private double salary;
 
    public double getSalary() {
        return salary;
    }
 
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}