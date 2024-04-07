package jeu;

import java.util.*;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Jeu {
	private Set<Joueur> joueurs;
	private Sabot sabot;
	public Jeu() {
		this.joueurs = new HashSet<>();
		this.sabot = new Sabot(107);
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
		
		if(!sabot.estVide()) {
		for(Joueur j:joueurs) {
			Carte carte=sabot.piocher();
			j.donner(carte);
			System.out.println("Le Joueur "+j.getNom()+" a pioche "
					+carte);
			carte = j.getMain().iterator().next();
			HashSet<Coup> coupP = j.coupsPossible(joueurs);
			if(coupP.isEmpty()) {
				j.retirerDeLaMain(carte);
				Coup coup =new Coup(carte, null);
				coup.getJoueurCible().deposer(carte);
				
			}
			else {
				for(Coup c:coupP) {
					c.getJoueurCible().deposer(c.getCarte());
					j.retirerDeLaMain(c.getCarte());
					System.out.println("Le joueur "+j.getNom()+c);
					break;
				}
			}
			
			
		}}
		else {
			System.out.println("La partie est terminé");
		}
	}

}
