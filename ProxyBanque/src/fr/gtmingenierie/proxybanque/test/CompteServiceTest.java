/*
 * CompteServiceTest.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.gtmingenierie.proxybanque.domaine.Agence;
import fr.gtmingenierie.proxybanque.domaine.Client;
import fr.gtmingenierie.proxybanque.domaine.Conseiller;
import fr.gtmingenierie.proxybanque.domaine.CompteCourant.TypeCarte;
import fr.gtmingenierie.proxybanque.service.AgenceService;
import fr.gtmingenierie.proxybanque.service.ClientService;
import fr.gtmingenierie.proxybanque.service.CompteService;
import fr.gtmingenierie.proxybanque.service.ConseillerService;

/**
 * 
 * @author Laurent Lamassé
 *
 *         Classe de tests unitaires qui verifie le bon comportement des objets
 *         de type CompteService.
 */
public class CompteServiceTest {
		
	/**
	 * Methode qui teste la methode la creation de compte courant
	 */
	@Test
	public void testCreerCompteCourant()
	{
		Client client = new Client("Parker", "Peter", "Queens 25 rue bidon", "347", "New York", "0102030405");
		assertEquals("testCreerCompteCourant() : Retourne vrai alors que le client ne possede pas", false,
				client.getCompteCourant() != null);
		
		AgenceService as = new AgenceService();
		Agence agence = new Agence("01/01/2017");
		new ConseillerService(as).ajoutConseiller(agence.getID(), new Conseiller("Stark", "Tony", "ironman"));
		
		new ClientService(as).ajoutClient(agence.getID(), 0, client);
//		CompteService cs = new CompteService(as);
//		cs.creerCompteCourant(agence.getID(), agence.getListeConseiller().get(0).getID(), 0, 50000, "01/01/2017");
		
				
	}
}
