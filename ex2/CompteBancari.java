package ex2;

public class CompteBancari {

	private String dniTitular;
	private String nomTitular;
	private double saldo;
	
	public CompteBancari(String nom, String dni, double saldo) {
		this.nomTitular = nom;
		this.dniTitular = dni;
		this.saldo = saldo;
	}
	
	public CompteBancari() {
		
	}
	
	public String getNom() {
		return this.nomTitular;
	}
	
	public String getDni() {
		return this.dniTitular;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void mostrarDades() {
		System.out.println("Dades del compte bancari:");
		System.out.println("Nom................" + this.nomTitular);
		System.out.println("Dni................" + this.dniTitular);
		System.out.println("Saldo.............." + this.saldo);
	}
		
	public void mostrarSaldo() {
		System.out.println("Saldo......." + this.saldo);
	}
	
	public void ingressar(double quant) {
		this.saldo += quant;
	}
	
	public void retirar(double quant) {
		this.saldo -= quant;
	}
	
	
}