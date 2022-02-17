package com.example.assignment_2;

import android.app.Application;

import java.util.ArrayList;

public class MyApp extends Application {

    ArrayList<Product> products = new ArrayList<>();

    Product selected;

    ArrayList<History> history;

    @Override
    public void onCreate() {
        super.onCreate();

        products.add(products.size(), new Product("Pants", 10, 20.44));
        products.add(products.size(), new Product("Shoes", 100, 10.44));
        products.add(products.size(), new Product("Hats", 30, 5.9));

        selected = new Product();

        history = new ArrayList<>();

    }
}
