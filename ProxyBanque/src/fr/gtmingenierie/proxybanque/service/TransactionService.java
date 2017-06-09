package fr.gtmingenierie.proxybanque.service;

import java.util.ArrayList;

import fr.gtmingenierie.proxybanque.domaine.Compte;
import fr.gtmingenierie.proxybanque.domaine.Transaction;
import fr.gtmingenierie.proxybanque.domaine.Transaction.TypeTransaction;

public class TransactionService {

	private ArrayList<Transaction> listeTransaction;

	public TransactionService() {
		listeTransaction = new ArrayList<Transaction>();
	}
	
	public void ajoutTransaction(Compte compteDebiteur, Compte compteCrediteur, double montant, String message, TypeTransaction type) {
		listeTransaction.add(new Transaction(compteDebiteur, compteCrediteur, montant, message, type));
	}
	
	public ArrayList<Transaction> getHistorique(){
		return listeTransaction;
	}
	
	public Transaction getTransaction(int iTransaction){
		return listeTransaction.get(iTransaction);
	}
}
