package ex11;

public class Biblioteca{
	private Estanteria[] biblioteca = new Estanteria[100];
	private int index = 0;
	
	public Biblioteca(Estanteria estanteria) {
		biblioteca[index] = estanteria;
	}
}
