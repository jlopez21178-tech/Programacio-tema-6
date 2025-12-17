package ex5;

public class Persona {
	private String nom;
	private String dni;
	private int edat;
	
	public Persona(String nom, String dni, int edat) {
		this.nom = nom;
		this.dni = dni;
		this.edat = edat;
	}
	
	public Persona() {
		
	}
	
	public void mostrarDades() {
		System.out.println("Nom........................." + this.nom);
		System.out.println("DNI........................." + this.dni);
		System.out.println("Edat........................" + this.edat);
	}
}

