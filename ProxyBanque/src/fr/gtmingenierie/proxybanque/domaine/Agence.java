/*
 * Agence.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.domaine;

import java.util.ArrayList;

public class Agence {

	// ==========PROPRIETES==========
	private String ID;
	private String dateCreation;
	private Gerant gerant;
	private ArrayList<Conseiller> listeConseiller;
	private static char[] compteurID = {'0', '0', '0', '0', '0'};

	// ==========CONSTRUCTEUR==========
	public Agence(String pDateCreation) {
		dateCreation = pDateCreation;
		ID = genererID();
		listeConseiller = new ArrayList<Conseiller>();
	}

	// ==========GETTERS & SETTERS==========
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getDateCreation() {
		return this.dateCreation;
	}
	
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
	
	// ==========METHODE==========
	@Override
	public String toString() {
		return "[Identifiant : "+ID+" ; date de creation : "+dateCreation+" ; Nom du gerant : "+gerant.getNom()+"]";
	}
	
	/**
	 * Genere un identifiant alphanumerique de 5 caracteres
	 * @return L'identifiant genere
	 */
	private String genererID()
	{
		String nouveauID = "";
		for(int i=0; i<5 ;i++)
			nouveauID += compteurID[i];
		
		for(int i=4; i>=0 ;i--)
		{
			if(compteurID[i] == 'z')
			{
				compteurID[i] = '0';
				continue;
			}
			
			if(compteurID[i] == '9')
				compteurID[i] = 'A';
			else if(compteurID[i] == 'Z')
				compteurID[i] = 'a';
			else
				compteurID[i]++;
			break;
		}
		
		return nouveauID;
	}

}