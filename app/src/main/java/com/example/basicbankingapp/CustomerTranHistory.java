package com.example.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomerTranHistory extends AppCompatActivity {

    TextView tvTitle,tvStatus;
    ListView lvTran;
    ArrayList<Transaction> data;
    DbHelper Db;
    androidx.cardview.widget.CardView cvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_tran_history);

        tvTitle =  findViewById(R.id.tvHomeTitle);

        tvStatus = findViewById(R.id.tvStatus);
        tvStatus.setVisibility(View.GONE);

        lvTran = findViewById(R.id.lvTran);

        cvMain =  findViewById(R.id.cvMain);

        String acc_num = getIntent().getStringExtra("acc_num");
        String cus_name = getIntent().getStringExtra("cus_name");

        tvTitle.setText(cus_name + "'S TRANSACTION HISTORY ");

        Db = new DbHelper(this);
        data = new ArrayList<>();

        String[] arr = new String[10];

        Cursor r = Db.getAllTranHistoryByAccNum(acc_num);
        if(r.getCount() == 0)
        {
            tvStatus.setVisibility(View.VISIBLE);
            cvMain.setVisibility(View.GONE);
        }
        else {

            cvMain.setVisibility(View.VISIBLE);
            tvStatus.setVisibility(View.GONE);

            while(r.moveToNext())
            {
                for (int i = 0;i<10;i++)
                {
                    arr[i] = String.valueOf(r.getString(i));
                }
                data.add(new Transaction(arr[0],arr[1],arr[2],
                        arr[3],arr[4],arr[5],
                        arr[6],arr[7],arr[8],arr[9]));
            }

            lvTran.setAdapter(new TransactionAdapter(CustomerTranHistory.this,data));
        }

    }
}