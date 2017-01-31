package ping30;
import java.util.*;
public class Ecole {
	int idEcole;
	String nomEcole;
	ArrayList<Etudiant> listEtudiant;
	ArrayList<Salle> listSalle;
	ArrayList<Enseignant> listEnseignant;
	ArrayList<Cours> listCours;
	ArrayList<GroupeEtudiant> listGroupeEtudiant;
	ArrayList<PresenceEtudiant> listPresenceEtudiant;
	
	public Ecole(){}
	
	public Ecole(int idEcole, String nomEcole) {
		super();
		this.idEcole = idEcole;
		this.nomEcole = nomEcole;
		ArrayList<Etudiant> listEtudiant = new ArrayList<Etudiant>();
		ArrayList<Salle> listSalle = new ArrayList<Salle>();
		ArrayList<Enseignant> listEnseignant = new ArrayList<Enseignant>();
		ArrayList<Cours> listCours = new ArrayList<Cours>();
		ArrayList<GroupeEtudiant> listGroupeEtudiant = new ArrayList<GroupeEtudiant>();
		ArrayList<PresenceEtudiant> listPresenceEtudiant = new ArrayList<PresenceEtudiant>();
	}
	
	public Ecole(int idEcole, String nomEcole, ArrayList<Etudiant> listEtudiant, ArrayList<Salle> listSalle,
			ArrayList<Enseignant> listEnseignant, ArrayList<Cours> listCours,
			ArrayList<GroupeEtudiant> listGroupeEtudiant, ArrayList<PresenceEtudiant> listPresence) {
		super();
		this.idEcole = idEcole;
		this.nomEcole = nomEcole;
		this.listEtudiant = listEtudiant;
		this.listSalle = listSalle;
		this.listEnseignant = listEnseignant;
		this.listCours = listCours;
		this.listGroupeEtudiant = listGroupeEtudiant;
		this.listPresenceEtudiant = listPresence;
	}
	@Override
	public String toString() {
		return "Ecole [idEcole=" + idEcole + ", nomEcole=" + nomEcole + ", listEtudiant=" + listEtudiant
				+ ", listSalle=" + listSalle + ", listEnseignant=" + listEnseignant + ", listCours=" + listCours
				+ ", listGroupeEtudiant=" + listGroupeEtudiant + ", listPresence=" + listPresenceEtudiant + "]";
	}
	
	public String toStringEnrichi(){
		String str =	"*******************************\n";
		str += 			"NOM : " + this.getNomEcole() + "\n";
		str +=			"*******************************\n";
		str +=			"LISTE DES ETUDIANTS : \n";
		
		for(Etudiant etu : this.listEtudiant)
			str += etu.toString() + "\n";
		
		str +=			"*******************************\n";
		str +=			"LISTE DES ENSEIGNANTS : \n";
		
		for(Enseignant ens : this.listEnseignant)
			str += ens.toString() + "\n";
		
		str +=			"*******************************\n";
		str +=			"LISTE DES COURS : \n";
		
		for(Cours crs : this.listCours)
			str += crs.toString() + "\n";
		
		str +=			"*******************************\n";
		str +=			"LISTE DES SALLE : \n";
		
		for(Salle sal : this.listSalle)
			str += sal.toString() + "\n";
		
		str +=			"*******************************\n";
		str +=			"LISTE DES GROUPES ETUDIANTS : \n";
		
		for(GroupeEtudiant grpEtu : this.listGroupeEtudiant)
			str += grpEtu.toString() + "\n";
		
		str +=			"*******************************\n";
		str +=			"LISTE DES PRESENCE : \n";
		
		for(PresenceEtudiant prs : this.listPresenceEtudiant)
			str += prs.toString() + "\n";
		
		return str;
	}
	
	public int getIdEcole() {
		return idEcole;
	}
	public void setIdEcole(int idEcole) {
		this.idEcole = idEcole;
	}
	public String getNomEcole() {
		return nomEcole;
	}
	public void setNomEcole(String nomEcole) {
		this.nomEcole = nomEcole;
	}
	public ArrayList<Etudiant> getListEtudiant() {
		return listEtudiant;
	}
	public void setListEtudiant(ArrayList<Etudiant> listEtudiant) {
		this.listEtudiant = listEtudiant;
	}
	public ArrayList<Salle> getListSalle() {
		return listSalle;
	}
	public void setListSalle(ArrayList<Salle> listSalle) {
		this.listSalle = listSalle;
	}
	public ArrayList<Enseignant> getListEnseignant() {
		return listEnseignant;
	}
	public void setListEnseignant(ArrayList<Enseignant> listEnseignant) {
		this.listEnseignant = listEnseignant;
	}
	public ArrayList<Cours> getListCours() {
		return listCours;
	}
	public void setListCours(ArrayList<Cours> listCours) {
		this.listCours = listCours;
	}
	public ArrayList<GroupeEtudiant> getListGroupeEtudiant() {
		return listGroupeEtudiant;
	}
	public void setListGroupeEtudiant(ArrayList<GroupeEtudiant> listGroupeEtudiant) {
		this.listGroupeEtudiant = listGroupeEtudiant;
	}
	public ArrayList<PresenceEtudiant> getListPresence() {
		return listPresenceEtudiant;
	}
	public void setListPresence(ArrayList<PresenceEtudiant> listPresence) {
		this.listPresenceEtudiant = listPresence;
	}
	
	
	
	
	
}
