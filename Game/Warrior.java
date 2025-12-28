public class Warrior extends Player {
	private double defense;

	public Warrior(String name) {
		super(name, 120, 50, 2, 1, "±", "\u001B[96m");
		this.defense = 35.0;
	}

	public double getDefense() {
		return this.defense;
	}

	public int specialAbility() {
		System.out.println("Bloquejaras el següent atac.");
		return 0;
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