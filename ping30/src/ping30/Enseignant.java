package ping30;

public class Enseignant {
	int idEnseignant;
	public String email;
	String nomEnseignant;
	String prenomEnseignant;
	String pwd;
	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + ", nomEnseignant=" + nomEnseignant + ", prenomEnseignant="
				+ prenomEnseignant + "]";
	}
	public int getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	public String getNomEnseignant() {
		return nomEnseignant;
	}
	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}
	public String getPrenomEnseignant() {
		return prenomEnseignant;
	}
	public void setCourriel(String mail){
		this.email=mail;
	}
	public String getPwd(){
		return pwd;
	}
	public String getCourriel(){
		return email;
	}
	public void setPrenomEnseignant(String prenomEnseignant) {
		this.prenomEnseignant = prenomEnseignant;
	}
	public Enseignant(int idEnseignant, String nomEnseignant, String prenomEnseignant) {
		super();
		this.idEnseignant = idEnseignant;
		this.nomEnseignant = nomEnseignant;
		this.prenomEnseignant = prenomEnseignant;
	}
	public Enseignant(String nomEnseignant, String prenomEnseignant,String email,String pwd) {
		super();
		
		this.nomEnseignant = nomEnseignant;
		this.prenomEnseignant = prenomEnseignant;
		this.email=email;
		this.pwd=pwd;
		
	}
	public Enseignant(){}

}
