----------------------------------------------------------------------------------------------
				Projet ProxiBanqueSI v1.0
----------------------------------------------------------------------------------------------
Par Laurent LAMASSE et Clément Roux
le 09/06/2017


---------------------
I. Problématique
---------------------

	L'application ProxibanqueSI permet la gestion des agences et des clients de
ProxiBanque "la banque proche de ses clients!". Elle sera utilisée par les gérants des
agences ou par les conseillers.
	
	L'application doit permettre au conseiller clientèle de créer un client, le modifier,
lire ses informations et le supprimer. Le conseil doit pouvoir effectuer des virements de 
compte à compte ainsi que réaliser des simulations de crédits immobiliers ou de consommation.
Les clients (particuliers uniquement) fortunés peuvent bénéficier d'un système de placement en bourse. 

	L'application propose également de faire un audit de chaque clients d'une agence.

	L'application doit disposer d'un système d'authentification pour attribuer des 
droits différents à l'utilisateur, par exemple les gérants peuvent faire la gestion de 
tous les clients de leur agence tandis que les conseillers ne peuvent gérer que leurs propres
clients.


---------------------
II. Fonctionnalités
---------------------

	ProxiBanqueSI v1.0 dispose des fonctionnalités suivantes :

Gestion client :
- création d'un nouveau client
- modification des informations d'un client
- lecture des informations détailées d'un client
- suppression d'un client
- affichage de la liste des clients gérés par un conseiller
- ouverture d'un compte courant ou épargne pour un client
	|-> le numéro de compte est attribué automatiquement en accord avec le format ProxiBanque

Virement de compte à compte :
- sélection du compte débiteur parmi la liste des comptes des clients du conseiller
- sélection du compte à créditer en renseignant le numéro de compte
- vérification de l'existence du compte à créditer (y compris dans les autres agences 
ProxiBanque que celle du client)
- choix du montant et d'un message lié au virement
- confirmation pour éviter les erreurs 
- vérification de la validité du virement par l'application
- une trace du virement comportant le compte débiteur, le compte à créditer, le montant et le message
est gardée dans l'historique de la banque 

Placement en bourse :
- sélection du compte débiteur parmi la liste des comptes des clients du conseiller
- vérification de l'éligibilité du client et du solde de son compte
- choix de la bourse, du montant du placement et d'un message associé au placement
- vérification de la validité du placement par l'application
- une trace du placement comportant le compte débiteur, la bourse, le montant et le message est gardée
dans l'historique de la banque


---------------------
III. Installation
---------------------

	Pour utiliser ProxiBanqueSI v1.0, copiez le projet dans le workspace d'Eclipse.
Ouvrez Eclipse et importez le projet (File -> Import -> Existing projects into workspace).
Lancez l'application depuis le lanceur, tout simplement !

--------------------------------------
IV. Scénario classique d'utilisation
--------------------------------------

	Cette section présente un scénario classique de l'utilisation de ProxiBanqueSI v1.0.
La version 1.0 étant hautement expérimentale, il est fortement conseillé, voire impératif, 
de respecter les instructions de l'application. Un certains nombre de saisies sont controlées 
pour éviter de planter l'application, mais pas toutes. Un plantage brutal et violent à un moment
ou un autre est à prévoir si vous ne respectez pas les instructions.


	Au démarrage de l'application une liste des bourses étrangères, des agences du réseau,
des conseillers de chaque agence ainsi que la liste des clients sont affichées vous aider dans
la navigation.
	
	Le menu principal propose deux options, "quitter" ou "se connecter".
L'option "quitter" termine l'application, l'option "se connecter" permettra par la suite 
l'authentification de l'utilisateur.

	Le menu suivant vous permet de choisir l'agence dans laquelle vous travaillez. Il faut
renseigner l'identifiant de l'agence souhaitée.
	Le menu suivant propose la liste des conseillers de cette agence

	Ces deux menus ne seront plus affichés dès lors que l'authentification sera disponible.

	Vous devez maintenant choisir quel menu utiliser. 
Le premier propose la gestion des clients (création, modification, ouverture de compte,..)
Le deuxième propose de faire un ou plusieurs virements
Le troisième propose de faire un ou plusieurs placements
Le quatrième proposera de faire les audits, il n'est pas disponible

	Pour les menus virements et placements il suffit de se laisser guider en respectant les
instructions à l'écran. 

	Informations utiles : n° compte de Bad Pittr : 3000000003
			      n° compte de Georges Clooney : 3000000004
			      Matt Diamond de l'agence '00001' est éligible aux placements boursiers
	
	Le menu de gestion des clients propose différents sous-menu en fonction de l'action souhaitée


------------------------------------------------------
V. Améliorations prévues ou en cours de dévelopement
------------------------------------------------------

[Manque de temps pour renseigner cette section, veuilez nous excuser]

- Les fonctions de gestion des cartes de crédit, la simulation des crédits ainsi que les fontions
pour réaliser des audits sont partiellement implémentées mais ne sont pas accessibles depuis les
menus de l'application. 
- L'authentification se fera dans un service dédié contenant une map<ID_employe,password> permettant
de déterminer qui utilise l'application et de le rediriger vers les bons menus
- Vérifier les saisies clavier de façon plus systématiques et gérer les soucis du type mismatchInput
- simplifier le code, dans les menus notamment (c'est vraiment le bazar et difficile à lire)