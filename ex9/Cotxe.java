package ex9;

public class Cotxe extends Vehicle {
	private int capacitat;
	
	public Cotxe(String marca, String model, int any, String tipusMotor, int costPerKm, int capacitat) {
		super(marca, model, any, tipusMotor, costPerKm);
		this.capacitat = capacitat;
	}
	
	public void mostrarInformacio() {
		super.mostrarInformacio();
		System.out.println("Capacitat................." + this.capacitat + "L");
	}

}
