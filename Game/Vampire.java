public class Vampire extends Player {

	public Vampire() {
		super("Vampire", 500,  100, 1, 2, "Ð", "\u001B[91m");
	}

	public int specialAbility() {
		super.heal(100);
		return 1;
	}
}
