/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oculusfinal;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author @Atahan Ekici
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
    
    /**
     *
     * @param tablename
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void createtable(String tablename) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
         }
        PreparedStatement createdb;
        PreparedStatement createdb2;
        createdb2 = con.prepareStatement("DROP TABLE IF EXISTS " + tablename + " ; ");
        createdb = con.prepareStatement(" create table if not exists " + tablename + " (id integer , name varchar(50) default unknown , Is_favourite boolean default 0 , primary key(id));");
        createdb2.execute();
        createdb.execute();      
    }
    
    /**
     *
     * @param tablename
     * @param attribute
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
    
    /**
     *
     * @param tablename
     * @param new_name
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void renametable(String tablename , String new_name) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
        }
        
        PreparedStatement renametable;
        renametable = con.prepareStatement(" alter table  " + tablename + " rename to " + new_name + " ;");
        renametable.execute();
        manuallyvacuumDB();        
    }
    
    /**
     *
     * @param tablename
     * @param attribute
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
     
    /**
     *
     * @param tablename
     * @param attribute
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
      
    /**
     *
     * @param tablename
     * @param attribute
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
      
    /**
     *
     * @param tablename
     * @param attribute
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void deleteAttribute(String tablename , String attribute) throws SQLException, ClassNotFoundException
      {
          if(con == null)
        {
           getConnection();
         }
        PreparedStatement deleteAttribute;
        deleteAttribute = con.prepareStatement(" ALTER TABLE " + tablename + " DROP COLUMN " + attribute + ";");
        deleteAttribute.execute(); 
        manuallyvacuumDB();
      }
      
    /**
     *
     * @param tablename
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void droptable(String tablename) throws SQLException, ClassNotFoundException
      {
          if(con == null)
        {
           getConnection();
         }
          PreparedStatement droptable;
          droptable = con.prepareStatement(" DROP TABLE if exists " + tablename + "");        
          droptable.execute();
          manuallyvacuumDB();
      }
      
    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void manuallyvacuumDB() throws ClassNotFoundException, SQLException
      {
           if(con == null)
        {
           getConnection();
         }
           
          PreparedStatement vacuum;
          vacuum = con.prepareStatement(" VACUUM;");
          vacuum.execute();
      }
             
    /**
     *
     * @param tablename
     * @param attribute
     * @param value
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertInt(String tablename , String attribute , int value) throws SQLException, ClassNotFoundException  
      {
      if(con == null)
        {
           getConnection();
         }
          PreparedStatement insertInt;
          insertInt = con.prepareStatement("insert into "+tablename+"("+attribute+") values("+value+") ");
          insertInt.execute();
      }
      
    /**
     *
     * @param tablename
     * @param attribute
     * @param value
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertVarchar(String tablename , String attribute , String value) throws SQLException, ClassNotFoundException
      {
      if(con == null)
        {
           getConnection();
         }
          PreparedStatement insertVarchar;
          insertVarchar = con.prepareStatement("insert into "+tablename+"("+attribute+") values("+value+") ");
          insertVarchar.execute();
      }
      
    /**
     *
     * @param tablename
     * @param attribute
     * @param value
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertDouble(String tablename , String attribute , double value ) throws SQLException, ClassNotFoundException
      {
      if(con == null)
        {
           getConnection();
        }
          PreparedStatement insertDouble;
          insertDouble = con.prepareStatement("insert into "+tablename+"("+attribute+") values("+value+") ");
          insertDouble.execute();
      }
      
    /**
     *
     * @param tablename
     * @param attribute
     * @param value
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertBoolean(String tablename , String attribute , double value ) throws SQLException, ClassNotFoundException
      {
      if(con == null)
        {
           getConnection();
        }
          PreparedStatement insertBoolean;
          insertBoolean = con.prepareStatement("insert into "+tablename+"("+attribute+") values("+value+") ");
          insertBoolean.execute();
      }
      
    /**
     *
     * @param tablename
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void DisplayTable(String tablename) throws SQLException , ClassNotFoundException
      {
          Statement state = con.createStatement();
          ResultSet res = state.executeQuery("select * from sqlite_master where type = 'table' and name ='"+tablename+"'");
          
          while(res.next())
          {
              
          }
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
      public void displaySpecifictable(String tablename) throws SQLException, ClassNotFoundException
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
      
        public void DisplayAllTables() throws SQLException, ClassNotFoundException
      {
       if(con == null)
        {
           getConnection();
        }
           DatabaseMetaData md = con.getMetaData();
           ResultSet rs = md.getTables(null, null, "%", null);           
            
           while(rs.next())
           {
                System.out.println(rs.getString(3));
           }   
      }

         public ArrayList<String> DisplayAllTablesReturns() throws SQLException, ClassNotFoundException
   {   
       if(con == null)
        {
           getConnection();
        }

           ArrayList<String> mylist = new ArrayList<>();
           DatabaseMetaData md = con.getMetaData();
           ResultSet rs = md.getTables(null, null, "%", null);           
            
           while(rs.next())
           {
               mylist.add(rs.getString(3));
           }
         return (mylist);
   
  }

        
         public ArrayList<Integer> getTotalColumn() throws ClassNotFoundException, SQLException
  {
        if(con == null)
        {
           getConnection();
        }
        
        ArrayList<String> data = DisplayAllTablesReturns();
        ArrayList<Integer> result = new ArrayList<>();
        Statement state = ConnectDB.con.createStatement();
        String tablename;
        
        for(int i=0; i<data.size();i++)
        {
            tablename = data.get(i);
            ResultSet rs =  state.executeQuery("select count(*) from " + tablename + "");
            
            while(rs.next())
            {
               result.add(rs.getInt(1));
            }
        }
 return (result);
   }

        public void Terminal(String a) throws SQLException, ClassNotFoundException
      {
          if(con == null)
         {
           getConnection();
         }
          PreparedStatement displaytable;
          displaytable = con.prepareStatement("  "+a+" ");
          displaytable.execute();        
      }
        
        
        public int  getTotalRow() throws SQLException, ClassNotFoundException
      {
          
          if(con == null)
        {
           getConnection();
         }
          
          int sayı = 0;
          Statement  getTotalRow = ConnectDB.con.createStatement();
          ResultSet rs =  getTotalRow.executeQuery("select count(*) from sqlite_master where type = 'table'  ");
          
          if(rs.next())
          {
               sayı = rs.getInt(1);
          }
          return sayı;
      }
   /*     
        public void insert(String tablename) throws ClassNotFoundException, SQLException
 {
            if(con == null)
     {
           getConnection();
     }
            int numberofrows = getTotalRow();
            int numberofcolumns = getTotalColumn();
            ArrayList<String> return_types = new ArrayList<>();
            int counter = 0;      
            Statement state = ConnectDB.con.createStatement();

                for(int i=0; i<return_types.size();i++)
        { 
                    ResultSet rs = state.executeQuery("PRAGMA table_info(" + tablename + ")");                   
                    
                    while(rs.next())
           {     
                        return_types.add(rs.getString(2));
                        counter = counter + 1;
           }
        }
                int ctr = 0;
                PreparedStatement insert;
                while(ctr <= counter)
                {
                   return_types.get(ctr);
                   if(return_types.get(ctr) == "int")
                   {
                       PreparedStatement insertInt;
                       insertInt = con.prepareStatement("  "++" ");
                       insertInt.execute();
                   }
                   
                   else if(return_types.get(ctr) == "varchar")
                   {
                       PreparedStatement insertVarchar;
                       insertVarchar = con.prepareStatement("  "+ +" ");
                       insertVarchar.execute();
                   }
                   
                   else if(return_types.get(ctr) == "boolean")
                   {
                       PreparedStatement insertBoolean;
                       insertBoolean = con.prepareStatement("  "++" ");
                       insertBoolean.execute();
                   }
                   
                   else if(return_types.get(ctr) == "real")
                   {
                       PreparedStatement insertReal;
                       insertReal = con.prepareStatement("  "++" ");
                       insertReal.execute();
                   }
                   ctr = ctr + 1;                
                }           
 }
     */    
}
