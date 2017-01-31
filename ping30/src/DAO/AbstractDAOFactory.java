package DAO;

public abstract class AbstractDAOFactory {

	public abstract DAO getEcoleDAO();
	public abstract DAO getEtudiantDAO();
	public abstract DAO getSalleDAO();
	public abstract DAO getCoursDAO();
	public abstract DAO getEnseignantDAO();
	public abstract DAO getGroupeEtudiantDAO();
	public abstract DAO getPresenceEtudiantDAO();
	
	/**
	 * Méthode nous permettant de récupérer une factory de DAO
	 * @param type
	 * @return AbstractDAOFactory
	 */
	public static AbstractDAOFactory getFactory(FactoryType type){
		
		if(type.equals(type.DAO_FACTORY)) 
			return new DAOFactory();
		return null;
	}
	
}