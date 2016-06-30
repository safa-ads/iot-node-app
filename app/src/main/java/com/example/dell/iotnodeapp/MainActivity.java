package com.example.dell.iotnodeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static EditText email;
    private static EditText password;
    private static Button btn_login;
    private static TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerButton();
        LoginButton();
    }

    public void registerButton() {
        register = (TextView) findViewById(R.id.link_to_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register_page = new Intent("com.example.dell.iotnodeapp.Register");
                startActivity(register_page);
                // TODO Auto-generated method stub
            }
        });
    }

    public void LoginButton() {
        btn_login = (Button) findViewById(R.id.btnSingIn);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        btn_login.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        //if (email.getText().toString().equals("safa.ads@gmail.com") &&
                            //    password.getText().toString().equals("111")) {
                            Intent intent = new Intent("com.example.dell.iotnodeapp.MapsActivity");
                            startActivity(intent);
//                        }
//                        else
//                            Toast.makeText(MainActivity.this, "Username or password are incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
