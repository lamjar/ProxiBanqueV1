package fr.gtmingenierie.proxybanque.domaine;

import java.util.ArrayList;

public class Agence {

	private String ID;
	private String dateCreation;
	private Gerant gerant;
	private ArrayList<Conseiller> listeConseiller;

	/**
	 * 
	 * @param pDateCreation
	 */
	public Agence(String pID, String pDateCreation) {
		// TODO - implement Agence.Agence
		dateCreation = pDateCreation;
		ID = pID;
		listeConseiller = new ArrayList<Conseiller>();
	}

	public String getID() {
		return ID;
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}

	public String getDateCreation() {
		return this.dateCreation;
	}

	/**
	 * 
	 * @param dateCreation
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
	
	public ArrayList<Conseiller> getListeConseiller() {
		return listeConseiller;
	}
	
	@Override
	public String toString() {
		return "[Identifiant : "+ID+" ; date de creation : "+dateCreation+" ; Nom du gerant : "+gerant.getNom()+"]";
	}

}