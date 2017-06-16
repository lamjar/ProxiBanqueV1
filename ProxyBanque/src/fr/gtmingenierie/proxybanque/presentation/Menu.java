/*
 * Menu.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.presentation;

import java.util.Scanner;

import fr.gtmingenierie.proxybanque.domaine.Client.TypeClient;
import fr.gtmingenierie.proxybanque.domaine.Compte;
import fr.gtmingenierie.proxybanque.domaine.CompteCourant;
import fr.gtmingenierie.proxybanque.domaine.CompteEpargne;
import fr.gtmingenierie.proxybanque.domaine.Transaction.TypeTransaction;
import fr.gtmingenierie.proxybanque.service.AgenceService;
import fr.gtmingenierie.proxybanque.service.ClientService;
import fr.gtmingenierie.proxybanque.service.CompteService;
import fr.gtmingenierie.proxybanque.service.ConseillerService;
import fr.gtmingenierie.proxybanque.service.TransactionService;

/**
 * 
 * @author Laurent LAMASSÉ Il s'agit du menu d'affichage.
 *
 */
public class Menu {

	// ==========PROPRIETES==========
	private AgenceService agenceS;
	private ConseillerService conseillerS;
	private ClientService clientS;
	private CompteService compteS;
	private TransactionService transactionS;

	// ==========CONSTRUCTEUR==========
	public Menu(AgenceService pAS, ConseillerService pCS, ClientService pClientS, CompteService pCompteS,
			TransactionService pTransactionS) {
		agenceS = pAS;
		conseillerS = pCS;
		clientS = pClientS;
		compteS = pCompteS;
		transactionS = pTransactionS;
	}

	// ==========METHODES==========
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
	 *            Objet de type Scanner qui sera utilise pour la saisie a partir
	 *            de la console.
	 * @return Un entier qui indiquera le numero de l'operation a lancer
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

	/**
	 * Execute les methodes de la couche Service
	 */
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

