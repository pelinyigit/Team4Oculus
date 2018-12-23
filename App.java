package softwarepulse.app;

import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) {
		
		ConnectSqlit test = new ConnectSqlit();
		ResultSet rs;
		
		try {
			  rs = test.displayUsers();
			  
			  while (rs.next()) {
				     System.out.println(rs.getString("fname") + " " + rs.getString("lname"));
				  }
			  
		  } catch (ClassNotFoundException | SQLException e) {
		  }

	}

}
