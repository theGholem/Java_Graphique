package fr.oem5;

public class Compte {

	private double soldeInitial,depot,retrait,transf;
	
	/**
	 * constructor
	 * 
	 * @param soldeInit
	 * @param depot
	 * @param retrait
	 * @param transf
	 */
	public Compte(double soldeInit, double depot, double retrait, double transf) {
		
		this.soldeInitial=soldeInit;
		this.depot=depot;
		this.retrait=retrait;
		this.transf=transf;
		
	}
	
	//default's constructor
	public Compte() {
		
	}
	
	
	/**
	 * 
	 * @return solde initial entré par le user
	 */
	public double SoldeInitial() {
		return this.soldeInitial;
	}
	
	/**
	 * 
	 * @return la somme deposé par le user
	 */
	public double Depot() {
		return this.depot;
	}
	
	/**
	 * 
	 * @return la somme retiré par le user
	 */
	public double retrait() {
		
		return this.retrait;
	}
	
	/**
	 * 
	 * @return le montant transféré par le user vers un autre compte
	 */
	public double Trsf() {
		return this.transf;
	}
	
	/**
	 * 
	 * @return le solde restant apres toutes transactions
	 */
	public double SoldeFinal() {
		return this.SoldeInitial()+this.Depot()-this.retrait()-this.Trsf();
	}
	
	/**
	 * 
	 * @return la nature du compte du user.
	 */
	public String testFond() {
		if(this.SoldeFinal()<0) {
			return "Vous etes endetté"; 
		} else if(this.SoldeFinal()>0) {
			return" vous etes correcte";
		}else {
			return "De justesse";
		}
	}
	
}
