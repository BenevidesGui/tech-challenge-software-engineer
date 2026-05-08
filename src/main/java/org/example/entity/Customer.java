package org.example.entity;


import java.util.Date;

public class Customer {

    String name;
    String document;
    Date birthDay;
    String location;
    Double vValue;

    public Customer() {
    }

    public Customer(String name, String document, Date birthDay, String location, Double vValue) {
        this.name = name;
        this.document = document;
        this.birthDay = birthDay;
        this.location = location;
        this.vValue = vValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getvValue() {
        return vValue;
    }

    public void setvValue(Double vValue) {
        this.vValue = vValue;
    }
}
