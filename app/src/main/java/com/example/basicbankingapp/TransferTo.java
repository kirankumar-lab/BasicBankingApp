package com.example.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import java.util.ArrayList;

public class TransferTo extends AppCompatActivity implements CustomerAdapter.ItemClicked  {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager manager;
    ArrayList<Customer> customer;
    DbHelper Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setContentView(R.layout.transfer_to_activity);

        String CusId = getIntent().getStringExtra("cus_id");

        Db = new DbHelper(this);

        recyclerView = findViewById(R.id.customer_list);
//        recyclerView.setHasFixedSize(true);

//      manager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);

        customer = new ArrayList<>();

        String[] arr= new String[10];

        Cursor r = Db.getAllDataExcept(CusId);
        while(r.moveToNext())
        {
            for (int i = 0;i<10;i++)
            {
                arr[i] = String.valueOf(r.getString(i));
            }
            customer.add(new Customer(arr[0],arr[1],arr[2],
                    arr[3],arr[4],arr[5],
                    arr[6],arr[7],arr[8],arr[9]));
        }

        myAdapter = new  CustomerAdapter(this,customer);
        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onItemClicked(int index) {
        Intent i  =  new Intent(TransferTo.this,Transfer.class);
        i.putExtra("rev_cus_id",customer.get(index).getCus_id());
        i.putExtra("sen_cus_id",getIntent().getStringExtra("cus_id"));
        startActivity(i);
        finish();
    }
}