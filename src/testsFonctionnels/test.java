package testsFonctionnels;
import java.util.ArrayList;

import java.util.Iterator;

import cartes.*;
import cartes.Probleme.Type;
import jeu.*;
import utilis.Utilis;


public class test {
	
	public static void main(String[] args) {
		System.out.println("///TEST SABOT///");
		Sabot sabot = new Sabot(7);
		sabot.ajouterFamilleCarte(new Attaque(3,Type.ACCIDENT));
		sabot.ajouterFamilleCarte(new Parade(3,Type.ACCIDENT));
		sabot.ajouterFamilleCarte(new Botte(1,Type.ACCIDENT));
		//sabot.piocher();
		
		for(int i=0;i<7;i++) {
			System.out.println("je pioche "+sabot.piocher().toString());
		}
		System.out.println("\n");
		
		
		sabot.ajouterFamilleCarte(new Attaque(3,Type.ACCIDENT));
		sabot.ajouterFamilleCarte(new Parade(3,Type.ACCIDENT));
		sabot.ajouterFamilleCarte(new Botte(1,Type.ACCIDENT));
		Iterator<Carte> I = sabot.iterator();
		for(int i=0;i<7;i++) {
			System.out.println("je pioche "+I.next());
			I.remove();
			//sabot.ajouterFamilleCarte(new Botte(1,Type.ACCIDENT));
			
		}
		System.out.println("\n");
		
		
		System.out.println("///TEST EQUALS///");
		System.out.println(new Attaque(3,Type.ACCIDENT).equals(new Attaque(4,Type.ACCIDENT)));
		System.out.println(new Attaque(3,Type.ACCIDENT).equals(new Attaque(4,Type.CREVAISON)));
		System.out.println("\n");
		
		System.out.println("///TEST JEU DE CARTES///");
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println(jeu.getListeCartes());
		System.out.println(jeu.checkCount());
		//jeu.getListeCartes().remove(0);
		System.out.println(jeu.checkCount());
		System.out.println("\n");
		
		
		JeuDeCartes jeu2 = new JeuDeCartes();
		ArrayList<Carte> listeCarteNonMelangee = jeu2.getListeCartes();
		ArrayList<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = Utilis.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? "
		+ Utilis.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = Utilis.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? " + Utilis.verifierRassemblement(listeCartes));
		
		System.out.println("\n");
		
		JeuDeCartes jeu3 = new JeuDeCartes();
		System.out.println("Le mélange a le bon compte ? "+jeu3.checkCount());
		
		
		
		
	}


}
