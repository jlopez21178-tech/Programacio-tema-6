public class Combat {
  public static boolean probHit() {
    return (Math.random() * 100 <= 60);
  }

  public static boolean probSpecialAttack() {
    return (Math.random() * 100 <= 30);
  }

  public static void monstAttack(Player monst, Player hero) {
    if (probHit()) {
      double dmg = monst.attack();
      if (monst instanceof Vampire && probSpecialAttack()) {
        monst.specialAbility();
        System.out.println("El vampir fa un atac especial i et sucla la sang. Recupera 100 de vida");
      }
      if (hero.getWeaknes() == monst.getType()) {
        dmg *= 1.5;
      }
      if (hero instanceof Warrior) {
        dmg *= (hero.getDefense() / (100.0 + hero.getDefense()));
      }
      hero.recieveDmg(dmg);

      System.out.println("El monstre t'ataca i et fa " + dmg + " de dany.");
    } else {
      System.out.println("L'atac a fallat.");
    }
  }

  public static void heroAttack(Player hero, Player monst) {
    if (probHit()) {
      int dmg = (int) hero.attack();
      if (monst.getWeaknes() == hero.getType() || monst.getWeaknes() == 4) {
        dmg *= 1.5;
      }
      if (monst instanceof Golem) {
        dmg *= (monst.getDefense() / (100.0 + monst.getDefense()));
      }
      System.out.println("L'heroe ataca i fa " + dmg + " de dany.");
      monst.recieveDmg(dmg);
    } else {
      System.out.println("Has fallat l'atac.");
    }
  }

  public static void heroSpecialAttack(Player hero, Player monst){
    monst.recieveDmg(hero.specialAbility());
  }
  
}
