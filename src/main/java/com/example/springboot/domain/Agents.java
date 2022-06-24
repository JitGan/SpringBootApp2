package com.example.springboot.domain;

public class Agents {
    private String AGENTS_CODE;
    private String name;
    private String location;
    private double commission;

    public String getCode() {return AGENTS_CODE;}
    public void setCode(String AGENTS_CODE) {
        this.AGENTS_CODE = AGENTS_CODE;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public double getCommission() {return commission;}

    public void setCommission(double commission) {this.commission = commission;}

    @Override
    public String toString() {
        return ("Agent: " + name + " From:" + location + " Agent Code: " + AGENTS_CODE + '\n');
    }

}
