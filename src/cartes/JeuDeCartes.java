package cartes;

import java.util.ArrayList;
import java.util.Iterator;
import utilis.Utilis;

import cartes.Probleme.Type;

public class JeuDeCartes {
	public static Carte[] typesDeCartes = new Carte[] {
			new Botte(1,Type.FEU),
			new Botte(1,Type.ACCIDENT),
			new Botte(1,Type.CREVAISON),
			new Botte(1,Type.ESSENCE),
			new Attaque(1,Type.FEU),
			new DebutLimite(1),
			new Attaque(1,Type.ACCIDENT),
			new Attaque(1,Type.CREVAISON),
			new Attaque(1,Type.ESSENCE),
			new Parade(1,Type.FEU),
			new FinLimite(1),
			new Parade(1,Type.ACCIDENT),
			new Parade(1,Type.CREVAISON),
			new Parade(1,Type.ESSENCE),
			new Borne(1,25),
			new Borne(1,50),
			new Borne(1,75),
			new Borne(1,100),
			new Borne(1,200)
		};
	
	private int getNbExemplaire(Carte carte) {
		switch (carte.toString()) {
		//Attaque
		case "Feu rouge":
			return 5;
		case "Crevaison":
			return 3;
		case "Panne d'essence":
			return 3;
		case "Accident" :
			return 3;
		case "Limite de vitesse":
			return 4;
		//Parade	
		case "Reparation":
			return 6;
		case "Roue de secours":
			return 6;
		case "Essence":
			return 6;
		case "Feu vert":
			return 14;
		case "Fin de limite de vitesse":
			return 6;
		//Borne
		case "Borne25":
			return 10;
		case "Borne50":
			return 10;
		case "Borne75":
			return 10;
		case "Borne100":
			return 12;
		case "Borne200":
			return 4;
		//Botte
		default:
			return 1;
		}
		
		
	}
	
	
	private ArrayList<Carte> listeCartes = new ArrayList<Carte>();
	
	public JeuDeCartes() {
		for(int i=0;i<typesDeCartes.length;i++) {
			for(int j=0;j<getNbExemplaire(typesDeCartes[i]);j++) {
				listeCartes.add(typesDeCartes[i]);
			}
		}
		listeCartes = Utilis.melanger(listeCartes);
	}
	
	
	public ArrayList<Carte> getListeCartes() {
		return listeCartes;
	}
	
	public boolean checkCount() {
		for(Carte curCarte : typesDeCartes) {
			int nbVoulu = getNbExemplaire(curCarte);
			int nbCur = 0;
			for(Carte curCarteCheck : listeCartes) {
				if(curCarteCheck.equals(curCarte)) nbCur++;
			}
			if(nbCur!=nbVoulu) return false;		
		}
		return true;
	}
}
