public class Player {

	private String name;
	private int level;
	private double maxLife;
	private double actLife;
	private int actActionPoint;
	private int maxActionPoint;
	private int strength;
	// Weakness explanation: 0 - none, 1 - Slash damage, 2 - Penetration damage,
	// 3 - Contundent damage, 4 - All.
	private int weakness;
	private int attackType;
	private double exp;
	private int row;
	private int column;
	private String icon;
	private String color;

	public Player(String name, double Life, int strength, int weakness, int attackType, String icon,
			String color) {
		this.name = name;
		this.level = 1;
		this.maxLife = this.actLife = Life;
		this.maxActionPoint = this.actActionPoint = 1;
		this.strength = strength;
		this.weakness = weakness;
		this.attackType = attackType;
		this.icon = icon; this.color = color;
		this.exp = 0;
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

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public int getWeaknes() {
		return this.weakness;
	}

	public int getType() {
		return this.attackType;
	}

	public int getActionPoint() {
		return this.actActionPoint;
	}

	public int getMaxActionPoint() {
		return this.maxActionPoint;
	}

	public String getName() {
		return this.name;
	}

	public String getIcon() {
		return this.icon;
	}

	public String getColor() {
		return this.color;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}

	public void recieveDmg(double Life) {
		this.actLife -= Life;
	}

	public void heal(double x) {
		this.actLife = Math.min(this.actLife + x, this.maxLife);
	}

	public void resetActionPoint() {
		this.actActionPoint = this.maxActionPoint;
	}

	public void useActionPoint() {
		--this.actActionPoint;
	}

	public void setRow(int x) {
		this.row = x;
	}

	public void setColumn(int x) {
		this.column = x;
	}

	public double attack() {
		return (Math.random() * this.strength + (this.strength / 3));
	}

	public boolean isDead() {
		return this.actLife <= 0;
	}

	public void descansar() {
		this.actLife = this.maxLife;
		System.out.println("L'heroe ha descansat i a recuperat tota la vida.");
	}

	public void levelUp() {
		while (this.exp >= 100) {
			this.level++;
			this.maxLife *= 1.2;
			this.strength *= 1.3;
			this.exp -= 100;
			if (this.getLvl() % 2 == 0) {
				this.maxActionPoint++;
			}
		}
	}

	public void mostrarEstat() {
		System.out.println("Name: " + this.name);
		System.out.println("Level: " + this.level);
		System.out.println("Action Point: " + this.actActionPoint + "/" + this.maxActionPoint);
		System.out.println("Life: " + this.actLife + "/" + this.maxLife);
		System.out.println("Strength: " + this.strength);
	}

	public int specialAbility() {
		return -1;
	}
}
