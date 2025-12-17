package ex10;

public abstract class FitxerMultimedia {
	private String nom;
	private int durada;
	private double midaMB;
	
	public FitxerMultimedia(String nom, int durada, double mida) {
		this.nom = nom;
		this.durada = durada;
		this.midaMB = mida;
	}
	
	public void mostrarInformacio() {
		System.out.println("Nom....................." + this.nom);
		System.out.println("Durada.................." + this.durada + "s");
		System.out.println("MB......................" + this.midaMB + "MB");
	}
	
	void reproduir() {
		System.out.println("Reproduint musica");
	}
}
