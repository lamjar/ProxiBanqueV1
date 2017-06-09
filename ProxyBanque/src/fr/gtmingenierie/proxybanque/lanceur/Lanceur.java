/*
 * Lanceur.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.lanceur;

import java.util.Scanner;
import fr.gtmingenierie.proxybanque.domaine.*;
import fr.gtmingenierie.proxybanque.domaine.Client.TypeClient;
import fr.gtmingenierie.proxybanque.presentation.Menu;
import fr.gtmingenierie.proxybanque.service.*;

public class Lanceur {

	private static Scanner s;
	
	/**
	 * Fonction principale qui lance l'application
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Declaration, instanciation
		AgenceService agenceService = new AgenceService();
		GerantService gerantService = new GerantService();
		ClientService clientService = new ClientService(agenceService);
		CompteService compteService = new CompteService(agenceService);
		ConseillerService conseillerService = new ConseillerService(agenceService);
		
		Menu menu = new Menu(agenceService, conseillerService, clientService);
		
		// Remplissage des différentes listes
		agenceService.ajoutAgence("ABCD1", new Agence("08/06/2017"));
		agenceService.ajoutAgence("ABCD2", new Agence("08/06/2017"));
		
		gerantService.ajoutGerant(new Gerant("Wayne", "Bruce", "batman"));
		gerantService.ajoutGerant(new Gerant("Stark", "Tony", "ironman"));
		
		conseillerService.ajoutConseiller("ABCD1", new Conseiller("Hubert", "Paul", "password"));
		conseillerService.ajoutConseiller("ABCD2", new Conseiller("Dupont", "Michel", "password"));
		
		clientService.ajoutClient("ABCD1", 0, new Client("Nom", "Prenom", "Adresse du client", "38000", "Grenoble", "04 05 60 78 21"));
		clientService.ajoutClient("ABCD2", 0, new Client("Nom", "Prenom", "Adresse du client", "38000", "Grenoble", "04 05 60 78 21"));
		
		// Assignation des gérants dans les agences (possibilité de faire une boucle)
		agenceService.assignerGerant("ABCD1", gerantService.getGerant(0));
		agenceService.assignerGerant("ABCD2", gerantService.getGerant(1));
		
		// Affichage des listes
		agenceService.afficher();
		conseillerService.afficher("ABCD1");
		clientService.afficher("ABCD1", 0);
		
		// Menu
		menu.useMenu();
		
		
		
		
		
		
	}

}
