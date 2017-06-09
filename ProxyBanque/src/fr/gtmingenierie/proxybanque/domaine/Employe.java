/*
 * Employe.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.domaine;

public abstract class Employe {

	// ==========PROPRIETES==========
	private static int compteurEmploye = 0;
	private String nom;
	private String prenom;
	private Integer ID;
	private String password;

	// ==========CONSTRUCTEUR==========
	public Employe(String pNom, String pPrenom, String pPassword) {
		// TODO - implement Employe.Employe
		nom = pNom;
		prenom = pPrenom;
		password = pPassword;
		ID = compteurEmploye;
		compteurEmploye++;
	}

	// ==========GETTERS & SETTERS==========
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

	public Integer getID() {
		return ID;
	}

	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	// ==========METHODE==========
	@Override
	public String toString() {
		return "[Nom : \"" + nom + "\" ; Prenom : \"" + prenom + "\" ; ID : " + ID + "]";
	}

}