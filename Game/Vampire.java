public class Vampire extends Player {

	public Vampire() {
		super("Vampire", 500, 200, 100, 1, 2);
	}

	@Override
	public void suckBlood() {
		this.setLife(50);
	}
}
