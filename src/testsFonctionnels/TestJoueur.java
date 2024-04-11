package testsFonctionnels;

import cartes.*;
import jeu.*;

public class TestJoueur {

	public static void main(String[] args) {
		ZoneDeJeu zone = new ZoneDeJeu();
		zone.ajouter(new Borne(1,50));
		zone.ajouter(new Borne(1,25));
		zone.ajouter(new Borne(1,100));
		zone.ajouter(new Borne(1,200));
		
		
		
		System.out.println(zone.donnerKmParcourus());

	}

}
