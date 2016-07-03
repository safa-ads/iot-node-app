package com.example.dell.iotnodeapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableString;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class device extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static Button btn_editcomm;
    private static TextView comm_device;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        spinner = (Spinner) findViewById(R.id.spinner);
        editcomm_btn();
        spinner.setOnItemSelectedListener(this);
        ArrayList categories = new ArrayList<String>();
        categories.add("BLE");
        categories.add("WIFI");
        categories.add("Xgbee");
        ArrayAdapter <String> dataAdapter = new ArrayAdapter <String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void editcomm_btn() {
        btn_editcomm = (Button) findViewById(R.id.btn_commdevice);
        btn_editcomm.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        ((Spinner) findViewById(R.id.spinner)).performClick();
                        }
                    }

            );
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        comm_device = (TextView)findViewById(R.id.commdevice);
        comm_device.setText("Communicating device: " + item.toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

