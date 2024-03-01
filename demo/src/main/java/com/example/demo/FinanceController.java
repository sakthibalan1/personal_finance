package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FinanceController {

    @GetMapping("/balance")
    public String showBalance() {
        // Logic to fetch and return the user's balance
        int income=IncomeRequest.currentincome;

        return "Your balance is :"+income;
    }

    @GetMapping("/viewincomes")
    public HashMap showIncomes() {


        return Income.incomes;
    }


        @PostMapping("/addincome")
        public String addIncome(@RequestBody Income income) {
            // Extract income source and date from the request
            String source = income.source;
            int amount = income.amount;
            IncomeRequest.currentincome+=amount;
           Income.incomes.put(source,amount);
            return "Income added successfully";
        }

    @GetMapping("/expenseview")
    public HashMap showexpenses() {

        return expense.expens;
    }

    @PostMapping("/addexpense")
    public String addExpense(@RequestBody expense expense) {
        // Extract expense name and amount from the request
        String name = expense.getName();
        int amount = expense.getAmount();
        if (IncomeRequest.currentincome < amount) {
            return "Error: Insufficient income to add expense";
        }
        expense.expens.put(name, amount);
        IncomeRequest.currentincome -= amount;
        return "Expense added successfully";
    }

    @GetMapping("/investmentview")
    public HashMap showInvestment() {

        return Investment.investment;
    }

    @PostMapping("/addinvestment")
    public String addInvestment(@RequestBody Investment inv) {
        // Extract expense name and amount from the request
        String name = inv.getName();
        int amount = inv.getAmount();
        if (IncomeRequest.currentincome < amount) {
            return "Error: Insufficient income to add investment";
        }
        Investment.investment.put(name, amount);
        IncomeRequest.currentincome -= amount;
        return "Investment added successfully";
    }

    @PostMapping("/updateinvestment")
    public String updateInvestment(@RequestBody Investment inv) {
        // Extract investment name and new amount from the request
        String name = inv.getName();
        int newAmount = inv.getAmount();
        // Update the investment amount
        Investment.investment.put(name, newAmount);
        return "Investment updated successfully";
    }

    @DeleteMapping("/deleteinvestment/{name}")
    public String deleteInvestment(@PathVariable String name) {
        // Check if the investment exists
        if (Investment.investment.containsKey(name)) {
            // Remove the investment
            Investment.currentincome+=Investment.investment.get(name);
            Investment.investment.remove(name);
            return "Investment '" + name + "' deleted successfully";
        } else {
            return "Investment '" + name + "' not found";
        }
    }


}

