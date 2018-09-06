package com.example.academy_intern.myfirstapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {


    private EditText Username;
    private EditText Password;
    private EditText Age;
    private EditText Email;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Username = findViewById(R.id.etRegistUsername);
        Password = findViewById(R.id.pRegistPassword);
        Age =   findViewById(R.id.etRegistAge);
        Email = findViewById(R.id.tvRegistEmail);
        button = findViewById(R.id.etRegistRegister);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = Username.getText().toString();
                String password = Password.getText().toString();
                String age = Age.getText().toString();
                String email = Email.getText().toString();

                if (validation(email)) {

                        if (name.isEmpty() && password.isEmpty() && age.isEmpty()) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity.this);
                            builder.setMessage("Fill all the filds").setNegativeButton("Retry Again", null).create().show();

                        } else {

                            User user = new User(name, password, age, email);

                            DataSource.list.add(user);

                            Toast.makeText(RegistrationActivity.this, "User Registered", Toast.LENGTH_SHORT).show();


                        }
                }else{
                    Toast.makeText(RegistrationActivity.this,"Enter Email",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public boolean validation(String email){

        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());

    }
}
