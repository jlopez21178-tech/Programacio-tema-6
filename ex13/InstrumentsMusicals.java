package ex13;

public abstract class InstrumentsMusicals implements Sons {

	private String nom;
	
	public InstrumentsMusicals(String nom) {
		this.nom = nom;
	}
	
	String tocar() {
		return "Tocant musica";
	}
}
