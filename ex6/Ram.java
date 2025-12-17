package ex6;

public class Ram extends Ordenador{
	
	private int memoriaRam;
	
	public Ram(String nom, String marca, String Componente, int memoria) {
		super(nom, marca, Componente);
		this.memoriaRam = memoria;
	}
	
	public Ram() {
		
	}

}
