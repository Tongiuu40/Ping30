package DAO;

import java.sql.*;
import java.util.ArrayList;

import ping30.GroupeEtudiant;
import ping30.Salle;

public class GroupeEtudiantDAO extends DAO<GroupeEtudiant>{
	public GroupeEtudiant create(GroupeEtudiant obj){
		try {
			ResultSet result = this	.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT last_insert_id() as id from groupeEtudiant");
			if(result.first()){
				int id = result.getInt("id");
				id++;
				PreparedStatement prepare = this.connect.prepareStatement(
						"INSERT INTO GroupeEtudiant (idGroupeEtudiant, nomGroupeEtudiant) VALUES(?, ?)"
						);
				prepare.setInt(1, id);
				prepare.setString(2, obj.getNomGroupeEtudiant());

				prepare.executeUpdate();
				obj = this.find(id);	

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public ArrayList<GroupeEtudiant> getAll(){
		ArrayList<GroupeEtudiant> list = new ArrayList<GroupeEtudiant>();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM groupeetudiant ");
			if(result!=null){
			while(result.next()){
				
			    
				GroupeEtudiant groupeetudiant = new GroupeEtudiant(
						
						result.getInt("idGroupeEtudiant"),
						result.getString("nomGroupe")
						
						);
				
				list.add(groupeetudiant);
				}
		
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public GroupeEtudiant find(int id) {
		GroupeEtudiant groupeGroupeEtudiant = new GroupeEtudiant();
		try {
			ResultSet result = this .connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM groupeGroupeEtudiant WHERE idGroupeEtudiant = " + id);
			if(result.first())
				groupeGroupeEtudiant = new GroupeEtudiant(
						id, 
						result.getString("nomGroupeEtudiant")
						);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupeGroupeEtudiant;
	}


	public GroupeEtudiant update(GroupeEtudiant obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
			.executeUpdate("UPDATE groupeGroupeEtudiant SET "
					+ "nomGroupeEtudiant = '" + obj.getNomGroupeEtudiant() + "'"
					+ " WHERE idGroupeEtudiant = " + obj.getIdGroupeEtudiant()
					); 
			obj = this.find(obj.getIdGroupeEtudiant());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void delete(GroupeEtudiant obj) {
		try {	
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
			.executeUpdate("DELETE FROM groupeEtudiant WHERE idGroupeEtudiant = " + obj.getIdGroupeEtudiant());				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
