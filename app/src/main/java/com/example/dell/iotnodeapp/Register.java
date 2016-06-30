package com.example.dell.iotnodeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private static TextView homepage;
    private static Button btn_signup;
    private static EditText reg_email;
    private static EditText user_name;
    private static EditText reg_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        Homepage_Button();
        validate();
        register_button();

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


    public void Homepage_Button() {
        homepage = (TextView) findViewById(R.id.link_to_login);
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                // TODO Auto-generated method stub
            }
        });
    }

    public boolean validate() {
        reg_email = (EditText) findViewById(R.id.regEmail);
        user_name = (EditText) findViewById(R.id.UserName);
        reg_password = (EditText) findViewById(R.id.pass);
        boolean valid = true;

        String name = user_name.getText().toString();
        String email = reg_email.getText().toString();
        String password = reg_password.getText().toString();

        if (name.length() < 3) {
            user_name.setError("at least 3 characters");
            valid = false;
        } else {
            user_name.setError(null);
        }

        if ( !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            reg_email.setError("enter a valid email address");
            valid = false;
        } else {
            reg_email.setError(null);
        }

        if ( password.length() < 4 || password.length() > 10) {
            reg_password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            reg_password.setError(null);
        }

        return valid;
    }
    public void register_button() {
        btn_signup = (Button)findViewById(R.id.btnsignup);
        btn_signup.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if (validate()) {
                            Toast.makeText(Register.this, "Account created successfully", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(Register.this, "Registeration failed", Toast.LENGTH_SHORT).show();


                        }


                    }
                }
        );
    }
}