package ex3;

import java.util.Scanner;

public class gestorPassword {

	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);	
		
		System.out.println("Quantes contrasenyas necesites?");
		int quantitat = sc.nextInt();
		sc.nextLine();
		Password[] contras = new Password[quantitat];		
		
		for(int i = 0; i < quantitat; i++) {
			System.out.println("Introdueix la longitud de la contraseña.");	
			String num = sc.nextLine();
			
			if(num.isEmpty()) {
				contras[i] = new Password();
			}else {
				int longi = Integer.parseInt(num);
				contras[i] = new Password(longi);	
			}
			System.out.print("Contrasenya: ");
			contras[i].getPassword();
			if(contras[i].esRobust()) {
				System.out.print(" i es segura.\n");
			}else {
				System.out.print(" i no es segura.\n");
			}
		}
				
		
		}
		
	}


