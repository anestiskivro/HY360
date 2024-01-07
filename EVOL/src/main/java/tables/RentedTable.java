/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import com.google.gson.Gson;
import database.DB_setup;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClasses.Rented;

/**
 *
 * @author anestiskivroglou
 */
public class RentedTable {
      
    public void addRentedFromJSON(String json) throws ClassNotFoundException{
        Rented user=jsonToRented(json);
        addNewRented(user);
   }
   
    public Rented jsonToRented(String json){
        Gson gson = new Gson();

       Rented user = gson.fromJson(json, Rented.class);
       return user;
   }
   
   public String RentedToJSON(Rented user){
        Gson gson = new Gson();

       String json = gson.toJson(user, Rented.class);
       return json;
   }

  /**
     * Establish a database connection and add in the database.
     *
     * @param user
     * @throws ClassNotFoundException
     */
    public void addNewRented(Rented user) throws ClassNotFoundException {
        try {
            Connection con = DB_setup.getConnection();

            try (Statement stmt = con.createStatement()) {
                String insertQuery = "INSERT INTO "
                        + " Rented (name,date,duration,payment,model,number_vehicle,color,kmh_vehicle)"
                        + " VALUES ("
                        + "'" + user.getName() + "',"
                        + "'" + user.getDate() + "',"
                        + "'" + user.getDuration() + "',"
                        + "'" + user.getPayment() + "',"
                        + "'" + user.getmodel() + "',"
                        + "'" + user.get_number_vehicle() + "',"
                        + "'" + user.getColor() + "',"
                        + "'" + user.get_kmh_vehicle() + "'"
                        + ")";
                stmt.execute(insertQuery);
                System.out.println(insertQuery);
                stmt.executeUpdate(insertQuery);
                System.out.println("# The user was successfully added in the database.");
                /* Get the member id from the database and set it to the member */
            }

        } catch (SQLException ex) {
            Logger.getLogger(RentedTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void createRentedTable() throws SQLException, ClassNotFoundException {
         Connection con = DB_setup.getConnection();
        try (Statement stmt = con.createStatement()) {
            String query = "CREATE TABLE Rented "
                    + "   (name VARCHAR(30) not NULL,"
                    + "    date DATE not NULL,	"
                    + "    duration INTEGER not NULL,"
                    + "    payment INTEGER not NULL,"
                    + "    id_vehicle INTEGER not NULL AUTO_INCREMENT,"
                    + "    model VARCHAR(30) not null,"
                    + "    number_vehicle INTEGER not null,"
                    + "    color VARCHAR(10) not null,"
                    + "    kmh_vehicle INTEGER not null,"
                    + " PRIMARY KEY ( id_vehicle))";
            stmt.execute(query);
        }
     }
}
