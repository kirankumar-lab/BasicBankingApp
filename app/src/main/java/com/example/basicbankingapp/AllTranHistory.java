package com.example.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AllTranHistory extends AppCompatActivity {

    ListView lvTran;
    ArrayList<Transaction> data;
    DbHelper Db;
    androidx.cardview.widget.CardView cvMain;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tran_history);

        lvTran =  findViewById(R.id.lvTran);

        tvStatus =  findViewById(R.id.tvStatus);
        tvStatus.setVisibility(View.GONE);
        cvMain =  findViewById(R.id.cvMain);

        Db = new DbHelper(this);
        data = new ArrayList<>();

        String[] arr = new String[10];

        Cursor r = Db.getAllTranHistory();

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

            lvTran.setAdapter(new TransactionAdapter(AllTranHistory.this,data));
        }

    }

}