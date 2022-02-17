package com.example.assignment_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductBaseAdapter extends BaseAdapter {

    ArrayList<Product> products;
    Context context;

    public ProductBaseAdapter(ArrayList<Product> products, Context context)
    {
        this.products = products;
        this.context = context;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.product_layout, null);
        }

        TextView name = view.findViewById(R.id.product_name);
        TextView quantity = view.findViewById(R.id.product_quantity);
        TextView price = view.findViewById(R.id.product_price);

        name.setText(products.get(i).name);
        quantity.setText(String.valueOf(products.get(i).quantity));

        String result = String.format("%.2f", products.get(i).price);
        price.setText(result);

        return view;
    }
}
