package spiel;

import java.util.Vector;

public final class Planspiel {
	
	private static Vector<Unternehmen> alleUnternehmen = new Vector<Unternehmen>();
	private static Unternehmen aktuellesUnternehmen;
	private static int runde = 1;
	private static int spielerNr = 0;	
	
	/** Kosten **/
	private static int fixkosten = 10000; // Mietkosten, Energie
	
	/** Konstanten, die zu Beginn des Spiels festgelegt werden **/
	private static final int startMitarbeiterAnzahl = 10;
	private static final int startGehaltMitarbeiter = 2500;
	private static final int startKontostand = 800000;
	private static final int startLagerKapazitaet = 15000;
	private static final int startAnzahlMaschinen = 5;
	private static final int startProduktionsKapazitaetMaschine = 100;
	private static final int startMaterialAnzahl = 150;
	private static final int startFahrradPlatzbedarf = 16;
	private static final int[] startMaterialPlatzbedarf = {
		3, // Rahmen
		2, // Lenker
		1, // Pedal
		2, // Rad
		1, // Sattel
		1, // Bremsen
		1, // Schaltung
		1 // Kette		
	};
	private static final int startGebuehrProUeberschritteneEinheit = 20;
	
	/** Konstanten für die Entwicklung **/
	private static final int startMaschinenPreis = 80000;
	private static final int startMitarbeiterProMaschine = 2;
	private static final int startMaschinenUpgradeWert = 20;
	private static final int startMaschinenUpgradePreis = 120000;
	private static final int startLagerKapazitaetErhoehenWert = 5000;
	private static final int startLagerKapazitaetErhoehenPreis = 100000;
	private static final int startMtbPremPatentPreis = 100000;
	private static final int startTrekkingPremPatentPreis = 120000;
	private static final int startRennradPremPatentPreis = 180000;
	private static final int startMtbStandardForschungPreis = 10000;
	private static final int startMtbPremiumForschungPreis = 10000;
	private static final int startTrekkingradStandardForschungPreis = 10000;
	private static final int startTrekkingradPremiumForschungPreis = 10000;
	private static final int startRennradStandardForschungPreis = 10000;
	private static final int startRennradPremiumForschungPreis = 10000;
	private static final int startBrandschutzPreis = 5000;
	private static final int startReparaturVertragPreis = 3000;
	private static final int startRechtsschutzVersicherungPreis = 2000;
	
