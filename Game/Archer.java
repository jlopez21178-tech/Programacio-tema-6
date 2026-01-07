public class Archer extends Player {
	private int actArrow;
	private int maxArrow;

	public Archer(String nom) {
		super(nom, 90, 30, 10, 1, 2, "¤", "\u001B[92m");
		this.maxArrow = 10;
		this.actArrow = this.maxArrow;
	}

	public int specialAbility() {
		int dmg = 0;
		if (actArrow > 0) {
			this.actArrow--;
			dmg = (int) (Math.random() * super.getStrength() + ((super.getStrength() * super.getLvl())));
			System.out.println("Llances una fletxa que fa " + dmg + " de dany.");
		} else {
			System.out.println("No tens fletxes disponibles.");
		}
		return dmg;
	}

	public void levelUp() {
		super.levelUp();
		this.maxArrow += 5;
	}

	public void descansar() {
		super.descansar();
		this.actArrow = this.maxArrow;
		System.out.println("Has recuperat les teves fletxes.");
	}

	public void mostrarEstat() {
		super.mostrarEstat();
		System.out.println("Fletxes: " + this.actArrow + "/" + this.maxArrow);
	}
}
