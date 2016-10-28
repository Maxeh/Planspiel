package spiel;
public class Fahrrad {
	
	private String typ;
	private int anzahl;
	private String name; // ausführlicher Name
	
	/** KONSTRUKTOR **/
	public Fahrrad(String typ, String name, int anzahl){
		this.typ = typ;
		this.anzahl = anzahl;	
		this.name = name;
	}
	
	public String getTyp() {
		return typ;
	}
	public String getName() {
		return name;
	}
	public int getAnzahl() {
		return anzahl;
	}
}
