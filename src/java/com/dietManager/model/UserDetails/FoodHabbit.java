package com.dietManager.model.UserDetails;

public class FoodHabbit {
    private double u_id;
    private double f_id;
    private String meal;

    public FoodHabbit() {
    }

    public FoodHabbit(double u_id, double f_id, String meal) {
        this.u_id = u_id;
        this.f_id = f_id;
        this.meal = meal;
    }

    public double getU_id() {
        return u_id;
    }

    public void setU_id(double u_id) {
        this.u_id = u_id;
    }

    public double getF_id() {
        return f_id;
    }

    public void setF_id(double f_id) {
        this.f_id = f_id;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    @Override
    public String toString() {
        return "FoodHabbit{" + "u_id=" + u_id + ", f_id=" + f_id + ", meal=" + meal + '}';
    }
    
    

}
