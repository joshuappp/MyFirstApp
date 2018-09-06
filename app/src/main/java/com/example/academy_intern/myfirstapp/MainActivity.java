package com.example.academy_intern.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView RegisterHere;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Username = (findViewById(R.id.etUsername));
       Password = findViewById(R.id.pPassword);
       RegisterHere = findViewById(R.id.etRegistration);
       Login = findViewById(R.id.etLogin);




       Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = Username.getText().toString();
                String password = Password.getText().toString();

                boolean validatemethod = DataSource.validate(name,password);

              if(validatemethod) {

                  Intent intent = new Intent(MainActivity.this, DataSource.class);



                  for (User user : DataSource.list) {

                      if (user.getUsername().equals(name) && user.getPassword().equals(password)) {


                          intent.putExtra("Username",user.getUsername());
                          intent.putExtra("Age",user.getAge());
                          intent.putExtra("Email",user.getEmail());

                      }

                  }




                  MainActivity.this.startActivity(intent);

              }else {
                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                  builder.setMessage("Login failed").setNegativeButton("Retry Again",null).create().show();
              }

            }
        });


        RegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registIntent = new Intent(MainActivity.this,RegistrationActivity.class);
                MainActivity.this.startActivity(registIntent);

            }
        });




        
    }


}
