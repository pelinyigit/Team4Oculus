
package oculusfinal;

import java.sql.SQLException;

public class OculusFinal
{

    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        ConnectDB db = new ConnectDB();
        
        db.getConnection();
/*
        db.createtable("rap");
        db.createtable("Vosvos");
        db.createtable("Graphicscards");
        db.createtable("Books");
        
        db.renametable("vosvos", "Cars");
        db.renametable("rap", "Musics");
*/   
        db.DisplayAllTables();
        
        System.out.println(db.DisplayAllTablesReturns());
        System.out.println(db.getTotalColumn());
        System.out.println(db.getTotalRow()); 
        
 /*       
        db.addAttributeInt("Cars", "hp");
        db.insertInt("Cars", "hp", 100);
 */        
        
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
