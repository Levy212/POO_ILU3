package jeu;

import java.util.*;

import cartes.*;

public class ZoneDeJeu {
	private ArrayList<Carte> pileLimite, pileBataille;
	private Collection<Borne> collectionBornes;
	private Set<Botte> setBottes;
	
	public ZoneDeJeu() {
        this.pileLimite = new ArrayList<>();
        this.pileBataille = new ArrayList<>();
        this.collectionBornes = new ArrayList<>();
        this.setBottes = new HashSet<>();
    }
	
	public void ajouterCarteLimite(Carte carte) {
        pileLimite.add(carte);
    }

    public Carte retirerCarteLimite() {
        if (!pileLimite.isEmpty()) {
            return pileLimite.remove(pileLimite.size() - 1);
        }
        return null;
    }


    // Méthodes pour manipuler la pile de bataille
    public void ajouterCarteBataille(Carte carte) {
        pileBataille.add(carte);
    }

    public Carte retirerCarteBataille() {
        if (!pileBataille.isEmpty()) {
            return pileBataille.remove(pileBataille.size() - 1);
        }
        return null;
    }

    // Méthodes pour manipuler la collection de bornes
    public void ajouterBorne(Borne carte) {
        collectionBornes.add(carte);
    }

    public boolean retirerBorne(Carte carte) {
        return collectionBornes.remove(carte);
    }

    // Méthodes pour manipuler l'ensemble de bottes
    public void ajouterBotte(Botte carte) {
        setBottes.add(carte);
    }

    public boolean retirerBotte(Carte carte) {
        return setBottes.remove(carte);
    }

    // Méthodes pour accéder aux informations sur la zone de jeu
    public ArrayList<Carte> getPileLimite() {
        return pileLimite;
    }

    public ArrayList<Carte> getPileBataille() {
        return pileBataille;
    }

    public Collection<Borne> getCollectionBornes() {
        return collectionBornes;
    }

    public Set<Botte> getSetBottes() {
        return setBottes;
    }
	
	
	
}
