package Cartes;
/*La Classe Carte represente une situation et est compose de deux objets
Podiums */
public class Carte {
	//Attributs:
	private  Podium Podium_B;     //Podium Bleu
	private  Podium Podium_R;	 //Podium rouge

	
	//Constructeur:
	//Un objet Carte est cree lorsque l'on combine deux podiums
	public Carte(Podium B, Podium R) {
		Podium_B = B;
		Podium_R = R; 
	}
	
	//Clone du constructeur d'une Carte, dont on se servira pour cloner la Carte de la situation initial du Jeu
	public Carte(Carte initial) {
		this.Podium_B = new Podium(initial.getPodium_B());
		this.Podium_R = new Podium(initial.getPodium_R());
	}


	//Methodes:
	/*-----------------------------------------METHODES COMMANDES------------------------------------------------*/  
	public void LO() { 	//L'animal au sommet du podium_R va au sommet du podium_B
		if(!Podium_B.estPlein() && !Podium_R.estVide()) {
			Podium_B.ajouter(Podium_R.Sommet()); //On ajoute au sommet du Podium_B l'animal au sommet du Podium_R
			Podium_R.retirer(Podium_R.Sommet()); //Puis on retire l'animal au sommet du Podium_R
			
		}
		else {
			System.out.println("La commande LO ne peut pas etre exectuee, car la podium bleu est deja plein et le podium rouge est vide.");
			
		}
	}
	
	public void SO() { //Les animaux au sommet des deux podiums echangent leur place
		if(!Podium_B.estVide() && !Podium_R.estVide()) {
			Animal a;
			a = Podium_R.Sommet(); //On garde temporairement l'animal dans la variable a
			Podium_R.remplacerSommet(Podium_B.Sommet()); //On remplace l'animal au sommet du Podium_R avec l'animal au sommet du Podium_B
			Podium_B.remplacerSommet(a); //Puis on fait la meme chose avec le Podium_B
		}
		else {
			if(Podium_R.estVide()) {
				System.out.println("La commande SO ne peut pas etre exectuee, car la podium rouge est vide");
			}
			if(Podium_B.estVide()) {
				System.out.println("La commande SO ne peut pas etre exectuee, car la podium bleu est vide");
			}
		}
	}
	
	public void KI() { //L'animal au sommet du podium_B va au sommet du podium_R
		if(!Podium_R.estPlein()&&!Podium_B.estVide()) {
			Podium_R.ajouter(Podium_B.Sommet()); //On ajoute au sommet du Podium_R l'animal au sommet du Podium_B
			Podium_B.retirer(Podium_B.Sommet()); //Puis on retire l'animal au sommet du Podium_B
		}
		else {
			System.out.println("La commande KI ne peut pas etre exectuee, car la podium rouge est deja plein et le podium bleu est vide");
			
		}
	}
	
	public void MA() { //L'animal au bas du podium_R se place au sommet du podium_R
		if(Podium_R.getNbAnimal()>1) {
			Animal a;
			a = Podium_R.Sommet(); //On garde temporairement l'animal au sommet 
			Podium_R.remplacerSommet(Podium_R.Bas()); //on remplace la sommet avec l'animal du Bas
			Podium_R.remplacerBas(a); //Puis on fait la meme chose avec le bas mais avec l'animal au sommet
		}
		else {
			System.out.println("La commande MA ne peut pas etre exectuee, car il n'y a qu'un seul, ou aucun animal sur le podium rouge");
		}
	}
	
	public void NI() { //L'animal au bas du podium_B se place au sommet du podium_B
		if(Podium_B.getNbAnimal()>1) {
			Animal a;
			a = Podium_B.Sommet();
			Podium_B.remplacerSommet(Podium_B.Bas());
			Podium_B.remplacerBas(a);
		}
		else {
			System.out.println("La commande NI ne peut pas etre exectuee, car il n'y a qu'un seul, ou aucun animal sur le podium bleu");
		}
	}
	

	
	
	
	
	
	//----------------------------------LES METHODES GETTER----------------------------------------------//
	
	public Podium getPodium_B() {
		return Podium_B;
	}
	
	public Podium getPodium_R() {
		return Podium_R;
	}
	
	
	//---------------------------------LES METHODES TOSTRING---------------------------------------------//

	public String toString() {
		String s = "" + System.lineSeparator();
		s += "     " + Podium_B.toStringTop()+"   " + Podium_R.toStringTop() + System.lineSeparator();
		s += "     " + Podium_B.toStringMiddle()+"   " + Podium_R.toStringMiddle() + System.lineSeparator();
		s += "     " + Podium_B.toStringBottom()+"   " + Podium_R.toStringBottom() + System.lineSeparator();
		s += "       " + "----" + "       " + "----" + System.lineSeparator();
		s += "       " + "BLEU" + "       " + "ROUGE" + System.lineSeparator();
		return s;
	}
	
	
}
