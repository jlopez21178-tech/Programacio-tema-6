package ex6;

public class Cpu extends Ordenador {
	private double Hz;
	private int cores;
	
	public Cpu(String nom, String marca, String Componente, double Hz, int cores) {
		super(nom, marca, Componente);
		this.Hz = Hz;
		this.cores = cores;
	}
	
	public Cpu(){

	}
}
