package ex4;

public class Data {

	private int dia = -1;
	private int mes;
	private int any;

	public Data(int dia, int mes, int any) {
		boolean dataValida = false;
		boolean bisiesto ;

		if(any % 100 == 0) {
			bisiesto = (any % 400 == 0) && (any % 4 == 0);
		}else {
			bisiesto = (any % 4 == 0);
		}
		
		if(mes >= 1 && mes <= 12) {
			switch (mes) {
			case 1, 3, 5, 7, 8, 10, 12: 
				if(dia >= 1 && dia <= 31) {
					this.dia = dia;
					this.mes = mes;
					this.any = any;
					dataValida = true;
				}
			break;
			case 2:
				if(bisiesto) {
					if(dia >= 1 && dia <= 29) {
						this.dia = dia;
						this.mes = mes;
						this.any = any;
						dataValida = true;
					}
				} else {
					if(dia >= 1 && dia <= 28) {
						this.dia = dia;
						this.mes = mes;
						this.any = any;
						dataValida = true;
					}
				}
				break;
			default: 
				if(dia >= 1 && dia <= 30) {
					this.dia = dia;
					this.mes = mes;
					this.any = any;
					dataValida = true;
				}
				break;
			}
		}
		
		if(dataValida) {
			System.out.println("La data que ha introduit es correcta.");
		}else {
			System.out.println("Error. Data incorrecta.");
		}
	}

	public Data() {

	}
	
	public int getDia() {
		return this.dia;
	}
	public int getMes() {
		return this.mes;
	}
	public int getAny() {
		return this.any;
	}

	public void dema() {
		boolean bisiesto;
		
		if(this.any % 100 == 0) {
			bisiesto = (this.any % 400 == 0) && (this.any % 4 == 0);
		}else {
			bisiesto = (this.any % 4 == 0);
		}

		switch (this.mes) {
		case 1,3,5,7,8,10:
			if(this.dia == 31) {
				this.dia = 1;
				this.mes++;
			} else {
				this.dia++;
			}
			break;
		case 2:
			if(bisiesto) {
				if(this.dia == 29) {
					this.dia = 1;
					this.mes = 3;
				} else {
					this.dia++;
				}
			} else {
				if(this.dia == 28) {
					this.dia = 1;
					this.mes = 3;
				}else {
					this.dia++;
				}
			}
			break;
		case 12:
			if(this.dia == 31) {
				this.dia = 1;
				this.mes = 1;
				this.any++;
			} else {
				this.dia++;
			}
			break;
		default:
			if(this.dia == 30) {
				this.dia = 1;
				this.mes++;
			} else {
				this.dia++;
			}
			break;
		}
	}
}
