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
		agenceService.ajoutAgence("00000", new Agence("08/06/2017"));
		agenceService.ajoutAgence("00001", new Agence("08/06/2017"));
		
		gerantService.ajoutGerant(new Gerant("Wayne", "Bruce", "batman"));
		gerantService.ajoutGerant(new Gerant("Stark", "Tony", "ironman"));
		
		conseillerService.ajoutConseiller("00000", new Conseiller("Hubert", "Paul", "password"));
		conseillerService.ajoutConseiller("00001", new Conseiller("Dupont", "Michel", "password"));
		
		clientService.ajoutClient("00000", 0, new Client("Bad", "Pittr", "Hollywood Boulevard", "38000", "Los Angeles", "04 05 60 78 21"));
		clientService.ajoutClient("00000", 0, new Client("Clooney", "Georges", "Sunset Avenu", "38000", "Los Angeles", "04 05 60 78 21"));
		clientService.ajoutClient("00001", 0, new Client("Diamond", "Matt", "Time Square", "38000", "New York", "04 05 60 78 21"));
		
		System.out.println("Numéros des comptes associés aux bourses étrangères :");
		System.out.println("Paris : "+paris.getNum());
		System.out.println("Tokyo : "+tokyo.getNum());
		System.out.println("New York : "+newYork.getNum());
		
		boolean temp;
		temp = compteService.creerCompteCourant("00000", 2, 0, 10000.0, "09/06/2017");
		temp = compteService.creerCompteCourant("00000", 2, 1, 5000.0, "09/06/2017");
		temp = compteService.creerCompteCourant("00001", 3, 0, 150000.0, "09/06/2017");
		// Assignation des gérants dans les agences (possibilité de faire une boucle)
		agenceService.assignerGerant("00000", gerantService.getGerant(0));
		agenceService.assignerGerant("00001", gerantService.getGerant(1));
		
		// Affichage des listes
		agenceService.afficher();
		conseillerService.afficher("00000");
		clientService.afficher("00000", 0);
		conseillerService.afficher("00001");
		clientService.afficher("00001", 0);
		
		// Menu
		menu.useMenu();
		
		
		
		
		
		
	}

}
