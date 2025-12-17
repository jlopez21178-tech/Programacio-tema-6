package ex12;

public class Persona {

	private String nom;
	private String dni;
	
	public Persona(String nom, String dni) {
		this.nom = nom;
		this.dni = dni;
	}
	
	public void mostrarDades() {
		System.out.println("Nom........." + this.nom);
	}
}
