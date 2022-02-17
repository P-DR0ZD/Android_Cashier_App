package com.example.assignment_2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailedHistoryActivity extends AppCompatActivity {

    History selected;

    TextView name;
    TextView price;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_details);

        int cur = getIntent().getExtras().getInt("selected");

        selected = ((MyApp) getApplication()).history.get(cur);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        date = findViewById(R.id.date);

        if (!selected.product_purchased.equals(""))
        {
            String result = String.format("%.2f", selected.total);

            name.setText("Product: " + selected.product_purchased);
            price.setText("Price: " + result);
            date.setText("Purchase Date: " + selected.date.toString());
        }

    }
}
