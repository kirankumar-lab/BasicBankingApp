package com.example.basicbankingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder>
{

private final ArrayList<Customer> customer;
ItemClicked activity;

public interface ItemClicked{
    void onItemClicked(int index);
}

    public CustomerAdapter (Context context, ArrayList<Customer> list)
    {
        customer = list;
        activity  = (ItemClicked) context;
    }

public class ViewHolder extends RecyclerView.ViewHolder{

    TextView tvFirstLetterOfName,tvCusName,tvBankName,tvBranchName,tvBal;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        tvFirstLetterOfName = itemView.findViewById(R.id.tvFirstLetterOfName);
        tvCusName = itemView.findViewById(R.id.tvCusName);
        tvBankName = itemView.findViewById(R.id.tvBankName);
        tvBranchName = itemView.findViewById(R.id.tvBranchName);
        tvBal = itemView.findViewById(R.id.tvBal);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onItemClicked(customer.indexOf((Customer) v.getTag() ));
            }
        });

    }
}


    @NonNull
    @Override
    public CustomerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(customer.get(position));

        String firstChar = customer.get(position).getCus_name();
        char x =  firstChar.charAt(0);
        String firstLater = String.valueOf(x);
        holder.tvFirstLetterOfName.setText(firstLater);

        holder.tvCusName.setText(customer.get(position).getCus_name());
        holder.tvBankName.setText(customer.get(position).getCus_bank());
        holder.tvBranchName.setText(customer.get(position).getCus_branch());

        String bal = String.valueOf(customer.get(position).getCus_curr_bal());
        holder.tvBal.setText(bal);
    }

    @Override
    public int getItemCount() {
        return customer.size();
    }
}
