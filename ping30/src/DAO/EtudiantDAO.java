package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ping30.Etudiant;

public class EtudiantDAO extends DAO<Etudiant>{
	public Etudiant create(Etudiant obj){
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT  last_insert_id() as id from etudiant");
			if(result.first()){
				int id = result.getInt("id");
				id++;
				PreparedStatement prepare = this.connect.prepareStatement(
						"INSERT INTO Etudiant (idEtudiant, nomEtudiant, prenomEtudiant, idGroupeEtudiant, INEEtudiant, adressePhoto) VALUES(?, ?, ?, ?, ?, ?)");
				prepare.setInt(1, id);
				prepare.setString(2, obj.getNomEtudiant());
				prepare.setString(3, obj.getPrenomEtudiant());
				prepare.setInt(4, obj.getIdGroupeEtudiant());
				prepare.setInt(5, obj.getINEEtudiant());
				prepare.setString(6, obj.getAdressePhoto());
				prepare.executeUpdate();
				obj = this.find(id);	

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	

	public Etudiant find(int id) {
		Etudiant etudiant = new Etudiant();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery(
							"SELECT * FROM etudiant WHERE idEtudiant = " + id);
			if(result.first())
				etudiant = new Etudiant(
						id, 
						result.getString("nomEtudiant"),
						result.getString("prenomEtudiant"),
						result.getInt("idGroupeEtudiant"),
						result.getInt("INEEtudiant"),
						result.getString("adressePhoto")
						);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return etudiant;

	}


	public Etudiant update(Etudiant obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
			.executeUpdate("UPDATE etudiant SET "
					+ "nomEtudiant = '" + obj.getNomEtudiant() + "'"
					+ "prenomEtudiant = " + obj.getPrenomEtudiant() + "'"
					+ "prenomEtudiant = " + obj.getIdGroupeEtudiant() + "'"
					+ "prenomEtudiant = " + obj.getINEEtudiant() + "'"
					+ "prenomEtudiant = " + obj.getAdressePhoto() + "'"
					+ " WHERE idEtudiant = " + obj.getIdEtudiant()
					);           

			obj = this.find(obj.getIdEtudiant());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public void delete(Etudiant obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
			.executeUpdate("DELETE FROM etudiant WHERE idEtudiant = " + obj.getIdEtudiant());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
