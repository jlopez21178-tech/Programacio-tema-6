public class Golem extends Player{

	private int defense;
	
	public Golem() {
		super("Golem", 100, 100, 50);		
		this.defense = 100;
	}

	@Override
	public int getDefense(){ return this.defense;}

	public void mostrarEstat(){
		super.mostrarEstat();
		System.out.println("Defense: " + this.defense);
	}


}
