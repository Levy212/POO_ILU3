package testsFonctionnels;

import cartes.*;
import cartes.Probleme.Type;
import jeu.*;

public class testZoneDeJeu {

	public static void main(String[] args) {
		Carte cartTest0 = new Attaque(1,Type.FEU);
		Carte cartTest1 = new Botte(1,Type.FEU);
		Bataille cartTest2 = new Attaque(1,Type.ACCIDENT);
		Botte cartTest3 = new Botte(1,Type.ACCIDENT);
		ZoneDeJeu zone = new ZoneDeJeu();
		zone.ajouter(Cartes.FEU_ROUGE);
		
		
		
		Joueur ali = new Joueur("Ali",zone);
		//System.out.println(ali.donnerKmParcourus());
		System.out.println(zone.estBloque());
		zone.ajouter(Cartes.PRIORITAIRE);
		System.out.println(zone.estBloque());
		zone.ajouter(cartTest2);
		System.out.println(zone.estBloque());
		zone.ajouter(cartTest3);
		System.out.println(zone.estBloque());
		zone.ajouter(new Attaque(1,Type.ESSENCE));
		System.out.println(zone.estBloque());
		zone.ajouter(new Parade(1,Type.ESSENCE));
		System.out.println(zone.estBloque());
		zone.retirerBotte(cartTest3);
		zone.retirerBotte(Cartes.PRIORITAIRE);
		System.out.println(zone.estBloque());
		zone.ajouter(Cartes.FEU_VERT);
		System.out.println(zone.estBloque());
		System.out.println(zone.getSetBottes());
		System.out.println(zone.getPileBataille());
		
	}

}
