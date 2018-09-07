package com.example.academy_intern.myfirstapp;

public class User extends Person{


    private String email;

    public User(String username,String password,int age,String email){

         super(username,password,age);

         this.email = email;

    }

    public String getEmail(){
        return email;
    }
}
