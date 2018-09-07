package com.example.academy_intern.myfirstapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DataSource extends AppCompatActivity {

    public static List<User> list = new ArrayList<User>();

    private TextView Username;
    private TextView Age;
    private TextView Id;
    private Button logout;
    private SearchView search;
    private TextView searchResult;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_source);

        Username =  findViewById(R.id.etUsername);
        Age = findViewById(R.id.etUserAge);
        Id = findViewById(R.id.email_Id);
        logout = findViewById(R.id.bLogout);
        searchButton = findViewById(R.id.bserachButton);
        search = findViewById(R.id.userSearch);
        searchResult = findViewById(R.id.userSearchAge);





        Intent intent = getIntent();

        String username = intent.getStringExtra("Username");
        int age = intent.getIntExtra("Age",-1);
        String id = intent.getStringExtra("Email") ;


        Username.setText(username);
        Age.setText(age+"");
        Id.setText(id);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String searchN = search.getQuery().toString();

                String result =  searchMethod(searchN);


                    searchResult.setText(result);



            }
        });






        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSource.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }

    public static boolean validate(String name, String pass) {

                for (User user : list) {

                        if (user.getUsername().equals(name) && user.getPassword().equals(pass)) {


                            return true;

                        }

                }
        return false;
    }


    public String searchMethod(String search){

        for(User user: list){


            if(user.getUsername().equals(search)){

                return user.getEmail();

            }

        }
        return "User Not Registered";
    }
}


