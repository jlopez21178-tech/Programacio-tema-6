public class Combat {
  public static boolean probHit() {
    return (Math.random() <= 0.7);
  }

  public static boolean probSpecialAttack() {
    return (Math.random() <= 0.3);
  }

  public static void monstAttack(Player monst, Player hero) {
    if (probHit()) {
      int dmg = (int) monst.attack();
      if (monst instanceof Vampire && probSpecialAttack()) {
        monst.specialAbility();
        System.out.println("El vampir fa un atac especial i et sucla la sang. Recupera 100 de vida");
      }
      if (hero.getWeaknes() == monst.getType()) {
        dmg *= 1.5;
      }
      dmg *= hero.dmgReduction();
      dmg = hero.recieveDmg(dmg);

      if (dmg == 0) {
        System.out.println("Has bloquejat l'atac.");
      } else {
        System.out.println("El monstre t'ataca i et fa " + dmg + " de dany.");
      }
    } else {
      System.out.println("El monstre t'ataca pero a fallat.");
    }
  }

  public static void heroAttack(Player hero, Player monst) {
    if (probHit()) {
      int dmg = (int) hero.attack();
      if (monst.getWeaknes() == hero.getType() || monst.getWeaknes() == 4) {
        dmg *= 1.5;
      }
      dmg *= monst.dmgReduction();
      System.out.println("L'heroe ataca i fa " + dmg + " de dany.");
      monst.recieveDmg(dmg);
    } else {
      System.out.println("Has fallat l'atac.");
    }
  }

  public static void heroSpecialAttack(Player hero, Player monst) {
    monst.recieveDmg(hero.specialAbility());
  }

}
