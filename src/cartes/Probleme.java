package cartes;

public abstract class Probleme extends Carte {
	public enum Type{
		FEU, ESSENCE, CREVAISON, ACCIDENT
	}
	
	private Type type;

	protected Probleme(int n, Type type) {
		super(n);
		this.type = type;
	}

	public Type getType() {
		return type;
	}
	

}
