package com.example.assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ManageActivity extends AppCompatActivity implements View.OnClickListener {

    Button history;

    Button restock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage);

        history = findViewById(R.id.history);
        history.setOnClickListener(this);

        restock = findViewById(R.id.restock);
        restock.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.history) {
            Intent myIntent = new Intent(this, HistoryActivity.class);
            startActivity(myIntent);
        }
        if (id == R.id.restock)
        {
            Intent myIntent = new Intent(this, RestockActivity.class);
            startActivity(myIntent);
        }
    }
}
