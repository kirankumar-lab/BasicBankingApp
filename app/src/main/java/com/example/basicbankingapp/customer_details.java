package com.example.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class customer_details extends AppCompatActivity {

    TextView tvCusID,tvCusName,tvBankName,tvBranchName,tvAccType,tvAccNum,tvIFSCCode,tvBal,tvEmail,tvConNum,tvFirstLetterOfName;
    DbHelper Db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_details_activity);

        Db = new DbHelper(this);

        tvCusID =  findViewById(R.id.tvCusId);
        tvFirstLetterOfName =  findViewById(R.id.tvFirstLetterOfName);
        tvCusName =  findViewById(R.id.tvName);
        tvBankName =  findViewById(R.id.tvBankName);
        tvBranchName =  findViewById(R.id.tvBranchName);
        tvAccType =  findViewById(R.id.tvAccType);
        tvAccNum =  findViewById(R.id.tvAccNum);
        tvIFSCCode =findViewById(R.id.tvIfcsCode);
        tvBal =  findViewById(R.id.tvBal);
        tvEmail =  findViewById(R.id.tvEmail);
        tvConNum =  findViewById(R.id.tvConNum);


        String CusId = getIntent().getStringExtra("c_id");

        String[] arr = new String[10];

        Cursor r = Db.getAllDataByCusId(CusId);
        while(r.moveToNext())
        {
            arr[0] = String.valueOf(r.getString(0));
            arr[1] = String.valueOf(r.getString(1));
            arr[2] = String.valueOf(r.getString(2));
            arr[3] = String.valueOf(r.getString(3));
            arr[4] = String.valueOf(r.getString(4));
            arr[5] = String.valueOf(r.getString(5));
            arr[6] = String.valueOf(r.getString(6));
            arr[7] = String.valueOf(r.getString(7));
            arr[8] = String.valueOf(r.getString(8));
            arr[9] = String.valueOf(r.getString(9));
        }

        tvCusID.setText(arr[0]);
        tvCusName.setText(arr[1]);

        String firstChar = tvCusName.getText().toString();
        char x =  firstChar.charAt(0);
        String firstLater = String.valueOf(x);
        tvFirstLetterOfName.setText(firstLater);

        tvAccNum.setText(arr[5]);
        tvIFSCCode.setText(arr[6]);
        tvAccType.setText(arr[4]);
        tvBal.setText(arr[7]);
        tvBankName.setText(arr[2]);
        tvBranchName.setText(arr[3]);
        tvConNum.setText(arr[8]);
        tvEmail.setText(arr[9]);

    }

    public void transfer(View v)
    {
        Intent i = new Intent(customer_details.this,TransferTo.class);
        i.putExtra("cus_id",tvCusID.getText().toString());
        startActivity(i);
    }

    public void viewTranHistory(View v)
    {
        Intent i = new Intent(customer_details.this,CustomerTranHistory.class);
        i.putExtra("acc_num",tvAccNum.getText().toString());
        i.putExtra("cus_name",tvCusName.getText().toString());
        startActivity(i);
    }

}