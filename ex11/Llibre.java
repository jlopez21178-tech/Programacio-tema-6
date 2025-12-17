package ex11;

public class Llibre {
	private String autor;
	private String titol;
	private int numPag;
	private String genere;
	
	public Llibre(String autor, String titol, int pag, String genere) {
		this.autor = autor;
		this.titol = titol;
		this.numPag = pag;
		this.genere = genere;
	}
	
	public String getAutor() {return this.autor;}
	public String getTitol() {return this.titol;}
	public int getPag() {return this.numPag;}
	public String getGenere() {return this.genere;}
	
	public void setAutor(String autor) {this.autor = autor;}
	public void setTitol(String titol) {this.titol = titol;}
	public void setPag(int pag) {this.numPag = pag;}
	public void setGenere(String genere) {this.genere = genere;}
	
	public String toString() {
		return 
			"Autor........" + this.autor + "\nTitol......." + this.titol + "\nNum pag....." + this.numPag + "\nGenere......" + this.genere;
	}
}
