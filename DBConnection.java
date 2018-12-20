/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oculus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author oculus_team_4
 */

public class DBConnection 
{
    
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver"; //loading jdbc driver for apache server
     private static final String JDBC_URL = "jdbc:derby:oculus;create=true";  //loading server's data location 
    
     
     Connection conn;     
     
    /**
     */
    public DBConnection()
           {
        try {
            this.conn = DriverManager.getConnection(JDBC_URL);
            if(this.conn != null)
            {
                System.out.println("Connected to DB");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
    
     public void createTable()
{
        try {
            conn.createStatement().execute("CREATE TABLE Mytable( Name varchar(50)");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    /**
     *
     * 
     */
    public void insertIntoTable(String name)
{
        try {      
            conn.createStatement().execute("INSERT INTO Mytable Values ("+name+")");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void Display()
{
        try {
            Statement statement = this.conn.createStatement();
            ResultSet RS = statement.executeQuery("Select * FROM Mytable");
            
            while(RS.next())
            {
                System.out.println(RS.getString("Name"));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    

}

