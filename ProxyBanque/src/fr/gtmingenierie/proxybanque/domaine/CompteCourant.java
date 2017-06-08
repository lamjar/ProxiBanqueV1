package fr.gtmingenierie.proxybanque.domaine;
public class CompteCourant extends Compte {

	private double decouvert = 1000;

	public double getDecouvert() {
		return this.decouvert;
	}

	/**
	 * 
	 * @param decouvert
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	/**
	 * 
	 * @param pSolde
	 * @param pDateOuverture
	 */
	public CompteCourant(double pSolde, String pDateOuverture) {
		super(pSolde, pDateOuverture);
		// TODO
	}

	/**
	 * 
	 * @param pSolde
	 * @param pDateOuverture
	 * @param pDecouvert
	 */
	public CompteCourant(double pSolde, String pDateOuverture, double pDecouvert) {
		super(pSolde, pDateOuverture);
		//TODO
	}

}