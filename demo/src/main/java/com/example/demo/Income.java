package com.example.demo;

import java.util.HashMap;

public class Income extends IncomeRequest{

    public String source;
    public int amount;

    static HashMap<String,Integer> incomes=new HashMap<>();
}
