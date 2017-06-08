package fr.gtmingenierie.proxybanque.service;

import java.util.ArrayList;
import fr.gtmingenierie.proxybanque.domaine.Agence;
import fr.gtmingenierie.proxybanque.domaine.Gerant;

public class AgenceService {

	private ArrayList<Agence> listeAgence = new ArrayList<Agence>();
	
	public void ajoutAgence(Agence agence) {
		listeAgence.add(agence);
	}
	
	public void assignerGerant(int iAgence, Gerant gerant) {
		listeAgence.get(iAgence).setGerant(gerant);
	}
	
}