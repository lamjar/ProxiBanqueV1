/*
 * CompteEpargne.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.domaine;

public class CompteEpargne extends Compte {

	//==========PROPRIETE==========
	private double tauxRemuneration;

	
	//==========CONSTRUCTEURS==========
	public CompteEpargne(double pSolde, String pDateOuverture) {
		super(pSolde, pDateOuverture);
		tauxRemuneration = 3.00;
	}

	public CompteEpargne(double pSolde, String pDateOuverture, double pTauxRemuneration) {
		super(pSolde, pDateOuverture);
		tauxRemuneration = tronquerDouble(pTauxRemuneration);
		if (tauxRemuneration > 100.0)
			tauxRemuneration = 100.0;
		else if (tauxRemuneration < 0.0)
			tauxRemuneration = 0.0;
	}

	//==========GETTER & SETTER==========
	public double getTauxRemuneration() {
		return this.tauxRemuneration;
	}
	
	public void setTauxRemuneration(double pTauxRemuneration) {
		tauxRemuneration = tronquerDouble(pTauxRemuneration);
		if (tauxRemuneration > 100.0)
			tauxRemuneration = 100.0;
		else if (tauxRemuneration < 0.0)
			tauxRemuneration = 0.0;
	}
}