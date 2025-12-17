package ex7;

public abstract class Musica {
	private double durada;
	public abstract void reproduir();

	public Musica(double durada) {
		this.durada = durada;
	}
	
	public Musica() {
		
	}
}