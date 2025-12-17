package ex5;

public class Professor extends Persona{
	private String materia;
	
	public Professor(String nom, String dni, int edat, String materia) {
		super(nom, dni, edat);
		this.materia = materia;
	}
	
	public Professor() {
		
	}
	
	public void mostrarDades() {
		super.mostrarDades();
		System.out.println("Materia....................." + this.materia);
	}
}
