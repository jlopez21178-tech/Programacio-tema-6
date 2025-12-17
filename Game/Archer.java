public class Archer extends Player{
	private int precision;
	
	public Archer(String nom) {
		super(nom, 90, 60, 30);
		this.precision = 5;
	}
	
	@Override
	public int throwArrow() {
		return ((int) (Math.random() * super.getStrength() + ((super.getStrength() * this.precision * super.getLvl()))));
	}
		
	public void levelUp() {
		super.levelUp();
		this.precision += 5;
	}

	public void mostrarEstat(){
		super.mostrarEstat();
		System.out.println("Precision: " + this.precision);
	}
}
