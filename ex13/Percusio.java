package ex13;

public class Percusio extends InstrumentsMusicals implements Sons{

	public Percusio(String nom) {
		super(nom);
	}
	
	@Override
	public void soProduit() {
		System.out.println("pom-pom-pooooom");
	}
	
	@Override
	public String tocar() {
		return "Tocant instrument de percusio";
	}
}
