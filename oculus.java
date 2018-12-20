/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oculus;

/**
 *
 * @author team_4_oculus
 */
public class Oculus 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       DBConnection db = new DBConnection();
       
       db.createTable();
       db.insertIntoTable("Şükrü");
       db.insertIntoTable("Pelin");
       db.insertIntoTable("Beyza");
       db.insertIntoTable("Ata");
       db.insertIntoTable("Yamaç");
       db.Display();
    } 
}

  
