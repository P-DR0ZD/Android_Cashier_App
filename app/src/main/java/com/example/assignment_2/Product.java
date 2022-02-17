package com.example.assignment_2;

public class Product {

    String name;
    int quantity;
    double price;

    Product()
    {
        name = "";
        quantity = 0;
        price = 0;
    }

    Product(String name, int quantity, double price)
    {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void restock(int quantity)
    {
        this.quantity += quantity;
    }
}
