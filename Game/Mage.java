public class Mage extends Player {
	private int spellSlots;
	private int maxSpellSlots;

	public Mage(String nom) {
		super(nom, 50, 20, 10, 1, 3);
		this.spellSlots = 4;
		this.maxSpellSlots = this.spellSlots;
	}

	@Override
	public int useSpell() {
		if (this.spellSlots > 0) {
			spellSlots--;
			return ((int) (Math.random() * super.getLvl() * 50 + (super.getLvl() * this.maxSpellSlots + 20)));
		} else {
			return 0;
		}
	}

	public void levelUp() {
		super.levelUp();
		if (super.getLvl() % 2 == 0) {
			this.maxSpellSlots++;
		}
	}

	public void mostrarEstat() {
		super.mostrarEstat();
		System.out.println("Spell slots: " + this.spellSlots + "/" + this.maxSpellSlots);
	}
}
