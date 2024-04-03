package jeu;
import cartes.*;
import cartes.Probleme.Type;


public interface Cartes {
    Botte PRIORITAIRE = new Botte(1,Type.FEU);
    Attaque FEU_ROUGE = new Attaque(1,Type.FEU);
    Parade FEU_VERT = new Parade(1,Type.FEU);
    
    	
}
