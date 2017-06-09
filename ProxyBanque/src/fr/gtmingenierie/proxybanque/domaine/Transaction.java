package fr.gtmingenierie.proxybanque.domaine;

public class Transaction {

	// Type de transactions possibles
	public enum TypeTransaction {
		virement, placement
	}

	// Propriétés
	private Compte compteDebiteur;
	private Compte commpteCrediteur;
	private double montant;
	private String message;
	private TypeTransaction type;

	// Constructeur
	public Transaction(Compte compteDebiteur, Compte commpteCrediteur, double montant, String message,
			TypeTransaction type) {
		super();
		this.compteDebiteur = compteDebiteur;
		this.commpteCrediteur = commpteCrediteur;
		this.montant = montant;
		this.message = message;
		this.type = type;
	}

	// Getters et setters
	public Compte getCompteDebiteur() {
		return compteDebiteur;
	}

	public void setCompteDebiteur(Compte compteDebiteur) {
		this.compteDebiteur = compteDebiteur;
	}

	public Compte getCommpteCrediteur() {
		return commpteCrediteur;
	}

	public void setCommpteCrediteur(Compte commpteCrediteur) {
		this.commpteCrediteur = commpteCrediteur;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TypeTransaction getType() {
		return type;
	}

	public void setType(TypeTransaction type) {
		this.type = type;
	}

}
