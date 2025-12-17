package ex9;

public abstract class Vehicle {
	private String marca;
	private String model;
	private int any;
	private String tipusMotor;
	private int costPerKm;
	
	public Vehicle(String marca, String model, int any, String tipusMotor, int costPerKm) {
		this.marca = marca;
		this.model = model;
		this.any = any;
		this.tipusMotor = tipusMotor;
		this.costPerKm = costPerKm;
	}
	
	public void mostrarInformacio() {
		System.out.println("Marca....................." + this.marca);
		System.out.println("Model....................." + this.model);
		System.out.println("Any......................." + this.any);
		System.out.println("Motor....................." + this.tipusMotor);
		System.out.println("Cost/km..................." + this.costPerKm);
	}
	
	public void costPerKm(int km) {
		System.out.println("Cost per a " + km + " km........." + (this.costPerKm * km));
	}
	
	public int getCost() {
		return this.costPerKm;
	}
	
}
