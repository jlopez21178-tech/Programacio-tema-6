import java.util.Scanner;

public class Utils {
	
	public static int validateInt(int x, int y) {
		Scanner sc = new Scanner(System.in);
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

  public static void cleanScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

  public static void sleep(int x){
    try{
      Thread.sleep(x);
    } catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}
