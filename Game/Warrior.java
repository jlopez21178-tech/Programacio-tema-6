public class Warrior extends Player {
	private double defense;

	public Warrior(String name) {
		super(name, 120, 30, 50, 2, 1);
		this.defense = 35.0;
	}

	@Override
	public double getDefense() {
		return this.defense;
	}

	public boolean bloquejar() {
		return true;
	}

	public void levelUp() {
		super.levelUp();
		this.defense += 10;
	}

	public void mostrarEstat() {
		super.mostrarEstat();
		System.out.println("Defense: " + this.defense);
	}
}