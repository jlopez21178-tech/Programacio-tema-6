package clase;

public class Persona {

	private String nom;
	private String dni;
	private int edad;
	
	public Persona(String nom, String dni, int edad) {
		this.nom = nom;
		this.dni = dni;
		this.edad = edad;
	}
	
	public Persona() {
		
	}
	
	public void comer() {
		System.out.println("Soy " + this.nom + " y estoy comiendo");
	}
	
	public void caminar() {
		System.out.println("Soy " + this.nom + " y estoy caminando");
	}
	
	public void mostradDades() {
		System.out.println("Visualitzacio de dades de la persona:");
		System.out.println("Nom..............." + this.nom);
		System.out.println("DNI..............." + this.dni);
		System.out.println("Edat.............." + this.edad);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	public String getDni() {
		return this.dni;
	}
	public int getEdat() {
		return this.edad;
	}
}