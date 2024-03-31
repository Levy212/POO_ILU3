package cartes;

public class Botte extends Probleme {

	public Botte(int n, Type type) {
		super(n, type);
	}
	
	public String toString() {
		switch(getType()) {
		case ACCIDENT:
			return "As du volant";
		case CREVAISON:
			return "Increvable";
		case ESSENCE:
			return "Citerne d'essence";
		case FEU:
			return "Vehicule prioritaire";
		default:
			return "Erreur";
		
		}
	}

}
