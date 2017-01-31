package DAO;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ping30.Cours;

public class CoursDAO extends DAO<Cours> {

	public Cours create(Cours obj){
		try {
			ResultSet result = this	.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT idCours as id from cours  order by idCours Desc");
			if(result.first()){
				int id = result.getInt("id");
				PreparedStatement prepare = this.connect.prepareStatement(
						"INSERT INTO Cours (idCours, nomCours, idSalle, idEnseignant, dateCours)"
								+ "VALUES(?, ?, ?, ?, ?)");
				id++;
				prepare.setInt(1, id);
				prepare.setString(2, obj.getNomCours());
				prepare.setInt(3, obj.getIdSalle());
				prepare.setInt(4, obj.getIdEnseignant());
				prepare.setDate(5, obj.getDateCours());

				prepare.executeUpdate();
				obj = this.find(id);
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}


	public Cours find(int id) {
		Cours cours = new Cours();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Cours WHERE idCours = " + id);
			if(result.first())
				cours = new Cours(
						id, 
						result.getString("nomCours"),
						result.getInt("idSalle"),
						result.getInt("idEnseignant"),
						result.getDate("dateCours")
						);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cours;
	}


	public Cours update(Cours obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
					"UPDATE Cours SET "
							+ "nomCours = '" + obj.getNomCours() + "' ,"
							+ "idSalle = " + obj.getIdSalle() + " ,"
							+ "idEnseignant = " + obj.getIdEnseignant() + " ,"
							+ "dateCours = '" + obj.getDateCours() + "' "
							+ " WHERE idCours = " + obj.getIdCours()+";"
					);           

			obj = this.find(obj.getIdCours());
		} catch (SQLException e) {
			e.printStackTrace();
		}	    
		return obj;
	}


	public void delete(Cours obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(
					"DELETE FROM Cours WHERE idCours = " + obj.getIdCours()
					);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cours> findbyenseignan(int id) throws ParseException {
		ArrayList<Cours> listcours = new ArrayList<Cours>();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Cours WHERE idEnseignant = " + id);
			if(result!=null){
			while(result.next()){
				
			    
				Cours cours = new Cours(
						result.getInt("idCours"),
						result.getString("nomCours"),
						result.getInt("idSalle"),
						result.getInt("idEnseignant"),
						result.getDate("dateCours")
						
						);
				
				listcours.add(cours);
				}
		
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listcours;
	}
	public ArrayList<Cours> getAll() throws ParseException {
		ArrayList<Cours> listcours = new ArrayList<Cours>();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Cours ");
			if(result!=null){
			while(result.next()){
				
			    
				Cours cours = new Cours(
						result.getInt("idCours"),
						result.getString("nomCours"),
						result.getInt("idSalle"),
						result.getInt("idEnseignant"),
						result.getDate("dateCours")
						
						);
				
				listcours.add(cours);
				}
		
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listcours;
	}
	
	
}
