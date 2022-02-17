package com.example.assignment_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView product;
    TextView quantity;
    TextView total;

    NumberPicker numberPicker;

    Button buy;
    Button manager;

    ListView product_list;

    ArrayList<Product> products = new ArrayList<>();

    Product selected;

    AlertDialog.Builder builder;

    ArrayList<History> history;

    int val;
    double totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selected = ((MyApp) getApplication()).selected;

        history = ((MyApp) getApplication()).history;

        builder = new AlertDialog.Builder(this);

        product = findViewById(R.id.productSelected);
        quantity = findViewById(R.id.quantityView);
        total = findViewById(R.id.totalView);

        setValues();

        numberPicker = findViewById(R.id.quantityPicker);

        numberPicker.setMaxValue(100);
        numberPicker.setMinValue(0);

        numberPicker.setOnValueChangedListener((numberPicker, oldVal, newVal) -> {
            val = newVal;
            quantity.setText(String.valueOf(val));

            if (selected.name != "")
            {
                setValues();
            }

        });

        product_list = findViewById(R.id.productList);

        products = ((MyApp) getApplication()).products;

        ProductBaseAdapter adapter = new ProductBaseAdapter(products,this);
        product_list.setAdapter(adapter);

        AdapterView.OnItemClickListener productClickedHandler = (adapterView, view, i, l) -> {
            selected = products.get(i);

            setValues();
        };

        product_list.setOnItemClickListener(productClickedHandler);

        buy = findViewById(R.id.buyButton);
        buy.setOnClickListener(this);

        manager = findViewById(R.id.managerButton);
        manager.setOnClickListener(this);
    }

    public void setValues()
    {
        product.setText(R.string.select_product);
        total.setText(R.string.total);
        quantity.setText(R.string.quantity_);
        if (!selected.name.equals(""))
        {
            product.setText(selected.name);
        }
        if (val != 0 && !selected.name.equals("")) {
            quantity.setText(String.valueOf(val));
            totalAmount = val * selected.price;
            String result = String.format("%.2f", totalAmount);
            total.setText(result);
        }
    }

    public void clear()
    {
        selected = new Product();
        val = 0;
        numberPicker.setValue(val);
        setValues();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.buyButton)
        {
            if (val != 0 && !selected.name.equals(""))
            {

                if (selected.quantity < val)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Not enough quantity in stock!!!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {

                    builder.setTitle("Thank you for your purchase");
                    String result = String.format("%.2f", totalAmount);
                    builder.setMessage("Your purchase is " + val + " " + selected.name + " for " + result);
                    builder.setCancelable(true);

                    builder.show();

                    selected.quantity -= val;

                    history.add(new History(selected.name, totalAmount, val));

                    ProductBaseAdapter adapter = new ProductBaseAdapter(products,this);
                    product_list.setAdapter(adapter);

                    clear();
                }
            }
            else
            {
                Context context = getApplicationContext();
                CharSequence text = "All fields are required!!!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
        else if (id == R.id.managerButton)
        {
            Intent myIntent = new Intent(this, ManageActivity.class);
            startActivity(myIntent);
        }
    }
}