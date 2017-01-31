package ping30;

public class Etudiant {
	
	int idEtudiant;
	String nomEtudiant;
	String prenomEtudiant;
	int idGroupeEtudiant;
	int INEEtudiant;
	String adressePhoto;
	
	public Etudiant(){}
	
	public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, int idGroupeEtudiant, int iNEEtudiant,
			String adressePhoto) {
		super();
		this.idEtudiant = idEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.idGroupeEtudiant = idGroupeEtudiant;
		INEEtudiant = iNEEtudiant;
		this.adressePhoto = adressePhoto;
	}
	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nomEtudiant=" + nomEtudiant + ", prenomEtudiant="
				+ prenomEtudiant + ", idGroupeEtudiant=" + idGroupeEtudiant + ", INEEtudiant=" + INEEtudiant
				+ ", adressePhoto=" + adressePhoto + "]";
	}
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getNomEtudiant() {
		return nomEtudiant;
	}
	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}
	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}
	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}
	public int getIdGroupeEtudiant() {
		return idGroupeEtudiant;
	}
	public void setIdGroupeEtudiant(int idGroupeEtudiant) {
		this.idGroupeEtudiant = idGroupeEtudiant;
	}
	public int getINEEtudiant() {
		return INEEtudiant;
	}
	public void setINEEtudiant(int iNEEtudiant) {
		INEEtudiant = iNEEtudiant;
	}
	public String getAdressePhoto() {
		return adressePhoto;
	}
	public void setAdressePhoto(String adressePhoto) {
		this.adressePhoto = adressePhoto;
	}
	
	

}
