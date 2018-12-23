/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectsqlit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    
/**
 * 
 * @param args 
 */
public static void main(String[] args) 
{
      ConnectSqlit test = new ConnectSqlit();
      ResultSet rs;
       
    try {
        rs = test.displayUsers();
        while(rs.next())
{
  System.out.println(rs.getString("fName") + " " + rs.getString("lname"));
}

    } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    } 
}
}
