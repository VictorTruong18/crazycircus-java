package Jeu;

import java.util.ArrayList;
import java.util.List;
import Cartes.Carte;
import Cartes.Deck;
import Joueur.Joueur;
import Joueur.Joueurs;

//Classe Jeu de l'application qui prendra en compte les cartes a tirer et les situations a atteidnre
public class Jeu {
	//Attributs :
	private static final int NB_TOURS_MAX = 5; //Celui-ci ne sera jamais superieur a 24 sinon on aura une erreur de pointeur
	private Carte Initial; //La Carte de l'Etat Initial
	private Carte tmp;     //Le clone temporaire de la Carte de l'Etat Initial
	private Carte But;     //La Carte de l'Etat But
	private static int nbCarteTiree = 0; //Nombre de Cartes tiree
	
	public Jeu(Deck d) {
		Initial = d.tirerCarte(nbCarteTiree); //Tirage de la premiere carte du deck melange qui representera l'etat initial
		tmp = new Carte(Initial);
		CarteTiree(); //J'increment le nb de cartes qui ont ete tires
		But = d.tirerCarte(nbCarteTiree); //Tirage de la carte suivante pour l'etat a atteindre
	}
	
	
	
	//Methodes :
	//---------------------------------LES METHODES JEU--------------------------------------------------//
	
	public void CarteTiree() {
		nbCarteTiree++; //S'incremente a chaque tirage d'une nouvelle carte, sert d'indice pour la liste deck
	}
	
	public void SequenceExecution(List<String> seq, String surnom, Joueur Auteur) { //Execution des Sequences de coups sur la Carte Initial
		
		if(!Auteur.getElimination() ) { //Si l'auteur de la sequence n'est pas elimine il peut jouer 
			for(int i = 0; i <= (seq.size()-1); ++i) { //Parcourt la Liste de String correspondant a chaque coups d'une sequence
				if(seq.get(i).contentEquals("KI")) {
					Initial.KI(); 
					System.out.println(Initial.toString());
					
				}
				else if(seq.get(i).contentEquals("LO")) {
					Initial.LO();
					System.out.println(Initial.toString());
					
				}
				else if(seq.get(i).contentEquals("SO")) {
					Initial.SO();
					System.out.println(Initial.toString());
					
				}
				else if(seq.get(i).contentEquals("NI")) {
					Initial.NI();
					System.out.println(Initial.toString());
					
				}
				else if(seq.get(i).contentEquals("MA")) {
					Initial.MA();
					System.out.println(Initial.toString());
					
				}
				else { //Le coup n'a pas ete reconnue parmi ceux du jeux
					System.out.println("erreur, commande non reconnue");
					i = seq.size(); // fin de la boucle
				}
			}
		}
		
		else if( Auteur.getElimination()) { //Si le joueur est elimine il ne peut pas jouer
			System.out.println("Le joueur : " + Auteur.getSurnom() +" est pour le moment elimine");
			System.out.println(" ");
		}
		
	
		
		
		
	}
	
	public void RemiseInitial() {
//		for(int i = (seq.size()-1); i >= 0; i--) {
//			if(seq.get(i).contentEquals("KI")) {
//				Initial.LO();
//			}
//			else if(seq.get(i).contentEquals("LO")) {
//				Initial.KI();
//			}
//			else if(seq.get(i).contentEquals("SO")) {
//				Initial.SO();
//			}
//			else if(seq.get(i).contentEquals("NI")) {
//				Initial.NI();
//			}
//			else if(seq.get(i).contentEquals("MA")) {
//				Initial.MA();
//			}
//			
//		}
		Initial = tmp; //Le clone de la situation Initial permet de repprendre la carte Initial, celle avant que le joueur n'est change toute la carte avec les coups
		// de sa sequence
	}
	

	
	
