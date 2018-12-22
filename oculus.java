/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oculus;
/**
 *
 * @author team_oculus
 */
public class Oculus 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       DBConnection oculus;
       
       oculus = new DBConnection();       
       oculus.createTable(); //create table function for database embedded server 
       oculus.insertIntoTable(1, "Şükrü");
       oculus.insertIntoTable(2, "Pelin");
       oculus.insertIntoTable(3, "Beyza");
       oculus.insertIntoTable(4, "Yamaç");
       oculus.insertIntoTable(5, "Ata");
       oculus.Display(); // displaying the table's data
       oculus.DBShutdown(); //shutting down the database when it is not needed 
    } 
}