	public static int getStartMitarbeiterAnzahl() {
		return startMitarbeiterAnzahl;
	}
	public static int getStartGehaltMitarbeiter() {
		return startGehaltMitarbeiter;
	}
	public static int getStartKontostand() {
		return startKontostand;
	}
	public static int getStartLagerkapazitaet() {
		return startLagerKapazitaet;
	}
	public static int getStartAnzahlMaschinen() {
		return startAnzahlMaschinen;
	}
	public static int getStartProduktionsKapazitaetMaschine() {
		return startProduktionsKapazitaetMaschine;
	}
	public static int getStartMaterialAnzahl() {
		return startMaterialAnzahl;
	}
	public static int getStartFahrradPlatzbedarf() {
		return startFahrradPlatzbedarf;
	}
	public static int[] getStartMaterialPlatzbedarf() {
		return startMaterialPlatzbedarf;
	}
	public static int getStartGebuehrProUeberschritteneEinheit() {
		return startGebuehrProUeberschritteneEinheit;
	}
	public static int getStartMaschinenPreis() {
		return startMaschinenPreis;
	}
	public static int getStartMitarbeiterProMaschine() {
		return startMitarbeiterProMaschine;
	}
	public static int getStartMaschinenUpgradeWert() {
		return startMaschinenUpgradeWert;
	}
	public static int getStartMaschinenUpgradePreis() {
		return startMaschinenUpgradePreis;
	}
	public static int getStartLagerkapazitaetErhoehenWert() {
		return startLagerKapazitaetErhoehenWert;
	}
	public static int getStartLagerkapazitaetErhoehenPreis() {
		return startLagerKapazitaetErhoehenPreis;
	}
	public static int getStartMtbPremPatentPreis() {
		return startMtbPremPatentPreis;
	}
	public static int getStartTrekkingPremPatentPreis() {
		return startTrekkingPremPatentPreis;
	}
	public static int getStartRennradPremPatentPreis() {
		return startRennradPremPatentPreis;
	}
	public static int getStartMtbStandardForschungPreis() {
		return startMtbStandardForschungPreis;
	}
	public static int getStartMtbPremiumForschungPreis() {
		return startMtbPremiumForschungPreis;
	}
	public static int getStartTrekkingradStandardForschungPreis() {
		return startTrekkingradStandardForschungPreis;
	}
	public static int getStartTrekkingradPremiumForschungPreis() {
		return startTrekkingradPremiumForschungPreis;
	}
	public static int getStartRennradStandardForschungPreis() {
		return startRennradStandardForschungPreis;
	}
	public static int getStartRennradPremiumForschungPreis() {
		return startRennradPremiumForschungPreis;
	}
	public static int getStartBrandschutzPreis() {
		return startBrandschutzPreis;
	}
	public static int getStartReparaturVertragPreis() {
		return startReparaturVertragPreis;
	}
	public static int getStartRechtsschutzVersicherungPreis() {
		return startRechtsschutzVersicherungPreis;
	}
	public static Unternehmen getAktuellesUnternehmen(){
		return aktuellesUnternehmen;
	}	
	public static Vector<Unternehmen> getAlleUnternehmen(){
		return alleUnternehmen;
	}
	public static int getRundenNr(){
		return runde;
	}
	public static int getFixkosten(){
		return fixkosten;
	}

