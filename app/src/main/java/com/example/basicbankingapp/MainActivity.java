package com.example.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void viewAllCustomer(View v)
    {
        startActivity(new Intent(MainActivity.this,CustomerList.class));
    }
    public void viewAllHistory(View v)
    {
        Intent i = new Intent(MainActivity.this,AllTranHistory.class);
        startActivity(i);
    }

}