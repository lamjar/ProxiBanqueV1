package fr.gtmingenierie.proxybanque.domaine;

import java.util.ArrayList;

public class Conseiller extends Employe {

	private ArrayList<Client> listeClient;
	
	public Conseiller(String pNom, String pPrenom, String pPassword) {
		super(pNom, pPrenom, pPassword);
		listeClient = new ArrayList<Client>();
	}
	
	public ArrayList<Client> getListeClient() {
		return listeClient;
	}
}