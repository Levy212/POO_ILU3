package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int n, int km) {
		super(n);
		this.km = km;
	}
	
	public String toString() {
		switch (km) {
		case 25: return "Borne25";
		case 50: return "Borne50";
		case 75: return "Borne75";
		case 100: return "Borne100";
		case 200: return "Borne 200";
		default:return "Borne";
		}	
	}

	public int getKm() {
		return km;
	}

}
