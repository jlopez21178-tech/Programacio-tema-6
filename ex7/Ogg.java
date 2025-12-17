package ex7;

public class Ogg extends Musica{
	@Override
	public void reproduir() {
		System.out.println("Reproduint ogg");
	}
	
	public Ogg(double durada) {
		super(durada);
	}
	
	public Ogg() {
		
	}
}