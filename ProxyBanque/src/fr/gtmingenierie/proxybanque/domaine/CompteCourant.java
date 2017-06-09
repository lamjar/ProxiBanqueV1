/*
 * CompteCourant.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.domaine;

import java.util.ArrayList;

public class CompteCourant extends Compte {

	public enum typeCarte
	{
		VisaElectron,
		VisaPremier
	}
	
	//==========PROPRIETES==========
	private double plafondDecouvert;
	private ArrayList<Carte> cartes;

	//==========CONSTRUCTEURS==========
	public CompteCourant(double pSolde, String pDateOuverture) {
		super(pSolde, pDateOuverture);
		plafondDecouvert = 1000.00;
		cartes = new ArrayList<Carte>();
	}

	public CompteCourant(double pSolde, String pDateOuverture, double pPlafondDecouvert) {
		super(pSolde, pDateOuverture);
		plafondDecouvert = tronquerDouble(pPlafondDecouvert);
		cartes = new ArrayList<Carte>();
	}
	
	//==========GETTER & SETTER==========
	public double getDecouvert() {
		return this.plafondDecouvert;
	}

	public void setPlafondDecouvert(double pDecouvert) {
		this.plafondDecouvert = tronquerDouble(pDecouvert);
	}
	
	public Carte getCarte(Integer index) throws IndexOutOfBoundsException
	{
		return cartes.get(index);
	}

	//==========METHODES==========
	/**
	 * Cree une carte et l'associe au compte courant
	 * @param pTypeCarte Indique le type de carte (Visa Electron ou Visa Premier)
	 * @return Indique si l'ajout s'est bien effectue
	 */
	public boolean addCarte(typeCarte pTypeCarte)
	{
		if(pTypeCarte == typeCarte.VisaElectron)
			return cartes.add(new CarteVisaElectron(this));
		else if(pTypeCarte == typeCarte.VisaPremier)
			return cartes.add(new CarteVisaPremier(this));
		return false;
	}
	
	/**
	 * Supprime une carte de la liste des cartes liees au compte courant
	 * @param index Indice de la carte dans la liste des cartes bancaires
	 * @return Indique si la suppression a bien eu lieu
	 */
	public boolean deleteCarte(Integer index)
	{
		return cartes.remove(index);
	}

}