import java.util.Scanner;

public class Gameplay {
	public static Player hero;
	public static Player monst;
	public static int rest = 0;
	public static boolean blocked = false;
	public static final String RESET = "\u001B[0m";
	public static final int SIZE = 7;
	public static Map map = new Map(SIZE);

	public static void main(String[] args) {

		System.out.println("\u001B[91m\t=====================================");
		System.out.println("\t=                                   =");
		System.out.println("\t =        HEROES & monstS        =");
		System.out.println("\t=                                   =");
		System.out.println("\t=====================================" + RESET);
		System.out.println(
				"\nEl teu regne va ser masacrat per un deu maligne fa 10 anys. \nAra et trobes de cami cap al deu en cerca de vengança.\nEs hora de que decideixis quina classe de heroe vols ser.\n");
		crearPersonatge();
		Utils.cleanScreen();
		System.out.println(
				"\nAra mateix et trobes en un bosque molt perillos, no es recomable descansar\nSi descansas molt seguit es posible que et trobis amb enemics més perillosos");

		Utils.sleep(3000);
		Utils.cleanScreen();
		int option;
		do {
			spawnMonster();
			map.startGame(hero, monst);
			System.out.println("\n\nHa aparegut un monstre en el camí. \nEs un " + monst.getName() + " i es de nivell "
					+ monst.getLvl());
			Utils.sleep(2000);
			Utils.cleanScreen();
			do {
				do {
					map.clear();
					map.placePlayer(hero);
					map.placePlayer(monst);
					map.showMap();
					System.out.println();
					System.out.println("=== Accions disponibles ===");
					System.out.println("1. Moure");
					System.out.println("2. Atacar");
					System.out.println("3. Abilitat especial");
					System.out.println("4. Descansar");
					System.out.println("5. Mostrar estat");
					System.out.println("6. Mostrar estat del enemic");
					System.out.println("0. Sortir");
					option = Utils.validateInt(0, 6);
					switch (option) {
						case 1 -> {
							map.moveHero(hero);
							hero.useActionPoint();
						}
						case 2 -> {
							heroAttack();
							hero.useActionPoint();
						}
						case 3 -> {
							specialAbility();
							hero.useActionPoint();
						}
						case 4 -> {
							hero.descansar();
							rest++;
						}
						case 5 -> {
							hero.mostrarEstat();
						}
						case 6 -> {
							monst.mostrarEstat();
						}
					}
					Utils.sleep(1500);
				} while (hero.getActionPoint() > 0);

				monstTurn();
				Utils.sleep(1500);
				Utils.cleanScreen();

				hero.resetActionPoint();
				monst.resetActionPoint();
			} while (!hero.isDead() && !monst.isDead() && option != 0);

			if (hero.isDead()) {
				System.out.println(
						"Pese a tots els enemics que has matat en el teu cami, mai arribaras a complir la teva vengança, ara ets un més amb la resta de sers que has matat.");
				break;
			}

			if (monst instanceof God && monst.isDead()) {
				System.out.println(
						"Amb molt d'esforç i sang pel cami, finalment compleixes la teva vengaça.\nFelicitats, aqui acaba la teva historia per ara.");
				break;
			}

			if (monst.isDead()) {
				double exp = (Math.random() * monst.getLvl() * 30 + 10);
				System.out.println("Has matat el monstre. \nHas guanyat " + exp + " d'experiencia.");
				if (exp > 100) {
					System.out.println("Enorabona, has augmentat de nivell.");
				}
				hero.setExp(exp);
				hero.levelUp();

				System.out.println("Vols descansar ara que l'enemic a mort?");
				System.out.println("1. Si");
				System.out.println("2. No");
				int j = Utils.validateInt(1, 2);
				if (j == 1) {
					hero.descansar();
					rest++;
				}
				Utils.cleanScreen();
			}
		} while (option != 0);
	}

	public static void crearPersonatge() {
		Scanner sc = new Scanner(System.in);

		System.out.println("1. Guerrer");
		System.out.println("2. Mag");
		System.out.println("3. Arquer");
		int option = Utils.validateInt(1, 3);
		System.out.println("Quin es el teu nom?");
		String name = sc.next();
		switch (option) {
			case 1 -> {
				hero = new Warrior(name);
				System.out.println("Amb la teva armadura i la teva espasa, emprens el teu cami.");
			}
			case 2 -> {
				hero = new Mage(name);
				System.out.println("Amb el teu bacle i coneixemts en la magia, emprens el teu cami.");
			}
			case 3 -> {
				hero = new Archer(name);
				System.out.println("Amb el teu arc i fletxes, emprens el teu cami.");
			}
		}
	}

	public static void heroAttack() {
		if (map.inRange(hero, monst)) {
			Combat.heroAttack(hero, monst);
		} else {
			System.out.println("Estas massa enfora com per fer aquest atac, prova a aproparte.");
		}
	}

	public static void specialAbility() {
		if (hero instanceof Warrior) {
			blocked = true;
		} else {
			Combat.heroSpecialAttack(hero, monst);
		}
	}

	public static void spawnMonster() {
		double probMonst = Math.random() * 50 + (5 * hero.getLvl()) + (rest * 3);

		if (probMonst < 80) {
			monst = new Goblin();
		} else if (probMonst < 120) {
			monst = new Golem();
		} else if (probMonst < 150) {
			monst = new Vampire();
		} else {
			monst = new God();
		}
		monst.setExp(100 * (Math.random() * 5 + ((hero.getLvl() - 1) + rest / 3)));
		monst.levelUp();
	}

	public static void monstTurn() {
		while (monst.getActionPoint() > 0) {
			if (map.inRange(hero, monst)) {
				if (blocked) {
					System.out.println("Has bloquetjat l'atac.");
					blocked = false;
				} else {
					Combat.monstAttack(monst, hero);
				}
			} else {
				System.out.println("El monstre es mou.");
				map.moveMonst(monst, hero);
			}
			monst.useActionPoint();
		}
		blocked = false;
	}

}
