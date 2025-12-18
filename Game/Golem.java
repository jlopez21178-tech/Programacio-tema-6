public class Golem extends Player {

	private double defense;

	public Golem() {
		super("Golem", 100, 100, 50, 3, 3);
		this.defense = 100.0;
	}

	@Override
	public double getDefense() {
		return this.defense;
	}

	public void mostrarEstat() {
		super.mostrarEstat();
		System.out.println("Defense: " + this.defense);
	}

}
