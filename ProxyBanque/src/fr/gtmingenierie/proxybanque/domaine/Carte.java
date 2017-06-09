/*
 * Carte.java
 * Date : 08/06/2017
 * AUTEURS :
 * Laurent LAMASSE
 * Clement ROUX
 * */

package fr.gtmingenierie.proxybanque.domaine;


public abstract class Carte {

	//==========PROPRIETES==========
	private CompteCourant compte;
	private Integer ID;
	private static Integer compteurCarte = 0;

	//==========CONSTRUCTEUR==========
	public Carte(CompteCourant pCompte) {
		compte = pCompte;
		ID = compteurCarte;
		compteurCarte++;
	}
	
	//==========GETTER==========
	public Integer getID()
	{
		return ID;
	}
	
	//==========METHODE==========
	@Override
	public String toString() {
		return "[Carte n°"+ ID +" ; Numero du compte : "+ compte.getNum() +"]";
	}
}