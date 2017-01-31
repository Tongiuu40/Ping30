package maquette;

import javax.swing.JFrame;

import ping30.Cours;
import ping30.Enseignant;
import ping30.Etudiant;
import ping30.PresenceEtudiant;
import ping30.Salle;
import DAO.CoursDAO;
import DAO.EnseignantDAO;
import DAO.EtudiantDAO;
import DAO.PresenceEtudiantDAO;
import DAO.SalleDAO;

public class Operations extends JFrame{
	
public Operations(){
	super("Operations");
}

public void ajoutCoursF(){
	CoursDAO coursDAO = new CoursDAO();
	Cours cours = new Cours();
}
public void modifierCoursF(){
	CoursDAO coursDAO = new CoursDAO();
	Cours cours = new Cours();
}
public void supperimerCoursF(){
	CoursDAO coursDAO = new CoursDAO();
	Cours cours = new Cours();
}
public void ajoutSallesF(){
	SalleDAO salleDAO = new SalleDAO();
	Salle salle = new Salle();
}
public void suppermerSallesF(){
	SalleDAO salleDAO = new SalleDAO();
	Salle salle = new Salle();
}
public void modifierSallesF(){
	SalleDAO salleDAO = new SalleDAO();
	Salle salle = new Salle();
}
public void ajoutEtudiantsF(){
	EtudiantDAO etudiantDAO =  new EtudiantDAO();
	Etudiant etudiant = new Etudiant();
}
public void supperimerEtudiantsF(){
	EtudiantDAO etudiantDAO =  new EtudiantDAO();
	Etudiant etudiant = new Etudiant();
}
public void modifierEtudiantsF(){
	EtudiantDAO etudiantDAO =  new EtudiantDAO();
	Etudiant etudiant = new Etudiant();
}
public void ajoutEnseignantsF(){
	EnseignantDAO enseignantDAO = new EnseignantDAO();
	Enseignant enseignant = new Enseignant();
}
public void supperimerEnseignantsF(){
	EnseignantDAO enseignantDAO = new EnseignantDAO();
	Enseignant enseignant = new Enseignant();
}
public void modifierEnseignantsF(){
	EnseignantDAO enseignantDAO = new EnseignantDAO();
	Enseignant enseignant = new Enseignant();
}

public void ajoutListF(){
	PresenceEtudiantDAO presenceEtudiantDAO = new PresenceEtudiantDAO();
	PresenceEtudiant presenceEtudiant = new PresenceEtudiant();
}
public void supperimerListF(){
	PresenceEtudiantDAO presenceEtudiantDAO = new PresenceEtudiantDAO();
	PresenceEtudiant presenceEtudiant = new PresenceEtudiant();
}
public void modifierListF(){
	PresenceEtudiantDAO presenceEtudiantDAO = new PresenceEtudiantDAO();
	PresenceEtudiant presenceEtudiant = new PresenceEtudiant();
}
















}
