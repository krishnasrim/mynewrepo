package com.example.demo;

import java.io.Serializable;
public class Interfacenew implements Serializable{
       private static final long serialVersionUID = 1L; //Serial Version UID
       int id;
       String name;
       public Interfacenew(int id, String name) {
             this.id = id;
             this.name = name; 
       }
}