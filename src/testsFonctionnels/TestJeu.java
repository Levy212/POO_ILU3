package testsFonctionnels;
import cartes.*;
import jeu.*;

public class TestJeu {

	public static void main(String[] args) {
		Jeu game = new Jeu();
		Joueur j1 = new Joueur("J1", new ZoneDeJeu());
		Joueur j2 = new Joueur("J2", new ZoneDeJeu());
		Joueur j3 = new Joueur("J3", new ZoneDeJeu());
		game.inscrire(j1);
		game.inscrire(j2);
		game.remplirSabot(new JeuDeCartes());
		game.distribuerCarte();
		
		game.jouerTour();
		System.out.println("Bornes Parcourus par "+j1.getNom()+" : "+j1.getZone().donnerKmParcourus());
		System.out.println("Bornes Parcourus par "+j2.getNom()+" : "+j2.getZone().donnerKmParcourus());
		System.out.println("\n");
		
		
		while((j1.getZone().donnerKmParcourus()<1000&&
				j2.getZone().donnerKmParcourus()<1000)&& (!game.getSabot().estVide())) {
			game.jouerTour();
			System.out.println("Bornes Parcourus par "+j1.getNom()+" : "+j1.getZone().donnerKmParcourus());
			System.out.println("Bornes Parcourus par "+j2.getNom()+" : "+j2.getZone().donnerKmParcourus());
			System.out.println("\n");
		}
		System.out.println("La partie est terminé");

	}

}
