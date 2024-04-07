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
				if(coup.estValide(this)) {
					res.add(coup);
				}
			}
		}
		return res;
	}
	
	public HashSet<Coup> coupsDefausse(Set<Joueur> participants){
		HashSet<Coup> res = new HashSet<>();
		for(Coup c: coupsPossible(participants)) {
			if(c.getJoueurCible()==null) {
				res.add(c);
			}
		}
		return res;
	}
	
	public boolean deposer(Carte c) {
		return zone.deposer(c);
    }
	
	public void retirerDeLaMain(Carte carte) {
		main.jouer(carte);
	}
	
	
	
	
	
    

	
	
}
