package com.example.assignment_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RestockActivity extends AppCompatActivity implements View.OnClickListener {

    EditText text;

    Button ok;
    Button cancel;

    ListView productList;

    Product selected = new Product();

    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restock);

        text = findViewById(R.id.editTextNumber);

        products = ((MyApp) getApplication()).products;

        ok = findViewById( R.id.ok);
        ok.setOnClickListener(this);
        cancel = findViewById( R.id.cancel);
        cancel.setOnClickListener(this);

        productList = findViewById(R.id.productList);

        ProductBaseAdapter adapter = new ProductBaseAdapter(products,this);
        productList.setAdapter(adapter);

        AdapterView.OnItemClickListener productClickedHandler = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selected = products.get(i);
            }
        };
        productList.setOnItemClickListener(productClickedHandler);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ok) {
            String value = text.getText().toString();
            if (!value.equals("") && !selected.name.equals(""))
            {
                selected.restock(Integer.parseInt(value));

                ProductBaseAdapter adapter = new ProductBaseAdapter(products,this);
                productList.setAdapter(adapter);

                text.setText("");
                selected = new Product();
            }
            else
            {
                Context context = getApplicationContext();
                CharSequence text = "All fields are REQUIRED";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
        else if (id == R.id.cancel)
        {
            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);
        }
    }
}
