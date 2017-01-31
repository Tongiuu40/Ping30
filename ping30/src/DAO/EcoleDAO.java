package DAO;

import java.sql.*;
import java.util.*;

import ping30.Cours;
import ping30.Ecole;
import ping30.Enseignant;
import ping30.Etudiant;
import ping30.GroupeEtudiant;
import ping30.PresenceEtudiant;
import ping30.Salle;

public class EcoleDAO extends DAO<Ecole> {
	public Ecole create(Ecole obj) {
		try{			
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT last_insert_id() as id from ecole");
			if(result.first()){
				int id = result.getInt("id");
				id++;
				System.out.println(id);
				System.out.println(result.getInt("id"));
				PreparedStatement prepare = this.connect.prepareStatement(
						"INSERT INTO ecole (idEcole, nomEcole) VALUES(?, ?)");

				prepare.setLong(1, id);
				prepare.setString(2, obj.getNomEcole());
				prepare.executeUpdate();
				
				for(Etudiant etu : obj.getListEtudiant()){
					if(etu.getIdEtudiant() == 0){
						DAO<Etudiant> etudiantDAO = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY).getEtudiantDAO();
						etu = etudiantDAO.create(etu);
					}

					ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
							.executeQuery("SELECT last_insert_id() as id from j_ecole_etudiant"
									);
					if(result2.first()){
						int id2 = result2.getInt("id");
						id++;
						PreparedStatement prepare2 = this.connect.prepareStatement(
								"INSERT INTO j_ecole_etudiant (idj_ecole_etudiant, idEcole, idEtudiant)"+
										" VALUES(?, ?, ?)"
								);
						prepare2.setLong(1, id2);
						prepare2.setLong(2, id);
						prepare2.setLong(3, etu.getIdEtudiant());
						prepare2.executeUpdate();
					}
				}

				for(PresenceEtudiant presEtu : obj.getListPresence()){
					if(presEtu.getIdPresence() == 0){
						DAO<PresenceEtudiant> presenceEtudiantDAO = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY).getPresenceEtudiantDAO();
						presEtu = presenceEtudiantDAO.create(presEtu);
					}

					ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
							.executeQuery("SELECT last_insert_id() as id from j_ecole_presenceEtudiant"
									);
					if(result2.first()){
						int id2 = result2.getInt("id");
						id++;
						PreparedStatement prepare2 = this.connect.prepareStatement(
								"INSERT INTO j_ecole_presenceEtudiant (idj_ecole_etudiant, idEcole, idPresenceEtudiant)"+
										" VALUES(?, ?, ?)"
								);
						prepare2.setLong(1, id2);
						prepare2.setLong(2, id);
						prepare2.setLong(3, presEtu.getIdPresence());
						prepare2.executeUpdate();
					}
				}

				for(Salle sal : obj.getListSalle()){
					if(sal.getIdSalle() == 0){
						DAO<Salle> salleDAO = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY).getSalleDAO();
						sal = salleDAO.create(sal);
					}

					ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
							.executeQuery("SELECT last_insert_id() as id from j_ecole_salle"
									);
					if(result2.first()){
						int id2 = result2.getInt("id");
						id++;
						PreparedStatement prepare2 = this.connect.prepareStatement(
								"INSERT INTO j_ecole_etudiant (idj_ecole_etudiant, idEcole, idSalle)"+
										" VALUES(?, ?, ?)"
								);
						prepare2.setLong(1, id2);
						prepare2.setLong(2, id);
						prepare2.setLong(3, sal.getIdSalle());
						prepare2.executeUpdate();
					}
				}

