/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oculusfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ataha
 */
public class ConnectDB 
{
    private static Connection con;
   
    void getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:oculus.db");
         System.out.println("Connection to SQLite has been established.");
    }
    
    public void createtable(String tablename) throws SQLException
    {
        PreparedStatement createdb;
        createdb = con.prepareStatement("create table "+tablename+" (id integer , name varchar(50) , primary key(id));");
        createdb.execute();      
    }
    
    public void addAttributeInt(String tablename ,String attribute) throws SQLException
    {
        PreparedStatement addAttributeInt;
        addAttributeInt = con.prepareStatement("alter table "+tablename+" (add "+attribute+" int);");
        addAttributeInt.execute();
    }
     public void addAttributeVarchar(String tablename ,String attribute) throws SQLException
    {
        PreparedStatement addAttributeVarchar; 
        addAttributeVarchar = con.prepareStatement("alter table "+tablename+" (add "+attribute+" varchar(50));");
        addAttributeVarchar.execute();
    }
      public void addAttributeboolean(String tablename ,String attribute) throws SQLException
    {
        PreparedStatement addAttributeboolean;
        addAttributeboolean = con.prepareStatement("alter table "+tablename+" (add "+attribute+" boolean);");
        addAttributeboolean.execute();        
    }
      public void addAttributedouble(String tablename ,String attribute) throws SQLException
    {
        PreparedStatement addAttributedouble;
        addAttributedouble =  con.prepareStatement("alter table "+tablename+" (add "+attribute+" real);");
        addAttributedouble.execute();        
    }
      public void findontable(String tablename ,  String parameter) throws SQLException
    {
        boolean hasfound = false;
         PreparedStatement findontable;
         findontable = con.prepareStatement("SELECT * from "+tablename+" where "+parameter+"");
         
        if(hasfound = false)           
        {
            System.out.println("NOT FOUND");
        }
        
        else
        {
            System.out.println("FOUND");
        }
        
    }
      public void displaytable(String tablename) throws SQLException
      {
          PreparedStatement displaytable;
          displaytable = con.prepareStatement("select * from  "+tablename+"");
          displaytable.execute();        
      }
      
}