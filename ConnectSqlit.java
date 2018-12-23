package connectsqlit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSqlit {

   private static Connection con;
   private static  boolean hasData = false;
   
   public ResultSet displayUsers() throws SQLException, ClassNotFoundException
   {
       if(con == null)
       {
           getConnection();
       }
       Statement state = con.createStatement();
       ResultSet res = state.executeQuery("SELECT fname , lname FROM user");
       return res;
   }
   
 
    private void getConnection() throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:Oculus.db");
        initialise();
    }

    private void initialise() throws SQLException 
    {
       if(!hasData)
       {
           hasData = true;
           
           Statement state = con.createStatement();
           ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='user'");
           if(!res.next())
           {
               System.out.println("Building the User table with prepopulated values");
               
               Statement state2 = con.createStatement();
               state2.execute("CREATE TABLE user(id integer,"
               + "fName varchar(60)," + "lName varchar(60),"
               + "primary key(id)");
               
               //inserting synthetic load //
               PreparedStatement prep = con.prepareStatement("INSERT INTO user values(?,?,?); ");
               prep.setString(2, "Şükrü");
               prep.setString(3, "Yamaç");
               prep.setString(4, "Pelin");
               prep.setString(5, "Beyza");
               prep.setString(6, "Ata");
           }
       }
    }
    
    public void addUser(String firstname , String lastName) throws ClassNotFoundException, SQLException
    {
        if(con == null)
        {
            getConnection();
        }
        
        PreparedStatement prep = con.prepareStatement("INSERT INTO user values (?, ?, ?);");
        prep.setString(2, firstname);
        prep.setString(3, lastName);
        prep.execute();
    }
    
}
