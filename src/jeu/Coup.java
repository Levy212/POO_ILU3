package jeu;

import cartes.Carte;

public class Coup {
	private Carte carte;
	private Joueur joueurCible;
	
	
	public Coup(Carte carte, Joueur joueurCible) {
		this.carte = carte;
		this.joueurCible = joueurCible;
	}


	public Carte getCarte() {
		return carte;
	}



	public Joueur getJoueurCible() {
		return joueurCible;
	}


}
