package fr.gtmingenierie.proxybanque.domaine;
public class CompteEpargne extends Compte {

	private double tauxRemuneration = 3;

	public double getTauxRemuneration() {
		return this.tauxRemuneration;
	}

	/**
	 * 
	 * @param tauxRemuneration
	 */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	/**
	 * 
	 * @param pSolde
	 * @param pDateOuverture
	 */
	public CompteEpargne(double pSolde, String pDateOuverture) {
		super(pSolde, pDateOuverture);
		//TODO
	}

	/**
	 * 
	 * @param pSolde
	 * @param pDateOuverture
	 * @param pTauxRemuneration
	 */
	public CompteEpargne(double pSolde, String pDateOuverture, double pTauxRemuneration) {
		super(pSolde, pDateOuverture);
		//TODO
	}

}