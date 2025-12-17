public class Warrior extends Player{
	private int defense;

	public Warrior(String name) {
		super(name, 120, 30, 50 );
		this.defense = 35;
	}
	
	@Override
	public int getDefense(){ return this.defense;}
	
	public boolean bloquejar() {
		return true;
	}

	public void levelUp() {
		super.levelUp();
		this.defense += 5;
	}
	
	public void mostrarEstat(){
		super.mostrarEstat();
		System.out.println("Defense: " + this.defense);
	}
}