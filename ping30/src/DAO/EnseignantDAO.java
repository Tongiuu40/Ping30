package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ping30.Cours;
import ping30.Enseignant;

public class EnseignantDAO extends DAO<Enseignant>{

	public Enseignant create(Enseignant obj){
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT last_insert_id() as id from enseignant");
			if(result.first()){
				int id = result.getInt("id");
				id++;
				PreparedStatement prepare = this.connect.prepareStatement(
						"INSERT INTO Enseignant (idEnseignant, nomEnseignant, prenomEnseignant) VALUES(?, ?, ?)");
				prepare.setInt(1, id);
				prepare.setString(2, obj.getNomEnseignant());
				prepare.setString(3, obj.getPrenomEnseignant());

				prepare.executeUpdate();
				obj = this.find(id);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}


	public Enseignant find(int id) {
		Enseignant enseignant = new Enseignant();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM enseignant WHERE idEnseignant = " + id);
			if(result.first())
				enseignant = new Enseignant(
						id, 
						result.getString("nomEnseignant"),
						result.getString("prenomEnseignant")
						);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enseignant;

	}
	
	public Enseignant findpwd(String pwd, String email) {
		Enseignant enseignant = new Enseignant();
		try {
			
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM enseignant WHERE pwdEnseignant=" + pwd +" AND emailEnseignant="+ email );
			if(result.first())
				enseignant = new Enseignant(
						result.getInt("idEnseignant"), 
						result.getString("nomEnseignant"),
						result.getString("prenomEnseignant")
						);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enseignant;

	}
	public Enseignant findname(String nom, String prenom) {
		Enseignant enseignant = new Enseignant();
		try {
			
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM enseignant WHERE nomEnseignant= '" + nom +"' AND prenomEnseignant= '"+ prenom +"'");
			if(result.first())
				enseignant = new Enseignant(
						result.getInt("idEnseignant"), 
						result.getString("nomEnseignant"),
						result.getString("prenomEnseignant")
						);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enseignant;

	}
	
	public ArrayList<Enseignant> getAll(){
		ArrayList<Enseignant> list= new ArrayList<Enseignant>();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Enseignant ");
			if(result!=null){
			while(result.next()){
				
			    
				Enseignant enseignant = new Enseignant(
						result.getInt("idEnseignant"),
						result.getString("nomEnseignant"),
						result.getString("prenomEnseignant")
						);
				
				list.add(enseignant);
				}
		
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public Enseignant update(Enseignant obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
			.executeUpdate("UPDATE enseignant SET "
					+ "nomEnseignant = '" + obj.getNomEnseignant() + "'"
					+ "prenomEnseignant = " + obj.getPrenomEnseignant() + "'"
					+ " WHERE idEnseignant = " + obj.getIdEnseignant()
					);           

			obj = this.find(obj.getIdEnseignant());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}


	public void delete(Enseignant obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
			.executeUpdate("DELETE FROM enseignant WHERE idEneignant = " + obj.getIdEnseignant());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
