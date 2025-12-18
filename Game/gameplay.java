import java.util.Scanner;

public class gameplay {
	private static Scanner sc = new Scanner(System.in);
	public static Player hero = new Warrior("hero");
	public static Player monster;
	public static int rest = 0;

	public static void main(String[] args) {

		System.out.println("=== HEROES & MONSTERS ===");
		System.out.println(
				"El teu regne va ser masacrat per un deu maligne fa 10 anys. \nAra et trobes de cami cap al deu en cerca de vengança.\nEs hora de que decideixis quina classe de heroe vols ser.");
		crearPersonatge();
		System.out.println(
				"\nAra mateix et trobes en un bosque molt perillos, no es recomable descansar\nSi descansas molt seguit es posible que et trobis amb enemics més perillosos");

		int option;
		do {
			spawnMonster();
			System.out.println("\n\nHa aparegut un monstre en el camí. \nEs un " + monster.getName() + " i es troba a "
					+ monster.getPos() + " metres.");
			do {
				do {
					System.out.println("=== HEROES & MONSTERS ===");
					System.out.println("1. Moure");
					System.out.println("2. Atacar");
					System.out.println("3. Abilitat especial");
					System.out.println("4. Descansar");
					System.out.println("5. Mostrar estat");
					System.out.println("6. Mostrar estat del enemic");
					System.out.println("0. Sortir");

					option = validateInt(0, 6);

					switch (option) {
						case 1 -> {
							System.out.println("Quant et vols moure (maxim de 10 metres).");
							int metres = validateInt(1, 10);
							hero.setPos(metres);
						}
						case 2 -> {
							actionAttack();
						}
						case 3 -> {
							specialAbility();
						}
						case 4 -> {
							hero.descansar();
							rest++;
						}
						case 5 -> {
							hero.mostrarEstat();
						}
						case 6 -> {
							monster.mostrarEstat();
						}
					}
				} while (option > 4);
				monsterTurn();

				if (monster.getLife() <= 0) {
					break;
				}

			} while (hero.getLife() > 0);

			if (hero.getLife() <= 0) {
				break;
			}

			if (monster.getClass() == God.class && monster.getLife() <= 0) {
				System.out.println(
						"Amb molt d'esforç i sang pel cami, finalment compleixes la teva vengaça.\nFelicitats, aqui acaba la teva historia per ara.");
				break;
			}

			double exp = (Math.random() * monster.getLvl() * hero.getLvl() * 30 + 10);
			System.out.println("Has matat el monstre. \nHas guanyat " + exp + " d'experiencia.");
			if (exp > 100) {
				System.out.println("Enorabona, has augmentat de nivell.");
			}
			hero.setExp(exp);
			hero.levelUp();

			System.out.println("Vols descansar ara que l'enemic a mort?");
			System.out.println("1. Si");
			System.out.println("2. No");
			int j = validateInt(1, 2);
			if (j == 1) {
				hero.descansar();
				rest++;
			}

		} while (option != 0);
	}

	public static void crearPersonatge() {
		System.out.println("1. Guerrer");
		System.out.println("2. Mag");
		System.out.println("3. Arquer");
		int option = validateInt(1, 3);
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

	public static void actionAttack() {
		if (Math.abs(monster.getPos() - hero.getPos()) <= 5) {
			double dmg = hero.attack();
			if (monster.getClass() == Golem.class) {
				dmg -= (monster.getDefense() / (100.0 + monster.getDefense()));
			}
			System.out.println("L'heroe ataca i fa " + dmg + " de dany.");
			monster.setLife(-dmg);
		} else {
			System.out.println("Estas massa enfora com per fer aquest atac, prova a aproparte.");
		}
	}

	public static void specialAbility() {
		double dmg;
		if (hero.getClass() == Mage.class) {
			dmg = hero.useSpell();
			if (dmg == 0) {
				System.out.println("Tractes de emprar un conjur pero estas massa cansat com per emprar-lo.");
			} else {
				System.out.println("Conjures una bolla de foc que fa " + dmg + " de dany.");
			}
		} else {
			dmg = hero.throwArrow() * Math.abs(monster.getPos() - hero.getPos()) / 2;
			if (monster.getWeaknes() == 2) {
				dmg *= 1.5;
			}
		}
		monster.setLife(-dmg);
	}

	public static void spawnMonster() {
		double monst = Math.random() * 50 + (5 * hero.getLvl()) + (rest * 3);

		if (monst < 80) {
			monster = new Goblin();
		} else if (monst < 120) {
			monster = new Golem();
		} else if (monst < 150) {
			monster = new Vampire();
		} else {
			monster = new God();
		}

		monster.setPos((int) (Math.random() * 50 + 20));
		monster.setExp(100 * (Math.random() * 5));
		monster.levelUp();

	}

	public static void monsterTurn() {
		if (Math.abs(monster.getPos() - hero.getPos()) <= 5) {
			double dmg = monster.attack();
			if (monster.getClass() == Vampire.class) {
				double x = Math.random() * 100;
				if (hero.getWeaknes() == monster.getType()) {
					dmg *= 1.5;
				}
				if (x < 20) {
					monster.suckBlood();
				}
				hero.setLife(-dmg);
			} else {
				if (hero.getClass() == Warrior.class) {
					hero.setLife(-(dmg - (hero.getDefense() / (100.0 + hero.getDefense()))));
				} else {
					hero.setLife(-dmg);
				}
			}
		} else {
			System.out.println("El monstre es mou.");
			if (hero.getPos() > monster.getPos()) {
				monster.setPos(10);
			} else {
				monster.setPos(-10);
			}
			System.out.println("Es troba a " + (Math.abs(monster.getPos() - hero.getPos())) + " metres de tu.");
		}
	}

	public static int validateInt(int x, int y) {
		int option;
		do {
			while (!sc.hasNextInt()) {
				System.out.println("Error. Has d'introduir un nombre");
				sc.next();
			}
			option = sc.nextInt();
			if (option < x || option > y) {
				System.out.println("Error. Has d'introduir un nombre entre " + x + " y " + y);
			}
		} while (option < x || option > y);
		return option;
	}
}