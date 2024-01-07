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
import mainClasses.Scooter;

/**
 *
 * @author katerina
 */
public class ScooterTable {
	
	public void addScooterFromJSON(String json) throws ClassNotFoundException {
		Scooter user = jsonToScooter(json);
        addNewScooter(user);
    }

    public Scooter jsonToScooter(String json) {
        Gson gson = new Gson();
        Scooter scooter = gson.fromJson(json, Scooter.class);
        return scooter;
    }

    public String ScooterToJSON(Scooter scooter) {
        Gson gson = new Gson();
        String json = gson.toJson(scooter, Scooter.class);
        return json;
    }
    
    // Function to create a table for the scooters in the database
    public void createScooterTable() throws SQLException, ClassNotFoundException {

        try (Connection con = DB_setup.getConnection(); Statement stmt = con.createStatement()) {

            // Use the HY360_EVOL database
            stmt.execute("USE HY360_EVOL;");

            // Define the table creation query
            String query = "CREATE TABLE scooters "
                    + "(scooter_id INTEGER not NULL AUTO_INCREMENT, "
                    + " brand VARCHAR(30) not null, "
                    + " model VARCHAR(30) not null, "
                    + " color VARCHAR(30) not null, "
                    + " dailyRentCost INTEGER not null, "
                    + " range DOUBLE not null, "
                    + " scooterID INTEGER not null, "
                    + " PRIMARY KEY (scooter_id))";

            // Execute the query
            stmt.executeUpdate(query);
            System.out.println("Scooter table created successfully.");
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Error creating the scooter table: " + e.getMessage());
        }

    }
    
    /**
     * Adds a new scooter to the database.
     *
     * @param scooter the Scooter object to be added
     * @throws ClassNotFoundException if the MySQL JDBC driver is not found
     */
    public static void addNewScooter(Scooter scooter) throws ClassNotFoundException {
        try (Connection con = DB_setup.getConnection(); Statement stmt = con.createStatement()) {

            // Use the HY360_EVOL database
            stmt.execute("USE HY360_EVOL;");

            // Define the INSERT query for adding a new scooter
            String insertQuery = "INSERT INTO scooters "
                    + "(brand, model, color, dailyRentCost, range, scooterID) "
                    + "VALUES ("
                    + "'" + client.getBrand() + "',"
                    + "'" + client.getModel() + "',"
                    + "'" + client.getColor() + "',"
                    + "'" + client.getDailyRentCost() + "',"
                    + "'" + client.getRange() + "',"
                    + "'" + client.getScooterID() + "'"
                    + ")";

            // Execute the INSERT query
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The scooter was successfully added in the database.");
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Error adding a new scooter to the database: " + ex.getMessage());
        }
    }
    
}