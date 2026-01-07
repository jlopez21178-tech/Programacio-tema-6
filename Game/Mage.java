public class Mage extends Player {
	private int spellSlots;
	private int maxSpellSlots;

	public Mage(String nom) {
		super(nom, 50, 10,5, 1, 3, "╠", "\u001B[95m");
		this.spellSlots = 4;
		this.maxSpellSlots = this.spellSlots;
	}

	@Override
	public int specialAbility() {
		int dmg = 0;
		if (this.spellSlots > 0) {
			spellSlots--;
			dmg = (int) (Math.random() * super.getLvl() * 50 + (super.getLvl() * this.maxSpellSlots));
			System.out.println("Conjures una bolla de foc que fa " + dmg + " de dany.");
		} else{
			System.out.println("No tens espais de conjur disponibles");
		}
		return dmg;
	}

	public void levelUp() {
		super.levelUp();
		if (super.getLvl() % 2 == 0) {
			this.maxSpellSlots++;
		}
	}

	public void descansar() {
		super.descansar();
		this.spellSlots = this.maxSpellSlots;
		System.out.println("S'han recuperat tots els espais de conjurs.");
	}

	public void mostrarEstat() {
		super.mostrarEstat();
		System.out.println("Spell slots: " + this.spellSlots + "/" + this.maxSpellSlots);
	}
}
