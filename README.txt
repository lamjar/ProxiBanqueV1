----------------------------------------------------------------------------------------------
				Projet ProxiBanqueSI v1.0
----------------------------------------------------------------------------------------------
Par Laurent LAMASSE et Cl�ment Roux
le 09/06/2017


---------------------
I. Probl�matique
---------------------

	L'application ProxibanqueSI permet la gestion des agences et des clients de
ProxiBanque "la banque proche de ses clients!". Elle sera utilis�e par les g�rants des
agences ou par les conseillers.
	
	L'application doit permettre au conseiller client�le de cr�er un client, le modifier,
lire ses informations et le supprimer. Le conseil doit pouvoir effectuer des virements de 
compte � compte ainsi que r�aliser des simulations de cr�dits immobiliers ou de consommation.
Les clients (particuliers uniquement) fortun�s peuvent b�n�ficier d'un syst�me de placement en bourse. 

	L'application propose �galement de faire un audit de chaque clients d'une agence.

	L'application doit disposer d'un syst�me d'authentification pour attribuer des 
droits diff�rents � l'utilisateur, par exemple les g�rants peuvent faire la gestion de 
tous les clients de leur agence tandis que les conseillers ne peuvent g�rer que leurs propres
clients.


---------------------
II. Fonctionnalit�s
---------------------

	ProxiBanqueSI v1.0 dispose des fonctionnalit�s suivantes :

Gestion client :
- cr�ation d'un nouveau client
- modification des informations d'un client
- lecture des informations d�tail�es d'un client
- suppression d'un client
- affichage de la liste des clients g�r�s par un conseiller
- ouverture d'un compte courant ou �pargne pour un client
	|-> le num�ro de compte est attribu� automatiquement en accord avec le format ProxiBanque

Virement de compte � compte :
- s�lection du compte d�biteur parmi la liste des comptes des clients du conseiller
- s�lection du compte � cr�diter en renseignant le num�ro de compte
- v�rification de l'existence du compte � cr�diter (y compris dans les autres agences 
ProxiBanque que celle du client)
- choix du montant et d'un message li� au virement
- confirmation pour �viter les erreurs 
- v�rification de la validit� du virement par l'application
- une trace du virement comportant le compte d�biteur, le compte � cr�diter, le montant et le message
est gard�e dans l'historique de la banque 

Placement en bourse :
- s�lection du compte d�biteur parmi la liste des comptes des clients du conseiller
- v�rification de l'�ligibilit� du client et du solde de son compte
- choix de la bourse, du montant du placement et d'un message associ� au placement
- v�rification de la validit� du placement par l'application
- une trace du placement comportant le compte d�biteur, la bourse, le montant et le message est gard�e
dans l'historique de la banque


---------------------
III. Installation
---------------------

	Pour utiliser ProxiBanqueSI v1.0, copiez le projet dans le workspace d'Eclipse.
Ouvrez Eclipse et importez le projet (File -> Import -> Existing projects into workspace).
Lancez l'application depuis le lanceur, tout simplement !

--------------------------------------
IV. Sc�nario classique d'utilisation
--------------------------------------

	Cette section pr�sente un sc�nario classique de l'utilisation de ProxiBanqueSI v1.0.
La version 1.0 �tant hautement exp�rimentale, il est fortement conseill�, voire imp�ratif, 
de respecter les instructions de l'application. Un certains nombre de saisies sont control�es 
pour �viter de planter l'application, mais pas toutes. Un plantage brutal et violent � un moment
ou un autre est � pr�voir si vous ne respectez pas les instructions.


	Au d�marrage de l'application une liste des bourses �trang�res, des agences du r�seau,
des conseillers de chaque agence ainsi que la liste des clients sont affich�es vous aider dans
la navigation.
	
	Le menu principal propose deux options, "quitter" ou "se connecter".
L'option "quitter" termine l'application, l'option "se connecter" permettra par la suite 
l'authentification de l'utilisateur.

	Le menu suivant vous permet de choisir l'agence dans laquelle vous travaillez. Il faut
renseigner l'identifiant de l'agence souhait�e.
	Le menu suivant propose la liste des conseillers de cette agence

	Ces deux menus ne seront plus affich�s d�s lors que l'authentification sera disponible.

	Vous devez maintenant choisir quel menu utiliser. 
Le premier propose la gestion des clients (cr�ation, modification, ouverture de compte,..)
Le deuxi�me propose de faire un ou plusieurs virements
Le troisi�me propose de faire un ou plusieurs placements
Le quatri�me proposera de faire les audits, il n'est pas disponible

	Pour les menus virements et placements il suffit de se laisser guider en respectant les
instructions � l'�cran. 

	Informations utiles : n� compte de Bad Pittr : 3000000003
			      n� compte de Georges Clooney : 3000000004
			      Matt Diamond de l'agence '00001' est �ligible aux placements boursiers
	
	Le menu de gestion des clients propose diff�rents sous-menu en fonction de l'action souhait�e


------------------------------------------------------
V. Am�liorations pr�vues ou en cours de d�velopement
------------------------------------------------------

[Manque de temps pour renseigner cette section, veuilez nous excuser]

- Les fonctions de gestion des cartes de cr�dit, la simulation des cr�dits ainsi que les fontions
pour r�aliser des audits sont partiellement impl�ment�es mais ne sont pas accessibles depuis les
menus de l'application. 
- L'authentification se fera dans un service d�di� contenant une map<ID_employe,password> permettant
de d�terminer qui utilise l'application et de le rediriger vers les bons menus
- V�rifier les saisies clavier de fa�on plus syst�matiques et g�rer les soucis du type mismatchInput
- simplifier le code, dans les menus notamment (c'est vraiment le bazar et difficile � lire)