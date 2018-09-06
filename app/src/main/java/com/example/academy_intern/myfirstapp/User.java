package com.example.academy_intern.myfirstapp;

public class User extends Person{


    private String age;
    private String email;

    public User(String username,String password,String age,String email){

         super(username,password);

         this.age = age;
         this.email = email;

    }

    public void setAge(int Age){
        this.age = age;
    }

    public String getAge(){
        return age;
    }

    public String getEmail(){
        return email;
    }
}
