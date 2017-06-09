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

	public enum TypeCarte {
		VisaElectron, VisaPremier
	}

	// ==========PROPRIETES==========
	private double plafondDecouvert;
	private ArrayList<Carte> cartes;

	// ==========CONSTRUCTEURS==========
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

	// ==========GETTER & SETTER==========
	public double getDecouvert() {
		return this.plafondDecouvert;
	}

	public void setPlafondDecouvert(double pDecouvert) {
		this.plafondDecouvert = tronquerDouble(pDecouvert);
	}

	public Carte getCarte(Integer index) throws IndexOutOfBoundsException {
		return cartes.get(index);
	}

	// ==========METHODES==========
	/**
	 * Cree une carte et l'associe au compte courant
	 * 
	 * @param pTypeCarte
	 *            Indique le type de carte (Visa Electron ou Visa Premier)
	 * @return Indique si l'ajout s'est bien effectue
	 */
	public boolean addCarte(TypeCarte pTypeCarte) {
		if (pTypeCarte != null) {
			if (pTypeCarte == TypeCarte.VisaElectron)
				return cartes.add(new CarteVisaElectron(this));
			else if (pTypeCarte == TypeCarte.VisaPremier)
				return cartes.add(new CarteVisaPremier(this));
		}
		return false;
	}

	/**
	 * Supprime une carte de la liste des cartes liees au compte courant
	 * 
	 * @param index
	 *            Indice de la carte dans la liste des cartes bancaires
	 * @return Indique si la suppression a bien eu lieu
	 */
	public boolean deleteCarte(int index) {
		Carte carte;
		try {
			carte = cartes.remove(index);
		} catch (IndexOutOfBoundsException ex) {
			System.err.println("Erreur : " + ex + "\n=> La valeur de l'indice n'est pas valide\n");
			return false;
		}
		return (carte == null) ? false : true;
	}

	/**
	 * Cherche l'indice de la carte dans la liste des cartes du compte courant a
	 * partir de son identifiant unique
	 * 
	 * @param idCarte
	 *            Identifiant de la carte
	 * @return Si la carte existe, retourne l'indice de cette carte. Sinon, la
	 *         methode retourne -1.
	 */
	public int findCarte(Integer idCarte) {
		if(idCarte != null)
		{
			Integer index = 0;
			for (Carte carte : cartes) {
				if (carte.getID().equals(idCarte))
					return index;
				index++;
			}
		}
		return -1;
	}

}