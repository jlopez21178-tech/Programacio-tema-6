package ex2;

public class Banco {

	private String dniTitular;
	private String nomTitular;
	private double saldo;
	
	public Banco(String nom, String dni, double saldo) {
		this.nomTitular = nom;
		this.dniTitular = dni;
		this.saldo = saldo;
	}
	
	public Banco() {
		
	}
	
	public void ingressos(double quant) {
		this.saldo += quant;
	}
}
