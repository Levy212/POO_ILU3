package jeu;
import java.util.*;
import cartes.*;

public class Joueur {
	
	private String nom;
	private ZoneDeJeu zone;
	private IMain main;
	public Joueur(String nom, ZoneDeJeu zone) {
		this.nom = nom;
		this.zone = zone;
		this.main = new MainAsListe();
	}
	public String getNom() {
		return nom;
	}
	
	public ZoneDeJeu getZone() {
		return zone;
	}
	
	public boolean equals(Joueur joueur) {
		return nom.equals(joueur.getNom());
	}
	
	@Override
	public String toString() {
		return "Joueur: "+nom;
	}
	public IMain getMain() {
		return main;
	}
	
	public void donner(Carte c) {
		main.prendre(c);
	}
	
	public Carte prendreCarte(ArrayList<Carte> sabot) {
		if(sabot.isEmpty()) {
			return null;
		}
		else {
			return sabot.remove(0);
		}
	}
	
	public HashSet<Coup> coupsPossible(Set<Joueur> participants){
		HashSet<Coup> res = new HashSet<>();
		
		for(Joueur j:participants) {
			for(Iterator<Carte> i = main.iterator(); i.hasNext();) {
				Carte c =  i.next();
				Coup coup = new Coup(c, j);
				//System.out.println(coup);
				if(coup.estValide(this) && j.getZone().estDepotAutorise(c)) {
					res.add(coup);
				}
			}
		}
		return res;
	}
	
	public HashSet<Coup> coupsDefausse(){
		HashSet<Coup> res = new HashSet<>();
		Iterator<Carte> i = main.iterator();
		for(int j=0;j<7;j++) {
			Carte c =  i.next();
			res.add(new Coup(c, null));
		}	
		return res;
	}
	
	public boolean deposer(Carte c) {
		return zone.deposer(c);
    }
	
	public void retirerDeLaMain(Carte carte) {
		main.jouer(carte);
	}
	
	public Coup choisirCoup(Set<Joueur> participants) {
		HashSet<Coup> coupsPossibles = coupsPossible(participants);
		if(coupsPossibles.isEmpty()) {
			HashSet<Coup> defausse = coupsDefausse();
			Coup[] tableau = defausse.toArray(new Coup[0]); 
	        Random random = new Random();
	        int indiceAleatoire = random.nextInt(tableau.length);
	        Coup c = tableau[indiceAleatoire];
			return c;
			
		}
		else {
			Coup[] tableau = coupsPossibles.toArray(new Coup[0]); 
	        Random random = new Random();
	        int indiceAleatoire = random.nextInt(tableau.length);
	        Coup c = tableau[indiceAleatoire];
			return c;
			
		}
	}
	
	
	
	
	
    

	
	
}
