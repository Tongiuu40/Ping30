package ping30;

public class GroupeEtudiant {
	int idGroupeEtudiant;
	String nomGroupeEtudiant;
	
	public GroupeEtudiant(){}
	
	public GroupeEtudiant(int idGroupeEtudiant, String nomGroupeEtudiant) {
		super();
		this.idGroupeEtudiant = idGroupeEtudiant;
		this.nomGroupeEtudiant = nomGroupeEtudiant;
	}


	public int getIdGroupeEtudiant() {
		return idGroupeEtudiant;
	}


	public void setIdGroupeEtudiant(int idGroupeEtudiant) {
		this.idGroupeEtudiant = idGroupeEtudiant;
	}


	public String getNomGroupeEtudiant() {
		return nomGroupeEtudiant;
	}


	public void setNomGroupeEtudiant(String nomGroupeEtudiant) {
		this.nomGroupeEtudiant = nomGroupeEtudiant;
	}


	@Override
	public String toString() {
		return "GroupeEtudiantEtudiant [idGroupeEtudiant=" + idGroupeEtudiant + ", nomGroupeEtudiant=" + nomGroupeEtudiant + "]";
	}
	
	
}
