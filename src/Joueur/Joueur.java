

package Joueur;


public class Joueur {
	//Attributs :
	private String surnom; 
	private int nbPoints;
	private Boolean elimination; //True : si le Joueur est elimine lors du tour
	
	
	//Constructeur :
	public Joueur(String nom) {
		assert(nom.length() > 1) : "Surnom trop court";
		this.surnom = nom;
		this.nbPoints = 0;
		this.elimination = false;
	}
	
	
	/*-----------------------------------------LES METHODES JOUEUR----------------------------------------------------------------------------*/
	
	public int addPoints() {
		return nbPoints++; //Incremente le nombre de points
	}
	
	public void elimination() {
		elimination = true; //Elimine le joueur
	}
	
	public void deselimination() {
		elimination = false; //Leve l'elimination
	}
	
	/*------------------------------------------LES METHODES GETTER----------------------------------------------------------------------------*/
	
	public String getSurnom() {
		return surnom; 
	}
	
	public int getnbPoints() {
		return nbPoints;
	}
	
	public Boolean getElimination() {
		return elimination;
	}
	
	/*------------------------------------------LES METHODES TO STRING--------------------------------------------------------------------------*/
	
	public static String Normaliser(String surnom) {
		String nom = surnom.trim();
		int i = 0;
		String s = "";
		while(i < nom.length()){
			if(nom.charAt(i)!=32) {
				s+=nom.charAt(i);
			}
			i++;
		}
		return s;
	}
	
	public String toString() {
		String s = surnom + " score : " + nbPoints;
		return s;
	}
	
	
	
	
	
}
