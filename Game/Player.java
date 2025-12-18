public class Player {

	private String name;
	private int level;
	private double maxLife;
	private double actLife;
	private double actEnergy;
	private double maxEnergy;
	private int strength;
	// Weakness explanation: 0 - none, 1 - Slash damage, 2 - Penetration damage, 3 -
	// Contundent damage, 4 - All.
	private int weakness;
	private int attackType;
	private double exp;
	private int pos;

	public Player(String name, double Life, double Energy, int strength, int weakness, int attackType) {
		this.name = name;
		this.level = 1;
		this.maxLife = Life;
		this.actLife = this.maxLife;
		this.maxEnergy = Energy;
		this.actEnergy = this.maxEnergy;
		this.strength = strength;
		this.weakness = weakness;
		this.attackType = attackType;
		this.exp = 0;
		this.pos = 0;
	}

	public Player() {
	}

	public int getLvl() {
		return this.level;
	}

	public double getLife() {
		return this.actLife;
	}

	public int getStrength() {
		return this.strength;
	}

	public double getDefense() {
		return -1;
	}

	public int getPos() {
		return this.pos;
	}

	public int getWeaknes() {
		return this.weakness;
	}

	public int getType() {
		return this.attackType;
	}

	public String getName() {
		return this.name;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}

	public void setLife(double Life) {
		this.actLife += Life;
	}

	public void setPos(int x) {
		this.pos += x;
	}

	public double attack() {
		return (Math.random() * this.strength + (this.strength / 5));
	}

	public void descansar() {
		this.actLife = this.maxLife;
		this.actEnergy = this.maxEnergy;
		System.out.println("L'heroe ha descansat i a recuperat tota la vida.");
	}

	public void levelUp() {
		while (this.exp >= 100) {
			this.level++;
			this.maxLife *= 1.2;
			this.maxEnergy *= 1.2;
			this.strength *= 1.3;
			this.exp -= 100;
		}
	}

	public void mostrarEstat() {
		System.out.println("Name: " + this.name);
		System.out.println("Level: " + this.level);
		System.out.println("Life: " + this.actLife + "/" + this.maxLife);
		System.out.println("Energy: " + this.actEnergy + "/" + this.maxEnergy);
		System.out.println("strength: " + this.strength);
	}

	public void suckBlood() {
	}

	public int useSpell() {
		return -1;
	}

	public int throwArrow() {
		return -1;
	}
}
