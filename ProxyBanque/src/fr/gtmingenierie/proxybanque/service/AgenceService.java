package fr.gtmingenierie.proxybanque.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import fr.gtmingenierie.proxybanque.domaine.Agence;
import fr.gtmingenierie.proxybanque.domaine.Gerant;

public class AgenceService {

	private HashMap<String, Agence> mapAgence;
	
	public AgenceService()
	{
		mapAgence = new HashMap<String, Agence>();
	}
	
	public void ajoutAgence(String idAgence, Agence agence) {
		mapAgence.put(idAgence, agence);
	}
	
	public void assignerGerant(String idAgence, Gerant gerant) {
		mapAgence.get(idAgence).setGerant(gerant);
	}
	
	public Agence getAgence(String idAgence) {
		return mapAgence.get(idAgence);
	}
	
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
}