package fr.gtmingenierie.proxybanque.domaine;
public abstract class Compte {

	private String num;
	private double solde;
	private String dateOuverture;

	/**
	 * 
	 * @param pSolde
	 * @param pDateOuverture
	 */
	public Compte(double pSolde, String pDateOuverture) {
		// TODO - implement Compte.Compte
		throw new UnsupportedOperationException();
	}

	public String getNum() {
		return this.num;
	}

	/**
	 * 
	 * @param num
	 */
	public void setNum(String num) {
		this.num = num;
	}

	public double getSolde() {
		return this.solde;
	}

	/**
	 * 
	 * @param solde
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return this.dateOuverture;
	}

	/**
	 * 
	 * @param dateOuverture
	 */
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

}