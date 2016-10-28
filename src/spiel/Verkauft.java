package spiel;

public class Verkauft {
	
	private String fahrradBezeichnung;
	private int preis;
	private int anzahl;
	private int runde;
	
	public String getFahrradBezeichnung() {
		return fahrradBezeichnung;
	}
	public int getPreis() {
		return preis;
	}
	public int getAnzahl() {
		return anzahl;
	}
	public int getRunde() {
		return runde;
	}

	public Verkauft(String fahrradBezeichnung, int preis, int anzahl){
		this.fahrradBezeichnung = fahrradBezeichnung;
		this.preis = preis;
		this.anzahl = anzahl;
		this.runde = Planspiel.getRundenNr();
	}
}
