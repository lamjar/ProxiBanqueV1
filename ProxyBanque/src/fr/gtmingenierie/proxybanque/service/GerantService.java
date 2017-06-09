/*
 * GerantService.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.service;

import java.util.ArrayList;
import fr.gtmingenierie.proxybanque.domaine.Gerant;

public class GerantService implements IEmployeService {
	
	// ==========PROPRIETE==========
	private ArrayList<Gerant> listeGerant;
	
	// ==========CONSTRUCTEUR==========
	public GerantService()
	{
		listeGerant = new ArrayList<Gerant>();
	}
	
	// ==========METHODES==========
	/**
	 * Ajoute un gerant dans la liste des gerants
	 * @param gerant Gerant a ajouter
	 */
	public void ajoutGerant(Gerant gerant) {
		listeGerant.add(gerant);
	}
	
	/**
	 * Recupere un Gerant de la liste
	 * @param index Indice du gerant dans la liste des gerants
	 * @return Retourne le gerant
	 */
	public Gerant getGerant(int index) {
		return listeGerant.get(index);
	}
}