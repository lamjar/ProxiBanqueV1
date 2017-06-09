/*
 * Conseiller.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.domaine;

import java.util.ArrayList;

public class Conseiller extends Employe {

	// ==========PROPRIETE==========
	private ArrayList<Client> listeClient;
	
	// ==========CONSTRUCTEUR==========
	public Conseiller(String pNom, String pPrenom, String pPassword) {
		super(pNom, pPrenom, pPassword);
		listeClient = new ArrayList<Client>();
	}
	
	// ==========GETTER==========
	public ArrayList<Client> getListeClient() {
		return listeClient;
	}
}