	/**
	 * Funktion wird aus der Klasse Start aufgerufen
	 * @param spieler1 Name von Spieler 1
	 * @param spieler2 Name von Spieler 2
	 * @param spieler3 Name von Spieler 3
	 */
	public static void starteSpiel(String spieler1, String spieler2, String spieler3) {
		String[] args = new String[3];
		args[0] = spieler1;
		args[1] = spieler2;
		args[2] = spieler3;
		
		/** Zunächst 3 Unternehmen erzeugen = 3 verschiedene Spieler **/
		
		for (int i = 0; i < 3; i++) {
			Unternehmen unternehmen = new Unternehmen(args[i]);
			alleUnternehmen.add(unternehmen);
		}
		
		/** Zu Beginn alle Anbieter mit den dazugehörigen Materialien erzeugen **/
		
		Anbieter anbieter1 = new Anbieter("anbieter1", 1);
		anbieter1.addMaterial("mtbRahmen", "Mountainbike Rahmen");
		anbieter1.addMaterial("trekkingRahmen", "Trekkingrad Rahmen");
		anbieter1.addMaterial("rennradRahmen", "Rennrad Rahmen");
		anbieter1.addMaterial("mtbLenker", "Mountainbike Lenker");
		anbieter1.addMaterial("trekkingLenker", "Trekkingrad Lenker");
		anbieter1.addMaterial("rennradLenker", "Rennrad Lenker");
		anbieter1.addMaterial("mtbPedal", "Mountainbike Pedal");
		anbieter1.addMaterial("trekkingPedal", "Trekkingrad Pedal");
		anbieter1.addMaterial("rennradPedal", "Rennrad Pedal");
		anbieter1.addMaterial("mtbRadStandard", "Mountainbike Rad St.");
		anbieter1.addMaterial("mtbRadPremium", "Mountainbike Rad Pr.");
		anbieter1.addMaterial("trekkingRadStandard", "Trekking Rad St.");
		anbieter1.addMaterial("trekkingRadPremium", "Trekking Rad Pr.");
		anbieter1.addMaterial("rennradRadStandard", "Rennrad Rad St.");
		anbieter1.addMaterial("rennradRadPremium", "Rennrad Rad Pr.");
		anbieter1.addMaterial("mtbSattelStandard", "Mountainbike Sattel St.");
		anbieter1.addMaterial("mtbSattelPremium", "Mountainbike Sattel Pr.");
		anbieter1.addMaterial("trekkingSattelStandard", "Trekking Sattel St.");
		anbieter1.addMaterial("trekkingSattelPremium", "Trekking Sattel Pr.");
		anbieter1.addMaterial("rennradSattelStandard", "Rennrad Sattel St.");
		anbieter1.addMaterial("rennradSattelPremium", "Rennrad Sattel Pr.");
		anbieter1.addMaterial("felgenbremsen", "Felgenbremsen");
		anbieter1.addMaterial("scheibenbremsen", "Scheibenbremsen");
		anbieter1.addMaterial("drehgriffSchaltung", "Drehgriffschaltung");
		anbieter1.addMaterial("triggerSchaltung", "Triggerschaltung");
		anbieter1.addMaterial("kette", "Kette");
		Marktplatz.addAnbieter(anbieter1);
		
		Anbieter anbieter2 = new Anbieter("anbieter2", 2);
		anbieter2.addMaterial("mtbRahmen", "Mountainbike Rahmen");
		anbieter2.addMaterial("trekkingRahmen", "Trekkingrad Rahmen");
		anbieter2.addMaterial("rennradRahmen", "Rennrad Rahmen");
		anbieter2.addMaterial("mtbLenker", "Mountainbike Lenker");
		anbieter2.addMaterial("trekkingLenker", "Trekkingrad Lenker");
		anbieter2.addMaterial("rennradLenker", "Rennrad Lenker");
		anbieter2.addMaterial("mtbPedal", "Mountainbike Pedal");
		anbieter2.addMaterial("trekkingPedal", "Trekkingrad Pedal");
		anbieter2.addMaterial("rennradPedal", "Rennrad Pedal");
		anbieter2.addMaterial("mtbRadStandard", "Mountainbike Rad St.");
		anbieter2.addMaterial("mtbRadPremium", "Mountainbike Rad Pr.");
		anbieter2.addMaterial("trekkingRadStandard", "Trekking Rad St.");
		anbieter2.addMaterial("trekkingRadPremium", "Trekking Rad Pr.");
		anbieter2.addMaterial("rennradRadStandard", "Rennrad Rad St.");
		anbieter2.addMaterial("rennradRadPremium", "Rennrad Rad Pr.");
		anbieter2.addMaterial("mtbSattelStandard", "Mountainbike Sattel St.");
		anbieter2.addMaterial("mtbSattelPremium", "Mountainbike Sattel Pr.");
		anbieter2.addMaterial("trekkingSattelStandard", "Trekking Sattel St.");
		anbieter2.addMaterial("trekkingSattelPremium", "Trekking Sattel Pr.");
		anbieter2.addMaterial("rennradSattelStandard", "Rennrad Sattel St.");
		anbieter2.addMaterial("rennradSattelPremium", "Rennrad Sattel Pr.");
		anbieter2.addMaterial("felgenbremsen", "Felgenbremsen");
		anbieter2.addMaterial("scheibenbremsen", "Scheibenbremsen");
		anbieter2.addMaterial("drehgriffSchaltung", "Drehgriffschaltung");
		anbieter2.addMaterial("triggerSchaltung", "Triggerschaltung");
		anbieter2.addMaterial("kette", "Kette");
		Marktplatz.addAnbieter(anbieter2);
		
		Anbieter anbieter3 = new Anbieter("anbieter3", 3);
		anbieter3.addMaterial("mtbRahmen", "Mountainbike Rahmen");
		anbieter3.addMaterial("trekkingRahmen", "Trekkingrad Rahmen");
		anbieter3.addMaterial("rennradRahmen", "Rennrad Rahmen");
		anbieter3.addMaterial("mtbLenker", "Mountainbike Lenker");
		anbieter3.addMaterial("trekkingLenker", "Trekkingrad Lenker");
		anbieter3.addMaterial("rennradLenker", "Rennrad Lenker");
		anbieter3.addMaterial("mtbPedal", "Mountainbike Pedal");
		anbieter3.addMaterial("trekkingPedal", "Trekkingrad Pedal");
		anbieter3.addMaterial("rennradPedal", "Rennrad Pedal");
		anbieter3.addMaterial("mtbRadStandard", "Mountainbike Rad St.");
		anbieter3.addMaterial("mtbRadPremium", "Mountainbike Rad Pr.");
		anbieter3.addMaterial("trekkingRadStandard", "Trekkingrad Rad St.");
		anbieter3.addMaterial("trekkingRadPremium", "Trekkingrad Rad Pr.");
		anbieter3.addMaterial("rennradRadStandard", "Rennrad Rad St.");
		anbieter3.addMaterial("rennradRadPremium", "Rennrad Rad Pr.");
		anbieter3.addMaterial("mtbSattelStandard", "Mountainbike Sattel St.");
		anbieter3.addMaterial("mtbSattelPremium", "Mountainbike Sattel Pr.");
		anbieter3.addMaterial("trekkingSattelStandard", "Trekkingrad Sattel St.");
		anbieter3.addMaterial("trekkingSattelPremium", "Trekkingrad Sattel Pr.");
		anbieter3.addMaterial("rennradSattelStandard", "Rennrad Sattel St.");
		anbieter3.addMaterial("rennradSattelPremium", "Rennrad Sattel Pr.");
		anbieter3.addMaterial("felgenbremsen", "Felgenbremsen");
		anbieter3.addMaterial("scheibenbremsen", "Scheibenbremsen");
		anbieter3.addMaterial("drehgriffSchaltung", "Drehgriffschaltung");
		anbieter3.addMaterial("triggerSchaltung", "Triggerschaltung");
		anbieter3.addMaterial("kette", "Kette");
		Marktplatz.addAnbieter(anbieter3);
		
		/** aktuellesUnternehmen hat immer eine Referenz auf das Unternehmen, das gerade am Zug ist **/
		
		aktuellesUnternehmen = alleUnternehmen.get(spielerNr); // erstes Unternehmen auswaählen
		aktuellesUnternehmen.neuerZug();
		//aktuellesUnternehmen.getBank().kreditAufnehmen(5000, 5, 5);
		
		// Diagramm zu Beginn mit Werten füllen + Nachfrage für Beginn des Spiels generieren
		for (int i = 0; i < 8; i++)
			Markt.nachfrageBerechnen();

		Markt.angeboteVerfuegbarkeitAnpassen();
		Markt.angebotePreiseAnpassen();
	}
	
