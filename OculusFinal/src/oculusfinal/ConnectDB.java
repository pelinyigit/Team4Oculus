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
    
    public void createtable(String tablename) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
         }
        PreparedStatement createdb;
        createdb = con.prepareStatement(" create table " + tablename + " (id integer , name varchar(50) default unknown , Is_favourite boolean default 0 , primary key(id));");
        createdb.execute();      
    }
    
    public void addAttributeInt(String tablename ,String attribute) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
         }
        PreparedStatement addAttributeInt;
        addAttributeInt = con.prepareStatement(" alter table " + tablename + " add " + attribute + " int default 0;");
        addAttributeInt.execute();
    }
    
     public void addAttributeVarchar(String tablename ,String attribute) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
        }
        PreparedStatement addAttributeVarchar; 
        addAttributeVarchar = con.prepareStatement(" alter table " + tablename + " add " + attribute + " varchar(50) default unknown;");
        addAttributeVarchar.execute();
    }
     
      public void addAttributeBoolean(String tablename ,String attribute) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
         }
        PreparedStatement addAttributeBoolean;
        addAttributeBoolean = con.prepareStatement(" alter table " + tablename + " add " + attribute + " boolean default 0;");
        addAttributeBoolean.execute();        
    }
      
      public void addAttributeDouble(String tablename ,String attribute) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
         }
        PreparedStatement addAttributeDouble;
        addAttributeDouble = con.prepareStatement(" alter table " + tablename + " add " + attribute + " double default 0.);");
        addAttributeDouble.execute();        
    }
      
      public void deleteAttribute(String tablename , String attribute) throws SQLException, ClassNotFoundException
      {
          if(con == null)
        {
           getConnection();
         }
        PreparedStatement deleteAttribute;
        deleteAttribute = con.prepareStatement(" alter table " + tablename + " drop column " + attribute + ";");
        deleteAttribute.execute();   
      }
      public void droptable(String tablename) throws SQLException, ClassNotFoundException
      {
          if(con == null)
        {
           getConnection();
         }
          PreparedStatement droptable;
          droptable = con.prepareStatement(" DROP TABLE [IF EXISTS] " + tablename + ";");
          droptable.execute();
      }
             
      public void insertInt(String tablename , int attribute) throws SQLException, ClassNotFoundException  
      {
      if(con == null)
        {
           getConnection();
         }
          PreparedStatement insertInt;
          insertInt = con.prepareStatement(" insert into  " + tablename + " values add " + attribute + ";");
          insertInt.execute();
      }
      
      public void insertVarchar(String tablename , String attribute) throws SQLException, ClassNotFoundException
      {
      if(con == null)
        {
           getConnection();
         }
          PreparedStatement insertVarchar;
          insertVarchar = con.prepareStatement("insert into  " + tablename + " values add " + attribute + ";");
          insertVarchar.execute();
      }
      
      public void insertDouble(String tablename , String attribute) throws SQLException, ClassNotFoundException
      {
      if(con == null)
        {
           getConnection();
        }
          PreparedStatement insertDouble;
          insertDouble = con.prepareStatement("insert into  "+tablename+" values add "+attribute+" real;");
          insertDouble.execute();
      }

      public void findontableitem(String tablename , String item , String parameter) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
        }

         PreparedStatement findontableitem;
         findontableitem = con.prepareStatement("SELECT "+item+" FROM " + tablename + " WHERE " + parameter + " ");
         findontableitem.execute();
    
    }
      public void displaytable(String tablename) throws SQLException, ClassNotFoundException
      {
          if(con == null)
        {
           getConnection();
         }
          PreparedStatement displaytable;
          displaytable = con.prepareStatement("select * from  " + tablename + " ");
          displaytable.execute();        
      }
      
     
       public void displaywithvariable(String tablename , String a) throws SQLException, ClassNotFoundException
      {
          if(con == null)
        {
           getConnection();
         }
          PreparedStatement displaytable;
          displaytable = con.prepareStatement("select * from  "+tablename+" where "+a+" ");
          displaytable.execute();        
      }
      
        public void DisplayAll() throws SQLException, ClassNotFoundException
      {
          if(con == null)
        {
           getConnection();
         }
           PreparedStatement DisplayAll;
           DisplayAll = con.prepareStatement(" SELECT * FROM sqlite_master WHERE type= 'table' ");
           DisplayAll.execute();
      }
      
        public int row_size() throws ClassNotFoundException, SQLException
        {
            if(con == null)
        {
           getConnection();
         }
            
            String row_size = "SELECT COUNT(*) from sqlite_master WHERE type= 'table'";
            ResultSet rs = con.createStatement().executeQuery(row_size);
             
      if (rs.next()) 
    {            
        int row_number = 0;
        rs.getInt(row_number);
        return row_number;
    }
        else
          return 1;
        }
}