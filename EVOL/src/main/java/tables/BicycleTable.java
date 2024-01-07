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
import mainClasses.Bicycle;

/**
 *
 * @author katerina
 */
public class BicycleTable {
	
	public void addBicycleFromJSON(String json) throws ClassNotFoundException {
        Bicycle user = jsonToBicycle(json);
        addNewBicycle(user);
    }

    public Bicycle jsonToBicycle(String json) {
        Gson gson = new Gson();
        Bicycle bicycle = gson.fromJson(json, Bicycle.class);
        return bicycle;
    }

    public String BicycleToJSON(Bicycle bicycle) {
        Gson gson = new Gson();
        String json = gson.toJson(bicycle, Bicycle.class);
        return json;
    }
    
    // Function to create a table for the bicycles in the database
    public void createBicycleTable() throws SQLException, ClassNotFoundException {

        try (Connection con = DB_setup.getConnection(); Statement stmt = con.createStatement()) {

            // Use the HY360_EVOL database
            stmt.execute("USE HY360_EVOL;");

            // Define the table creation query
            String query = "CREATE TABLE bicycles "
                    + "(bicycle_id INTEGER not NULL AUTO_INCREMENT, "
                    + " brand VARCHAR(30) not null, "
                    + " model VARCHAR(30) not null, "
                    + " color VARCHAR(30) not null, "
                    + " dailyRentCost INTEGER not null, "
                    + " range DOUBLE not null, "
                    + " bicycleID INTEGER not null, "
                    + " PRIMARY KEY (bicycle_id))";

            // Execute the query
            stmt.executeUpdate(query);
            System.out.println("Bicycle table created successfully.");
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Error creating the bicycle table: " + e.getMessage());
        }

    }
    
    /**
     * Adds a new bicycle to the database.
     *
     * @param bicycle the Bicycle object to be added
     * @throws ClassNotFoundException if the MySQL JDBC driver is not found
     */
    public static void addNewBicycle(Bicycle bicycle) throws ClassNotFoundException {
        try (Connection con = DB_setup.getConnection(); Statement stmt = con.createStatement()) {

            // Use the HY360_EVOL database
            stmt.execute("USE HY360_EVOL;");

            // Define the INSERT query for adding a new bicycle
            String insertQuery = "INSERT INTO bicycles "
                    + "(brand, model, color, dailyRentCost, range, bicycleID) "
                    + "VALUES ("
                    + "'" + client.getBrand() + "',"
                    + "'" + client.getModel() + "',"
                    + "'" + client.getColor() + "',"
                    + "'" + client.getDailyRentCost() + "',"
                    + "'" + client.getRange() + "',"
                    + "'" + client.getBicycleID() + "'"
                    + ")";

            // Execute the INSERT query
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The bicycle was successfully added in the database.");
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Error adding a new bicycle to the database: " + ex.getMessage());
        }
    }
    
}