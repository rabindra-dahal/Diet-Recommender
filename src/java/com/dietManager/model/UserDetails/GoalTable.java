package com.dietManager.model.UserDetails;
public class GoalTable {

    private double age;
    private double energyLimit;

    @Override
    public String toString() {
        return '{' + "age : " + age + ", energyLimit : " + energyLimit + '}';
    }

    public GoalTable() {
    }

    public GoalTable(double age, double energyLimit) {
        this.age = age;
        this.energyLimit = energyLimit;
    }
    

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getEnergyLimit() {
        return energyLimit;
    }

    public void setEnergyLimit(double energyLimit) {
        this.energyLimit = energyLimit;
    }
    
    
}
