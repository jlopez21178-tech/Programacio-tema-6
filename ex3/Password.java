package ex3;

public class Password {
	private String password = "";
	private int longitud;

	public Password(int longitud) {
		this.longitud = longitud;
		this.password = setPassword(longitud);
	}

	public Password() {
		this.longitud = 8;
		this.password = setPassword(8);
	}

	public String setPassword(int longitud) {
		do {
			int variable;
			do {
//				Debe de llegar hasta la posicion 126, pero si llega hasta ella y le sumo 33 se sale fuera de 
//				rango de los imprimibles por java, por eso le resto 33, asi, si sale el numero maximo, me saldra el valor 126
//				pero si la multiplicacion me llega a dar 0, jamas pondra el caracter 0 ni hasta el 32, que son de control
				variable = (int) (Math.random() * (126-33) + 33);
			}while(variable == 127);
			this.password += (char) variable;
		}while(this.password.length() < longitud);
		return this.password;
	}

	public boolean esRobust() {
		boolean majuscula = false;
		boolean minuscula = false;
		boolean simbol = false;
		boolean numero = false;


		for(int i = 0; i < this.longitud; i++) {
			if(this.password.charAt(i) >= 'A' && this.password.charAt(i) <= 'Z') {
				majuscula = true;
			} else if(this.password.charAt(i) >= 'a' && this.password.charAt(i) <= 'z') {
				minuscula = true;
			}if(this.password.charAt(i) >= '0' && this.password.charAt(i) <= '9') {
				numero = true;
			}if(this.password.charAt(i) >= 33 && this.password.charAt(i) <= 47 || this.password.charAt(i) >= 58 && this.password.charAt(i) <= 64 || this.password.charAt(i) >= 91 && this.password.charAt(i) <= 96 || this.password.charAt(i) >= 123) {
				simbol = true;
			}
		}

		if(majuscula && minuscula && numero && simbol) {
			return true;
		}else {
			return false;
		}
	}

	public void getPassword() {
		System.out.print(this.password + " y te una longitud de " + this.longitud + " caracters");
	}
}
