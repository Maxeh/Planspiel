/**
 * Bei den Krediten handelt es sich um Tilgungsdarlehn. Das hei�t die zu zahlenden Tilgungen bleiben immer gleich.
 * Die Zinsen werden nach jeder Zahlung angepasst und werden im laufe der Zeit weniger. 
 * Die Rate, die monatlich bezahlt wird, besteht aus Tilgung + Zins.
 */
package spiel;

public class Kredit {
	
	private Bank bank; // Verweis auf das Bank Objekt, zu dem der Kredit geh�rt
	private int kreditSumme; // Betrag des Kredits
	private double zinsSatz; // Prozentzahl
	private double zins; // Zinsen, die in der Runde bezahlt wurden werden gespeichert
	private double tilgung; // Tilgung wird einmalig berechnet und bleibt danach immer gleich
	private int laufzeit;  // die Laufzeit des Kredits wird gespeichert
	private int anzahlNochZuTilgen; // Z�hler, der angibt wie oft die monatliche Rate noch bezahlt werden muss, wird jede Runde runtergez�hlt
	private boolean kreditGetilgt = false; // wird auf true gesetzt wenn der Kredit getilgt wurde
	
	public boolean isKreditGetilgt(){
		return kreditGetilgt; 
	}
	public int getKreditSumme() {
		return kreditSumme;
	}
	public double getZins() {
		return zins;
	}
	public double getZinsSatz() {
		return zinsSatz;
	}
	public int getLaufzeit() {
		return laufzeit;
	}
	public double getTilgung(){
		return tilgung;
	}
	public int getAnzahlNochZuTilgen(){
		return anzahlNochZuTilgen;
	}
	public int getRestSchuld(){
		return (int)(anzahlNochZuTilgen * tilgung);
	}
	/**
	 * Methode berechnet die durchschnittlichen Zinsen, die im Laufe des Darlehens noch bezahlt werden m�ssen.
	 * Dazu werden alle kommenden Zinsen zusammengerechnet und durch die Anzahl der ausstehenden Tilgungen geteilt.
	 * Die durchschnittlichen Zinsen gehen in die Berechnung der Kreditw�rdigkeit ein.
	 * @return Liefert die durchschnittlichen Zinsen zur�ck, die noch gezahlt werden m�ssen.
	 */
	public double getDurchschnitsZinsen(){
		double zins = 0;
		double anzahlNochZuTilgen = this.anzahlNochZuTilgen;
		
		for (int i = 0; i < this.anzahlNochZuTilgen; i++){
			zins += anzahlNochZuTilgen * tilgung * zinsSatz / 100;
			anzahlNochZuTilgen--;
		}
		
		double durchschnittsZins = zins / this.anzahlNochZuTilgen;
		
		return durchschnittsZins;
	}
	
	/** KONSTRUKTOR **/
	public Kredit(Bank bank, int kreditSumme, double zinsSatz, int laufzeit){
		this.bank = bank;
		this.kreditSumme = kreditSumme;
		this.zinsSatz = zinsSatz;
		this.laufzeit = laufzeit;
		this.anzahlNochZuTilgen = laufzeit;
		this.tilgung = kreditSumme / laufzeit;
	}
	
	/** Methode berechnet die Zinsen, die f�r die aktuelle Runde f�r diesen Kredit gezahlt werden m�ssen **/
	public void berechneZins(){
		zins = (double) (Math.round(getRestSchuld() * zinsSatz * 100) / 10000);
	}
	
	/**
	 * Die Zinsen m�ssen nach jeder Tilgung neu berechnet werden.
	 * An die Bank muss die Rate bezahlt werden (Tilgung + Zins).
	 * Je mehr von dem Kredit getilgt wurde, desto geringer wird die Rate ( = Tilgungsdarlehn )
	 */
	public void tilgung(){
		berechneZins();
		anzahlNochZuTilgen--;
		
		bank.kontostandVerringern(tilgung + zins);
		
		// Zinsen als zahlungswirksame Aufwendungen im Cashflow vermerken
		Planspiel.getAktuellesUnternehmen().getCashflow().setZinsen(Planspiel.getAktuellesUnternehmen().getCashflow().getZinsen() + zins);

		if(anzahlNochZuTilgen == 0)
			kreditGetilgt = true;		
	}
}
