package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CustomerRequest {

    @NotBlank(
            message = "Name is required"
    )
    private String name;

    @NotBlank(
            message = "Document is required"
    )
    private String document;

    @NotBlank(
            message = "Birthday is required"
    )
    private String birthday;

    @NotBlank(
            message = "Location is required"
    )
    private String location;

    @Positive(message = "Vehicle value must be greater than zero")
    private Double vehicle_value;

    public CustomerRequest() {
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getLocation() {
        return location;
    }

    public double getVehicle_value() {
        return vehicle_value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setVehicle_value(double vehicle_value) {
        this.vehicle_value = vehicle_value;
    }
}
