package spiel;
import java.util.Vector;


public class Unternehmen {
	
	private String spieler;
	private Bank bank;
	private Fabrik fabrik;
	private Cashflow cashflow;
	private Entwicklung entwicklung;
	private Versicherung versicherung;
	private Vector<Bestellung> alleBestellungen = new Vector<Bestellung>();
	private Vector<Verkauft> verkaufteFahrraeder = new Vector<Verkauft>();
	private Vector<Cashflow> alleCashflows = new Vector<Cashflow>();
	private int anzahlMitarbeiter;
	private int gehaltMitarbeiter;
	
	/** Die folgenden 3 Arrays beinhalten die Daten aus dem Zufallsereignis **/
	private int[] lagerBrand = new int[3]; //[0] wenn 1 dann ist Zufallsereignis eingetreten, [1] Anzahl der verbrannten Materialien, [2] Nummer des verbrannten Materials im Lager
	private int[] maschineDefekt = new int[2]; //[0] wenn 1 dann ist Zufallsereignis eingetreten, [1] Kosten für die entstandene Reparatur
	private int[] rechtsstreit = new int[2]; //[0] wenn 1 dann ist Zufallsereignis eingetreten, [1] Kosten für den Rechtsstreit

	public int[] getLagerBrand() {
		return lagerBrand;
	}
	public int[] getMaschineDefekt() {
		return maschineDefekt;
	}
	public int[] getRechtsstreit() {
		return rechtsstreit;
	}
	public void setLagerBrand(int brand, int anzahl, int materialNummer) {
		this.lagerBrand[0] = brand;
		this.lagerBrand[1] = anzahl;
		this.lagerBrand[2] = materialNummer;
	}
	public void setMaschineDefekt(int defekt, int preis) {
		this.maschineDefekt[0] = defekt;
		this.maschineDefekt[1] = preis;
	}
	public void setRechtsstreit(int rechtsstreit, int preis) {
		this.rechtsstreit[0] = rechtsstreit;
		this.rechtsstreit[1] = preis;
	}
	public String getSpielername(){
		return spieler;
	}
	public int getGehaelter(){
		return anzahlMitarbeiter * gehaltMitarbeiter;
	}
	public int getAnzahlMitarbeiter(){
		return anzahlMitarbeiter;
	}
	public void setAnzahlMitarbeiter(int anzahlMitarbeiter){
		this.anzahlMitarbeiter = anzahlMitarbeiter;
	}
	public Bank getBank(){
		return bank;
	}
	public Fabrik getFabrik() {
		return fabrik;
	}
	public Lager getLager() {
		return fabrik.getLager();
	}
	public Entwicklung getEntwicklung(){
		return entwicklung;
	}
	public Versicherung getVersicherung() {
		return versicherung;
	}
	public Cashflow getCashflow(){
		return cashflow;
	}
	/** Alle Cashflows aus alle Perioden werden in einem Array zurückgeliefert **/
	public Cashflow[] getAlleCashflows(){
		Cashflow[] cashflow = new Cashflow[alleCashflows.size()];
		for (int i = 0; i < alleCashflows.size(); i++){
			cashflow[i] = alleCashflows.get(i);
		}
		return cashflow;
	}
	/** Der durchschnttliche Wert des Cashflows vor Zinsen wird errechnet und zurückgegeben. **/
	public double getDurchschnittsCashflowVorZins(){
		if (alleCashflows.size() == 0) return 0;
		
		double summe = 0;
		double durchschnitt = 0;
		
		for (int i = 0; i < alleCashflows.size(); i++){
			summe += alleCashflows.get(i).getCashflowVorZins();
		}
		durchschnitt = summe / alleCashflows.size();
		return durchschnitt;
	}
	/** Der durchschnttliche Wert des Cashflows nach Zinsen wird errechnet und zurückgegeben. **/
	public double getDurchschnittsCashflowNachZins(){
		if (alleCashflows.size() == 0) return 0;
		
		double summe = 0;
		double durchschnitt = 0;
		
		for (int i = 0; i < alleCashflows.size(); i++){
			summe += alleCashflows.get(i).getCashflowNachZins();
		}
		durchschnitt = summe / alleCashflows.size();
		return durchschnitt;
	}
	
