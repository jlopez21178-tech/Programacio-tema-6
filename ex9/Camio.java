package ex9;

public class Camio extends Vehicle {
	private int carregaMaxima;
	
	public Camio(String marca, String model, int any, String tipusMotor, int costPerKm, int carregaMaxima) {
		super(marca, model, any, tipusMotor, costPerKm);
		this.carregaMaxima = carregaMaxima;
	}
	
	public void mostrarInformacio() {
		super.mostrarInformacio();
		System.out.println("Carrega Maxima............" + this.carregaMaxima + "T");
	}
}
