package Joueur;

import java.util.ArrayList;



public class Joueurs {
	//Attributs
	private static ArrayList<Joueur> tabJoueurs = new ArrayList<Joueur>(); //La liste de tous les joueurs
	private static int nbJoueurs; //Le nbDeJoueurs au total
	
	
	/*-----------------------------------------METHODES JOUEURS------------------------------------------------------------*/
	
	public static void addJoueurs(Joueur j) {
		tabJoueurs.add(j); //Ajoute un Joueur dans la liste
	}
	
	
	public static void setnbJoueurs(int nb) { //Setter du nbDeJoeurs dnas la partie
		assert(nb > 1);
		nbJoueurs = nb;
	}
	
	
	public static void setPlusElimine() { //Enleve l'elimination pour tous les joueurs de la partie
		for(Joueur j : tabJoueurs) { 
		    j.deselimination(); //Elimination mis a false
		}
	}
	
	public static Boolean doublonFinder(String surnom, int j) { //Erreur, et cassage du programme si un joueur indique deux fois le
		int i = 0; 												//meme surnom
		while(i<j) {
			Joueur tmp = tabJoueurs.get(i);
			if(surnom.equals(tmp.getSurnom())) {
				return true;
			}
			else {
				return false;
			}
		}
	return false;
	}
	
	/*----------------------------------------METHODES GETTER----------------------------------------------------------------*/
	
	
	public static int getnbJoueurs() {
		return nbJoueurs;
	}
	
	public static ArrayList<Joueur> getJoueurs() {
		return tabJoueurs; //renvoie toute la liste de Joueurs
	}
	

	
	public static Joueur getJoueurPasElimine() { //renvoie tous les joueurs non elimines
		for(Joueur j : tabJoueurs) {
			if(!j.getElimination()) {
				return j;
			}
		}
		return null;
	}

	

	
	
	
	

	
	
	
	
}
