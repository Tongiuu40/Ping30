package ping30;

import java.awt.Component;
import java.sql.Date;

public class Cours {
	int idCours;
	String nomCours;
	int idSalle;
	int idEnseignant;
	Date dateCours;
	
	public Cours(){}
	public Cours(int idCours, String nomCours, int idSalle, int idEnseignant) {
		super();
		this.idCours = idCours;
		this.nomCours = nomCours;
		this.idSalle = idSalle;
		this.idEnseignant = idEnseignant;
		this.dateCours = null;
	}
	
	public Cours(int idCours, String nomCours, int idSalle, int idEnseignant, Date dateCours) {
		super();
		this.idCours = idCours;
		this.nomCours = nomCours;
		this.idSalle = idSalle;
		this.idEnseignant = idEnseignant;
		this.dateCours = dateCours;
	}

	@Override
	public String toString() {
		return "Cours [idCours=" + idCours + ", nomCours=" + nomCours + ", idSalle=" + idSalle + ", idEnseignant="
				+ idEnseignant + ", dateCours=" + dateCours + ", getIdCours()=" + getIdCours() + ", getNomCours()="
				+ getNomCours() + ", getIdSalle()=" + getIdSalle() + ", getIdEnseignant()=" + getIdEnseignant()
				+ ", getDateCours()=" + getDateCours() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public int getIdCours() {
		return idCours;
	}
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}
	public String getNomCours() {
		return nomCours;
	}
	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}
	public int getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}
	public int getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	public Date getDateCours() {
		return dateCours;
	}

	public void setDateCours(Date dateCours) {
		this.dateCours = dateCours;
	}

}