	/** Alle Bestellungen werden als Array zurückgeliefert **/
	public Bestellung[] getBestellungen(){
		Bestellung[] bestellung = new Bestellung[alleBestellungen.size()];
		for (int i = 0; i < alleBestellungen.size(); i++){
			bestellung[i] = alleBestellungen.get(i);
		}
		return bestellung;
	}
	/**
	 * Die Methode berechnet das gesamte Eigenkapital des Unternehmens zusammen.
	 * Zum Eigenkapital gehören der Kontostand, die Materialien (Anzahl Materialien * Materialien Grundpreis) 
	 * und das AV (Maschinen, MaschinenUpgrades, LagerUpgrade, Patente).
	 * @return Gibt den Wert des Eigenkapitals zurück.
	 */
	public double getEigenkapital(){
		double kontostand = bank.getKontostand();
		int[] lagerInhalt = getLager().getLagerInhalt();
		
		/** Fahrräder, die in der Produktionsliste stehen mit in die EK-Berechung reinnehmen **/
		Fahrrad[] produktionsliste = fabrik.getProduktionsliste();
		for (int i = 0; i < produktionsliste.length; i++){
			switch(produktionsliste[i].getTyp()){
				case "mtbStandard": lagerInhalt[0] += produktionsliste[i].getAnzahl(); break;
				case "mtbPremium": lagerInhalt[1] += produktionsliste[i].getAnzahl(); break;
				case "trekkingradStandard": lagerInhalt[2] += produktionsliste[i].getAnzahl(); break;
				case "trekkingradPremium": lagerInhalt[3] += produktionsliste[i].getAnzahl(); break;
				case "rennradStandard": lagerInhalt[4] += produktionsliste[i].getAnzahl(); break;
				case "rennradPremium": lagerInhalt[5] += produktionsliste[i].getAnzahl(); break;
			}
		}
		
		int materialWerte = Markt.getMaterialWerte(lagerInhalt);
		
		int av = fabrik.getAnzahlMaschinen() * Planspiel.getStartMaschinenPreis() + entwicklung.getLevelMaschinen() * Planspiel.getStartMaschinenUpgradePreis() +
				 entwicklung.getLevelLager() * Planspiel.getStartLagerkapazitaetErhoehenPreis();
		if (entwicklung.isPatentMountainbikePrem())
			av += Planspiel.getStartMtbPremPatentPreis();
		if (entwicklung.isPatentTrekkingradPrem())
			av += Planspiel.getStartTrekkingPremPatentPreis();
		if (entwicklung.isPatentRennradPrem())
			av += Planspiel.getStartRennradPremPatentPreis();

		double ek = kontostand + materialWerte + av - getFremdkapital();
		return ek;
	}
	/**
	 * Die Methode berechnet das gesamte Fremdkapital, das dem Unternehmen zur Verfügung steht.
	 * Dazu wird die Restschuld aus allen Krediten zusammengerechnet.
	 * @return Gibt den Wert des Fremdkapitals zurück.
	 */
	public double getFremdkapital(){
		Kredit[] kredite = bank.getAlleKredite();
		double fk = 0;
		for (int i = 0; i < kredite.length; i++){
			fk += kredite[i].getRestSchuld();
		}
		return fk;
	}
	/** Alle verkauften Fahrräder werden als Array von Verkauft-Objekten zurückgegeben **/
	public Verkauft[] getVerkaufteFahrraeder() {
		Verkauft[] verkauft = new Verkauft[verkaufteFahrraeder.size()];
		for (int i = 0; i < verkaufteFahrraeder.size(); i++){
			verkauft[i] = verkaufteFahrraeder.get(i);
		}
		return verkauft;
	}
	

