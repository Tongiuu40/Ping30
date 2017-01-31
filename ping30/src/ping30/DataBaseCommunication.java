package ping30;
/**
 * proto bdd :
 * 
 * cours(idCours, nomCours, idSalle, idEnseignant, dateCours);
 * enseignant(idEnseignant, nomEnseignant, prenomEnseignant);
 * etudiant(idEtudiant, nomEtudiant, prenomEtudiant, idGroupeEtudiant, INEEtudiant, adressePhoto);
 * groupeetudiant(idGroupe, nomGroupe),
 * salle(idSalle, nomSalle);
 * presenceetudiant(idPresence, idEtudiant, idCours, presence);
 */
import java.sql.*;
import java.io.*;


public class DataBaseCommunication {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/ping30";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
      
    public static Connection getInstance() {
    	
        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println( e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                            DB_CONNECTION , DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

 
}



