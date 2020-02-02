package Cartes;


import java.util.ArrayList;
import java.util.Collections;



//Deck compose de 24 cartes. Il sera melange avant chaque partie. Les 24 cartes ser-
//ont initialisees a la main
public class Deck {
	//Atributs :               
	private static ArrayList<Carte> deck = new ArrayList<Carte>();  //Tableau de cartes, deck de cartes 
	
	//Constructeur :
	public Deck() {
		//Dans ce constructeur nous creons les 24 cartes qui seront ajouter dans la liste deck
		Animal E = Animal.ELEPHANT;
		Animal O = Animal.OURS;
		Animal L = Animal.LION;
		Animal N = Animal.NULL;
		
		Podium ab = new Podium(L,O,E);     Podium mb = new Podium(N,N,N) ;
		Podium ar = new Podium(N,N,N);	   Podium mr = new Podium(L,O,E) ;
		Carte a = new Carte(ab,ar);        Carte m = new Carte (mb,mr);
		deck.add(a);					   deck.add(m);
		Podium bb = new Podium(L,O,N);     Podium nb = new Podium(E,N,N) ;
		Podium br = new Podium(E,N,N);     Podium nr = new Podium(L,O,N) ;
		Carte b = new Carte(bb,br);		   Carte n = new Carte (nb,nr);
		deck.add(b);					   deck.add(n);
		Podium cb = new Podium(L,E,N);     Podium ob = new Podium(O,N,N) ;
		Podium cr = new Podium(O,N,N);	   Podium or = new Podium(L,E,N) ;
		Carte c = new Carte(cb,cr);		   Carte o = new Carte (ob,or);
		deck.add(c);					   deck.add(o);
		Podium db = new Podium(L,E,O);     Podium pb = new Podium(N,N,N) ;
		Podium dr = new Podium(N,N,N);     Podium pr = new Podium(L,E,O) ;
		Carte d = new Carte(db,dr); 	   Carte p = new Carte(pb,pr);
		deck.add(d);					   deck.add(p);
		Podium eb = new Podium(E,O,L);     Podium qb = new Podium(N,N,N) ;
		Podium er = new Podium(N,N,N);     Podium qr = new Podium(E,O,L) ;
		Carte e = new Carte(eb,er);		   Carte q = new Carte(qb,qr);
		deck.add(e);					   deck.add(q);
		Podium fb = new Podium(E,O,N);     Podium rb = new Podium(L,N,N) ;
		Podium fr = new Podium(L,N,N);     Podium rr = new Podium(E,O,N) ;
		Carte f = new Carte(fb,fr);        Carte r = new Carte(rb,rr);
		deck.add(f);					   deck.add(r);
		Podium gb = new Podium(E,L,N);     Podium sb = new Podium(O,N,N) ;
		Podium gr = new Podium(O,N,N); 	   Podium sr = new Podium(E,L,N) ;
		Carte g = new Carte(gb,gr);        Carte s = new Carte(sb,sr);
		deck.add(g);					   deck.add(s);
		Podium hb = new Podium(E,L,O);	   Podium tb = new Podium(N,N,N) ;
		Podium hr = new Podium(N,N,N);     Podium tr = new Podium(E,L,O) ;
		Carte h = new Carte(hb,hr);        Carte t = new Carte(tb,tr);
		deck.add(h);  					   deck.add(t);
		Podium ib = new Podium(O,L,E);     Podium ub = new Podium(N,N,N) ;
		Podium ir = new Podium(N,N,N);     Podium ur = new Podium(O,L,E) ;
		Carte i = new Carte(ib,ir);		   Carte u = new Carte(ub,ur);
		deck.add(i);					   deck.add(u);
		Podium jb = new Podium(O,L,N);     Podium vb = new Podium(E,N,N) ;
		Podium jr = new Podium(E,N,N);     Podium vr = new Podium(O,L,N) ;
		Carte j = new Carte(jb,jr);        Carte v = new Carte(vb,vr);
		deck.add(j);					   deck.add(v);
		Podium kb = new Podium(O,E,N);     Podium wb = new Podium(L,N,N) ;
		Podium kr = new Podium(L,N,N);     Podium wr = new Podium(O,E,N) ;
		Carte k = new Carte(kb,kr);		   Carte w = new Carte(wb,wr);
		deck.add(k);					   deck.add(w);
		Podium lb = new Podium(O,E,L);	   Podium xb = new Podium(N,N,N) ; 
		Podium lr = new Podium(N,N,N);     Podium xr = new Podium(O,E,L) ;
		Carte l = new Carte(lb,lr); 	   Carte x = new Carte(xb,xr);
		deck.add(l);					   deck.add(x);
	}
	
	//Methodes :
	//--------------------------------------------------LES METHODES GETTER------------------------------------------------------------------//
	
	public ArrayList<Carte> getDeck(){  //retourne la liste de cartes
		return deck;
	}
//	public int getnbElements() {	//retroune le nombre de carte dans le deck
//		return deck.size();
//	}
	
	//----------------------------------------------------LES METHODES DECK------------------------------------------------------------------//
	
	public void melangerDeck() {
		Collections.shuffle(deck);	//melange le deck, donc melange l'ordre des Cartes dans la liste
	}
	
//	public void retirerCarte(Carte c) {
//		deck.remove(c);	//retirer une carte de la liste
//	}
//	
	
	
	public Carte tirerCarte(int nbCarteTirer) {
		return deck.get(nbCarteTirer); //Tirer une carte, le nombre de cartes tirees sert d'indice
	}


	
	
	
	
	
	
	
}
