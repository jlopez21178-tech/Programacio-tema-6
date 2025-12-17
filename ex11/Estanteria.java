package ex11;

public class Estanteria{
	private Llibre[] estanteria = new Llibre[30];
	private int index = 0;

	public Estanteria() {}

	public void afegirLlibre(String autor, String titol, int pag, String genere) {
		if(index < 30) {
			estanteria[index].setAutor(autor);
			estanteria[index].setTitol(titol);
			estanteria[index].setPag(pag);
			estanteria[index].setGenere(genere);
			index++;
		} else {
			System.out.println("Estanteria plena");
		}
	}

	public void eliminarLibro(String titol) {
		Llibre[] nuevaEsta = new Llibre[estanteria.length];
		int j = 0;
		
		for(int i = 0; i < index; i++) {
			if(estanteria[i].getTitol().equals(titol)) {
				estanteria[i].setTitol("");
			}
		}

		for(int i = 0; i < index; i++) {
			if(!estanteria[i].getTitol().equals("")) {
				nuevaEsta[j] = estanteria[i];
				j++;
			}
		}
		
		estanteria = nuevaEsta;
		index = j; 
	}
	
	public void mostrarDatos(String titol) {
		for(int i = 0; i < index; i++) {
			if(estanteria[i].getTitol().equals(titol)) {
				System.out.println(estanteria[i].toString());				
			}
		}
	}
}
