package org.example.dto;

public class CustomerResponse {

    private String name;
    private String location;
    private double value;

    public CustomerResponse(
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

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
