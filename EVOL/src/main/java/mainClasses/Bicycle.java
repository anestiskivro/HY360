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
public class Bicycle extends Vehicle {
	
	private int bicycleID;
    
    /**
     * Gets the ID of bicycle.
     *
     * @return the ID of bicycle
     */
    public int getBicycleID() {
        return bicycleID;
    }

    /**
     * Sets the ID of bicycle.
     *
     * @param bicycleID (the ID of bicycle)
     */
    public void setBicycleID(String bicycleID) {
        this.bicycleID = bicycleID;
    }
    
}