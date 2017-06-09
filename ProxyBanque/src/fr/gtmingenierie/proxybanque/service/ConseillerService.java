/*
 * ConseillerService.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.service;

import java.util.ArrayList;
import fr.gtmingenierie.proxybanque.domaine.Client;
import fr.gtmingenierie.proxybanque.domaine.Conseiller;

public class ConseillerService implements IEmployeService {

	// ==========PROPRIETE==========
	private AgenceService aS;

	// ==========CONSTRUCTEUR==========
	public ConseillerService(AgenceService aS) {
		this.aS = aS;
	}

	// ==========METHODE==========
	/**
	 * Ajoute un conseiller a une agence
	 * 
	 * @param idAgence
	 *            Identifiant de l'agence
	 * @param conseiller
	 *            Le conseiller a rajouter a l'agence
	 */
	public void ajoutConseiller(String idAgence, Conseiller conseiller) {
		aS.getAgence(idAgence).getListeConseiller().add(conseiller);
	}

	/**
	 * Affiche la liste des conseillers pour une agence donnee
	 * 
	 * @param idAgence
	 *            Identifiant de l'agence
	 */
	public void afficher(String idAgence) {
		System.out.println("==> Affichage de la liste des conseiller de l'agence : " + aS.getAgence(idAgence).getID());
		System.out.println(aS.getAgence(idAgence).getListeConseiller());
		System.out.println("");
	}

	/**
	 * Affiche la liste des conseillers d'une agence. Les conseillers sont
	 * numerotes par leur indice.
	 * 
	 * @param idAgence
	 *            Identifiant de l'agence
	 */
	public void afficherNumerote(String idAgence) {
		int i = 0;
		for (Conseiller c : aS.getAgence(idAgence).getListeConseiller()) {
			System.out.println(i + ". " + c.getNom() + " " + c.getPrenom());
			i++;
		}
	}

	/**
	 * Simule un credit a partir du montant souhaite, de la duree du credit et
	 * du taux d'interet
	 * 
	 * @param montant
	 *            Montant souhaite
	 * @param dureeMois
	 *            Nombre de mois
	 * @param tauxDebiteur
	 *            Taux d'interet ayant une valeur entre 0 et 100 (pourcentage)
	 */
	public void simulerCredit(double montant, int dureeMois, double tauxDebiteur) {
		boolean erreur = false;
		if (montant < 0.0) {
			System.err.println("Le montant est negatif");
			erreur = true;
		}
		if (dureeMois < 0) {
			System.err.println("La duree est negative");
			erreur = true;
		}
		if (tauxDebiteur < 0.0 || tauxDebiteur > 100.0) {
			System.err.println("Le taux doit etre situe entre 0 et 100");
			erreur = true;
		}
		if (erreur)
			return;

		System.out.println("Simulation - Credit :");
		System.out.println("Montant souhaite : " + montant + " euros");
		System.out.println("Duree : " + dureeMois + " mois");
		System.out.println("Taux debiteur : " + tauxDebiteur + "%");
		double mensualite = (montant / dureeMois) * (100.0 + tauxDebiteur);
		System.out.println("Mensualite : " + mensualite + " euros");
		System.out.println("Montant total des interets : " + mensualite * dureeMois + " euros\n");
	}
}