package com.example.academy_intern.myfirstapp;

public class Person {

    private String username;
    private String password;
    private int age;

    public Person(String username, String password, int age){

        this.username = username;
        this.password = password;
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;

    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setAge(int Age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}
