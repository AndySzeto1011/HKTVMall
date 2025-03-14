package com.example.demo.model;

public class Parcel {
    private double length;
    private double width;
    private double height;
    private double weight;
    private String temperature;
    private int quantity;

    // Constructors
    public Parcel() {}

    public Parcel(double length, double width, double height, double weight, String temperature, int quantity) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.temperature = temperature;
        this.quantity = quantity;
    }

    // Getters and Setters
    public double getLength() { 
        return length; 
    }
    public void setLength(double length) { 
        this.length = length; 
    }

    public double getWidth() { 
        return width; 
    }
    public void setWidth(double width) { 
        this.width = width; 
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

    public String getTemperature() { 
        return temperature; 
    }
    public void setTemperature(String temperature) { 
        this.temperature = temperature; 
    }

    public int getQuantity() { 
        return quantity; 
    }
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
    }
}