	public Boolean ValidationTour(Joueur AuteurSeq) { //renvoie true lorsque la sequence est bonne, et false si elle est mauvaise
		//On aurait pu faire if(Initial.equals(but){return true }, mais pour des raisons que nous ne savons pas encore nous avons du
		//faire cela, c'est a dire verifier que chaque case des podiums de la Carte Initial correspondent a chaque case des podiums de la Carte But
		
		if(!Initial.getPodium_B().getTop().equals(But.getPodium_B().getTop())) { //Si le Sommet du Podium Bleu de la Carte Initial ne correspond pas  au Sommet du  
			System.out.println("Situation Initial non atteinte"); //Podium Bleu de la carte But le joueur est Elimine
			System.out.println(AuteurSeq.getSurnom() + " est elimine pour ce tour.");
			AuteurSeq.elimination(); //Elimination du Joueur Auteur de la sequence de coups fausse
			return false;
		}
		else if (!Initial.getPodium_B().getMiddle().equals(But.getPodium_B().getMiddle())) {
			AuteurSeq.elimination();
			System.out.println("Situation Initial non atteinte");
			System.out.println(AuteurSeq.getSurnom() + " est elimine pour ce tour.");
			return false;
		}
		else if (!Initial.getPodium_B().getBottom().equals(But.getPodium_B().getBottom())){
			AuteurSeq.elimination();
			System.out.println("Situation Initial non atteinte");
			System.out.println(AuteurSeq.getSurnom() + " est elimine pour ce tour.");
			return false;
		}
		else if (!Initial.getPodium_R().getTop().equals(But.getPodium_R().getTop())) {
			AuteurSeq.elimination();
			System.out.println("Situation Initial non atteinte");
			System.out.println(AuteurSeq.getSurnom() + " est elimine pour ce tour.");
			return false;
		}
		
		else if (!Initial.getPodium_R().getMiddle().equals(But.getPodium_R().getMiddle())) {
			AuteurSeq.elimination();
			System.out.println("Situation Initial non atteinte");
			System.out.println(AuteurSeq.getSurnom() + " est elimine pour ce tour.");
			return false;
		}
		else if (!Initial.getPodium_R().getBottom().equals(But.getPodium_R().getBottom())){
			AuteurSeq.elimination();
			System.out.println("Situation Initial non atteinte");
			System.out.println(AuteurSeq.getSurnom() + " est elimine pour ce tour.");
			return false;
		}
		
		else {
			System.out.println("La sequence est bonne");
			System.out.println(AuteurSeq.getSurnom() + " remporte un point.");
			AuteurSeq.addPoints();
			System.out.println(Joueurs.getJoueurs());
			return true;
		
		}
		
			
	}
	
	
	//Ce qu'il se passe lorsqu'un joueur trouve la bonne combinaison, La Carte BUt devient la Carte Initial du tour suivant
	public void TourTrouve(Deck d) {
		//d.retirerCarte(Initial);
		Initial = But; //La Carte but devient la Carte Initial
		CarteTiree(); //On tire une carte donc l'indice est incremente
		if(nbCarteTiree < NB_TOURS_MAX) { //On tire une carte tant que le nombre Maximum de tours n'est pas atteint
			But = d.tirerCarte(nbCarteTiree);
		}
		
	}
	
	//Ce qu'il se passe lorsqu'aucun joueur trouve la bonne combinaison, La Carte Initial reste seul la carte But change
	public void TourNonTrouve(Deck d) {
		//d.retirerCarte(But);
		CarteTiree(); //On tire une carte donc l'indice est incremente
		if(nbCarteTiree < NB_TOURS_MAX) { //On tire une carte tant que le nombre Maximum de tours n'est pas atteint
		But = d.tirerCarte(nbCarteTiree);
		}
	}
	
