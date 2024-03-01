package com.example.demo;

import java.util.HashMap;

public class Investment extends IncomeRequest{
    private String name;
    private int amount;
   static HashMap<String, Integer> investment = new HashMap<>();

    // Default constructor
    public Investment() {
    }

    // Parameterized constructor
    public Investment(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for amount
    public int getAmount() {
        return amount;
    }

    // Setter for amount
    public void setAmount(int amount) {
        this.amount = amount;
    }


}

