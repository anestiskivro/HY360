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
import mainClasses.Motorbike;

/**
 *
 * @author katerina
 */
public class MotorbikeTable {
	
	public void addMotorbikeFromJSON(String json) throws ClassNotFoundException {
		Motorbike user = jsonToMotorbike(json);
        addNewMotorbike(user);
    }

    public Motorbike jsonToMotorbike(String json) {
        Gson gson = new Gson();
        Motorbike motorbike = gson.fromJson(json, Motorbike.class);
        return motorbike;
    }

    public String MotorbikeToJSON(Motorbike motorbike) {
        Gson gson = new Gson();
        String json = gson.toJson(motorbike, Motorbike.class);
        return json;
    }
    
    // Function to create a table for the motorbikes in the database
    public void createMotorbikeTable() throws SQLException, ClassNotFoundException {

        try (Connection con = DB_setup.getConnection(); Statement stmt = con.createStatement()) {

            // Use the HY360_EVOL database
            stmt.execute("USE HY360_EVOL;");

            // Define the table creation query
            String query = "CREATE TABLE motorbikes "
                    + "(motorbike_id INTEGER not NULL AUTO_INCREMENT, "
                    + " brand VARCHAR(30) not null, "
                    + " model VARCHAR(30) not null, "
                    + " color VARCHAR(30) not null, "
                    + " dailyRentCost INTEGER not null, "
                    + " range DOUBLE not null, "
                    + " motorbikePlates VARCHAR(10) not null, "
                    + " PRIMARY KEY (motorbike_id))";

            // Execute the query
            stmt.executeUpdate(query);
            System.out.println("Motorbike table created successfully.");
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Error creating the motorbike table: " + e.getMessage());
        }

    }
    
    /**
     * Adds a new motorbike to the database.
     *
     * @param motorbike the Motorbike object to be added
     * @throws ClassNotFoundException if the MySQL JDBC driver is not found
     */
    public static void addNewMotorbike(Motorbike motorbike) throws ClassNotFoundException {
        try (Connection con = DB_setup.getConnection(); Statement stmt = con.createStatement()) {

            // Use the HY360_EVOL database
            stmt.execute("USE HY360_EVOL;");

            // Define the INSERT query for adding a new motorbike
            String insertQuery = "INSERT INTO motorbikes "
                    + "(brand, model, color, dailyRentCost, range, motorbikePlates) "
                    + "VALUES ("
                    + "'" + client.getBrand() + "',"
                    + "'" + client.getModel() + "',"
                    + "'" + client.getColor() + "',"
                    + "'" + client.getDailyRentCost() + "',"
                    + "'" + client.getRange() + "',"
                    + "'" + client.getMotorbikePlates() + "'"
                    + ")";

            // Execute the INSERT query
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The motorbike was successfully added in the database.");
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Error adding a new motorbike to the database: " + ex.getMessage());
        }
    }
    
}