	public Boolean UnSeulNonElimine() { //True: Si il ne reste qu'un seul joueur non elimine
		int nbJoueursElimine = 0;
		for (Joueur j : Joueurs.getJoueurs()) {
			if (j.getElimination()) {
				nbJoueursElimine++; 
			}
		}
		if(nbJoueursElimine == (Joueurs.getJoueurs().size()-1)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void ClassementTrie() { //Algorithme de Trie de la liste de Joueurs selon leur score
		for(int i = 0; i < Joueurs.getnbJoueurs(); i++) {
			for(int j = i+1; j < Joueurs.getnbJoueurs(); j++ ) {
				if(Joueurs.getJoueurs().get(i).getnbPoints() < Joueurs.getJoueurs().get(j).getnbPoints() ) { 
					Joueur tmp = Joueurs.getJoueurs().get(i);
					Joueurs.getJoueurs().set(i, Joueurs.getJoueurs().get(j));
					Joueurs.getJoueurs().remove(j);
					Joueurs.getJoueurs().add(j,tmp);
				}
			}
		}
	}
	
	
	//------------------------------LES METHODES GUETTER--------------------------------------------------//
	
	public int getNbCarteTiree() {
		return nbCarteTiree;
	}
	
	public int getNBMAXTOURS () {
		return NB_TOURS_MAX;
	}

	
	
	//--------------------------------LES METHODES TO STRING---------------------------------------------// 
	
	public String ToStringInterface() {
		String s = System.lineSeparator();	
		s += "TOUR "+ nbCarteTiree +System.lineSeparator();
		s += System.lineSeparator();	
		s += "     " + Initial.getPodium_B().toStringTop()+"   " + Initial.getPodium_R().toStringTop() + "         " +But.getPodium_B().toStringTop()+"   " + But.getPodium_R().toStringTop() + System.lineSeparator();
		s += "     " + Initial.getPodium_B().toStringMiddle()+"   " + Initial.getPodium_R().toStringMiddle() + "         " +But.getPodium_B().toStringMiddle()+"   " + But.getPodium_R().toStringMiddle()	+	System.lineSeparator();
		s += "     " + Initial.getPodium_B().toStringBottom()+"   " + Initial.getPodium_R().toStringBottom() +	"         " +But.getPodium_B().toStringBottom()+"   " + But.getPodium_R().toStringBottom()	+   System.lineSeparator();
		s += "       " + "----" + "       " + "----" + 	"     " + "==>" + "     " + "----" + "       " + "----" +System.lineSeparator();
		s += "       " + "BLEU" + "       " + "ROUGE" +	"            " +"BLEU" + "       " + "ROUGE" + System.lineSeparator();
		s += "   ---------------------------------------------------" + System.lineSeparator();
		s += "   KI : BLEU --> ROUGE     NI  :  BLEU  ^" + System.lineSeparator();
		s += "   LO : BLEU <-- ROUGE     MA  :  ROUGE ^" + System.lineSeparator();
		s += "   SO : BLEU <-> ROUGE";
		s += System.lineSeparator();
		s += System.lineSeparator();
		return s;
	}
	
	public String ToStringClassement() {
		String s = System.lineSeparator();
		int previous = -1;
		int current = -1;
		int indexRank = 1;
		ArrayList<Joueur> joueursList = Joueurs.getJoueurs();
		String stringTmp;
		s += "LE CLASSEMENT : " + System.lineSeparator();
		for (int i = 0; i < joueursList.size(); i++) {
			if(i == 0)
				stringTmp = Integer.toString(indexRank) + " "+":"+" "+joueursList.get(i).getSurnom() +" || Score : "+joueursList.get(i).getnbPoints();
			else {
				current = joueursList.get(i).getnbPoints();
				if(i-1 <= joueursList.size()) {
					previous = joueursList.get(i-1).getnbPoints();
				}
				if(current == previous) {
					stringTmp = " && " + joueursList.get(i).getSurnom() +" || Score : "+joueursList.get(i).getnbPoints();
				}
				else {
					indexRank++;
					stringTmp =  System.lineSeparator() + indexRank + " "+":"+" "+Joueurs.getJoueurs().get(i).getSurnom() +" || Score : "+Joueurs.getJoueurs().get(i).getnbPoints();
				}
			}
			//s += (i+1) + " "+":"+" "+Joueurs.getJoueurs().get(i).getSurnom() +" || Score : "+Joueurs.getJoueurs().get(i).getnbPoints()  +System.lineSeparator() ;
			s += stringTmp;
		}
		s += System.lineSeparator();
		s += "Felicitation : " + " (/^▽^)/" + Joueurs.getJoueurs().get(0).getSurnom() + "ヾ(＾∇＾)";
		return s;
	}
	
}

	
