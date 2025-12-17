package ex12;

import java.util.Scanner;

public class gestorCua {

	public static void main(String[] args) {
		Cua cola = new Cua();
		Scanner sc = new Scanner(System.in);
		int opcio;
		
		do {
			System.out.println("-------Menu-------");
			System.out.println("1. Afegir persona");
			System.out.println("2. Treure persona");
			System.out.println("3. Estat de la cua");
			
			opcio = sc.nextInt();
			
			switch (opcio) {
			case 1 -> {
				System.out.println("Introdueix el nom:");
				String nom = sc.next();
				System.out.println("Introdueix el DNI");
				String dni = sc.next();
				
				cola.afegir(nom, dni);
			}
			case 2 -> {
				cola.treurePersona();
			}
			case 3 -> {
				cola.estatCua();
			}
			}
			
		}while(opcio != 4);
	}

}
