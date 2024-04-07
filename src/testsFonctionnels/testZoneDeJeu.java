package testsFonctionnels;

import cartes.*;
import cartes.Probleme.Type;
import jeu.*;

public class testZoneDeJeu {

	public static void main(String[] args) {
		Carte cartTest0 = new Attaque(1,Type.FEU);
		Carte cartTest1 = new Botte(1,Type.FEU);
		Bataille accident = new Attaque(1,Type.ACCIDENT);
		Botte as = new Botte(1,Type.ACCIDENT);
		Bataille panneEssence = new Attaque(1, Type.ESSENCE);
		Bataille essence = new Parade(1, Type.ESSENCE);
		Carte borne100 = new Borne(1,100);
		Carte borne25 = new Borne(1,25);
		Carte limite = new DebutLimite(1);
		Carte finLimite = new FinLimite(1);
		ZoneDeJeu zone = new ZoneDeJeu();
		zone.ajouter(Cartes.FEU_ROUGE);
		
		
		
		Joueur ali = new Joueur("Ali",zone);
		//System.out.println(ali.donnerKmParcourus());
		System.out.println(zone.estBloque());
		zone.ajouter(Cartes.PRIORITAIRE);
		System.out.println(zone.estBloque());
		zone.ajouter(accident);
		System.out.println(zone.estBloque());
		zone.ajouter(as);
		System.out.println(zone.estBloque());
		zone.ajouter(new Attaque(1,Type.ESSENCE));
		System.out.println(zone.estBloque());
		zone.ajouter(new Parade(1,Type.ESSENCE));
		System.out.println(zone.estBloque());
		zone.retirerBotte(as);
		zone.retirerBotte(Cartes.PRIORITAIRE);
		System.out.println(zone.estBloque());
		zone.ajouter(Cartes.FEU_VERT);
		System.out.println(zone.estBloque());
		System.out.println(zone.getSetBottes());
		System.out.println(zone.getPileBataille());
		
		System.out.println("\n");
		System.out.println("TP4////TEST/////TP4");
		ZoneDeJeu zone1 = new ZoneDeJeu();
		Joueur mugs = new Joueur("Mugs", zone1);
		
		System.out.println("Déposer "+Cartes.FEU_ROUGE+" : depot ?"
				+zone1.deposer(Cartes.FEU_ROUGE)
				+", bloqué ? "+zone1.estBloque());
		
		System.out.println("Déposer "+accident+" : depot ?"
				+zone1.deposer(accident)
				+", bloqué ? "+zone1.estBloque());
		
		System.out.println("Déposer "+as+" : depot ?"
				+zone1.deposer(as)
				+", bloqué ? "+zone1.estBloque());
		
		System.out.println("Déposer "+panneEssence+" : depot ?"
				+zone1.deposer(panneEssence)
				+", bloqué ? "+zone1.estBloque());
		
		System.out.println("Déposer "+essence+" : depot ?"
				+zone1.deposer(essence)
				+", bloqué ? "+zone1.estBloque());
		
		System.out.println("Déposer "+Cartes.FEU_VERT+" : depot ?"
				+zone1.deposer(Cartes.FEU_VERT)
				+", bloqué ? "+zone1.estBloque());
		
		System.out.println("Déposer "+borne100+" : depot ?"
				+zone1.deposer(borne100)
				+", bloqué ? "+zone1.estBloque());
	
		System.out.println("Déposer "+limite+" : depot ?"
				+zone1.deposer(limite)
				+", bloqué ? "+zone1.estBloque());
		
		System.out.println("Déposer "+borne100+" : depot ?"
				+zone1.deposer(borne100)
				+", bloqué ? "+zone1.estBloque());
		
		System.out.println("Déposer "+borne25+" : depot ?"
				+zone1.deposer(borne25)
				+", bloqué ? "+zone1.estBloque());
		
		System.out.println("Déposer "+finLimite+" : depot ?"
				+zone1.deposer(finLimite)
				+", bloqué ? "+zone1.estBloque());
		
		System.out.println("Déposer "+borne100+" : depot ?"
				+zone1.deposer(borne100)
				+", bloqué ? "+zone1.estBloque());
		
		
		
		
		
		
	
		
	}

}
