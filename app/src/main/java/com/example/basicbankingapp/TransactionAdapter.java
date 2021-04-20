package com.example.basicbankingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TransactionAdapter extends ArrayAdapter<Transaction> {

    private final Context context;
    private final ArrayList<Transaction> values;

    public TransactionAdapter(@NonNull Context context, ArrayList<Transaction> list) {
        super(context,R.layout.transaction_item_layout,list);
        this.context = context;
        this.values = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.transaction_item_layout,parent,false);

        TextView tvTranId =  rowView.findViewById(R.id.tvTranId);
        TextView tvAmount =  rowView.findViewById(R.id.tvAmount);
        TextView tvDate =   rowView.findViewById(R.id.tvDate);
        TextView tvTime =   rowView.findViewById(R.id.tvTime);

        TextView tvSenName =   rowView.findViewById(R.id.tvSenName);
        TextView tvSenBank =   rowView.findViewById(R.id.tvSenBank);
        TextView tvSenAccno =   rowView.findViewById(R.id.tvSenAccno);

        TextView tvRevName =   rowView.findViewById(R.id.tvRevName);
        TextView tvRevBank =   rowView.findViewById(R.id.tvRevBank);
        TextView tvRevAccno =   rowView.findViewById(R.id.tvRevAccno);

        tvTranId.setText(values.get(position).getTran_id());
        tvAmount.setText(values.get(position).getAmmount());
        tvDate.setText(values.get(position).getDate());
        tvTime.setText(values.get(position).getTime());

        tvSenName.setText(values.get(position).getSen_name());
        tvSenBank.setText(values.get(position).getSen_bank());
        tvSenAccno.setText(values.get(position).getSen_acc_num());

        tvRevName.setText(values.get(position).getRev_name());
        tvRevBank.setText(values.get(position).getRev_bank());
        tvRevAccno.setText(values.get(position).getRev_acc_num());

        return rowView;
    }
}
