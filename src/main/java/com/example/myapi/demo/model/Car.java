package com.example.myapi.demo.model;

public class Car {
    private int id;
    private String make;
    private String model;
    private int year;
    private boolean available;

    public Car() {
    }

    public Car(String make, String model, int year, boolean available) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.available = available;
    }

    public Car(int id, String make, String model, int year, boolean available) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.available = available;
    }

    public int getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public boolean isAvailable() { return available; }





}
