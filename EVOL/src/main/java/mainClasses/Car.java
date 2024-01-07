/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainClasses;

import mainClasses.Vehicle;

/**
 *
 * @author katerina
 */
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