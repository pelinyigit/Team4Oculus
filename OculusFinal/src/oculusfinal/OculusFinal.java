
package oculusfinal;

import java.sql.SQLException;

public class OculusFinal
{

    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        ConnectDB db = new ConnectDB();
        
        db.getConnection();
        db.createtable("araba");
        db.createtable("music");
        db.createtable("books");
        db.renametable("araba", "vosvos");
        db.DisplayTables();
        
    }
    
}
