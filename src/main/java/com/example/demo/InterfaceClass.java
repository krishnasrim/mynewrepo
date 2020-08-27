package com.example.demo;

import java.io.*;
class Persist{
       public static void main(String args[]){
               try{
            	   Interfacenew emp1 =new Interfacenew(20110,"John");
            	   Interfacenew emp2 =new Interfacenew(22110,"Jerry");
            	   Interfacenew emp3 =new Interfacenew(20120,"Sam");
                      FileOutputStream fout=new FileOutputStream("output.txt");
                      ObjectOutputStream out=new ObjectOutputStream(fout);
                      out.writeObject(emp1);
                      out.writeObject(emp2);
                      out.writeObject(emp3);
                      out.flush();
                      out.close();
                      System.out.println("Serialization and Deserialization is been successfully executed");
               }
               catch(Exception e){
                      System.out.println(e);}
               }
}
