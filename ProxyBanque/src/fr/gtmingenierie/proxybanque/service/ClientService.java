package fr.gtmingenierie.proxybanque.service;

import fr.gtmingenierie.proxybanque.domaine.Client;

public class ClientService {

	private int attribute;

	public boolean ajoutClient(AgenceService aS, String idAgence, int iConseiller, Client client) {
		if (aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().size() > 9) {
			return false;
		} else {
			aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().add(client);
		}
		return true;
	}

	
	
	public void afficher(AgenceService aS, String idAgence, int iConseiller) {
		System.out.println("==> Affichage de la liste des clients du conseiller "+aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getNom()+" de l'agence "+aS.getAgence(idAgence).getID());
		System.out.println(aS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient());
		System.out.println("");
	}
	
	

}