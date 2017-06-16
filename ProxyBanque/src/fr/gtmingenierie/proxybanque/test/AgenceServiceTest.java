/*
 * TestAgenceService.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */


package fr.gtmingenierie.proxybanque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.gtmingenierie.proxybanque.domaine.Agence;
import fr.gtmingenierie.proxybanque.domaine.CompteCourant.TypeCarte;
import fr.gtmingenierie.proxybanque.domaine.Gerant;
import fr.gtmingenierie.proxybanque.service.AgenceService;

/**
 * 
 * @author Laurent Lamassé
 *
 *         Classe de tests unitaires qui verifie le bon comportement des objets
 *         de type AgenceService.
 *
 */
public class AgenceServiceTest {

	/**
	 * Methode qui teste la methode d'ajout d'une agence a la table de hachage
	 */
	@Test
	public void testAjoutAgence() {
		AgenceService as = new AgenceService();
		Agence agence = new Agence("11/01/2017");
		
		as.ajoutAgence(agence.getID(), agence);
		assertEquals("testAjoutAgence() : Retourne faux alors qu'on a ajoute une agence", true, as.getAgence(agence.getID()).equals(agence));		
	}
	
	/**
	 * Methode qui teste la methode d'assignement d'un gerant
	 */
	@Test
	public void testAssignerGerant() {
		AgenceService as = new AgenceService();
		Agence agence = new Agence("11/01/2017");
		
		Gerant gerant = new Gerant("Stark", "Tony", "ironman");
		
		as.ajoutAgence(agence.getID(), agence);	
		assertEquals("testAssignerGerant() : Retourne vrai alors que l'agence ne possede aucun gerant", false, as.getAgence(agence.getID()).getGerant() != null);		
		as.assignerGerant(agence.getID(), gerant);		
		assertEquals("testAssignerGerant() : Retourne faux alors qu'on a ajoute un gerant a l'agence", true, as.getAgence(agence.getID()).getGerant().equals(gerant));		
	}
}
