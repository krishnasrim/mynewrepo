package com.example.demo;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;

public class ComparatorClass implements Comparator<ComparatorObj> {
    @Override
	public int compare(ComparatorObj o1, ComparatorObj o2) {
		// TODO Auto-generated method stub
		 if (o1.getSalary() < o2.getSalary()) {
	            return -1;
	        } else if (o1.getSalary() > o2.getSalary()) { 
	            return 1;
	        } else {
	            return 0;
	        }}}