	/** KONSTRUKTOR **/
	public Unternehmen(String spieler){
		this.spieler = spieler;
		anzahlMitarbeiter = Planspiel.getStartMitarbeiterAnzahl();
		gehaltMitarbeiter = Planspiel.getStartGehaltMitarbeiter();
		
		entwicklung = new Entwicklung();
		bank = new Bank();
		fabrik = new Fabrik();	
		versicherung = new Versicherung();
	}
	
	/**
	 * Diese Methode wird zu Beginn jeden Zugs aufgerufen.
	 * Es werden alle anstehenden Veränderungen durchgenommen und danach das UI in der Klasse Planspiel geupdated.
	 */
	public void neuerZug() {
		// jede Runde wird ein neues Cashflow-Objekt erstellt
		cashflow = new Cashflow(Planspiel.getRundenNr());
				
		// folgende Methodenaufrufe werden erst ab der 2. Runde durchgeführt
		if (Planspiel.getRundenNr() != 1){ 
			
			setLagerBrand(0,0,0);
			setMaschineDefekt(0,0);
			setRechtsstreit(0,0);
			Zufallsereignis.zufall();	
			
			versicherung.gebuehrBerechnen();
			pruefeBestellungenErhalten();
			fabrik.produktionFertig();
			getLager().gebuehrBerechnen(this);
		}
	}
	
	/**
	 * Wenn der Spieler seinen Zug beendet wird die Methode aufgerufen ( in der Klasse Planspiel in der Methode zugBeenden() ).
	 * Es werden die Kosten zusammengerechnet und danach vom Bankkonto abgezogen sowie im Cashflow vermerkt.
	 */
	public void kostenAbziehen() {
		// Gehälter und Kosten im Cashflow vermerken
		cashflow.setFixkosten(Planspiel.getFixkosten());
		cashflow.setGehaelter(getGehaelter());

		bank.kontostandVerringern(Planspiel.getFixkosten() + getGehaelter());
	}
	
	/** Wenn Fahrräder am Marktplatz verkauft werden, wird das im Vector gespeichert **/
	public void addVerkaufteFahrraeder(String fahrradBezeichnung, int preis, int anzahl){
		verkaufteFahrraeder.add(new Verkauft(fahrradBezeichnung, preis, anzahl));
	}

	/**
	 * Diese Methode wird aufgerufen wenn der Spieler im UI eine Bestellung aufgibt.
	 * Es wird die Methode "createBestellung" in der Klasse Marktplatz aufgerufen, welche ein neues Bestellung-Objekt zurückgibt.
	 * @param anbieterName Der Name des Anbieters, bei dem bestellt werden soll.
	 * @param materialName Der Name des Materials, das bestellt werden soll.
	 * @param anzahl Gibt an wie oft das Material bestellt werden soll.
	 * @return true wenn Bestellung erfolgreich aufgegebn wurde, ansonsten false
	 */
	public boolean createBestellung(String anbieterName, String materialName, int anzahl){
		Bestellung bestellung = Marktplatz.createBestellung(this, anbieterName, materialName, anzahl);
		if (bestellung != null){
			alleBestellungen.add(bestellung);
			return true;
		}
		return false;
	}

	/**
	 * Methode wird zu Beginn jeden Zugs aufgerufen in der Methode neuerZug().
	 * Es wird für jede Bestellung geprüft, ob die Lieferzeit abgelaufen ist und die Bestellung in dieser Runde eintrifft.
	 * Wenn eine Bestellung eintrifft, wird sie dem Lager hinzugefügt.
	 */
	private void pruefeBestellungenErhalten() {
		int i = 0;
		while (i < alleBestellungen.size()){
			if (alleBestellungen.get(i).pruefeBestellungErhalten()){
				alleBestellungen.removeElementAt(i);
			}
			else i++;			
		}
	}
	
	/** 
	 * Cashflow für die letzte Runde berechnen und im Vector speichern.
	 */
	public void saveCashflow(){
		cashflow.berechneCashflowVorZins();
		cashflow.berechneCashflowNachZins();
		alleCashflows.add(cashflow);
	}
}
