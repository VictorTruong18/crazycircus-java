  package Joueur;



import java.util.Arrays;
import java.util.List;

//objet qui correspond a la sequence de coups entree par le joueur
public class Sequence {
	//Attributs :
	private String Sequence; //la sequence, un string
	private List<String> SequenceList;
	private String Auteur; //le joueur qui a ecrit la sequence
	
//	@brief : constructeur de la sequence de coups du joueur
//	input[in] String : la Sequence avec le surnom et la sequence de commandes
//	String Sequence : la Sequence de commande uniquement
//	Joueur Auteur : le Joueur qui a ecrit la Sequence
	public Sequence(String S) {
		int i = 0;
		while(i < S.length()) {
			if(S.charAt(i)==32) { //si il y a un espace
				Auteur = S.substring(0,i); //substring du debut de la chaine jusqu'a l'espace ce qui represente le nom de l'auteur de la Sequence
				Sequence = S.substring(i+1,S.length()); //substring de l'espace jusau'a la fin de la chaine, ce qui represente la sequence de coups
				i++;
			}
			i++;
		}
		SequenceList = Arrays.asList(Sequence.split("(?<=\\G..)")); //La Sequence de coups est decoupe par 4 et ensuite mis dans chaque case de la liste SequenceList
		//source : https://stackoverflow.com/questions/2297347/splitting-a-string-at-every-n-th-character/54991743#54991743
	}
	
/*-----------------------------------------------------------LES METHODES GETTER--------------------------------------------------------------------------*/
	
	public List<String> getSequence(){
		return SequenceList;
	}
	
	public String getAuteur() {
		return Auteur;
	}
	
	public Joueur getAuteurJoueur() {
		for(Joueur j : Joueurs.getJoueurs()) {
			if(Auteur.equals(j.getSurnom())) { //renvoie le Type Joueur correspondant a la chaine de carractere Auteur
				return j;
			}
		}
		return null;
	}
	
	public Boolean ValidationSurnomExistant(String Surnom) { //renvoie true lorsque le surnom existe et false lorsqu'il n'existe pas
		for (Joueur j : Joueurs.getJoueurs()) {
			if (Surnom.contentEquals(j.getSurnom())) { 
				return true;
			}
		}
		return false;
	}
	
	
	

}
