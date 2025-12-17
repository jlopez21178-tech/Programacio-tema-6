package ex10;

public class Playlist extends FitxerMultimedia{
	FitxerMultimedia[] playlist = new FitxerMultimedia[20];
	private int i = 0;
	
	public Playlist(String nom, int durada, double mida, int res, int fps) {
		playlist[i] = new Video(nom, durada, mida, res, fps);
		i++;
	}
	
	public Playlist() {
		
	}
	
	public void reproduirHoTot() {
		super.reproduir();
	}
}
