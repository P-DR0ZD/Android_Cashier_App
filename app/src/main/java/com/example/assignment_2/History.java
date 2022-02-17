package com.example.assignment_2;

import java.util.Date;

public class History {
    String product_purchased;
    double total;
    int amount;
    Date date;

    History(){
        product_purchased = "";
        total = 0;
        amount = 0;
    }

    History(String product_purchased, double total, int amount)
    {
        this.product_purchased = product_purchased;
        this.total = total;
        this.amount = amount;
        date = new Date();
    }
}
