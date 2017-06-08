package fr.gtmingenierie.proxybanque.service;

import java.util.ArrayList;

import fr.gtmingenierie.proxybanque.domaine.Client;
import fr.gtmingenierie.proxybanque.domaine.Conseiller;

public class ConseillerService implements IEmployeService {
		
	public void ajoutConseiller(AgenceService aS, String idAgence, Conseiller conseiller) {
		aS.getAgence(idAgence).getListeConseiller().add(conseiller);
	}

	public void afficher(AgenceService aS, String idAgence) {
		System.out.println("==> Affichage de la liste des conseiller de l'agence : " + aS.getAgence(idAgence).getID());
		System.out.println(aS.getAgence(idAgence).getListeConseiller());
		System.out.println("");
	}
	
	
	
	
}