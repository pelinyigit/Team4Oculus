package connectsqlit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSqlit {
	 private static Connection con;
	 private static boolean hasData = false;
	 
	 private void getConnection() throws ClassNotFoundException, SQLException {
		  // sqlite driver
		  Class.forName("org.sqlite.JDBC");
		  // database path, if it's new database, it will be created in the project folder
		  con = DriverManager.getConnection("jdbc:sqlite:Oculus.db");
		  initialise();
	 }
	 

	public void addUser(String firstname, String lastname) throws ClassNotFoundException, SQLException {
		 if(con == null) {
			 // get connection
			 getConnection();
		 }
		  PreparedStatement prep = con
				    .prepareStatement("insert into creators values(?,?,?);");
				  prep.setString(2, firstname);
				  prep.setString(3, lastname);
				  prep.execute();
		 
	 }
	 
	 public ResultSet displayUsers() throws SQLException, ClassNotFoundException {
		 if(con == null) {
			 // get connection
			 getConnection();
		 }
		 Statement state = con.createStatement();
		 ResultSet res = state.executeQuery("select fname, lname from creators");
		 return res;
	 }
	 
	 private void initialise() throws SQLException {
		 if( !hasData ) {
			 hasData = true;
			 // check for database table
			 Statement state = con.createStatement();
			 ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='creators'");
			 if( !res.next()) {
				 System.out.println("Building the User table with prepopulated values.");
				 // need to build the table
				  Statement state2 = con.createStatement();
				  state2.executeUpdate("create table creators(id integer,"
				    + "fName varchar(60)," + "lname varchar(60)," + "primary key (id));");

				  // inserting some sample data
				  PreparedStatement prep = con.prepareStatement("insert into creators values(?,?,?);");
				  prep.setString(2, "Atahan");
				  prep.setString(3, "Ekici");
				  prep.execute();
				  
				  PreparedStatement prep2 = con.prepareStatement("insert into creators values(?,?,?);");
				  prep2.setString(2, "Yamac");
				  prep2.setString(3, "Kayseri");
				  prep2.execute();
                                  
                                  PreparedStatement prep3 = con.prepareStatement("insert into creators values(?,?,?);");
				  prep3.setString(2, "Şükrü");
				  prep3.setString(3, "Kaplan");
				  prep3.execute();
                                  
                                  PreparedStatement prep4 = con.prepareStatement("insert into creators values(?,?,?);");
				  prep4.setString(2, "Beyza");
				  prep4.setString(3, "Korkmaz");
				  prep4.execute();
                                  
                                  PreparedStatement prep5 = con.prepareStatement("insert into creators values(?,?,?);");
				  prep5.setString(2, "Pelin");
				  prep5.setString(3, "Yiğit");
				  prep5.execute();
                                  
                                 
			 }
			 
		 }
	 }
	 
}
