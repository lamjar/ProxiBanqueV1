/*
 * AgenceService.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import fr.gtmingenierie.proxybanque.domaine.Agence;
import fr.gtmingenierie.proxybanque.domaine.Gerant;

public class AgenceService {

	// ==========PROPRIETE==========
	private HashMap<String, Agence> mapAgence;
	
	// ==========CONSTRUCTEUR==========
	public AgenceService()
	{
		mapAgence = new HashMap<String, Agence>();
	}
	
	// ==========METHODES==========
	/**
	 * Ajoute une agence dans la table de hachage
	 * @param idAgence Identifiant de l'agence
	 * @param agence L'agence a rajouter
	 */
	public void ajoutAgence(String idAgence, Agence agence) {
		mapAgence.put(idAgence, agence);
	}
	
	/**
	 * Assigne un gerant a une agence
	 * @param idAgence Identifiant de l'agence
	 * @param gerant Le gerant qui dirige l'agence
	 */
	public void assignerGerant(String idAgence, Gerant gerant) {
		mapAgence.get(idAgence).setGerant(gerant);
	}
	
	/**
	 * Recuperer une agence a partir de son identifiant
	 * @param idAgence Identifiant de l'agence
	 * @return Retourne l'agence identifiee
	 */
	public Agence getAgence(String idAgence) {
		return mapAgence.get(idAgence);
	}
	
	/**
	 * Affiche la liste des agences de ProxyBanque
	 */
	public void afficher() {
		
		Set<String> keys = mapAgence.keySet();
		Iterator<String> it =  keys.iterator();
		
		System.out.println("==> Affichage de la liste des agences de ProxyBanque :");
		while(it.hasNext())
		{
			String key = it.next();
			System.out.println(mapAgence.get(key));
		}
		System.out.println("");
	}
	
	/**
	 * Permet de verifier si l'identifiant est enregistre dans la table de hachage (qui contient toutes les agences).
	 * @param ID Identifiant de l'agence
	 * @return Retourne true si une agence possede cet identifiant
	 */
	public boolean verifieID(String ID) {
		return mapAgence.containsKey(ID);
	}
}