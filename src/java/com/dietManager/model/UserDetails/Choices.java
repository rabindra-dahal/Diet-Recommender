package com.dietManager.model.UserDetails;

public class Choices {
    private double u_id;
    private double f_id;
    private double no_of_times;

    public Choices(double u_id, double f_id, double no_of_times) {
        this.u_id = u_id;
        this.f_id = f_id;
        this.no_of_times = no_of_times;
    }

    public Choices() {
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

    public double getNo_of_times() {
        return no_of_times;
    }

    public void setNo_of_times(double no_of_times) {
        this.no_of_times = no_of_times;
    }

    @Override
    public String toString() {
        return "Choices{" + "u_id=" + u_id + ", f_id=" + f_id + ", no_of_times=" + no_of_times + '}';
    }
    
    

}
