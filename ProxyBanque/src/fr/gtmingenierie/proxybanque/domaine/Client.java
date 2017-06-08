package fr.gtmingenierie.proxybanque.domaine;


public class Client {

	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;

	/**
	 * 
	 * @param pNom
	 * @param pPrenom
	 * @param pAdresse
	 * @param pCodePostal
	 * @param pVille
	 * @param pTelephone
	 */
	public Client(String pNom, String pPrenom, String pAdresse, String pCodePostal, String pVille, String pTelephone) {
		// TODO - implement Client.Client
		nom = pNom;
		prenom = pPrenom;
		adresse = pAdresse;
		codePostal = pCodePostal;
		ville = pVille;
		telephone = pTelephone;
	}

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

	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * 
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	/**
	 * 
	 * @param codePostal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return this.ville;
	}

	/**
	 * 
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "[Nom : \""+nom+"\" ; Prenom : \""+prenom+"\" ; Telephone : "+telephone+"]";
	}

}