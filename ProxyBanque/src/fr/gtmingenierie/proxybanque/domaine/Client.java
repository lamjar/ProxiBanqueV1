/*
 * Client.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.domaine;


public class Client {

	public enum TypeClient{
		particulier,
		professionnel
	}
	
	//==========PROPRIETES==========
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private TypeClient type;

	//==========CONSTRUCTEUR==========
	public Client(String pNom, String pPrenom, String pAdresse, String pCodePostal, String pVille, String pTelephone) {
		this(pNom, pPrenom, pAdresse, pCodePostal, pVille, pTelephone, TypeClient.particulier);
	}
	
	public Client(String pNom, String pPrenom, String pAdresse, String pCodePostal, String pVille, String pTelephone, TypeClient pType) {
		nom = pNom;
		prenom = pPrenom;
		adresse = pAdresse;
		codePostal = pCodePostal;
		ville = pVille;
		telephone = pTelephone;
		type = pType;
		compteCourant = null;
		compteEpargne = null;
	}

	//==========GETTERS & SETTERS==========
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return this.adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return this.codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return this.ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return this.telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}
	
	public TypeClient getType() {
		return type;
	}

	public void setType(TypeClient type) {
		this.type = type;
	}

	//==========METHODE==========
	@Override
	public String toString() {
		return "[Nom : \""+nom+"\" ; Prenom : \""+prenom+"\" ; Telephone : "+telephone+"]\n";
	}

}