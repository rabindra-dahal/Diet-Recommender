package com.dietManager.model.Nutrition;
public class Contains {
    private double f_id;
    private double n_id;
    private double amount;

    public Contains() {
    }

    public Contains(double f_id, double n_id, double amount) {
        this.f_id = f_id;
        this.n_id = n_id;
        this.amount = amount;
    }

    public double getF_id() {
        return f_id;
    }

    public void setF_id(double f_id) {
        this.f_id = f_id;
    }

    public double getN_id() {
        return n_id;
    }

    public void setN_id(double n_id) {
        this.n_id = n_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Contains{" + "f_id=" + f_id + ", n_id=" + n_id + ", amount=" + amount + '}';
    }
    
    
}
