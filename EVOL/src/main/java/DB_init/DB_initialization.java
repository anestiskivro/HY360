/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB_init;

import static database.DB_setup.getInitialConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import tables.ClientTable;

/**
 *
 * @author tzeor
 */
public class DB_initialization {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DB_initialization init = new DB_initialization();
        init.initDatabase();
        init.initTables();

    }

    public void dropDatabase() throws SQLException, ClassNotFoundException {
        Connection conn = getInitialConnection();
        Statement stmt = conn.createStatement();
        String sql = "DROP DATABASE  HY360_EVOL";
        stmt.executeUpdate(sql);
        System.out.println("Database dropped successfully...");
    }

    public void initDatabase() throws SQLException, ClassNotFoundException {
        Connection conn = getInitialConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE DATABASE HY360_EVOL");
        stmt.close();
        conn.close();

    }

    public void initTables() throws SQLException, ClassNotFoundException {
        ClientTable client = new ClientTable();
        client.createClientTable();
    }


}
