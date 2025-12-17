package ex10;

public class Video extends FitxerMultimedia{
	private int resolucio;
	private int fps;
	
	public Video(String nom, int durada, double mida, int res, int fps) {
		super(nom,durada, mida);
		this.resolucio = res;
		this.fps = fps;		
	}
	
	@Override
	void reproduir() {
		System.out.println("Reproduint vídeo en " + this.resolucio + " a " + this.fps + " fps." );
	}
	
	public void mostrarInformacio() {
		super.mostrarInformacio();
		System.out.println("Resolucio..............." + this.resolucio + "p");
		System.out.println("FPS....................." + this.fps);
	}
	
	
}
