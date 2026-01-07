public class Golem extends Player {

	private double defense;

	public Golem() {
		super("Golem", 200, 70,100, 3, 3, "▓", "\u001B[91m");
	}

	public double getDefense() {
		return this.defense;
	}

	public void mostrarEstat() {
		super.mostrarEstat();
		System.out.println("Defense: " + this.defense);
	}

}
