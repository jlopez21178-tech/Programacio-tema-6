package ex9;

public class Moto extends Vehicle {
	private int cilindrada;
	
	public Moto(String marca, String model, int any, String tipusMotor, int costPerKm, int cilindrada) {
		super(marca, model, any, tipusMotor, costPerKm);
		this.cilindrada = cilindrada;
	}
	
	public void mostrarInformacio() {
		super.mostrarInformacio();
		System.out.println("Cilindrada................" + this.cilindrada);
	}
}
