package cartes;

public class Attaque extends Bataille {

	public Attaque(int n, Type type) {
		super(n, type);
	}
	
	public String toString() {
		
		switch(getType()) {
		
		case ACCIDENT:
			return "Accident";
		case CREVAISON:
			return "Crevaison";
		case ESSENCE:
			return "Panne d'essence";
		case FEU:
			return "Feu rouge";
		default:
			return "Erreur";
		}
	}
	

	

}