				for(Enseignant ens : obj.getListEnseignant()){
					if(ens.getIdEnseignant() == 0){
						DAO<Enseignant> enseignantDAO = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY).getEnseignantDAO();
						ens = enseignantDAO.create(ens);
					}

					ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
							.executeQuery("SELECT last_insert_id() as id from j_ecole_enseignant"
									);
					if(result2.first()){
						int id2 = result2.getInt("id");
						id++;
						PreparedStatement prepare2 = this.connect.prepareStatement(
								"INSERT INTO j_ecole_etudiant (idj_ecole_etudiant, idEcole, idEnseignant)"+
										" VALUES(?, ?, ?)"
								);
						prepare2.setLong(1, id2);
						prepare2.setLong(2, id);
						prepare2.setLong(3, ens.getIdEnseignant());
						prepare2.executeUpdate();
					}
				}
				
				for(Cours crs : obj.getListCours()){
					if(crs.getIdCours() == 0){
						DAO<Cours> coursDAO = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY).getCoursDAO();
						crs = coursDAO.create(crs);
					}

					ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
							.executeQuery("SELECT last_insert_id() as id from j_ecole_cours"
									);
					if(result2.first()){
						int id2 = result2.getInt("id");
						id++;
						PreparedStatement prepare2 = this.connect.prepareStatement(
								"INSERT INTO j_ecole_etudiant (idj_ecole_etudiant, idEcole, idcours)"+
										" VALUES(?, ?, ?)"
								);
						prepare2.setLong(1, id2);
						prepare2.setLong(2, id);
						prepare2.setLong(3, crs.getIdCours());
						prepare2.executeUpdate();
					}
				}
				for(GroupeEtudiant grpEtu : obj.getListGroupeEtudiant()){
					if(grpEtu.getIdGroupeEtudiant() == 0){
						DAO<GroupeEtudiant> groupeEtudiantDAO = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY).getGroupeEtudiantDAO();
						grpEtu = groupeEtudiantDAO.create(grpEtu);
					}

					ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
							.executeQuery("SELECT last_insert_id() as id from j_ecole_groupeEtudiant"
									);
					if(result2.first()){
						int id2 = result2.getInt("id");
						id++;
						PreparedStatement prepare2 = this.connect.prepareStatement(
								"INSERT INTO j_ecole_etudiant (idj_ecole_etudiant, idEcole, idGroupeEtudiant)"+
										" VALUES(?, ?, ?)"
								);
						prepare2.setLong(1, id2);
						prepare2.setLong(2, id);
						prepare2.setLong(3, grpEtu.getIdGroupeEtudiant());
						prepare2.executeUpdate();
					}
				}

				obj = this.find(id);	

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;

	}

	public Ecole find(int id) {
		Ecole ecole = new Ecole();  
//		try {
//			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
//					.executeQuery("select * from ecole "+
//											" left join j_soc_dev on jsd_soc_k = soc_id AND soc_id = "+ id +
//											" inner join developpeur on jsd_dev_k = dev_id"
//									);
//
//			if(result.first()){
//				DeveloppeurDAO devDao = new DeveloppeurDAO();
//				ArrayList<Developpeur> listDeveloppeur = new ArrayList<Developpeur>();
//
//				result.beforeFirst();
//				while(result.next() && result.getLong("jsd_dev_k") != 0)
//					listDeveloppeur.add(devDao.find(result.getLong("jsd_dev_k")));
//
//				result.first();
//				ecole = new Ecole(id, result.getString("soc_nom"), listDeveloppeur);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return ecole;

	}
	public Ecole update(Ecole obj) {

		try{

			//On met à jours la liste des développeurs au cas ou
			PreparedStatement prepare = this .connect
					.prepareStatement(
							"UPDATE ecole SET soc_nom = '"+ obj.getNomEcole() +"'"+
									" WHERE soc_id = " + obj.getIdEcole()
							);

			prepare.executeUpdate();

			//Maintenant, nous devons créer les liens vers les développeurs
			//Si le développeur n'existe pas en base, on le créé
//			for(Developpeur dev : obj.getListDeveloppeur()){
//
//				DAO<Developpeur> developpeurDAO = AbstractDAOFactory    .getFactory(FactoryType.DAO_FACTORY)
//						.getDeveloppeurDAO();
//
//
//				//Si l'objet n'existe pas, on le créé avec sa jointure
//				if(dev.getId() == 0){
//
//					dev = developpeurDAO.create(dev);
//
//					//On récupère la prochaine valeur de la séquence
//					ResultSet result2 = this   .connect
//							.createStatement(
//									ResultSet.TYPE_SCROLL_INSENSITIVE, 
//									ResultSet.CONCUR_UPDATABLE
//									).executeQuery(
//											"SELECT NEXTVAL('j_soc_dev_jsd_id_seq') as id"
//											);
//					if(result2.first()){
//
//						long id2 = result2.getLong("id");
//						PreparedStatement prepare2 = this .connect
//								.prepareStatement(
//										"INSERT INTO j_soc_dev (jsd_id, jsd_soc_k, jsd_dev_k)"+
//												"VALUES(?, ?, ?)"
//										);
//						prepare2.setLong(1, id2);
//						prepare2.setLong(2, obj.getId());
//						prepare2.setLong(3, dev.getId());
//						prepare2.executeUpdate();
//					}
//
//				}
//				else{
//					developpeurDAO.update(dev);
//				}
//			}

			obj = this.find(obj.getIdEcole());

		}catch(SQLException e){
			e.printStackTrace();
		}

		return obj;

	}

	public void delete(Ecole obj) {

		try	{

//			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
//			.executeUpdate("DELETE FROM j_soc_dev WHERE jsd_soc_k = " + obj.getIdEcole());
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
			.executeUpdate("DELETE FROM ecole WHERE soc_id = " + obj.getIdEcole());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}




}
