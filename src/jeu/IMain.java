package jeu;

import java.util.Iterator;

import cartes.Carte;

public interface IMain {
    void prendre(Carte carte);
    void jouer(Carte carte);
    Iterator<Carte> iterator();
}
