
package oculusfinal;

import java.sql.SQLException;

public class OculusFinal
{

    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        ConnectDB db = new ConnectDB();
        
        db.getConnection();
/*
        db.createtable("cars");
        db.createtable("musics");
        db.createtable("vosvos");
        db.createtable("graphicscards");
        db.renametable("vosvos", "araba");
        db.createtable("god");
        db.addAttributeInt("god", "power");
        
  */      
        db.DisplayAllTables();
     
        System.out.println(db.getTotalRow());    
        System.out.println(db.DisplayAllTablesReturns());
        System.out.println(db.getTotalRow());

/* 
        db.Terminal("");
        db.Terminal("");
        db.Terminal("");
        db.Terminal("");
        db.Terminal("");
        db.Terminal("");
        db.Terminal("");
       */
    } 
}
