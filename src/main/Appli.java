package main;

import java.util.Scanner;



import Cartes.Deck;

import Joueur.Joueur;
import Joueur.Joueurs;
import Joueur.Sequence;
import Jeu.Jeu;
// Classe principale / Main de l'application 
public class Appli {
	//Remplir la liste de Joueurs d'Objet de type "Joueur"
	public static void remplir_Tabjoueurs() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Combien rentrer de joueurs ?"); 
		int nb = sc.nextInt();
		Joueurs.setnbJoueurs(nb);//Etablir le nombre de joueur pendant toute la partie
	
	
		
		//Boucle pour inserer les objets joueur dans la liste Joueurs
		for (int i = 1; i <= Joueurs.getnbJoueurs(); ++i) {
			System.out.println("j"+i+" :");
			Scanner db = new Scanner(System.in);
			String Surnom = db.nextLine();
			Joueur j = new Joueur(Joueur.Normaliser(Surnom)); // Je normalise le nom avant de creer la classe
			assert(!Joueurs.doublonFinder(Surnom, (i-1))) : "Un utilisateur porte deja ce surnom: "+Surnom; //le programme s'arrete s'il y a deux surnoms identiques
			Joueurs.addJoueurs(j); 
		
		}
		
		//Affichage des joueurs et du nombre de joueurs
		System.out.println("Vous etes "+ Joueurs.getnbJoueurs() +" dompteurs"); // Affiche le nombre de joueurs
		System.out.println(Joueurs.getJoueurs()); //Affiche tous les joueurs dans la liste
		}
	
	
	
	//Le jeu en lui meme
	public static void Jeu() {
		Deck D = new Deck(); //Le type deck est une liste d'objet de type Carte
		D.melangerDeck(); //Melange du deck avec la methode shuffle
		Jeu j = new Jeu(D);
		System.out.print(j.ToStringInterface());//Affichage de l'interface 
		while(j.getNbCarteTiree() < j.getNBMAXTOURS()) { //Tant que le nombre maximum de tours n'a pas ete atteint le jeu continue
			
			Scanner se = new Scanner(System.in);
			Sequence seq = new Sequence(se.nextLine());  //Creation d'une sequence de coups par le joueur
			
			if(seq.ValidationSurnomExistant(seq.getAuteur())){ //Verification de l'existence du surnom parmi la liste de joueurs
				j.SequenceExecution(seq.getSequence(), seq.getAuteur(), seq.getAuteurJoueur()); //Si Son surnom existe on execute sa sequence de coups
				
				if(!seq.getAuteurJoueur().getElimination()) { //On verifie que la sequence est correct seulement si le joueur n'est pas elimine
					if(j.ValidationTour(seq.getAuteurJoueur())) {  //Si la Sequence du Joueur est bonne la methode ValidationTour renvoie True
						j.TourTrouve(D); //Comme la sequence est correct la Carte Initial devient la Carte But et on pioche une autre Carte But
						System.out.println(j.ToStringInterface());
						Joueurs.setPlusElimine(); //Tous les Joueurs ne sont plus elimines
					}
					
					else if(j.UnSeulNonElimine()) { // Si tout le monde a ete elimine sauf un joueur
						System.out.println("Seul "+ Joueurs.getJoueurPasElimine().getSurnom() + " n'a pas encore ete elimine");
						System.out.println(Joueurs.getJoueurPasElimine().getSurnom() + " remporte donc le tour");
						j.RemiseInitial(); //la Carte Initial reste la meme, on la reintialise
						Joueurs.getJoueurPasElimine().addPoints(); //le joueur non elimine remporte un point
						System.out.println(Joueurs.getJoueurs());
						j.TourNonTrouve(D); //La Carte Initial reste la meme, on tire juste une nouvelle carte But
						System.out.println(j.ToStringInterface());
						Joueurs.setPlusElimine(); //Tous les Joueurs ne sont plus elimines
						
					}
					
					else  {
					j.RemiseInitial(); //Si la Sequence est fausse Le joueur est elimine, et on reintialise la Carte Intial car le tour n'est pas finie
					System.out.print(j.ToStringInterface());
					}
				}
			}
			else { //Si le nom n'a pas ete valide
				System.out.println("ERREUR : Le Joueur '"+seq.getAuteur()+"' n'est pas inscrit dans la liste:");
				System.out.println(Joueurs.getJoueurs());
				System.out.println("");
			}
			
		} //Fin de la boucle, le nombre maximum de tours a ete atteint
		System.out.println("");
		System.out.print("Deck finis");
		j.ClassementTrie(); //On trie le score des joueurs dans la liste
		System.out.print(j.ToStringClassement()); //On affiche le classement
	}
	
	
	
	public static void main(String[] args) {
		 
		remplir_Tabjoueurs(); //Les Joueurs specifient leur surnom
		Jeu(); //le jeu
		
		
	}

}
