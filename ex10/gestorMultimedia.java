package ex10;

public class gestorMultimedia {

	public static void main(String[] args) {

		FitxerMultimedia[] fitxers = new FitxerMultimedia[8];

		fitxers[0] = new Audio("Hanna Montan", 120, 33.6, 200, "Estereo");
		fitxers[1] = new Video("Hello Kitty", 720, 90.01, 1080, 60);
		fitxers[2] = new Imatge("Lollypop", 0, 2.1, "PNG", "1920x1080");
		fitxers[3] = new Audio("Uwu girl", 156, 34.01, 680, "Mono");
		fitxers[4] = new Video("Two girls", 860, 121.04, 1720, 120);
		fitxers[5] = new Imatge("Dark souls", 0, 23.65, "JVG", "2440x1320");
		fitxers[6] = new Audio("ulalala", 125, 34.5, 380, "Espacial");
		fitxers[7] = new Imatge("zipi zipi", 0, 34.9, "PNG", "1920x180");

		for(FitxerMultimedia f : fitxers) {
			f.mostrarInformacio();
			f.reproduir();
			System.out.println();
		}
	}

}
