package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int n, int km) {
		super(n);
		this.km = km;
	}
	
	public String toString() {
		return "Borne"+km;	
	}

}
