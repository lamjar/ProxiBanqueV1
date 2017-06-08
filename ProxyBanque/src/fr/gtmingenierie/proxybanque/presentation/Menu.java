package fr.gtmingenierie.proxybanque.presentation;

import java.util.Scanner;

import fr.gtmingenierie.proxybanque.service.AgenceService;
import fr.gtmingenierie.proxybanque.service.ClientService;
import fr.gtmingenierie.proxybanque.service.ConseillerService;

/**
 * 
 * @author Laurent LAMASSÉ Il s'agit du menu d'affichage.
 *
 */
public class Menu {

	private AgenceService agenceS;
	private ConseillerService conseillerS;
	private ClientService clientS;

	public Menu(AgenceService pAS, ConseillerService pCS, ClientService pClientS) {
		agenceS = pAS;
		conseillerS = pCS;
		clientS = pClientS;
	}

	/**
	 * Affiche le menu de test
	 */
	private void afficherMenu() {
		System.out.println("=======[MENU]======");
		System.out.println("1. Se connecter");
		System.out.println("0. Quitter");
		System.out.println("\nVotre choix : ");
	}

	/**
	 * Pour effectuer la saisie dans la console
	 * 
	 * @param sc
	 * @return
	 */
	private Integer saisirValeurConsole(Scanner sc) {
		String idStr = sc.nextLine();
		Integer idOperation;
		try {
			idOperation = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			System.err.println("Erreur de saisie ! Il faut entrer un entier !");
			return -1;
		}
		return idOperation;
	}

	public void useMenu() {
		// Declaration des variables pour les services
		// TODO
		// Instanciations des services
		// TODO
		Boolean continuer = true;
		System.out.println(" ------------------------------------------------------------------------------------- ");
		System.out.println(" ---------------------------- Bienvenue sur ProxyBanqueSI ---------------------------- ");
		System.out.println(" ------------------------------------------------------------------------------------- \n");

		while (continuer) {
			afficherMenu();
			Scanner sc = new Scanner(System.in);
			// TODO sc.close();
			String reponse = sc.nextLine();

			switch (reponse) {
			case "1":
				sousMenuChoixAgence(sc);
				break;
			case "0":
				System.out.println("Au revoir !!!");
				continuer = false;
				break;
			default:
				System.err.println(
						"Saisie incorrecte\nEntrez une valeur correspondant a l'un des services proposes ci-dessus.\n");
			}
		}
	}

	private void sousMenuChoixAgence(Scanner sc) {
		System.out.println("------Choix de l'agence------");
		agenceS.afficher();
		System.out.println("Entrez l'identifiant de l'agence souhaitée :");
		boolean continuer = true;
		while (continuer) {
			String reponse = sc.nextLine();
			if (agenceS.verifieID(reponse)) {
				sousMenuChoixConseiller(sc, reponse);
				continuer = false;
			} else {
				System.err.println("Saisie incorrecte\nEntrez un des identifiants existants.\n");
			}
		}

	}

	private void sousMenuChoixConseiller(Scanner sc, String idAgence) {
		System.out.println("------Choix du conseiller------");
		conseillerS.afficherNumerote(idAgence);
		System.out.println("Choisissez votre conseiller :");
		boolean continuer = true;
		while (continuer) {
			int reponse = sc.nextInt();
			if (reponse < agenceS.getAgence(idAgence).getListeConseiller().size()) {
				sousMenuActionsClient(sc, idAgence, reponse);
				continuer = false;
			} else {
				System.err.println("Saisie incorrecte\nEntrez une des options proposées.\n");
			}
		}
	}

	private void sousMenuActionsClient(Scanner sc, String idAgence, int iConseiller) {
		System.out.println("------Actions sur un client------");
		boolean continuer = true;
		int reponse;
		while (continuer) {
			System.out.println("1. Créer un nouveau client");
			System.out.println("2. Modifier les informations un client");
			System.out.println("3. Lire les informations d'un client");
			System.out.println("4. Supprimer un client");
			System.out.println("0. retour");
			reponse = sc.nextInt();
			switch (reponse) {
			case 1:
				// clientS.creerClient()
				break;
			case 2:
				// clientS.modifierClient()
				break;
			case 3:
				// clientS.lireClient()
				break;
			case 4:
				// clientS.supprimerClient() avec vérification etc...
				break;
			case 0:
				continuer = false;
				break;
			default:
				System.err.println("Saisie incorrecte\nEntrez une des options proposées.\n");
			}

		}
	}

}
