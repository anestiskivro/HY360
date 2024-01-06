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

public class Car extends Vehicle {
	
	private String carPlates;
	private String type;
	private int passengers;
    
    /**
     * Gets the plates of car.
     *
     * @return the plates of car
     */
    public String getCarPlates() {
        return carPlates;
    }

    /**
     * Sets the plates of car.
     *
     * @param carPlates (the plates of car)
     */
    public void setCarPlates(String carPlates) {
        this.carPlates = carPlates;
    }
    
    /**
     * Gets the type of car.
     *
     * @return the type of car
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of car.
     *
     * @param type (the type of car)
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Gets the number of passengers in the car.
     *
     * @return the number of passengers in the car
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Sets the number of passengers in the car.
     *
     * @param passengers (the number of passengers in the car)
     */
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
    
}

public class Motorbike extends Vehicle {
	
	private String motoPlates;
    
    /**
     * Gets the plates of motorbike.
     *
     * @return the plates of motorbike
     */
    public String getMotoPlates() {
        return motoPlates;
    }

    /**
     * Sets the plates of motorbike.
     *
     * @param motoPlates (the plates of motorbike)
     */
    public void setMotoPlates(String motoPlates) {
        this.motoPlates = motoPlates;
    }
    
}

public class Bicycle extends Vehicle {
	
	private int bicycle_ID;
    
    /**
     * Gets the ID of bicycle.
     *
     * @return the ID of bicycle
     */
    public int getBicycle_ID() {
        return bicycle_ID;
    }

    /**
     * Sets the ID of bicycle.
     *
     * @param bicycle_ID (the ID of bicycle)
     */
    public void setBicycle_ID(String bicycle_ID) {
        this.bicycle_ID = bicycle_ID;
    }
    
}

public class Scooter extends Vehicle {
	
	private int scooter_ID;
    
    /**
     * Gets the ID of scooter.
     *
     * @return the ID of scooter
     */
    public int getScooter_ID() {
        return scooter_ID;
    }

    /**
     * Sets the ID of scooter.
     *
     * @param scooter_ID (the ID of scooter)
     */
    public void setScooter_ID(String scooter_ID) {
        this.scooter_ID = scooter_ID;
    }
    
}