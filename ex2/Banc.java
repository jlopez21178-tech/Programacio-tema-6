package ex2;

import java.util.Scanner;

public class Banc {

	static Scanner sc = new Scanner(System.in);
	static CompteBancari[] comptes = new CompteBancari[1];
	static int i = 0;

	public static void main(String[] args) {


		int opcio = -1;

		do {
			System.out.println("===========MENU==========");
			System.out.println("1. Crear compte bancari.");
			System.out.println("2. Mostrar dades bancaris.");
			System.out.println("3. Ingressar doblers.");
			System.out.println("4. Retirar doblers.");
			System.out.println("5. Transferir doblers");
			System.out.println("6. Eliminar compte");
			System.out.println("7. Sortir.");

			do {
				while(!sc.hasNextInt()) {
					System.out.println("Introdueix un nombre de l'1 al 7");
					sc.next();
				}

				opcio = sc.nextInt();

				if(opcio < 1 || opcio > 7) {
					System.out.println("Introdueix un nombre de l'1 al 7");
				}
			}while(opcio < 1 || opcio > 7);

			switch(opcio) {
			case 1 -> {crearCompte();}
			case 2 -> {mostrarCompte();}
			case 3 -> {ingressarDoblers();}
			case 4 -> {retirarDoblers();}
			case 5 -> {transferirDoblers();}
			case 6 -> {eliminarCompte();}
			}
		}while(opcio != 7);
	}

	public static void crearCompte() {
		if(comptes.length >= i ){
			CompteBancari[] nouComptes = new CompteBancari[i + 1];
			for(int j = 0; j < comptes.length; j++) {
				nouComptes[j] = comptes[j];
			}
			comptes = nouComptes;
		}

		System.out.println("Introdueix el nom del titular.");
		String nom = sc.next();
		System.out.println("Introdueix el DNI del titular.");
		String dni = sc.next();

		boolean dniDuplicat = false;

		for(int j = 0; j < i; j++) {
			if(comptes[j].getDni().equals(dni)) {
				dniDuplicat = true;
			}
		}

		if(dniDuplicat) {
			System.out.println("Ya existeix un compte amb aquest DNI.");
		}else {
			comptes[i] = new CompteBancari(nom, dni, 0);
			System.out.println("El teu compte bancari s'ha inicialitzat amb 0€, si vols pots ingressar més.");
			i++;
		}
	}

	public static int confirmarTitularitat() {
		boolean trobat = false;
		int index = -1;

		do {
			System.out.println("Quin es el dni del titular del compte?");
			String dni = sc.next();
			for(int j = 0; j < i; j++) {
				if(comptes[j].getDni().equals(dni)) {
					trobat = true;
					index = j;
				}
			}
			if(!trobat) {
				System.out.println("No hi ha cap compte bancaria amb aquest titular.");
			}
		}while(!trobat);

		return index;
	}

	public static void mostrarCompte() {
		int index = confirmarTitularitat();

		comptes[index].mostrarDades();
	}

	public static void ingressarDoblers() {
		double doblers = -1;
		int index = confirmarTitularitat();

		System.out.println("Quant vols ingressar?");
		do {
			while(!sc.hasNextDouble()) {
				System.out.println("Has d'introduir un nombre.");
				sc.next();
			}
			doblers = sc.nextDouble();
			if (doblers < 0) {
				System.out.println("Ha de ser una quantitat positiva de doblers.");
			}
		}while(doblers < 0);

		comptes[index].ingressar(doblers);
	}

	public static void retirarDoblers() {
		double doblers = -1;
		int index = confirmarTitularitat();

		System.out.println("Quant vols retirar?");

		do {
			while(!sc.hasNextDouble()) {
				System.out.println("Has d'introduir un nombre.");
				sc.next();
			}
			doblers = sc.nextDouble();
			if (doblers < 0) {
				System.out.println("Ha de ser una quantitat positiva de doblers.");
			}
		}while(doblers < 0);

		if(comptes[index].getSaldo() < doblers) {
			System.out.println("Error. No hi ha suficient saldo en el compte.");
		}else {
			comptes[index].retirar(doblers);
		}
	}

	public static void transferirDoblers() {
		double doblers;

		System.out.println("====== COMPTE QUE TRANSFERIRA ELS DOBLERS ======");
		int indexEnvia = confirmarTitularitat();
		System.out.println("====== COMPTE QUE REBRA ELS DOBLERS ======");
		int indexRep = confirmarTitularitat();

		System.out.println("Dades obtingudes correctament.");
		System.out.println("Quants de doblers vols transferir?");
		do {
			while(!sc.hasNextDouble()) {
				System.out.println("Has d'introduir un nombre.");
				sc.next();
			}
			doblers = sc.nextDouble();
			if (doblers < 0) {
				System.out.println("Ha de ser una quantitat positiva de doblers.");
			}
		}while(doblers < 0);

		if(comptes[indexEnvia].getSaldo() < doblers) {
			System.out.println("Error. No hi ha suficient saldo en el compte.");
		} else {
			comptes[indexEnvia].retirar(doblers);
			comptes[indexRep].ingressar(doblers);
		}
	}
	
	public static void eliminarCompte() {
		System.out.println("====== ELIMINAR COMPTE ======");
		int index = confirmarTitularitat();
		
		i--;
		CompteBancari[] nouCompte = new CompteBancari[i];
		
		for(int j = 0; j < index; j++) {
			nouCompte[j] = comptes[j];
		}
		for(int j = index; j < i; j++ ) {
			nouCompte[j] = comptes[j + 1];
		}
		
		comptes = nouCompte;
		System.out.println("S'ha eliminat la compta correctament.");
		
		for(int j = 0; j < i; j++) {
			comptes[j].mostrarDades();
		}
	}

}
