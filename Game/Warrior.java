public class Warrior extends Player {
	private int rage;
	private int maxRage;
	private double probBlock;

	public Warrior(String name) {
		super(name, 120, 50, 20, 2, 1, "±", "\u001B[96m");
		this.rage = 0;
		this.maxRage = 30;
		this.probBlock = 0.2;
	}

	public int specialAbility() {
		return (int) super.attack() * Math.max(super.getLvl() - 3, 1);
	}

	@Override
	public double attack() {
		double dmg = super.attack();
		dmg *= this.rage + this.maxRage / this.maxRage;
		this.rage = Math.min(rage + 7, maxRage);
		return dmg;
	}

	@Override
	public int recieveDmg(int Life) {
		if (Math.random() < probBlock) {
			return 0;
		}
		this.rage = Math.min(rage + 3, this.maxRage);
		super.recieveDmg(Life);
		return Life;
	}

	public void levelUp() {
		super.levelUp();
		this.maxRage += 5;
		this.probBlock *= 1.3;
	}

	public void mostrarEstat() {
		super.mostrarEstat();
	}
}