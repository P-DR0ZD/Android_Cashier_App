package com.example.assignment_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryBaseAdapter extends BaseAdapter {

    ArrayList<History> histories;
    Context context;

    HistoryBaseAdapter(ArrayList<History> histories, Context context)
    {
        this.histories = histories;
        this.context = context;
    }

    @Override
    public int getCount() {
        return histories.size();
    }

    @Override
    public Object getItem(int i) {
        return histories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.history_layout, null);
        }

        TextView name = view.findViewById(R.id.history_name);
        TextView quantity = view.findViewById(R.id.history_quantity);
        TextView price = view.findViewById(R.id.history_price);

        name.setText(histories.get(i).product_purchased);
        quantity.setText(String.valueOf(histories.get(i).amount));

        String result = String.format("%.2f", histories.get(i).total);

        price.setText(result);

        return view;
    }
}
