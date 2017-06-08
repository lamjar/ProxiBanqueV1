package fr.gtmingenierie.proxybanque.service;

import java.util.ArrayList;
import fr.gtmingenierie.proxybanque.domaine.Gerant;

public class GerantService implements IEmployeService {
	
	// Changer en map pour lier numéro d'ID et Agence
	private ArrayList<Gerant> listeGerant = new ArrayList<Gerant>();
	
	public void ajoutGerant(Gerant gerant) {
		listeGerant.add(gerant);
	}
	
	public Gerant getGerant(int index) {
		return listeGerant.get(index);
	}
}