package testsFonctionnels;

import cartes.*;
import jeu.*;

public class TestJoueur {

	public static void main(String[] args) {
		Carte cartTest0 = new Borne(1,50);
		Carte cartTest1 = new Borne(1,75);
		Carte cartTest2 = new Borne(1,200);
		Carte cartTest3 = new Borne(1,25);
		ZoneDeJeu zone = new ZoneDeJeu();
		zone.ajouterBorne(new Borne(1,50));
		zone.ajouterBorne(new Borne(1,25));
		zone.ajouterBorne(new Borne(1,100));
		zone.ajouterBorne(new Borne(1,200));
		
		
		
		Joueur ali = new Joueur("Ali",zone);
		System.out.println(ali.donnerKmParcourus());

	}

}
