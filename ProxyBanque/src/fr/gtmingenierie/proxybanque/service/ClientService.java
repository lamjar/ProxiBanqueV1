/*
 * ClientService.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.service;

import fr.gtmingenierie.proxybanque.domaine.Client;
import fr.gtmingenierie.proxybanque.domaine.Client.TypeClient;
import fr.gtmingenierie.proxybanque.domaine.Compte;

public class ClientService {

	// ==========PROPRIETE==========
	private AgenceService aS;

	// ==========CONSTRUCTEUR==========
	public ClientService(AgenceService aS) {
		this.aS = aS;
	}

	// ==========METHODES==========
	/**
	 * Ajoute un client à partir des informations fournis en parametre.
	 * 
	 * @param idAgence
	 *            Identifiant de l'agence
	 * @param iConseiller
	 *            Indice du conseiller dans la liste des conseiller de l'agence
	 * @param client
	 *            Le nouveau client
	 * @return Indique si l'ajout s'est realise avec succes. Si le nombre de
	 *         clients affecte au conseiller est superieur a 9, retourne false.
	 */
	public boolean ajoutClient(String idAgence, int iConseiller, Client client) {
		if (aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().size() > 9) {
			return false;
		} else {
			aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().add(client);
		}
		return true;
	}

	public boolean creerClient(String idAgence, int iConseiller, String nom, String prenom, String adresse,
			String codePostal, String ville, String telephone, TypeClient pType) {
		Client client = new Client(nom, prenom, adresse, codePostal, ville, telephone, pType);
		if (aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().size() > 9) {
			return false;
		} else {
			aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().add(client);
		}
		return true;
	}

	/**
	 * Cette methode permet de modifier les informations d'un client
	 * 
	 * @param idAgence
	 *            Identifiant de l'agence
	 * @param iConseiller
	 *            Indice du conseiller dans la liste des conseiller de l'agence
	 * @param iClient
	 *            Indice du client dans la liste des clients du conseiller
	 * @param choix
	 *            Indique sur quelle valeur la modification va etre effectuee.
	 * @param modif
	 *            Nouvelle valeur a affecter dans les informations du client.
	 */
	public void modifierInfo(String idAgence, int iConseiller, int iClient, int choix, String modif) {
		switch (choix) {
		case 1:
			aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient).setNom(modif);
			break;
		case 2:
			aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient).setPrenom(modif);
			break;
		case 3:
			aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient)
					.setAdresse(modif);
			break;
		case 4:
			aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient)
					.setCodePostal(modif);
			break;
		case 5:
			aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient).setVille(modif);
			break;
		case 6:
			aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient)
					.setTelephone(modif);
			break;
		default:
			// TODO - lancer une exception pour prévenir que la modif n'a pas eu
			// lieu ?
		}
	}

	/**
	 * Affiche les informations concernant un client.
	 * 
	 * @param idAgence
	 *            Identifiant de l'agence
	 * @param iConseiller
	 *            Indice du conseiller dans la liste des conseiller de l'agence
	 * @param iClient
	 *            Indice du client dans la liste des clients du conseiller
	 */
	public void detailsClient(String idAgence, int iConseiller, int iClient) {
		System.out.println("==> Informations détaillées du client "
				+ aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient).getNom()
				+ " " + aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient)
						.getPrenom());
		System.out.println("Nom : "
				+ aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient).getNom());
		System.out.println("Prénom : " + aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
				.get(iClient).getPrenom());
		System.out.println("Adresse : " + aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
				.get(iClient).getAdresse());
		System.out.println("Code postal : " + aS.getAgence(idAgence).getListeConseiller().get(iConseiller)
				.getListeClient().get(iClient).getCodePostal());
		System.out.println("Ville : " + aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
				.get(iClient).getVille());
		System.out.println("Telephone : " + aS.getAgence(idAgence).getListeConseiller().get(iConseiller)
				.getListeClient().get(iClient).getTelephone());
		System.out.println("");
	}

	/**
	 * Supprime un client dans la liste des clients du conseiller.
	 * 
	 * @param idAgence
	 *            Identifiant de l'agence
	 * @param iConseiller
	 *            Indice du conseiller dans la liste des conseiller de l'agence
	 * @param iClient
	 *            Indice du client dans la liste des clients du conseiller
	 */
	public void supprimerClient(String idAgence, int iConseiller, int iClient) {
		// Demander confirmation avant de rentrer dans cette méthodes /!\
		aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().remove(iClient);
	}

	/**
	 * Affiche la liste des client d'un conseiller.
	 * 
	 * @param idAgence
	 *            Identifiant de l'agence
	 * @param iConseiller
	 *            Indice du conseiller dans la liste des conseiller de l'agence
	 */
	public void afficher(String idAgence, int iConseiller) {
		System.out.println("==> Affichage de la liste des clients du conseiller "
				+ aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getNom() + " de l'agence "
				+ aS.getAgence(idAgence).getID());
		System.out.println(aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient());
		System.out.println("");
	}

	/**
	 * Permet d'auditer un client. Si le client n'existe pas ou qu'il ne possede
	 * pas de compte courant, la methode retourne false.
	 * 
	 * @param idAgence
	 *            Identifiant de l'agence
	 * @param iConseiller
	 *            Indice du conseiller dans la liste des conseiller de l'agence
	 * @param iClient
	 *            Indice du client dans la liste des clients du conseiller
	 * @return Indique si le client a depasse le montant fixe pour l'audit (5000
	 *         pour un particulier, 50000 pour un professionnel)
	 */
	public boolean auditerClient(String idAgence, int iConseiller, int iClient) {
		Client client;
		try {
			client = aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Le client n'existe pas");
			return false;
		}

		Compte compte = client.getCompteCourant();
		if (compte == null) {
			System.err.println("Le client n'a pas de compte");
			return false;
		}

		if (client.getType() == TypeClient.particulier)
			return new CompteService(aS).auditerCompte(compte, 5000);
		else if (client.getType() == TypeClient.professionnel)
			return new CompteService(aS).auditerCompte(compte, 50000);

		return false;
	}

}