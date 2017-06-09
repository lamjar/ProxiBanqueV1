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
		CompteBourse paris = new CompteBourse();
		CompteBourse tokyo = new CompteBourse();
		CompteBourse newYork = new CompteBourse();
		AgenceService agenceService = new AgenceService();
		GerantService gerantService = new GerantService();
		ClientService clientService = new ClientService(agenceService);
		TransactionService transactionService = new TransactionService();
		CompteService compteService = new CompteService(agenceService, paris, tokyo, newYork);
		ConseillerService conseillerService = new ConseillerService(agenceService);
		
		Menu menu = new Menu(agenceService, conseillerService, clientService, compteService, transactionService);
		
		// Remplissage des différentes listes
		agenceService.ajoutAgence("ABCD1", new Agence("08/06/2017"));
		agenceService.ajoutAgence("ABCD2", new Agence("08/06/2017"));
		
		gerantService.ajoutGerant(new Gerant("Wayne", "Bruce", "batman"));
		gerantService.ajoutGerant(new Gerant("Stark", "Tony", "ironman"));
		
		conseillerService.ajoutConseiller("ABCD1", new Conseiller("Hubert", "Paul", "password"));
		conseillerService.ajoutConseiller("ABCD2", new Conseiller("Dupont", "Michel", "password"));
		
		clientService.ajoutClient("ABCD1", 0, new Client("Bad", "Pittr", "Hollywood Boulevard", "38000", "Los Angeles", "04 05 60 78 21"));
		clientService.ajoutClient("ABCD1", 0, new Client("Clooney", "Georges", "Sunset Avenu", "38000", "Los Angeles", "04 05 60 78 21"));
		clientService.ajoutClient("ABCD2", 0, new Client("Diamond", "Matt", "Time Square", "38000", "New York", "04 05 60 78 21"));
		
		System.out.println("Numéros des comptes associés aux bourses étrangères :");
		System.out.println("Paris : "+paris.getNum());
		System.out.println("Tokyo : "+tokyo.getNum());
		System.out.println("New York : "+newYork.getNum());
		
		boolean temp;
		temp = compteService.creerCompteCourant("ABCD1", 2, 0, 10000.0, "09/06/2017");
		temp = compteService.creerCompteCourant("ABCD1", 2, 1, 5000.0, "09/06/2017");
		temp = compteService.creerCompteCourant("ABCD2", 3, 0, 150000.0, "09/06/2017");
		// Assignation des gérants dans les agences (possibilité de faire une boucle)
		agenceService.assignerGerant("ABCD1", gerantService.getGerant(0));
		agenceService.assignerGerant("ABCD2", gerantService.getGerant(1));
		
		// Affichage des listes
		agenceService.afficher();
		conseillerService.afficher("ABCD1");
		clientService.afficher("ABCD1", 0);
		conseillerService.afficher("ABCD2");
		clientService.afficher("ABCD2", 0);
		
		// Menu
		menu.useMenu();
		
		
		
		
		
		
	}

}
