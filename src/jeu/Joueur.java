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
	
    
    public boolean estBloque() {
    	Carte sommetBataille = zone.getPileBataille().get(zone.getPileBataille().size()-1);
    	boolean prioritaire = zone.getSetBottes().contains(Cartes.PRIORITAIRE);
    	boolean attaqueFeuSommetBataille = sommetBataille instanceof Attaque && ((Attaque) sommetBataille).getType().equals(Type.FEU);
    	boolean attaqueAccSommetBataille = sommetBataille instanceof Attaque && ((Attaque) sommetBataille).getType().equals(Type.ACCIDENT);
    	boolean attaqueCrevSommetBataille = sommetBataille instanceof Attaque && ((Attaque) sommetBataille).getType().equals(Type.CREVAISON);
    	boolean attaqueEssenceSommetBataille = sommetBataille instanceof Attaque && ((Attaque) sommetBataille).getType().equals(Type.ESSENCE);
    	boolean paradeFeuSommetBataille = sommetBataille instanceof Parade && ((Parade) sommetBataille).getType().equals(Type.FEU);

    	if(zone.getPileBataille().isEmpty() && prioritaire) {
    		return false;
    	}
    	if(sommetBataille.toString().equals("Feu vert") || (sommetBataille instanceof Parade &&  prioritaire)) {
    		return false;
    	}
    	if(attaqueFeuSommetBataille && prioritaire) {
    		return false;
    	}
    	if(attaqueAccSommetBataille && prioritaire) {
    		for(Botte c : zone.getSetBottes()) {
    			if(c.getType().equals(Type.ACCIDENT)) {
    				return false;
    			}
    		}
    	}
    	if(attaqueCrevSommetBataille && prioritaire) {
    		for(Botte c : zone.getSetBottes()) {
    			if(c.getType().equals(Type.CREVAISON)) {
    				return false;
    			}
    		}
    	}
    	if(attaqueEssenceSommetBataille && prioritaire) {
    		for(Botte c : zone.getSetBottes()) {
    			if(c.getType().equals(Type.ESSENCE)) {
    				return false;
    			}
    		}
    	}
    	
    	
    	
    	
    	return true;
    	
    }

	
	
}
