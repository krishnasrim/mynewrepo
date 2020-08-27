package com.example.demo;

interface TestInterface1 
{ 
    // default method 
    default void show() 
    { 
        System.out.println("Default TestInterface1"); 
    } 
    //normal method
    public void new2() ;
    
    
} 
  
interface TestInterface2 
{ 
    // Default method 
    default void show() 
    { 
        System.out.println("Default TestInterface2"); 
    } 
} 
  
// Implementation class code 
class DefaultClass implements TestInterface1, TestInterface2 
{ 
    // Overriding default show method 
    public void show() 
    { 
        // use super keyword to call the show 
        // method of TestInterface1 interface 
        TestInterface1.super.show(); 
  
        // use super keyword to call the show 
        // method of TestInterface2 interface 
        TestInterface2.super.show(); 
    } 
  
    public static void main(String args[]) 
    { 
    	DefaultClass d = new DefaultClass(); 
        d.show(); 
    }

	@Override
	public void new2() {
		// TODO Auto-generated method stub
		
	} 
} 
