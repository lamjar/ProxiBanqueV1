package fr.gtmingenierie.proxybanque.domaine;

public abstract class Employe {

	private static int compteurEmploye = 0;
	private String nom;
	private String prenom;
	private Integer ID;
	private String password;

	public String getNom() {
		return this.nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getID() {
		// TODO - implement Employe.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(Integer ID) {
		// TODO - implement Employe.setID
		throw new UnsupportedOperationException();
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @param pNom
	 * @param pPrenom
	 * @param pPassword
	 */
	public Employe(String pNom, String pPrenom, String pPassword) {
		// TODO - implement Employe.Employe
		nom = pNom;
		prenom = pPrenom;
		password = pPassword;
		ID = compteurEmploye;
		compteurEmploye++;
	}

}