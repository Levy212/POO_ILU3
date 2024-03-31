package cartes;

public class Parade extends Bataille {

	public Parade(int n, Type type) {
		super(n, type);
	}
	
	public String toString() {
		switch(getType()) {
		case ACCIDENT:
			return "Reparation";
		case CREVAISON:
			return "Roue de secours";
		case ESSENCE:
			return "Essence";
		case FEU:
			return "Feu vert";
		default:
			return "Erreur";
		
		}
	}

}
