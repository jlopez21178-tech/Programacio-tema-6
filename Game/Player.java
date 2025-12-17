public class Player {

	private String name;
	private int level;
	private int maxLife;
	private int actLife;
	private int actEnergy;
	private int maxEnergy;
	private int strength; 
	private int exp;
	private int pos;
	
	public Player(String name, int Life, int Energy, int strength) {
		this.name = name;
		this.level = 1;
		this.maxLife = Life;
		this.actLife= this.maxLife;
		this.maxEnergy= Energy;
		this.actEnergy = this.maxEnergy;
		this.strength = strength;
		this.exp = 0;
		this.pos = 0;
	}
	public Player() {}
	
	public int getLvl() { return this.level; }
	public int getLife() {return this.actLife;}
	public int getStrength() { return this.strength;}
	public int getDefense() { return -1;}
	public int getPos() { return this.pos;}
	public String getName() { return this.name;}
	public void setExp(int exp) {this.exp = exp;}
	public void setLife(int Life) {this.actLife += Life;}
	public void setPos(int x) { this.pos += x;}

	
	public int attack() {
		return ((int) (Math.random() * this.strength + (this.strength / 5)));
	}
	
	public void descansar() {
		this.actLife = this.maxLife;
		this.actEnergy = this.maxEnergy;
		System.out.println("L'heroe ha descansat i a recuperat tota la vida.");
	}
	
	public void levelUp() {
		while (this.exp >= 100) {
			this.level++;
			this.maxLife*= 1.2;
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
	

	public void suckBlood(){}
	public int useSpell(){ return -1;}
	public int throwArrow(){ return -1;}
}

