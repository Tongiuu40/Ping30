package ping30;

public class PresenceEtudiant {
	int idPresence;
	int idEtudiant;
	int idCours;
	Boolean presence;
	
	public PresenceEtudiant(){}
	
	public PresenceEtudiant(int idPresence, int idEtudiant, int idCours, boolean presence) {
		super();
		this.idPresence = idPresence;
		this.idEtudiant = idEtudiant;
		this.idCours = idCours;
		this.presence = presence;
	}
	@Override
	public String toString() {
		return "Presence [idPresence=" + idPresence + ", idEtudiant=" + idEtudiant + ", idCours=" + idCours
				+ ", presence=" + presence + "]";
	}
	public int getIdPresence() {
		return idPresence;
	}
	public void setIdPresence(int idPresence) {
		this.idPresence = idPresence;
	}
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public int getIdCours() {
		return idCours;
	}
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}
	public boolean getPresence() {
		return presence;
	}
	public void setPresence(boolean presence) {
		this.presence = presence;
	}
	
	
	
}
