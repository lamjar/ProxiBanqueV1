package fr.gtmingenierie.proxybanque.lanceur;

import java.util.Scanner;
import fr.gtmingenierie.proxybanque.domaine.*;
import fr.gtmingenierie.proxybanque.service.*;

public class Lanceur {

	private static Scanner s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Declaration, instanciation
		AgenceService agenceService = new AgenceService();
		GerantService gerantService = new GerantService();
		ClientService clientService = new ClientService();
		CompteService compteService = new CompteService();
		
		// Remplissage des différentes listes
		agenceService.ajoutAgence(new Agence("ABCD1","08/06/2017"));
		agenceService.ajoutAgence(new Agence("ABCD2","08/06/2017"));
		
		gerantService.ajoutGerant(new Gerant("Wayne", "Bruce", "batman"));
		gerantService.ajoutGerant(new Gerant("Stark", "Tony", "ironman"));
		
		// ajouts clients et des conseiller
		
		// Assignation des gérants dans les agences (possibilité de faire une boucle)
		agenceService.assignerGerant(0, gerantService.getGerant(0));
		agenceService.assignerGerant(1, gerantService.getGerant(1));
		
		// Remplissage de la liste des employés de chaque agence
		
		
		
		
		
		
		
		
		
		
		
	}

}
