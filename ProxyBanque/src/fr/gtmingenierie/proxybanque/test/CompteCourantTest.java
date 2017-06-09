/*
 * CompteCourantTest.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import fr.gtmingenierie.proxybanque.domaine.Carte;
import fr.gtmingenierie.proxybanque.domaine.Compte;
import fr.gtmingenierie.proxybanque.domaine.CompteCourant;
import fr.gtmingenierie.proxybanque.domaine.CompteCourant.TypeCarte;

/**
 * 
 * @author Laurent Lamassé
 *
 *         Classe de tests unitaires qui verifie le bon comportement des objets
 *         de type CompteCourant.
 */
public class CompteCourantTest {

	/**
	 * Methode qui teste la methode d'ajout de carte
	 */
	@Test
	public void testAjouterCarte() {
		CompteCourant CC = new CompteCourant(10000, "15/01/2017");
		assertEquals("testAjouterCarte() : Retourne vrai alors qu'on ajoute une valeur nulle pour la carte", false,
				CC.addCarte(null));
		TypeCarte type = TypeCarte.VisaElectron;
		assertEquals("testAjouterCarte() : Retourne faux alors qu'on ajoute une carte VisaElectron", true,
				CC.addCarte(type));
		assertEquals("testAjouterCarte() : Retourne vrai alors qu'on ajoute une carte VisaPremier", true,
				CC.addCarte(TypeCarte.VisaPremier));
	}

	/**
	 * Methode qui teste la methode de suppression de carte
	 */
	@Test
	public void testSupprimerCarte() {
		CompteCourant CC = new CompteCourant(10000, "15/01/2017");
		Integer[] tabID = new Integer[10];

		try
		{
			for (int i = 0; i < 10; i++)
			{
				if (i % 2 == 0)
					CC.addCarte(TypeCarte.VisaPremier);
				else
					CC.addCarte(TypeCarte.VisaElectron);
				tabID[i] = CC.getCarte(i).getID();
			}
		}
		catch (Exception ex)
		{
			System.err.println("testSupprimerCarte() : Erreur de l'ajout d'une carte : " + ex);
			assert (false);
		}
		

		assertEquals("testSupprimerCarte() : Retourne vrai alors qu'on indique un indice negatif", false,
				CC.deleteCarte(-1));
		assertEquals("testSupprimerCarte() : Retourne faux alors qu'on supprime une carte enregistree pour ce compte", true,
				CC.deleteCarte(5));
		assertEquals("testSupprimerCarte() : Retourne vrai alors qu'on fait un depassement memoire", false,
				CC.deleteCarte(10));
		assertEquals("testSupprimerCarte() : Retourne faux alors qu'on doit avoir la carte d'indice 6 (au debut du test) qui doit etre positionnee a l'indice 5 (suite a la suppression de cette derniere)", true,
				CC.getCarte(5).getID().equals(tabID[6]));
	}
	
	/**
	 * Methode qui teste la methode de recherche de carte
	 */
	@Test
	public void testTrouverCarte() {
		CompteCourant CC = new CompteCourant(10000, "15/01/2017");
		Integer[] tabID = new Integer[10];

		try
		{
			for (int i = 0; i < 10; i++)
			{
				if (i % 2 == 0)
					CC.addCarte(TypeCarte.VisaPremier);
				else
					CC.addCarte(TypeCarte.VisaElectron);
				tabID[i] = CC.getCarte(i).getID();
			}
		}
		catch (Exception ex)
		{
			System.err.println("testTrouverCarte() : Erreur de l'ajout d'une carte : " + ex);
			assert (false);
		}
		

		assertEquals("testTrouverCarte() : Retourne vrai alors qu'on indique une valeur nulle", false,
				CC.findCarte(null) != -1);
		assertEquals("testTrouverCarte() : Retourne vrai alors qu'on indique un identifiant negatif", false,
				CC.findCarte(-1) != -1);
		assertEquals("testTrouverCarte() : Retourne faux alors qu'on indique l'identifiant d'une carte enregistree sur ce compte", true,
				CC.findCarte(tabID[4]) == 4);
		assertEquals("testTrouverCarte() : Retourne faux alors qu'on indique l'identifiant d'une carte enregistree sur ce compte", true,
				CC.findCarte(tabID[9]) == 9);
		assertEquals("testTrouverCarte() : Retourne faux alors qu'on indique l'identifiant d'une carte enregistree sur ce compte", true,
				CC.findCarte(tabID[0]) == 0);
		assertEquals("testTrouverCarte() : Retourne vrai alors qu'on indique un identifiant d'une carte qui n'est pas enregistree sur ce compte", false,
				CC.findCarte(tabID[9]+1) != -1);
		
	}

	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	/**
	 * Methode qui teste la methode de recuperation d'une carte
	 */
	@Test
	public void testGetCarte() {		  
		CompteCourant CC = new CompteCourant(10000, "15/01/2017");
		CC.addCarte(TypeCarte.VisaElectron);
		
		assertEquals("testGetCarte() : Retourne faux alors que la carte existe", true,
				CC.getCarte(0) != null);	
		
		expectedException.expect(IndexOutOfBoundsException.class);
		Carte carte = CC.getCarte(5);
	}

	
}
