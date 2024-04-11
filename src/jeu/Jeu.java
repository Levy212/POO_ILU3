package jeu;

import java.util.*;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Jeu {
	private Set<Joueur> joueurs;
	private Sabot sabot;
	public Jeu() {
		this.joueurs = new HashSet<>();
		this.sabot = new Sabot(106);
	}
	
	public Sabot getSabot() {
		return sabot;
	}
	
	public void inscrire(Joueur joueur) {
		joueurs.add(joueur);
	}
	
	public void remplirSabot(JeuDeCartes jeu) {
		for(Carte c: jeu.getListeCartes()) {
			sabot.ajouterCarte(c);
		}
	}
	
	public void distribuerCarte() {
		for(int i=0;i<6;i++) {
			for(Joueur j:joueurs) {
				j.donner(sabot.piocher());
			}
		}
	}
	
	public void jouerTour() {
		for(Joueur j:joueurs) {
			System.out.println("Le joueur "+j.getNom()+" a en main :"+j.getMain());
		}
		
		for(Joueur j:joueurs) {
			if(!sabot.estVide()) {
			Carte carte=sabot.piocher();
			j.donner(carte);
			System.out.println("Le Joueur "+j.getNom()+" a pioche "
					+carte);
			carte = j.getMain().iterator().next();
			Coup coup = j.choisirCoup(joueurs);
			if(coup.getJoueurCible()==null) {
				j.retirerDeLaMain(carte);
				System.out.println(j.getNom()+coup);
				
			}
			else {
				coup.getJoueurCible().deposer(coup.getCarte());
				j.retirerDeLaMain(coup.getCarte());
				System.out.println("Le joueur "+j.getNom()+coup);
			}	
			}
		}
		System.out.println("\n");
	}

}
