package ex4;

import java.util.Scanner;

public class gestorData {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Data[] fechas  = new Data[5];

		System.out.println("Introdueix datas:");
		
		for(int i = 0; i < fechas.length; i++) {
			do {
			System.out.println("Dia:");
			int dia = sc.nextInt();
			System.out.println("Mes");
			int mes = sc.nextInt();
			System.out.println("Any");
			int any = sc.nextInt();
			
			fechas[i] = new Data(dia, mes, any);
			}while(fechas[i].getDia() == -1);
		}
		
		for(int i = 0; i < fechas.length; i++) {
			fechas[i].dema();
		}
		
		
	}

}
