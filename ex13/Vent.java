package ex13;

public class Vent extends InstrumentsMusicals implements Sons{

	public Vent(String nom) {
		super(nom);
	}
	
	@Override
	public void soProduit() {
		System.out.println("fiuuuuuuuuuuuuu");		
	}
	
	@Override
	public String tocar() {
		return "Tocant instrument de vent";
	}
	
	

}
