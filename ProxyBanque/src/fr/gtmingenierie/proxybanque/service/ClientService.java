package fr.gtmingenierie.proxybanque.service;

import fr.gtmingenierie.proxybanque.domaine.Client;

public class ClientService {

	private AgenceService aS;

	public ClientService(AgenceService aS) {
		this.aS = aS;
	}

	public boolean ajoutClient(String idAgence, int iConseiller, Client client) {
		if (aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().size() > 9) {
			return false;
		} else {
			aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().add(client);
		}
		return true;
	}

	public boolean creerClient(String idAgence, int iConseiller, String nom, String prenom, String adresse,
			String codePostal, String ville, String telephone) {
		Client client = new Client(nom, prenom, adresse, codePostal, ville, telephone);
		if (aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().size() > 9) {
			return false;
		} else {
			aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().add(client);
		}
		return true;
	}

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

	public void supprimerClient(String idAgence, int iConseiller, int iClient) {
		// Demander confirmation avant de rentrer dans cette méthodes /!\
		aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().remove(iClient);
	}

	public void afficher(String idAgence, int iConseiller) {
		System.out.println("==> Affichage de la liste des clients du conseiller "
				+ aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getNom() + " de l'agence "
				+ aS.getAgence(idAgence).getID());
		System.out.println(aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient());
		System.out.println("");
	}

}