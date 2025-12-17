package ex13;

public class opera {

	public static void main(String[] args) {
		InstrumentsMusicals[] cantant = new InstrumentsMusicals[2];
		
		cantant[0] = new Vent("Flauta");
		cantant[1] = new Percusio("Tambor");
		
		for(int i = 0; i < 0; i++) {
			System.out.println(cantant[i].tocar());
			cantant[i].soProduit();
		}

	}

}
