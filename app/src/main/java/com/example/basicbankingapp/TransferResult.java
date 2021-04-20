package com.example.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TransferResult extends AppCompatActivity {

    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer_result_activity);

        String tranId = getIntent().getStringExtra("tranId");
        tvResult = findViewById(R.id.tvResult);
        tvResult.setText(tranId);
    }
    public void viewAllCustomer(View v)
    {
        Intent i = new Intent(TransferResult.this,CustomerList.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
    public void viewAllHistory(View v)
    {
        Intent i = new Intent(TransferResult.this,AllTranHistory.class);
        startActivity(i);
    }
}