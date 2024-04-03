package jeu;

import java.util.*;

import cartes.Carte;

public class MainAsListe implements IMain {
	
	private ArrayList<Carte> main;
	
	public MainAsListe() {
		this.main = new ArrayList<Carte>();
	}
	

	@Override
	public void prendre(Carte carte) {
		main.add(carte);
		
	}

	@Override
	public void jouer(Carte carte) {
		assert(main.contains(carte));
		main.remove(carte);
	}

	@Override
	public Iterator<Carte> iterator() {
		return main.iterator();
	}


	@Override
	public String toString() {
		return "MainAsListe [main=" + main + "]";
	}
	
	

}