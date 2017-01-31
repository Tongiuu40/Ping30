package DAO;

import java.sql.*;
import java.util.ArrayList;

import ping30.Cours;
import ping30.Salle;

public class SalleDAO extends DAO<Salle>{
	public Salle create(Salle obj){
		try {
			ResultSet result = this	.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT idSalle as id from salle  order by idSalle Desc");
			if(result.first()){
				int id = result.getInt("id");
				id++;
				PreparedStatement prepare = this.connect.prepareStatement(
						"INSERT INTO Salle (idSalle, nomSalle) VALUES(?, ?)"
						);
				prepare.setInt(1, id);
				prepare.setString(2, obj.getNomSalle());
				prepare.executeUpdate();
				obj = this.find(id);	

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}


	public Salle find(int id) {
		Salle salle = new Salle();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM salle WHERE idSalle = " + id);
			if(result.first())
				salle = new Salle(
						id, 
						result.getString("nomSalle")
						);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salle;

	}
	public Salle findnom(String nom) {
		Salle salle = new Salle();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM salle WHERE nomSalle = '" + nom+"'");
			if(result.first())
				salle = new Salle(
						result.getInt("idSalle"), 
						result.getString("nomSalle")
						);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salle;

	}

	public ArrayList<Salle> getAll(){
		ArrayList<Salle> list = new ArrayList<Salle>();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Salle ");
			if(result!=null){
			while(result.next()){
				
			    
				Salle salle = new Salle(
						
						result.getInt("idSalle"),
						result.getString("nomSalle")
						
						);
				
				list.add(salle);
				}
		
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Salle update(Salle obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
			.executeUpdate("UPDATE salle SET "
					+ "nomSalle = '" + obj.getNomSalle() + "'"
					+ " WHERE idSalle = " + obj.getIdSalle()
					);     
			obj = this.find(obj.getIdSalle());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void delete(Salle obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).
			executeUpdate("DELETE FROM salle WHERE idSalle = " + obj.getIdSalle());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
