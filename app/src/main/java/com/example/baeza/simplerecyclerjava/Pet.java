package com.example.baeza.simplerecyclerjava;

/**
 * Created by baeza on 25.01.2018.
 */

public class Pet {
    private String name;
    private int age;

    public Pet(String name, int age){
    this.name = name;
    this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
}
