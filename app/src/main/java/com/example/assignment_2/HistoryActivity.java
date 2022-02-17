package com.example.assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ListView history_list;

    int selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        history_list = findViewById(R.id.historyList);

        ArrayList<History> history = ((MyApp) getApplication()).history;

        HistoryBaseAdapter adapter = new HistoryBaseAdapter(history, this);
        history_list.setAdapter(adapter);

        AdapterView.OnItemClickListener historyClickHandler = (adapterView, view, i, l) -> {
            selected = i;

            changeActivity();
        };

        history_list.setOnItemClickListener(historyClickHandler);
    }

    void changeActivity()
    {
        Intent myIntent = new Intent(this, DetailedHistoryActivity.class);
        myIntent.putExtra("selected", selected);
        startActivity(myIntent);
    }
}
