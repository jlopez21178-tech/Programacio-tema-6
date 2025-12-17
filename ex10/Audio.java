package ex10;

public class Audio extends FitxerMultimedia{
	private int qualitat;
	private String canal;
	
	public Audio(String nom, int durada, double mida, int qua, String canal) {
		super(nom,durada, mida);
		this.qualitat = qua;
		this.canal = canal;
	}
	
	@Override
	void reproduir() {
		System.out.println("Reproduint àudio:");
		System.out.println("Qualitat: " + this.qualitat);
		System.out.println("Canal: " + this.canal);
	}

	public void mostrarInformacio() {
		super.mostrarInformacio();
		System.out.println("Qualitat................" + this.qualitat + "kbps");
		System.out.println("Canal..................." + this.canal);
	}
}
