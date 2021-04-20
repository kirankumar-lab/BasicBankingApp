package com.example.basicbankingapp;

public class Customer {

    private String cus_id;
    private String cus_name;
    private String cus_bank;
    private String cus_branch;
    private String cus_acc_type;
    private String cus_acc_num;
    private String cus_ifcs_code;
    private String cus_curr_bal;
    private String cus_con_no;
    private String cus_email;


    public Customer(String cus_id, String cus_name, String cus_bank, String cus_branch, String cus_acc_type, String cus_acc_num, String cus_ifcs_code, String cus_curr_bal, String cus_con_no, String cus_email) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_bank = cus_bank;
        this.cus_branch = cus_branch;
        this.cus_acc_type = cus_acc_type;
        this.cus_acc_num = cus_acc_num;
        this.cus_ifcs_code = cus_ifcs_code;
        this.cus_curr_bal = cus_curr_bal;
        this.cus_con_no = cus_con_no;
        this.cus_email = cus_email;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_bank() {
        return cus_bank;
    }

    public void setCus_bank(String cus_bank) {
        this.cus_bank = cus_bank;
    }

    public String getCus_branch() {
        return cus_branch;
    }

    public void setCus_branch(String cus_branch) {
        this.cus_branch = cus_branch;
    }

    public String getCus_acc_type() {
        return cus_acc_type;
    }

    public void setCus_acc_type(String cus_acc_type) {
        this.cus_acc_type = cus_acc_type;
    }

    public String getCus_acc_num() {
        return cus_acc_num;
    }

    public void setCus_acc_num(String cus_acc_num) {
        this.cus_acc_num = cus_acc_num;
    }

    public String getCus_ifcs_code() {
        return cus_ifcs_code;
    }

    public void setCus_ifcs_code(String cus_ifcs_code) {
        this.cus_ifcs_code = cus_ifcs_code;
    }

    public String getCus_curr_bal() {
        return cus_curr_bal;
    }

    public void setCus_curr_bal(String cus_curr_bal) {
        this.cus_curr_bal = cus_curr_bal;
    }

    public String getCus_con_no() {
        return cus_con_no;
    }

    public void setCus_con_no(String cus_con_no) {
        this.cus_con_no = cus_con_no;
    }

    public String getCus_email() {
        return cus_email;
    }

    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }
}
