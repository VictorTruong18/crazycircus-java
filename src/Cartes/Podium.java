package Cartes;

    /*La Classe Podium qu'on associera eventuellement avec un autre podium pour creer
    une carte representant une situation.*/

public class Podium {
	//Atributs : 
	private static final int MAX = 3;  					// Capacite maximal d'un podium
	private int nbAnimaux = 0; 					  // Le nombre d'animaux dans un Podium
	private  Animal[] Podium; 				 // L'Objet Podium est un tableau d'animaux
	
	//Constructeur :
	//Pour creer un Podium on doit mettre les animaux qu'il contient a l'interieur
	public Podium(Animal a, Animal b, Animal c) {
		Podium = new Animal[MAX]; //Allocation de l'espace
		Podium[0] = a;            //Le Bas du Podium
		Podium[1] = b;			  //Le Millieu du Podium
		Podium[2] = c; 			  //Le Haut du Podium
		for(Animal an : Podium ) {
			if (an!=Animal.NULL) {
				nbAnimaux++;
			}
		}
	}
	
	//Constructeur qui servira de clone pour la Carte Initial
	public Podium(Podium podium_p) {
		this.nbAnimaux = podium_p.getNbAnimal();
		this.Podium = new Animal[MAX]; //Allocation de l'espace
		this.Podium[0] = podium_p.getBottom();
		this.Podium[1] = podium_p.getMiddle();
		this.Podium[2] = podium_p.getTop();
	}

	
	//Methodes :
	/*----------------------LES METHODES PODIUMS------------------------------------*/
	
	
	public boolean estVide(){				//true si le podium ne contient aucun animal
		return nbAnimaux==0;      
	}
	public boolean estPlein() {				  //true si le podium contient trois animaux
		return nbAnimaux==3;
	}
	public void ajouter(Animal a) {                 //ajoute en tete du podium un animal 
		assert(!estPlein());
		Podium[nbAnimaux] = a ;
		nbAnimaux++;
	}
	public void retirer(Animal a) {          //retire l'animal qui est en tete du podium 
		assert(!estVide());
		Podium[nbAnimaux-1] = Animal.NULL;
		nbAnimaux--;
	}
	public void remplacerSommet(Animal a) {  //met l'animal en parametre dans la case au sommet
		Podium[nbAnimaux-1]=a;				 //du podium
	}
	public void remplacerBas(Animal a) {	//met l'animal en parametre dans la case au bas
		Podium[0]=a;						//du podium
	}
	public Animal Sommet() {                 	 //retourne l'animal au sommet du podium
		return Podium[nbAnimaux-1];
	}
	public Animal Bas() {					//retourne l'animal tout en bas
		return Podium[0];
	}
	
	
	
	/*----------------------LES METHODES SETTER-------------------------------------*/
	
//	public void setBottom(Animal a) {
//		Podium[0] = a;
//	}
//	public void setMiddle(Animal a) {
//		Podium[1] = a;
//	}
//	public void setTop(Animal a) {
//		Podium[2] = a;
//	}
//	
	/*----------------------LES METHODES GETTER-------------------------------------*/
	
	public Animal getBottom() {
		return Podium[0];
	}
	public Animal getMiddle() {
		return Podium[1];
	}
	public Animal getTop() {
		return Podium[2];
	}
	public int getNbAnimal() {
		return nbAnimaux;
	}
	public int getMAX() {
		return MAX;
	}
	
	/*----------------------LES METHODES TOSTRING-----------------------------------*/
	

	public String toStringBottom() {
		switch(this.Podium[0]) {
		case ELEPHANT : return"ELEPHANT";
		case LION: return "  LION  ";
		case OURS: return "  OURS  ";
		default: return "        ";
		}
	}
	
	public String toStringMiddle() {
		switch(this.Podium[1]) {
		case ELEPHANT : return"ELEPHANT";
		case LION: return "  LION  ";
		case OURS: return "  OURS  ";
		default: return "        ";
		}
	}

	
	public String toStringTop() {
		switch(this.Podium[2]) {
		case ELEPHANT : return"ELEPHANT";
		case LION: return "  LION  ";
		case OURS: return "  OURS  ";
		default: return "        ";
		}
	}
	

	
	
	
	

}
