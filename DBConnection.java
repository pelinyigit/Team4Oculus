package oculus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection 
{
    
    private static final String DRIVER ="org.apache.derby.jdbc.EmbeddedDriver"; //loading jdbc driver for apache server
    private static final String JDBC_URL ="jdbc:derby:oculus;create=true;";  //loading server's data location 
    
     Connection conn; 
     
    public DBConnection()
           {      
        try {           
            this.conn = DriverManager.getConnection(JDBC_URL);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
    
     public void  DBShutdown()
    {
        try {
            DriverManager.getConnection("jdbc:derby:DERBYDB;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void createTable()
{
        try {
            conn.createStatement().execute("CREATE TABLE OCULUS\n" +
"     (ID INT NOT NULL, NAME VARCHAR(50), PRIMARY KEY (ID)");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    /**
     *
     * @param ID
     * @param NAME
     */
    public void insertIntoTable(int ID,String NAME)
{
        try {      
            conn.createStatement().execute("INSERT INTO OCULUS VALUES('"+NAME+"',"+ID+")");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void Display()
{
        try {
            Statement statement = this.conn.createStatement();
            ResultSet res;
            res = statement.executeQuery("SELECT * FROM OCULUS");
            
            while(res.next())
            {
                System.out.println(res.getString("ID")+ " "+res.getString("NAME"));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
