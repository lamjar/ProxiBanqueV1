package fr.gtmingenierie.proxybanque.domaine;


public abstract class Carte {

	private String num;

	public Carte() {
		// TODO - implement Carte.Carte
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

}