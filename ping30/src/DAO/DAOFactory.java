package DAO;

import ping30.Cours;
import ping30.Ecole;
import ping30.Enseignant;
import ping30.Etudiant;
import ping30.GroupeEtudiant;
import ping30.PresenceEtudiant;
import ping30.Salle;

public class DAOFactory extends AbstractDAOFactory {

	public DAO<Etudiant> getEtudiantDAO(){
		return new EtudiantDAO();
	}
	
	public DAO<Cours> getCoursDAO(){
		return new CoursDAO();
	}
	
	public DAO<Ecole> getEcoleDAO(){
		return new EcoleDAO();
	}
	public DAO<Enseignant> getEnseignantDAO(){
		return new EnseignantDAO();
	}
	public DAO<PresenceEtudiant> getPresenceEtudiantDAO(){
		return new PresenceEtudiantDAO();
	}
	public DAO<Salle> getSalleDAO(){
		return new SalleDAO();
	}

	public DAO<GroupeEtudiant> getGroupeEtudiantDAO() {
		return new GroupeEtudiantDAO();
	}
	
	
}

