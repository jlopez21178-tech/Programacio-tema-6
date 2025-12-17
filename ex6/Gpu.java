package ex6;

public class Gpu extends Ordenador{

	private int memoriaGrafica;
	
	public Gpu(String nom, String marca, String Componente, int memoria) {
		super(nom, marca, Componente);
		this.memoriaGrafica = memoria;
	}
	
	public Gpu() {
		
	}
}
