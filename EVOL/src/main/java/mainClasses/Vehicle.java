/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

/**
 *
 * @author katerina
 */
public abstract class Vehicle {
	
	private String brand;
	private String model;
	private String color;
	private int dailyRentCost;
	private double range;
    
    /**
     * Gets the brand of vehicle.
     *
     * @return the brand of vehicle
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand of vehicle.
     *
     * @param brand (the brand of vehicle)
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    /**
     * Gets the model of vehicle.
     *
     * @return the model of vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of vehicle.
     *
     * @param model (the model of vehicle)
     */
    public void setModel(String model) {
        this.model = model;
    }
    
    /**
     * Gets the color of vehicle.
     *
     * @return the color of vehicle
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of vehicle.
     *
     * @param color (the color of vehicle)
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Gets the daily rent cost of vehicle.
     *
     * @return the daily rent cost of vehicle
     */
    public int getDailyRentCost() {
        return dailyRentCost;
    }

    /**
     * Sets the daily rent cost of vehicle.
     *
     * @param dailyRentCost (the daily rent cost of vehicle)
     */
    public void setDailyRentCost(int dailyRentCost) {
        this.dailyRentCost = dailyRentCost;
    }
    
    /**
     * Gets the range of vehicle.
     *
     * @return the range of vehicle
     */
    public double getRange() {
        return range;
    }

    /**
     * Sets the range of vehicle.
     *
     * @param range (the range of vehicle)
     */
    public void setRange(double range) {
        this.range = range;
    }
    
}