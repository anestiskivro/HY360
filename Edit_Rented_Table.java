
import mainClasses.Student;
import com.google.gson.Gson;
import mainClasses.User;
import database.DB_Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Edit_Rented_Table {
    
    public void addStudentFromJSON(String json) throws ClassNotFoundException{
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
     * @throws ClassNotFoundException
     */
    public void addNewRented(Rented user) throws ClassNotFoundException {
        try {
            Connection con = DB_Connection.getConnection();

            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " rented (name,date,duration,payment,model,number_vehicle,color,kmh_vehicle,city,address,student_type,"
                    + "student_id,student_id_from_date,student_id_to_date,university,department,lat,lon,telephone,personalpage)"
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
            //stmt.execute(table);
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The user was successfully added in the database.");

            /* Get the member id from the database and set it to the member */
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Edit_Rented_Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // public void createStudentsTable() throws SQLException, ClassNotFoundException {

    //     Connection con = DB_Connection.getConnection();
    //     Statement stmt = con.createStatement();

    //     String query = "CREATE TABLE students "
    //             + "(user_id INTEGER not NULL AUTO_INCREMENT, "
    //             + "    username VARCHAR(30) not null unique,"
    //             + "    email VARCHAR(200) not null unique,	"
    //             + "    password VARCHAR(32) not null,"
    //             + "    firstname VARCHAR(30) not null,"
    //             + "    lastname VARCHAR(30) not null,"
    //             + "    birthdate DATE not null,"
    //             + "    gender  VARCHAR (7) not null,"
    //             + "    country VARCHAR(30) not null,"
    //             + "    city VARCHAR(50) not null,"
    //             + "    address VARCHAR(50) not null,"
    //             + "    student_type VARCHAR(50) not null,"
    //             + "    student_id VARCHAR(14) not null unique,"
    //             + "    student_id_from_date DATE not null,"
    //             + "    student_id_to_date DATE not null,"
    //             + "   university VARCHAR(50) not null,"
    //             + "   department VARCHAR(50) not null,"
    //             + "    lat DOUBLE,"
    //             + "    lon DOUBLE,"
    //             + "    telephone VARCHAR(14),"
    //             + "   personalpage VARCHAR(200),"
    //             + " PRIMARY KEY ( user_id))";
    //     stmt.execute(query);
    //     stmt.close();
    // }
    
}