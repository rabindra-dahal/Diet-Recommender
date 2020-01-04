package com.dietManager.model.Nutrition;
public class Belongs {
     private double f_id;
    private double c_id;

    public Belongs() {
    }

    public Belongs(double f_id, double c_id) {
        this.f_id = f_id;
        this.c_id = c_id;
    }

    public double getF_id() {
        return f_id;
    }

    public void setF_id(double f_id) {
        this.f_id = f_id;
    }

    public double getC_id() {
        return c_id;
    }

    public void setC_id(double c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "Belongs{" + "f_id=" + f_id + ", c_id=" + c_id + '}';
    }
    
    
}
