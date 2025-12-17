package ex5;

public class gestorPersona {

	public static void main(String[] args) {
		
		Persona[] Persona = {
				new Alumnes("Jordi", "123421F", 20, "FP"),
				new Alumnes("sjdfi", "214789F", 19, "FP"),
				new Alumnes("Alberto", "1241908F", 20, "FP"),
				new Professor("Miquel", "123728941F", 99, "Programacio")
		};
		
		for(int i = 0; i < Persona.length; i++) {
			Persona[i].mostrarDades();
			System.out.println();
		}
		
		
		

	}

}
