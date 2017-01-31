package DAO;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import ping30.Cours;
import ping30.PresenceEtudiant;

public class PresenceEtudiantDAO extends DAO<PresenceEtudiant>{
	public PresenceEtudiant create(PresenceEtudiant obj){
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT last_insert_id() as id from presence");
			if(result.first()){
				int id = result.getInt("id");
				id++;
				PreparedStatement prepare = this.connect.prepareStatement(
						"INSERT INTO Presence (idPresence, idEtudiant, idCours, presence) VALUES(?, ?,?, ?)");
				prepare.setInt(1, id);
				prepare.setInt(2, obj.getIdEtudiant());
				prepare.setInt(3, obj.getIdCours());
				prepare.setBoolean(4, obj.getPresence());
				prepare.executeUpdate();
				obj = this.find(id);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	public ArrayList<PresenceEtudiant> findbycours(int idcours){
		ArrayList<PresenceEtudiant> myArrayList = new ArrayList<PresenceEtudiant>();
		try{
			ResultSet result =  this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery(
							"SELECT * FROM presence WHERE idPresence = " + idcours
							);
			if(result!=null){
				while(result.next()){
					
				    
					PresenceEtudiant presence = new PresenceEtudiant(
							result.getInt("idPresence"),
							result.getInt("idEtudiant"),
							result.getInt("idCours"),
							result.getBoolean("presenceEtudiant")
							);
					
					myArrayList.add(presence);
					}
			
				}
		}
		catch(SQLException e){			e.printStackTrace();
}
		
		return myArrayList;
	}

	public PresenceEtudiant find(int id) {
		PresenceEtudiant presence = new PresenceEtudiant();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery(
							"SELECT * FROM presence WHERE idPresence = " + id
							);
			if(result.first())
				presence = new PresenceEtudiant(
						id, 
						result.getInt("idEtudiant"),
						result.getInt("idCours"),
						result.getBoolean("presence")
						);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return presence;

	}


	public PresenceEtudiant update(PresenceEtudiant obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
			.executeUpdate(
					"UPDATE groupePresence SET "
							+ "idPresence = '" + obj.getIdPresence() + "'"
							+ "idEtudiant = '" + obj.getIdEtudiant() + "'"
							+ "idCours = '" + obj.getIdCours() + "'"
							+ "presence = '" + obj.getPresence() + "'"
							+ " WHERE idPresence = " + obj.getIdPresence()
					);           

			obj = this.find(obj.getIdPresence());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}


	public void delete(PresenceEtudiant obj) {
		try {	
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
			.executeUpdate(
					"DELETE FROM presence WHERE idPresence = " + obj.getIdPresence()
					);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
