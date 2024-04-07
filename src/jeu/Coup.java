package jeu;

import java.util.Objects;

import cartes.Attaque;
import cartes.Carte;
import cartes.DebutLimite;

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
	
	public boolean estValide(Joueur joueur) {
		if(joueurCible==null) {
			return true;
		}
		else if(!joueurCible.equals(joueur) && (carte instanceof Attaque || carte instanceof DebutLimite)){
			return true;
		}
		else {
			return joueurCible.equals(joueur);
		}
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coup coup = (Coup) o;
        return Objects.equals(carte, coup.carte) &&
                Objects.equals(joueurCible, coup.joueurCible);
    }
	
	
	@Override
	public String toString() {
		if(joueurCible==null) {
			return " a choisi de rendre "+ carte;
		}
		return " a choisi de deposer " + carte + ", dans la zone de " + joueurCible;
	}


	@Override
    public int hashCode() {
        return Objects.hash(carte, joueurCible);
    }


}
