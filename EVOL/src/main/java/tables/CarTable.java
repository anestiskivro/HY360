/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import com.google.gson.Gson;
import database.DB_setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mainClasses.Car;

/**
 *
 * @author katerina
 */
public class CarTable {
	
	public void addCarFromJSON(String json) throws ClassNotFoundException {
        Car user = jsonToCar(json);
        addNewCar(user);
    }

    public Car jsonToCar(String json) {
        Gson gson = new Gson();
        Car car = gson.fromJson(json, Car.class);
        return car;
    }

    public String CarToJSON(Car car) {
        Gson gson = new Gson();
        String json = gson.toJson(car, Car.class);
        return json;
    }
    
    // Function to create a table for the cars in the database
    public void createCarTable() throws SQLException, ClassNotFoundException {

        try (Connection con = DB_setup.getConnection(); Statement stmt = con.createStatement()) {

            // Use the HY360_EVOL database
            stmt.execute("USE HY360_EVOL;");

            // Define the table creation query
            String query = "CREATE TABLE cars "
                    + "(car_id INTEGER not NULL AUTO_INCREMENT, "
                    + " brand VARCHAR(30) not null, "
                    + " model VARCHAR(30) not null, "
                    + " color VARCHAR(30) not null, "
                    + " dailyRentCost INTEGER not null, "
                    + " range DOUBLE not null, "
                    + " carPlates VARCHAR(10) not null, "
                    + " type VARCHAR(30) not null, "
                    + " passengers INTEGER not null, "
                    + " PRIMARY KEY (car_id))";

            // Execute the query
            stmt.executeUpdate(query);
            System.out.println("Car table created successfully.");
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Error creating the car table: " + e.getMessage());
        }

    }
    
    /**
     * Adds a new car to the database.
     *
     * @param car the Car object to be added
     * @throws ClassNotFoundException if the MySQL JDBC driver is not found
     */
    public static void addNewCar(Car car) throws ClassNotFoundException {
        try (Connection con = DB_setup.getConnection(); Statement stmt = con.createStatement()) {

            // Use the HY360_EVOL database
            stmt.execute("USE HY360_EVOL;");

            // Define the INSERT query for adding a new car
            String insertQuery = "INSERT INTO cars "
                    + "(brand, model, color, dailyRentCost, range, carPlates, type, passengers) "
                    + "VALUES ("
                    + "'" + client.getBrand() + "',"
                    + "'" + client.getModel() + "',"
                    + "'" + client.getColor() + "',"
                    + "'" + client.getDailyRentCost() + "',"
                    + "'" + client.getRange() + "',"
                    + "'" + client.getCarPlates() + "',"
                    + "'" + client.getType() + "',"
                    + "'" + client.getPassengers() + "'"
                    + ")";

            // Execute the INSERT query
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The car was successfully added in the database.");
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Error adding a new car to the database: " + ex.getMessage());
        }
    }
    
}