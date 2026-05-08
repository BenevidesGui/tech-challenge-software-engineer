package org.example.entity;


public class CustomerResponseEntity {

    private String name;
    private String location;
    private double value;

    public CustomerResponseEntity(
            String name,
            String location,
            double value
    ) {
        this.name = name;
        this.location = location;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getValue() {
        return value;
    }
}
