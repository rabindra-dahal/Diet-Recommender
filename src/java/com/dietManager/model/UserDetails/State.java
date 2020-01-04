package com.dietManager.model.UserDetails;

public class State {
    private double u_id;
    private double height;
    private double weight;
    private double working_hrs;
    private double age;
    private String food_habbit;

    public State() {
    }

    public State(double u_id, double height, double weight, double working_hrs, double age, String food_habbit) {
        this.u_id = u_id;
        this.height = height;
        this.weight = weight;
        this.working_hrs = working_hrs;
        this.age = age;
        this.food_habbit = food_habbit;
    }

    public double getU_id() {
        return u_id;
    }

    public void setU_id(double u_id) {
        this.u_id = u_id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWorking_hrs() {
        return working_hrs;
    }

    public void setWorking_hrs(double working_hrs) {
        this.working_hrs = working_hrs;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getFood_habbit() {
        return food_habbit;
    }

    public void setFood_habbit(String food_habbit) {
        this.food_habbit = food_habbit;
    }

    @Override
    public String toString() {
        return "u_id : "+u_id+"  height : "+height+"  weight : "+weight+"  working_hrs : "+working_hrs+"  age : "+age+"  food_habbit : "+food_habbit+"  ";
    }
    



}
