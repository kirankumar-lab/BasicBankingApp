package com.example.basicbankingapp;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DbHelper extends SQLiteOpenHelper {

    // Customer table
    public static final String KEY_C_ID = "cus_id";
    public static final String KEY_C_NAME = "cus_name";
    public static final String KEY_C_BANK = "cus_bank";
    public static final String KEY_C_BRANCH= "cus_branch";
    public static final String KEY_C_ACC_TYPE = "cus_acc_type";
    public static final String KEY_C_ACC_NUM = "cus_acc_num";
    public static final String KEY_C_IFSC_CODE = "cus_ifsc_code";
    public static final String KEY_C_CURR_BAL = "cus_curr_bal";
    public static final String KEY_C_CON_NO= "cus_con_no";
    public static final String KEY_C_EMAIL = "cus_email";
    // transfer table
    public static final String KEY_T_ID = "tran_id";
    public static final String KEY_T_SEN_NAME = "sen_name";
    public static final String KEY_T_SEN_BANK = "sen_bank";
    public static final String KEY_T_SEN_ACC_NUM = "sen_acc_num";
    public static final String KEY_T_REV_NAME = "rev_acc_name";
    public static final String KEY_T_REV_BANK = "rev_bank";
    public static final String KEY_T_REV_ACC_NUM = "rev_acc_num";
    public static final String KEY_T_AMMOUNT = "ammount";
    public static final String KEY_T_DATE = "date";
    public static final String KEY_T_TIME = "time";

    public static final String DATABASE_NAME  = "BankDatabase";
    public static final String DATABASE_TABLE_CUSTOMER = "Customer";
    public static final String DATABASE_TABLE_TRANSFER  = "Transfer";
    public static final int DATABASE_VERSION  = 1;

    public DbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String code1 = "CREATE TABLE " + DATABASE_TABLE_CUSTOMER + " (" +
                KEY_C_ID + " INTEGER PRIMARY KEY, " +
                KEY_C_NAME + " TEXT NOT NULL, " +
                KEY_C_BANK + " TEXT NOT NULL, " +
                KEY_C_BRANCH + " TEXT NOT NULL, " +
                KEY_C_ACC_TYPE + " TEXT NOT NULL, " +
                KEY_C_ACC_NUM + " TEXT NOT NULL, " +
                KEY_C_IFSC_CODE + " TEXT NOT NULL, " +
                KEY_C_CURR_BAL + " TEXT NOT NULL, " +
                KEY_C_CON_NO + " TEXT NOT NULL, " +
                KEY_C_EMAIL + " TEXT NOT NULL);";
        db.execSQL(code1);

        String code2 = "CREATE TABLE " + DATABASE_TABLE_TRANSFER + " (" +
                KEY_T_ID + " TEXT PRIMARY KEY, " +
                KEY_T_SEN_NAME + " TEXT NOT NULL, " +
                KEY_T_SEN_BANK + " TEXT NOT NULL, " +
                KEY_T_SEN_ACC_NUM + " TEXT NOT NULL, " +
                KEY_T_REV_NAME + " TEXT NOT NULL, " +
                KEY_T_REV_BANK + " TEXT NOT NULL, " +
                KEY_T_REV_ACC_NUM + " TEXT NOT NULL, " +
                KEY_T_AMMOUNT + " TEXT NOT NULL, " +
                KEY_T_DATE + " TEXT NOT NULL, " +
                KEY_T_TIME + " TEXT NOT NULL);";

        db.execSQL(code2);

        String c1 = "INSERT INTO " + DATABASE_TABLE_CUSTOMER + " VALUES( " + " '1001'," + "'Gaurav Patel', " + "'State bank of india', " +
                "'Sarkhej', " + "'Savings', " + "'800600701', " + "'SBIN00001', " + "'20000.00', " + "'9876543210', " + "'gaurav@gmail.com');";
        db.execSQL(c1);

        String c2 = "INSERT INTO " + DATABASE_TABLE_CUSTOMER + " VALUES( " + " '1002'," + "'Karan Mehra', " + "'ICICI bank', " +
                "'Sola', " + "'Current', " + "'800600702', " + "'ICICI0001', " + "'4500.00', " + "'9876543211', " + "'karan@gmail.com');";
        db.execSQL(c2);

        String c3 = "INSERT INTO " + DATABASE_TABLE_CUSTOMER + " VALUES( " + " '1003'," + "'Dilip Nakum', " + "'State bank of india', " +
                "'Chuda', " + "'Current', " + "'800600703', " + "'SBIN00002', " + "'8500.00', " + "'9876543212', " + "'dilip@gmail.com');";
        db.execSQL(c3);

        String c4 = "INSERT INTO " + DATABASE_TABLE_CUSTOMER + " VALUES( " + " '1004'," + "'Rakesh Mishra', " + "'HDFC bank', " +
                "'Limbdi', " + "'Savings', " + "'800600704', " + "'HDFC20200', " + "'1000.00', " + "'9876543213', " + "'rakesh@gmail.com');";
        db.execSQL(c4);

        String c5 = "INSERT INTO " + DATABASE_TABLE_CUSTOMER + " VALUES( " + " '1005'," + "'Hitesh Pant', " + "'State bank of india', " +
                "'Sayla', " + "'Current', " + "'800600705', " + "'SBIN00003', " + "'35500.00', " + "'9876543214', " + "'hitesh@gmail.com');";
        db.execSQL(c5);

        String c6 = "INSERT INTO " + DATABASE_TABLE_CUSTOMER + " VALUES( " + " '1006'," + "'Rajesh Shah', " + "'Mahindra Kotak bank', " +
                "'Dholka', " + "'Savings', " + "'800600706', " + "'MKNB05050', " + "'78000.00', " + "'9876543215', " + "'rajesh@gmail.com');";
        db.execSQL(c6);

        String c7 = "INSERT INTO " + DATABASE_TABLE_CUSTOMER + " VALUES( " + " '1007'," + "'Krishna Modi', " + "'HDFC bank', " +
                "'Vadaj', " + "'Current', " + "'800600707', " + "'HDFC20201', " + "'63000.00', " + "'9876543216', " + "'krishna@gmail.com');";
        db.execSQL(c7);

        String c8 = "INSERT INTO " + DATABASE_TABLE_CUSTOMER + " VALUES( " + " '1008'," + "'Suraj Singh', " + "'HDFC bank', " +
                "'Khanpur', " + "'Savings', " + "'800600708', " + "'HDFC20202', " + "'60000.00', " + "'9876543217', " + "'suraj@gmail.com');";
        db.execSQL(c8);

        String c9 = "INSERT INTO " + DATABASE_TABLE_CUSTOMER + " VALUES( " + " '1009'," + "'Shilpa Sheth', " + "'State bank of india', " +
                "'Sabarmati', " + "'Current', " + "'800600709', " + "'SBIN00004', " + "'90000.00', " + "'9876543218', " + "'shilpa@gmail.com');";
        db.execSQL(c9);

        String c10 = "INSERT INTO " + DATABASE_TABLE_CUSTOMER + " VALUES( " + " '1010'," + "'Akshay Nakum', " + "'ICICI bank', " +
                "'Mirzapur', " + "'Savings', " + "'800600710', " + "'ICICI00002', " + "'50000.00', " + "'9876543219', " + "'akshay@gmail.com');";
        db.execSQL(c10);
        

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_TRANSFER);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_TRANSFER);
        onCreate(db);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor r = db.rawQuery("SELECT * FROM " + DATABASE_TABLE_CUSTOMER,null);
        return r;
    }

    public Cursor getAllDataExcept(String c_id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor r = db.rawQuery("SELECT * FROM " + DATABASE_TABLE_CUSTOMER + " WHERE " + KEY_C_ID + " != " + c_id,null);
        return r;
    }

    public Cursor getAllDataByCusId(String c_id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor r = db.rawQuery("SELECT * FROM " + DATABASE_TABLE_CUSTOMER + " WHERE " + KEY_C_ID + " = " + c_id,null);
        return r;
    }

    public String moneyTransfer(String sen_id,String sen_bal, String rev_id,String rev_bal,String tran_amount)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String senBalUpdate = "UPDATE " + DATABASE_TABLE_CUSTOMER + " SET " + KEY_C_CURR_BAL + " = " + "'" + sen_bal + "' WHERE " + KEY_C_ID + " = " + "'" + sen_id + "';" ;
        db.execSQL(senBalUpdate);

        String revBalUpdate = "UPDATE " + DATABASE_TABLE_CUSTOMER + " SET " + KEY_C_CURR_BAL + " = " + "'" + rev_bal + "' WHERE " + KEY_C_ID + " = " + "'" + rev_id + "';" ;
        db.execSQL(revBalUpdate);

        String[] arrSen = new String[10];
        Cursor rSen = db.rawQuery("SELECT * FROM " + DATABASE_TABLE_CUSTOMER + " WHERE " + KEY_C_ID + " = " + sen_id,null);
        while (rSen.moveToNext())
        {
            for(int i = 0;i<10;i++)
            {
                arrSen[i] = String.valueOf(rSen.getString(i));
            }
        }

        String[] arrRev = new String[10];
        Cursor rRev = db.rawQuery("SELECT * FROM " + DATABASE_TABLE_CUSTOMER + " WHERE " + KEY_C_ID + " = " + rev_id,null);
        while (rRev.moveToNext())
        {
            for(int i = 0;i<10;i++)
            {
                arrRev[i] = String.valueOf(rRev.getString(i));
            }
        }

        // for current date
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(d);

        // for current time
        SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss a", Locale.getDefault());
        String formattedTime = tf.format(d);

        // logic of transaction id
        String sampletranId = String.valueOf(d.getTime());

        String c = "INSERT INTO " + DATABASE_TABLE_TRANSFER + " VALUES( " + "'" +  sampletranId + "', "+
                                                                            "'" +  arrSen[1] + "', "+
                                                                            "'" +  arrSen[2] + "', "+
                                                                            "'" +  arrSen[5] + "', "+
                                                                            "'" +  arrRev[1] + "', "+
                                                                            "'" +  arrRev[2] + "', "+
                                                                            "'" +  arrRev[5] + "', "+
                                                                            "'" +  tran_amount + "', "+
                                                                            "'" +  formattedDate + "', "+
                                                                            "'" +  formattedTime + "' );";
        db.execSQL(c);
        return sampletranId;
    }

    public Cursor getAllTranHistory(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor r = db.rawQuery("SELECT * FROM " + DATABASE_TABLE_TRANSFER,null);
        return r;
    }

    public Cursor getAllTranHistoryByAccNum(String acc_num){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor r = db.rawQuery("SELECT * FROM " + DATABASE_TABLE_TRANSFER + " WHERE " + KEY_T_SEN_ACC_NUM + " = " + acc_num,null);
        return r;
    }


}
