package cartes;

import java.util.Objects;

public abstract class Carte {
	private int nombre;
	
	protected Carte(int n) {
		this.nombre = n;
	}
	
	public int getNombre() {
		return nombre;
	}
	
    public boolean equals(Carte carte) {
    	return this.toString().equals(carte.toString());
    }
}
