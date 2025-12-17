package ex10;

public class Imatge extends FitxerMultimedia {
	private String format;
	private String dimensions;
	
	public Imatge(String nom, int durada, double mida, String format, String dimen) {
		super(nom,durada, mida);
		this.format = format;
		this.dimensions = dimen;
	}
	
	@Override
	void reproduir() {
		System.out.println("Mostran imatge " + this.format + " de dimensions " + this.dimensions);
	}
	
	public void mostrarInformacio() {
		super.mostrarInformacio();
		System.out.println("Format.................." + this.format);
		System.out.println("Dimensions.............." + this.dimensions);
	}
}
