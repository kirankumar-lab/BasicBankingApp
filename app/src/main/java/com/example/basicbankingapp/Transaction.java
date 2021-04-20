package com.example.basicbankingapp;

public class Transaction {

    private final String  tran_id;
    private final String  sen_name;
    private final String  sen_bank ;
    private final String  sen_acc_num ;
    private final String  rev_name ;
    private final String  rev_bank ;
    private final String  rev_acc_num ;
    private final String  ammount ;
    private final String  date ;
    private final String  time ;

    public Transaction(String tran_id, String sen_name, String sen_bank, String sen_acc_num, String rev_name, String rev_bank, String rev_acc_num, String ammount, String date, String time) {
        this.tran_id = tran_id;
        this.sen_name = sen_name;
        this.sen_bank = sen_bank;
        this.sen_acc_num = sen_acc_num;
        this.rev_name = rev_name;
        this.rev_bank = rev_bank;
        this.rev_acc_num = rev_acc_num;
        this.ammount = ammount;
        this.date = date;
        this.time = time;
    }

    public String getTran_id() {
        return tran_id;
    }

    public String getSen_name() {
        return sen_name;
    }

    public String getSen_bank() {
        return sen_bank;
    }

    public String getSen_acc_num() {
        return sen_acc_num;
    }

    public String getRev_name() {
        return rev_name;
    }

    public String getRev_bank() {
        return rev_bank;
    }

    public String getRev_acc_num() {
        return rev_acc_num;
    }

    public String getAmmount() {
        return ammount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
