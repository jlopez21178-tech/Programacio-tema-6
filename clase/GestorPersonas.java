package clase;

public class GestorPersonas {

	public static void main(String[] args) {

		Persona p1 = new Persona();
		Persona p2 = new Persona("Pepito", "12345678E", 33);
		
		System.out.println("El nom de l'objecte p2 és: " + p2.getNom());	
		System.out.println("El dni de l'objecte p2 és: " + p2.getDni());	
		System.out.println("La edat de l'objecte p2 és: " + p2.getEdat());	
		
		
		p1.setNom("Jordi");
		
		p1.caminar();
  		p1.comer();
		
		
		
		System.out.println("El nom de l'objecte p1 és: " + p1.getNom());		
		
		
		p2.mostradDades();
	}

}
