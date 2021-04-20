package com.example.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Transfer extends AppCompatActivity {

    TextView tvSenCusName,tvSenBankName,tvSenAccNum,tvSenIFSCCode,tvSenBal;
    TextView tvRevCusName,tvRevBankName,tvRevAccNum,tvRevIFSCCode,tvRevBal;
    AutoCompleteTextView actvAmmount;
    DbHelper Db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer_activity);

        Db = new DbHelper(this);

        tvSenCusName =   findViewById(R.id.tvSenCusName);
        tvSenBankName =   findViewById(R.id.tvSenBankName);
        tvSenAccNum =   findViewById(R.id.tvSenAccNum);
        tvSenIFSCCode =   findViewById(R.id.tvSenIFSCCode);
        tvSenBal =   findViewById(R.id.tvSenBal);

        tvRevCusName =   findViewById(R.id.tvRevCusName);
        tvRevBankName =   findViewById(R.id.tvRevBankName);
        tvRevAccNum =   findViewById(R.id.tvRevAccNum);
        tvRevIFSCCode =   findViewById(R.id.tvRevIFSCCode);
        tvRevBal =   findViewById(R.id.tvRevBal);

        actvAmmount = (AutoCompleteTextView) findViewById(R.id.actvAmmount);

        String SenCusId = getIntent().getStringExtra("sen_cus_id");
        String RevCusId = getIntent().getStringExtra("rev_cus_id");

        String[] arr = new String[10];

        Cursor r = Db.getAllDataByCusId(SenCusId);
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

        tvSenCusName.setText(arr[1]);
        tvSenBankName.setText(arr[2]);
        tvSenAccNum.setText(arr[5]);
        tvSenIFSCCode.setText(arr[6]);
        tvSenBal.setText(arr[7]);

        String[] arr1 = new String[10];

        Cursor r1 = Db.getAllDataByCusId(RevCusId);
        while(r1.moveToNext())
        {
            arr1[0] = String.valueOf(r1.getString(0));
            arr1[1] = String.valueOf(r1.getString(1));
            arr1[2] = String.valueOf(r1.getString(2));
            arr1[3] = String.valueOf(r1.getString(3));
            arr1[4] = String.valueOf(r1.getString(4));
            arr1[5] = String.valueOf(r1.getString(5));
            arr1[6] = String.valueOf(r1.getString(6));
            arr1[7] = String.valueOf(r1.getString(7));
            arr1[8] = String.valueOf(r1.getString(8));
            arr1[9] = String.valueOf(r1.getString(9));
        }

        tvRevCusName.setText(arr1[1]);
        tvRevBankName.setText(arr1[2]);
        tvRevAccNum.setText(arr1[5]);
        tvRevIFSCCode.setText(arr1[6]);
        tvRevBal.setText(arr1[7]);
    }

    public void makeTransfer(View v)
    {
        try{
            if(actvAmmount.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Amount can not be empty", Toast.LENGTH_SHORT).show();
            }
            else if(Double.parseDouble(actvAmmount.getText().toString()) == 0.0)
            {
                Toast.makeText(this, "Amount can not be 0", Toast.LENGTH_SHORT).show();
            }
            else
            {


                String eA = actvAmmount.getText().toString();
                double enteredAmount = formatChanger(eA);

                String sB = tvSenBal.getText().toString();
                double senBal = formatChanger(sB);
//          double senBal = Double.parseDouble(sB);

                String rB = tvRevBal.getText().toString();
                double revBal = formatChanger(rB);
//          double revBal = Double.parseDouble(rB);;


                if(enteredAmount > senBal)
                {
                    Toast.makeText(this, "Insufficient balance in " + tvSenCusName.getText().toString() + "'s account", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double newSenBal = senBal - enteredAmount;
                    double newRevBal = revBal + enteredAmount;

                    String tranId;
                    tranId = Db.moneyTransfer(getIntent().getStringExtra("sen_cus_id"),
                            String.format("%.2f",newSenBal),
                            getIntent().getStringExtra("rev_cus_id"),
                            String.format("%.2f",newRevBal),
                            String.valueOf(enteredAmount));

                    Toast.makeText(this, "Transaction Successful ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Transfer.this,TransferResult.class);
                    i.putExtra("tranId",tranId);
                    startActivity(i);
                    finish();
                }
            }
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show();
        }
        finally
        {

        }


    }

    public double formatChanger(String str)
    {
       DecimalFormat pattern = new DecimalFormat("########0.00");
       String str1 = pattern.format(Double.parseDouble(str));
       return Double.parseDouble(str1);
    }

}