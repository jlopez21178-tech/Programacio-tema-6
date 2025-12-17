package ex12;

public class Cua {
	
	private Persona[] cua = new Persona[20];
	private int index = 0;
	
	public void afegir(String nom, String dni) {
		if(index <= cua.length) {
			this.cua[index++] = new Persona(nom, dni);			
		} else {
			System.out.println("Error");
		}
	}
	
	public void treurePersona() {
		Persona[] novaCua = new Persona[20];
		
		for(int i = 1; i < index; i++) {
			novaCua[i - 1] = cua[i];
		}
		index--;
		cua = novaCua;
	}
	
	public void estatCua() {
		if(index == 0) {
			System.out.println("Cua vuida");
		} else {
			System.out.println("Quantitat de persones en cua: " + (index));
			for(int i = 0; i < index; i++) {
				System.out.println("Posicio en la cua: " + (i + 1));
				cua[i].mostrarDades();
			}			
		}
	}
}
