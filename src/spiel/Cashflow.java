package spiel;

public class Cashflow {

	/** Monat in dem der Cashflow berechnet wurde **/
	private int runde;

	/** zahlungswirksame Aufwendungen **/
	private int lagerGebuehren = 0;
	private int materialKosten = 0;
	private int gehaelter = 0;
	private int fixkosten = 0;
	private int versicherungen = 0;
	private int marktforschungsKosten = 0;
	private int sonstige = 0;
	private double zinsen = 0;

	/** zahlungswirksame Erträge **/
	private int umsatzerloese = 0;
	
	private double cashflowVorZins = 0;
	private double cashflowNachZins = 0;
	
	public int getRunde() {
		return runde;
	}
	public int getLagerGebuehren() {
		return lagerGebuehren;
	}
	public int getMaterialKosten() {
		return materialKosten;
	}
	public int getGehaelter() {
		return gehaelter;
	}
	public int getFixkosten() {
		return fixkosten;
	}
	public int getVersicherungen() {
		return versicherungen;
	}
	public int getUmsatzerloese() {
		return umsatzerloese;
	}
	public int getMarktforschungsKosten() {
		return marktforschungsKosten;
	}
	public double getZinsen() {
		return zinsen;
	}
	public int getSonstige() {
		return sonstige;
	}
	public double getCashflowVorZins() {
		return cashflowVorZins;
	}
	public double getCashflowNachZins() {
		return cashflowNachZins;
	}
	public void setGehaelter(int gehaelter) {
		this.gehaelter = gehaelter;
	}
	public void setFixkosten(int fixkosten) {
		this.fixkosten = fixkosten;
	}
	public void setMaterialKosten(int materialKosten) {
		this.materialKosten = materialKosten;
	}
	public void setLagerGebuehren(int lagerGebuehren) {
		this.lagerGebuehren = lagerGebuehren;
	}
	public void setVersicherungen(int versicherungen) {
		this.versicherungen = versicherungen;
	}
	public void setUmsatzerloese(int umsatzerloese) {
		this.umsatzerloese = umsatzerloese;
	}
	public void setMarktforschungsKosten(int marktforschungsKosten) {
		this.marktforschungsKosten = marktforschungsKosten;
	}
	public void setZinsen(double zinsen) {
		this.zinsen = zinsen;
	}
	public void setSonstige(int sonstige) {
		this.sonstige = sonstige;
	}
	
	/** KONSTRUKTOR **/
	public Cashflow(int runde){
		this.runde = runde;
	}
	
	public void berechneCashflowVorZins(){
		cashflowVorZins = umsatzerloese - lagerGebuehren - materialKosten - gehaelter - fixkosten - versicherungen - marktforschungsKosten - sonstige;
	}
	
	public void berechneCashflowNachZins(){
		cashflowNachZins = umsatzerloese - lagerGebuehren - materialKosten - gehaelter - fixkosten - versicherungen - marktforschungsKosten - sonstige - zinsen;	
	}
	
	
	
}
