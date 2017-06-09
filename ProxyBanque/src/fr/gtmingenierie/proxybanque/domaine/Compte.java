/*
 * Compte.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */


package fr.gtmingenierie.proxybanque.domaine;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Compte {

	//==========PROPRIETES==========
	private int[] num;
	private double solde;
	private double soldeInitial;
	private String dateOuverture;
	
	//4 premiers chiffres sont toujours '3 0 0 0' 
	static int[] compteurNum = {3, 0, 0, 0, 0, 0, 0, 0, 0, 0};

	//==========CONSTRUCTEUR==========
	public Compte(double pSolde, String pDateOuverture) {
		solde = tronquerDouble(pSolde);
		soldeInitial = solde;
		dateOuverture = pDateOuverture;
		num = genererNumero();
	}

	//==========GETTERS & SETTERS==========
	public String getNum() {
		String strNum = "";
		for(int valeur : num)
		{
			strNum += valeur;
		}
		return strNum;
	}

	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = tronquerDouble(solde);
	}

	public String getDateOuverture() {
		return this.dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	
	public double getSoldeInitial()
	{
		return soldeInitial;
	}
	
	//==========METHODES==========
	public void reinitialiserSoldeInitial()
	{
		soldeInitial = solde;
	}
	
	@Override
	public String toString() {
		String strNumero = "";
		for(int i=0; i<num.length; i++)
			strNumero += num[i];
		return "[Numero du compte : " + strNumero + " ; solde : " + solde + " ; date d'ouverture : " + dateOuverture + "]";
	}
	
	/**
	 * Genere un numero de compte bancaire automatiquement
	 * Le numero de compte commence toujours par 3 0 0 0
	 * @return Tableau d'entiers contenant chaque chiffre (de 0 a 9) du numero du compte
	 */
	private int[] genererNumero()
	{
		int[] nouveauNumero = new int[10];
		for(int i=0; i<10 ;i++)
			nouveauNumero[i] = compteurNum[i];
		
		//4 premier chiffres sont toujours 3000
		for(int i=9; i>3 ;i--)
		{
			if(compteurNum[i] < 9)
			{
				compteurNum[i]++;
				break;
			}
			
			compteurNum[i]=0;
		}
		
		return nouveauNumero;
	}
	
	/**
	 * Tronque une valeur reelle a 2 chiffres apres le virgule
	 * @param valeur
	 * @return Nombre reel avec 2 chiffres max apres le virgule
	 */
	protected double tronquerDouble(double valeur)
	{
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		return Double.parseDouble(df.format(valeur));
	}

}