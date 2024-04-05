package jeu;
import java.util.ArrayList;

import cartes.*;
import cartes.Probleme.Type;

public class Joueur {
	
	private String nom;
	private ZoneDeJeu zone;
	private MainAsListe main;
	public Joueur(String nom, ZoneDeJeu zone) {
		this.nom = nom;
		this.zone = zone;
		this.main = new MainAsListe();
	}
	public String getNom() {
		return nom;
	}
	
	public boolean equals(Joueur joueur) {
		return nom.equals(joueur.getNom());
	}
	
	@Override
	public String toString() {
		return "Joueur: "+nom;
	}
	public MainAsListe getMain() {
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
	
	public void deposer(Borne borne) {
		zone.ajouterBorne(borne);
	}
	
	public int donnerKmParcourus() {
		int res = 0;
		for(Borne b:zone.getCollectionBornes()) {
			res = res+b.getKm();
		}
		return res;
	}
	
    public int donnerLimitationVitesse() {
    	if (zone.getSetBottes().contains(Cartes.PRIORITAIRE) || zone.getPileLimite().isEmpty() || zone.getPileLimite().get(zone.getPileLimite().size() - 1) instanceof FinLimite) {
    	    return 200;
    	} else {
    	        return 50;
    	    }
    }
	
    

	
	
}
