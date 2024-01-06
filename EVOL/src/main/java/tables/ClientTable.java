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
import java.time.LocalDate;
import mainClasses.Client;

/**
 *
 * @author tzeor
 */
public class ClientTable {


    public void addClientFromJSON(String json) throws ClassNotFoundException {
        Client user = jsonToClient(json);
        addNewClient(user);
    }

    public Client jsonToClient(String json) {
        Gson gson = new Gson();
        Client client = gson.fromJson(json, Client.class);
        return client;
    }

    public String ClientToJSON(Client client) {
        Gson gson = new Gson();
        String json = gson.toJson(client, Client.class);
        return json;
    }

    // Function to create a table for the client in the database
    public void createClientTable() throws SQLException, ClassNotFoundException {

        try (Connection con = DB_setup.getConnection(); Statement stmt = con.createStatement()) {

            // Use the HY360_EVOL database
            stmt.execute("USE HY360_EVOL;");

            // Define the table creation query
            String query = "CREATE TABLE clients "
                    + "(client_id INTEGER not NULL AUTO_INCREMENT, "
                    + " name VARCHAR(30) not null, "
                    + " last_name VARCHAR(30) not null, "
                    + " address VARCHAR(50) not null, "
                    + " date_of_birth DATE not null, "
                    + " driving_license_number VARCHAR(50), "
                    + " credit_card_number VARCHAR(40) not null, "
                    + " expiration_date DATE not null, "
                    + " CVV VARCHAR(10) not null, "
                    + " has_driving_license VARCHAR(30) not null, "
                    + " PRIMARY KEY (client_id))";

            // Execute the query
            stmt.executeUpdate(query);
            System.out.println("Client table created successfully.");
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Error creating the client table: " + e.getMessage());
        }

    }

    /**
     * Adds a new client to the database.
     *
     * @param client the Client object to be added
     * @throws ClassNotFoundException if the MySQL JDBC driver is not found
     */
    public static void addNewClient(Client client) throws ClassNotFoundException {
        try (Connection con = DB_setup.getConnection(); Statement stmt = con.createStatement()) {

            // Use the HY360_EVOL database
            stmt.execute("USE HY360_EVOL;");

            // Define the INSERT query for adding a new client
            String insertQuery = "INSERT INTO clients "
                    + "(name, last_name, address, date_of_birth, driving_license_number, credit_card_number, expiration_date, cvv, has_driving_license) "
                    + "VALUES ("
                    + "'" + client.getName() + "',"
                    + "'" + client.getLastName() + "',"
                    + "'" + client.getAddress() + "',"
                    + "'" + client.getDateOfBirth() + "',"
                    + "'" + client.getDrivingLicenseNumber() + "',"
                    + "'" + client.getCreditCardNumber() + "',"
                    + "'" + client.getExpirationDate() + "',"
                    + "'" + client.getCvv() + "',"
                    + "'" + client.getDrivingLicense() + "'"
                    + ")";

            // Execute the INSERT query
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The client was successfully added in the database.");
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Error adding a new client to the database: " + ex.getMessage());
        }
    }

    /**
     * Check if a client has a valid driving license and is above 18 years old.
     *
     * @param clientId the ID of the client to check
     * @return true if the client is eligible, false otherwise
     * @throws SQLException if a database error occurs
     * @throws java.lang.ClassNotFoundException
     */
    public boolean isClientEligible(int clientId) throws SQLException, ClassNotFoundException {
        try (Connection con = DB_setup.getConnection();
                PreparedStatement stmt = con.prepareStatement("SELECT date_of_birth, has_driving_license FROM clients WHERE client_id = ?")) {

            stmt.setInt(1, clientId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    LocalDate dateOfBirth = rs.getDate("date_of_birth").toLocalDate();
                    String hasDrivingLicense = rs.getString("has_driving_license");
                    System.out.println("date_of_birth" + rs.getDate("date_of_birth"));
                    System.out.println("date_of_birth.toLocalDate()" + rs.getDate("date_of_birth").toLocalDate());
                    System.out.println("has_driving_license" + rs.getString("has_driving_license"));

                    return dateOfBirth.plusYears(18).isBefore(LocalDate.now()) && "true".equalsIgnoreCase(hasDrivingLicense);
                } else {

                    return false;
                }
            }
        }
    }

}
