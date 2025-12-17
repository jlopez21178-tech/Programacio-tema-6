package ex5;

public class Alumnes extends Persona{
	private String nivellAcademic;
	
	public Alumnes(String nom, String dni, int edat, String nivell) {
		super(nom, dni, edat);
		this.nivellAcademic = nivell;
	}
	
	public Alumnes() {
		
	}
	
	public void mostrarDades() {
		super.mostrarDades();
		System.out.println("Nivell Academic............." + this.nivellAcademic);
	}
}