		boolean continuer = true;
		while (continuer) {
			System.out.println("------Choix du conseiller------");
			conseillerS.afficherNumerote(idAgence);
			System.out.println("Choisissez votre conseiller :");
			int iConseiller = sc.nextInt();
			int reponse;
			if (iConseiller < agenceS.getAgence(idAgence).getListeConseiller().size()) {
				while(continuer){	
					System.out.println("Choisissez le menu :");
					System.out.println(" 1. Menu client\n 2. Menu virements \n 3. Menu placements \n 4. Menu audit \n 0. Retour");
					do {
						reponse = sc.nextInt();
					} while (reponse < 0 || reponse > 4);
					switch (reponse) {
					case 1:
						sousMenuActionsClient(sc, idAgence, iConseiller);
						break;
					case 2:
						sousMenuVirement(sc, idAgence, iConseiller);
						break;
					case 3:
						sousMenuPlacement(sc, idAgence, iConseiller);
						break;
					case 4:
						// sousMenuAudit
						break;
					case 0:
						continuer = false;
						break;
					default:
						System.err.println("Saisie incorrecte\nEntrez une des options proposées.\n");
					}
				}
			} else {
				System.err.println("Saisie incorrecte\nEntrez une des options proposées.\n");
			}
		}
	}

	private void sousMenuActionsClient(Scanner sc, String idAgence, int iConseiller) {
		System.out.println("------Actions sur un client------");
		boolean continuer = true;
		int reponse;
		int iClient;
		while (continuer) {
			System.out.println("1. Créer un nouveau client");
			System.out.println("2. Modifier les informations un client");
			System.out.println("3. Lire les informations d'un client");
			System.out.println("4. Supprimer un client");
			System.out.println("5. Afficher la liste des clients");
			System.out.println("6. Ouvrir un compte");
			// FERMER UN COMPTE
			// AJOUTER UNE CARTE
			// SUPPRIMER UNE CARTE
			System.out.println("0. retour");
			reponse = sc.nextInt();
			switch (reponse) {
			case 1:
				System.out.println("Entrez le nom :");
				String nom = sc.next();
				System.out.println("Entrez le prenom :");
				String prenom = sc.next();
				System.out.println("Entrez l'adresse :");
				String adresse = sc.nextLine();
				adresse = sc.nextLine();
				System.out.println("Entrez le code postal :");
				String codePostal = sc.next();
				System.out.println("Entrez la ville :");
				String ville = sc.nextLine();
				ville = sc.nextLine();
				System.out.println("Entre le téléphone :");
				String telephone = sc.nextLine();
				System.out.println("Le client est un particulier : (O/N)");
				char type;
				do {
					type = sc.next().charAt(0);
				} while (type != 'O' && type != 'N');
				TypeClient tClient;
				if (type == 'O')
					tClient = TypeClient.particulier;
				else
					tClient = TypeClient.professionnel;

				clientS.creerClient(idAgence, iConseiller, nom, prenom, adresse, codePostal, ville, telephone, tClient);
				break;
			case 2:
				System.out.println("Choisissez le client à modifier :");
				clientS.afficherNumerote(idAgence, iConseiller);
				iClient = sc.nextInt();
				System.out.println("Choisissez le champ à modifier :");
				System.out.println(" 1. nom \n 2. prenom \n 3. adresse \n 4. code postal \n 5. ville \n 6. telephone");
				reponse = sc.nextInt();
				System.out.println("Entrez la nouvelle information :");
				String modif = sc.nextLine();
				modif = sc.nextLine();
				clientS.modifierInfo(idAgence, iConseiller, iClient, reponse, modif);
				break;
			case 3:
				System.out.println("Choisissez le client dont vous voulez les informations détaillées :");
				clientS.afficherNumerote(idAgence, iConseiller);
				iClient = sc.nextInt();
				clientS.detailsClient(idAgence, iConseiller, iClient);
				break;
			case 4:
				System.out.println("Choisissez le client à supprimer :");
				clientS.afficherNumerote(idAgence, iConseiller);
				iClient = sc.nextInt();
				System.out.println("Vous êtes sur le point de supprimer le compte de "
						+ agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
								.get(iClient).getNom()
						+ " " + agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
								.get(iClient).getPrenom());
				System.out.println("Êtes vous certains ? (O/N)");
				char validation;
				do {
					validation = sc.next().charAt(0);
				} while (validation != 'O' && validation != 'N');
				if (validation == 'O')
					clientS.supprimerClient(idAgence, iConseiller, iClient);
				break;
			case 5:
				clientS.afficher(idAgence, iConseiller);
				break;
			case 6:
				// TODO
				boolean confirmationCreationCompte;
				System.out.println("Choisissez le client pour lequel vous voulez ouvrir un compte :");
				clientS.afficherNumerote(idAgence, iConseiller);
				iClient = sc.nextInt();
				int idConseiller = agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getID();
				System.out.println("Entrez le type de compte souhaité :");
				System.out.println("1. Compte courant");
				System.out.println("2. Compte épargne");
				int choixTypeCompte = sc.nextInt();
				if(choixTypeCompte==1){
					System.out.println("Entrez la date de création (JJ/MM/AAAA) :");
					String dateCreation = sc.next();
					System.out.println("Entrez le solde du compte :");
					double soldeCompte = sc.nextDouble();
					confirmationCreationCompte = compteS.creerCompteCourant(idAgence, idConseiller, iClient, soldeCompte, dateCreation);
					if (confirmationCreationCompte == true)
						System.out.println("Création du compte réussie");
					else
						System.out.println("Impossible de créer le compte");
				}
				if(choixTypeCompte==2){
					System.out.println("Entrez la date de création (JJ/MM/AAAA) :");
					String dateCreation = sc.next();
					System.out.println("Entrez le solde du compte :");
					double soldeCompte = sc.nextDouble();
					confirmationCreationCompte = compteS.creerCompteEpargne(idAgence, idConseiller, iClient, soldeCompte, dateCreation);
					if (confirmationCreationCompte == true)
						System.out.println("Création du compte réussie");
					else
						System.out.println("Impossible de créer le compte");
				}	
				break;
			case 0:
				continuer = false;
				break;
			default:
				System.err.println("Saisie incorrecte\nEntrez une des options proposées.\n");
			}

		}
	}

	private void sousMenuVirement(Scanner sc, String idAgence, int iConseiller) {
		System.out.println("------Menu des virements bancaires------");
		boolean continuer = true;
		int choixCompteDebiteur;
		String numeroCompte = "";
		int iClient;
		int validationCompteDebiteur = 0;
		double montant;
		String message;
		String numCompteDebiteur = "";
		Compte compteDebiteur = null;
		Compte compteACrediter;
		while (continuer) {
			System.out.println("Choisissez le client débiteur :");
			clientS.afficherNumerote(idAgence, iConseiller);
			iClient = sc.nextInt();
			System.out.println("Choisissez le compte à débiter :");
			if (agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient)
					.getCompteCourant() != null) {
				System.out.println("1. " + agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller)
						.getListeClient().get(iClient).getCompteCourant());
				validationCompteDebiteur++;
			}
			if (agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient)
					.getCompteEpargne() != null) {
				System.out.println("2. " + agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller)
						.getListeClient().get(iClient).getCompteEpargne());
				validationCompteDebiteur++;
			}
			if (validationCompteDebiteur == 0) {
				System.out.println("Virement impossible, le client ne possède pas de compte");
				break;
			}
			choixCompteDebiteur = sc.nextInt();
			if (choixCompteDebiteur == 1) {
				numCompteDebiteur = agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
						.get(iClient).getCompteCourant().getNum();
				compteDebiteur = agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
						.get(iClient).getCompteCourant();
			} else if (choixCompteDebiteur == 2) {
				numCompteDebiteur = agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
						.get(iClient).getCompteEpargne().getNum();
				compteDebiteur = agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
						.get(iClient).getCompteEpargne();
			}
			do {
				System.out.println("Entrez le numéro du compte à créditer :");
				numeroCompte = String.valueOf(sc.next());
			} while (numeroCompte.length() != 10);
			compteACrediter = compteS.rechercheCompte(numeroCompte);
			System.out.println("Entrez le montant du virement :");
			montant = sc.nextDouble();
			System.out.println("Entrez le message accompagnant le virement :");
			message = sc.nextLine();
			message = sc.nextLine();
			System.out.println("Récapitulatif du virement :");
			System.out.println("Compte à débiter :" + numCompteDebiteur);
			System.out.println("Compte à créditer :" + compteS.rechercheCompte(numeroCompte).getNum());
			System.out.println("Montant du virement :" + montant);
			System.out.println("Message associé : " + message);
			char validation;
			System.out.println("Êtes vous certains ? (O/N)");
			do {
				validation = sc.next().charAt(0);
			} while (validation != 'O' && validation != 'N');
			if (validation == 'O')
				compteS.effectuerVirement(compteDebiteur, compteACrediter, montant, message, TypeTransaction.virement,
						transactionS);
			System.out.println("");
			System.out.println("Voulez vous faire un autre virement ? (O/N)");
			do {
				validation = sc.next().charAt(0);
			} while (validation != 'O' && validation != 'N');
			if (validation == 'N')
				continuer = false;
			System.out.println("");
		}

	}

	private void sousMenuPlacement(Scanner sc, String idAgence, int iConseiller) {
		System.out.println("------Menu des placements boursiers------");
		boolean continuer = true;
		int choixCompteDebiteur;
		String numeroCompteBourse = "";
		int iClient;
		int validationCompteDebiteur = 0;
		double montant;
		String message = "";
		String numCompteDebiteur = "";
		Compte compteDebiteur = null;
		Compte compteBourse;
		while (continuer) {
			System.out.println("Choisissez le client débiteur :");
			clientS.afficherNumerote(idAgence, iConseiller);
			iClient = sc.nextInt();
			if (agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient)
					.getType() != TypeClient.particulier) {
				System.out.println("Le client n'est pas elligible aux placements boursiers");
				break;
			}
			System.out.println("Choisissez le compte à débiter :");
			if (agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient)
					.getCompteCourant() != null) {
				System.out.println("1. " + agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller)
						.getListeClient().get(iClient).getCompteCourant());
				validationCompteDebiteur++;
			}
			if (agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient().get(iClient)
					.getCompteEpargne() != null) {
				System.out.println("2. " + agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller)
						.getListeClient().get(iClient).getCompteEpargne());
				validationCompteDebiteur++;
			}
			if (validationCompteDebiteur == 0) {
				System.out.println("Virement impossible, le client ne possède pas de compte");
				break;
			}
			choixCompteDebiteur = sc.nextInt();
			if (choixCompteDebiteur == 1) {
				numCompteDebiteur = agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
						.get(iClient).getCompteCourant().getNum();
				compteDebiteur = agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
						.get(iClient).getCompteCourant();
			} else if (choixCompteDebiteur == 2) {
				numCompteDebiteur = agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
						.get(iClient).getCompteEpargne().getNum();
				compteDebiteur = agenceS.getAgence(idAgence).getListeConseiller().get(iConseiller).getListeClient()
						.get(iClient).getCompteEpargne();
			}
			if (compteDebiteur.getSolde() < 50000.0) {
				System.out.println("Le compte du client ne dispose pas du solde suffisant pour effectuer un placement");
				break;
			}
			do {
				System.out.println("Entrez le numéro du compte boursier :");
				numeroCompteBourse = String.valueOf(sc.next());
			} while (numeroCompteBourse.length() != 10);
			compteBourse = compteS.rechercheCompteBourse(numeroCompteBourse);
			System.out.println("Entrez le montant du placement :");
			montant = sc.nextDouble();
			System.out.println("Entrez le message accompagnant le placement :");
			message = sc.nextLine();
			message = sc.nextLine();
			System.out.println("Récapitulatif du placement :");
			System.out.println("Compte à débiter :" + numCompteDebiteur);
			System.out.println("Bourse :" + compteBourse.getNum());
			System.out.println("Montant du placement :" + montant);
			System.out.println("Message associé : " + message);
			char validation;
			System.out.println("Êtes vous certains ? (O/N)");
			do {
				validation = sc.next().charAt(0);
			} while (validation != 'O' && validation != 'N');
			if (validation == 'O')
				compteS.effectuerVirement(compteDebiteur, compteBourse, montant, message, TypeTransaction.placement,
						transactionS);
			System.out.println("");
			System.out.println("Voulez vous faire un autre placement ? (O/N)");
			do {
				validation = sc.next().charAt(0);
			} while (validation != 'O' && validation != 'N');
			if (validation == 'N')
				continuer = false;
			System.out.println("");
		}

	}

}
