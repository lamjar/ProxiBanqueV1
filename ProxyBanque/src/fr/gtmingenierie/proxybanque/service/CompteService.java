/*
 * CompteService.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import fr.gtmingenierie.proxybanque.domaine.CarteVisaElectron;
import fr.gtmingenierie.proxybanque.domaine.Client;
import fr.gtmingenierie.proxybanque.domaine.Compte;
import fr.gtmingenierie.proxybanque.domaine.CompteBourse;
import fr.gtmingenierie.proxybanque.domaine.CompteCourant;
import fr.gtmingenierie.proxybanque.domaine.CompteCourant.TypeCarte;
import fr.gtmingenierie.proxybanque.domaine.CompteEpargne;
import fr.gtmingenierie.proxybanque.domaine.Conseiller;
import fr.gtmingenierie.proxybanque.domaine.Agence;
import fr.gtmingenierie.proxybanque.domaine.Transaction.TypeTransaction;

public class CompteService {

	// ==========PROPRIETE==========
	AgenceService aS;
	CompteBourse paris;
	CompteBourse tokyo;
	CompteBourse newYork;

	// ==========CONSTRUCTEUR==========
	public CompteService(AgenceService pAgenceService, CompteBourse pParis, CompteBourse pTokyo, CompteBourse pNewYork) {
		aS = pAgenceService;
		paris = pParis;
		tokyo = pTokyo;
		newYork = pNewYork;
	}

	// ==========METHODES==========
	/**
	 * Cette methode permet de creer un compte courant et de l'affecter au
	 * client indique en parametre par son identifiant.
	 * 
	 * @param pIdAgence
	 *            Identifiant de l'agence
	 * @param pIDConseiller
	 *            Identifiant du conseiller
	 * @param indexClient
	 *            Indice du client dans la liste des clients du conseiller
	 * @param pSolde
	 *            Montant du solde du client
	 * @param pDateOuverture
	 *            Date d'ouverture du compte
	 * @param plafondDecouvert
	 *            Montant du plafond de decouvert
	 * @return Indique si la creation du compte a ete effectue avec succes
	 */
	public boolean creerCompteCourant(String pIdAgence, Integer pIDConseiller, int indexClient, double pSolde,
			String pDateOuverture, double plafondDecouvert) {
		Client client = findClient(pIdAgence, pIDConseiller, indexClient);
		if (client == null)
			return false;
		client.setCompteCourant(new CompteCourant(pSolde, pDateOuverture, plafondDecouvert));
		return true;
	}

	/**
	 * Cette methode permet de creer un compte courant et de l'affecter au
	 * client indique en parametre par son identifiant. La valeur du montant du
	 * plafond de decouvert sera fixe a 1000 euros.
	 * 
	 * @param pIdAgence
	 *            Identifiant de l'agence
	 * @param pIDConseiller
	 *            Identifiant du conseiller
	 * @param indexClient
	 *            Indice du client dans la liste des clients du conseiller
	 * @param pSolde
	 *            Montant du solde du client
	 * @param pDateOuverture
	 *            Date d'ouverture du compte
	 * @return Indique si la creation du compte a ete effectue avec succes.
	 */
	public boolean creerCompteCourant(String pIdAgence, Integer pIDConseiller, int indexClient, double pSolde,
			String pDateOuverture) {
		return creerCompteCourant(pIdAgence, pIDConseiller, indexClient, pSolde, pDateOuverture, 1000.0);
	}

	/**
	 * Cette methode permet de creer un compte epargne et de l'affecter au
	 * client indique en parametre par son identifiant.
	 * 
	 * @param pIdAgence
	 *            Identifiant de l'agence
	 * @param pIDConseiller
	 *            Identifiant du conseiller
	 * @param indexClient
	 *            Indice du client dans la liste des clients du conseiller
	 * @param pSolde
	 *            Montant du solde du client
	 * @param pDateOuverture
	 *            Date d'ouverture du compte
	 * @param pTauxRemuneration
	 *            Valeur du taux de remuneration en pourcentage (valeur entre
	 *            100 et 0)
	 * @return Indique si la creation du compte a ete effectue avec succes.
	 */
	public boolean creerCompteEpargne(String pIdAgence, Integer pIDConseiller, int indexClient, double pSolde,
			String pDateOuverture, double pTauxRemuneration) {
		Client client = findClient(pIdAgence, pIDConseiller, indexClient);
		if (client == null)
			return false;

		client.setCompteEpargne(new CompteEpargne(pSolde, pDateOuverture, pTauxRemuneration));
		return true;
	}

	/**
	 * Cette methode permet de creer un compte epargne et de l'affecter au
	 * client indique en parametre par son identifiant. La valeur du taux de
	 * remuneration sera fixe a 3%.
	 * 
	 * @param pIdAgence
	 *            Identifiant de l'agence
	 * @param pIDConseiller
	 *            Identifiant du conseiller
	 * @param indexClient
	 *            Indice du client dans la liste des clients du conseiller
	 * @param pSolde
	 *            Montant du solde du client
	 * @param pDateOuverture
	 *            Date d'ouverture du compte
	 * @return Indique si la creation du compte a ete effectue avec succes.
	 */
	public boolean creerCompteEpargne(String pIdAgence, Integer pIDConseiller, int indexClient, double pSolde,
			String pDateOuverture) {
		return creerCompteEpargne(pIdAgence, pIDConseiller, indexClient, pSolde, pDateOuverture, 3.0);
	}
	
	/**
	 * Supprime le compte courant du client identifie par les valeurs des
	 * parametres
	 * 
	 * @param pIdAgence
	 *            Idenfitiant de l'agence
	 * @param pIDConseiller
	 *            Identifiant du conseiller
	 * @param indexClient
	 *            Indice du client dans la liste des clients du conseiller
	 * @return Indique si la suppression du compte a bien ete effectue avec
	 *         succes.
	 */
	public boolean supprimerCompteCourant(String pIdAgence, Integer pIDConseiller, int indexClient) {
		Client client = findClient(pIdAgence, pIDConseiller, indexClient);
		if (client == null)
			return false;
		client.setCompteCourant(null);
		return true;
	}

	/**
	 * Supprime le compte epargne du client identifie par les valeurs des
	 * parametres
	 * 
	 * @param pIdAgence
	 *            Idenfitiant de l'agence
	 * @param pIDConseiller
	 *            Identifiant du conseiller
	 * @param indexClient
	 *            Indice du client dans la liste des clients du conseiller
	 * @return Indique si la suppression du compte a bien ete effectue avec
	 *         succes.
	 */
	public boolean supprimerCompteEpargne(String pIdAgence, Integer pIDConseiller, int indexClient) {
		Client client = findClient(pIdAgence, pIDConseiller, indexClient);
		if (client == null)
			return false;
		client.setCompteEpargne(null);
		return true;
	}

	/**
	 * Creation d'une carte qui sera liee au compte courant du client. Si le
	 * client ou le compte courant n'existe pas, la methode retournera false.
	 * 
	 * @param pIdAgence
	 *            Idenfitiant de l'agence
	 * @param pIDConseiller
	 *            Identifiant du conseiller
	 * @param indexClient
	 *            Indice du client dans la liste des clients du conseiller
	 * @param typeCarte
	 *            Indique le type de la carte que l'on veut creer
	 *            (TypeCarte.VisaElectron ou TypeCarte.VisaPremier)
	 * @return Indique si l'ajout de la carte s'est effectue avec succes. Si le
	 *         client ou le compte courant n'existe pas, la methode retournera
	 *         false.
	 */
	public boolean creerCarte(String pIdAgence, Integer pIDConseiller, int indexClient, TypeCarte typeCarte) {
		Client client = findClient(pIdAgence, pIDConseiller, indexClient);
		if (client == null)
			return false;
		CompteCourant compte = client.getCompteCourant();
		if (compte == null)
			return false;
		return compte.addCarte(typeCarte);
	}

	/**
	 * Creation d'une carte Visa Electron qui sera liee au compte courant du
	 * client. Si le client ou le compte courant n'existe pas, la methode
	 * retournera false.
	 * 
	 * @param pIdAgence
	 *            Idenfitiant de l'agence
	 * @param pIDConseiller
	 *            Identifiant du conseiller
	 * @param indexClient
	 *            Indice du client dans la liste des clients du conseiller
	 * @return Indique si l'ajout de la carte Visa Electron s'est effectue avec
	 *         succes. Si le client ou le compte courant n'existe pas, la
	 *         methode retournera false.
	 */
	public boolean creerCarte(String pIdAgence, Integer pIDConseiller, int indexClient) {
		return creerCarte(pIdAgence, pIDConseiller, indexClient, TypeCarte.VisaElectron);
	}

	/**
	 * Supprime une carte liee au compte courant. Si le client n'existe pas,
	 * que la carte n'existe pas ou que l'identifiant de la carte n'est pas un
	 * identifiant d'une carte liee a ce compte, la methode retourne false.
	 * 
	 * @param pIdAgence Identifiant de l'agence
	 * @param pIDConseiller Identifiant du conseiller
	 * @param indexClient Indice du client dans la liste des clients du conseiller
	 * @param pIDCarte Identifiant de la carte
	 * @return Indique si la suppresion s'est effectuee avec succes.
	 */
	public boolean supprimerCarte(String pIdAgence, Integer pIDConseiller, int indexClient, Integer pIDCarte) {
		Client client = findClient(pIdAgence, pIDConseiller, indexClient);
		if (client == null)
			return false;
		CompteCourant compte = client.getCompteCourant();
		if (compte == null)
			return false;
		Integer indexCarte = compte.findCarte(pIDCarte);
		if (indexCarte == -1)
			return false;
		return compte.deleteCarte(indexCarte);
	}

	/**
	 * Retrouve le client a partir des informations fournis en parametre.
	 * 
	 * @param pIdAgence
	 *            Idenfitiant de l'agence
	 * @param pIDConseiller
	 *            Identifiant du conseiller
	 * @param indexClient
	 *            Indice du client dans la liste des clients du conseiller
	 * @return Retourne le client. Si le client n'existe pas, la methode
	 *         retourne "null".
	 */
	private Client findClient(String pIdAgence, Integer pIDConseiller, int indexClient) {
		ArrayList<Conseiller> listeConseiller = aS.getAgence(pIdAgence).getListeConseiller();

		for (Conseiller conseiller : listeConseiller) {
			if (conseiller.getID().equals(pIDConseiller)) {
				return conseiller.getListeClient().get(indexClient);
			}
		}
		return null;
	}

	/**
	 * Effectue un virement entre le compte debiteur et le compte crediteur. Si
	 * le compte debiteur n'a pas assez d'argent, le virement est annule.
	 * 
	 * @param compteDebiteur
	 *            Compte du client debiteur.
	 * @param compteCrediteur
	 *            Compte du client crediteur.
	 * @param montant
	 *            Montant du versement.
	 * @return Indique si le virement s'est bien effecute.
	 */
	public boolean effectuerVirement(Compte compteDebiteur, Compte compteCrediteur, double montant, String message,
			TypeTransaction type, TransactionService transactionS) {
		double soldeDebiteur = compteDebiteur.getSolde();
		if (soldeDebiteur < montant)
			return false;

		compteDebiteur.setSolde(soldeDebiteur - montant);
		compteCrediteur.setSolde(compteCrediteur.getSolde() + montant);

		transactionS.ajoutTransaction(compteDebiteur, compteCrediteur, montant, message, type);

		return true;
	}

	/**
	 * Indique si le compte a debite plus que le montant indique en parametre.
	 * Si le montant passe en parametre est negatif, la methode retourne false.
	 * 
	 * @param compte
	 *            Compte du client
	 * @param pMontant
	 *            Montant indique pour l'audit
	 * @return Indique si le montant de l'audit est depasse
	 */
	public boolean auditerCompte(Compte compte, double pMontant) {
		if (pMontant < 0)
			return false;

		double diffSolde = compte.getSoldeInitial() - compte.getSolde();
		if (diffSolde > pMontant)
			return true;
		return false;
	}

	public Compte rechercheCompte(String numeroCompte) {
		//System.out.println("numéroCompte (paramètre) :"+numeroCompte);
		Set<String> keys = aS.getMapAgence().keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Agence agence = aS.getMapAgence().get(key);
			//System.out.println(aS.getMapAgence().get(key));
			for (Conseiller conseiller : agence.getListeConseiller()) {
				//System.out.println("	"+conseiller);
				for (Client client : conseiller.getListeClient()) {
					//System.out.println("		"+client);
					if (client.getCompteCourant() != null) {
						//System.out.println(client.getCompteCourant().getNum());
						if (client.getCompteCourant().getNum().equals(numeroCompte)) {
							return client.getCompteCourant();
						}
					}
					if (client.getCompteEpargne() != null) {
						//System.out.println(client.getCompteCourant().getNum());
						if (client.getCompteEpargne().getNum().equals(numeroCompte)) {
							return client.getCompteEpargne();
						}
					}
				}

			}

		}
		System.out.println("Echec de la recherche du compte");
		return null; // TODO Gérer le fait de ne pas trouver de compte

	}

	public Compte rechercheCompteBourse(String numeroCompteBourse) {
		if(numeroCompteBourse.equals(paris.getNum()))
			return paris;
		else if(numeroCompteBourse.equals(tokyo.getNum()))
			return tokyo;
		else if(numeroCompteBourse.equals(newYork.getNum()))
			return newYork;
		else
			return null;
	}

}