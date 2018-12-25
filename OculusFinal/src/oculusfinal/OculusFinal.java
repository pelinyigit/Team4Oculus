
package oculusfinal;

import java.sql.SQLException;

public class OculusFinal
{

    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        ConnectDB db = new ConnectDB();
        
        db.getConnection();
        db.createtable("araba");
        db.addAttributeInt( "araba" , "beygir_gücü" );
        db.addAttributeVarchar("araba", "marka");
        db.addAttributeBoolean("araba","model");
    }
    
}
