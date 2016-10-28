package spiel;


public class Verkaufsposten
{
	private Unternehmen unternehmen;
	private String fahrradTyp;
	private String fahrradBezeichnung; // ausführlicher Name
	private int anzahl;
	private int preis;
	
	public Unternehmen getUnternehmen() {
		return unternehmen;
	}
	public String getFahrradTyp() {
		return fahrradTyp;
	}
	public String getFahrradBezeichnung() {
		return fahrradBezeichnung;
	}
	public int getAnzahl() {
		return anzahl;
	}
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	public int getPreis() {
		return preis;
	}
	public void setPreis(int preis) {
		this.preis = preis;
	}

	
	/** KONSTRUKTOR **/
	public Verkaufsposten(Unternehmen unternehmen, String fahrradTyp, String fahrradBezeichnung, int anzahl, int preis){
		this.unternehmen = unternehmen;
		this.fahrradTyp = fahrradTyp;
		this.fahrradBezeichnung = fahrradBezeichnung;
		this.anzahl = anzahl;
		this.preis = preis;		
	}
}