	/**
	 * Mit dieser Methode beendet ein Spieler seinen Zug.
	 * Das UI wird geupdatet und der nächste Spieler ist am Zug.
	 */
	public static void zugBeenden(){
		// Am Ende eines Zugs Kosten abziehen und Kredite tilgen
		Planspiel.getAktuellesUnternehmen().kostenAbziehen();
		Planspiel.getAktuellesUnternehmen().getBank().krediteTilgen();
		
		if (spielerNr < 2){
			spielerNr++;
		}
		else {
			Markt.fahrraederAbkaufen(); // Erträge werden auch im Cashflow gespeichert
			Markt.angeboteVerfuegbarkeitAnpassen();
			Markt.angebotePreiseAnpassen();
			// alle 3 Runden die Nachfrage berechnen und auf eventuelle Wirtschaftskrise prüfen
			if ((runde % 3) == 0) {
				Zufallsereignis.globalZufall();
				Markt.nachfrageBerechnen();
			}
			spielerNr = 0;
			runde++;

			// am Ende einer Runde den Cashflow aller Unternehmen speichern
			for (int i = 0; i < alleUnternehmen.size(); i++){
				alleUnternehmen.get(i).saveCashflow();
			}	
		}
		aktuellesUnternehmen = alleUnternehmen.get(spielerNr);
		
		/**
		 *  Nach 24 Runden wird das Spiel beendet.
		 *  Dies geschieht in der Methode spielBeenden() in der Klasse UI.
		 */
		if (runde == 24) return;
		
		aktuellesUnternehmen.neuerZug();
	}
}