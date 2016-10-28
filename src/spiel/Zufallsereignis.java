package spiel;

public final class Zufallsereignis {
	
	/**
	 * Wird zu Beginn jeden Zugs in der Klasse Unternehmen in der Methode neuerZug() aufgerufen.
	 * Mit einer Wahrscheinlichkeit von 45% tritt eines der 3 Zufallsereignisse ein.
	 */
	public static void zufall(){
		/** Zufallszahl zwischen 1 und 20 generieren **/
		int zufallsZahl = (int) (Math.round(Math.random() * 20)); 
		if (zufallsZahl == 0) zufallsZahl++;
		
		// 15% Chance
		if (zufallsZahl <= 3)
			lagerBrand();
		
		// 15% Chance
		if (zufallsZahl > 3 && zufallsZahl <= 6)
			maschineDefekt();
		
		// 15% Chance
		if (zufallsZahl > 6 && zufallsZahl <= 9)
			rechtsstreit();
	}
	
	/**
	 * Methode wird alle 3 Runden aufgerufen, bevor die Nachfrage berechnet wird.
	 */
	public static void globalZufall(){
		/** Zufallszahl zwischen 1 und 10 generieren **/
		int zufallsZahl = (int) (Math.round(Math.random() * 10)); 
		if (zufallsZahl == 0) zufallsZahl++;
		
		// 20% Chance
		if (zufallsZahl <= 2)
			wirtschaftsKrise();
	}

	/**
	 * Diese Methode stellt einen Lagerbrand da, bei dem 70% eines bestimmten Materials aus dem Lager verloren geht. Es wird zunächst eine Zufallszahl generiert,
	 * die als Materialnummer innerhalb des Lagerarrays dient. Dieser vorgang wird so lange wiederholt, bis die Nummer eines Materials bestimmt wurde, von dem es
	 * mehr als 0 gibt. Anschließend wird von dessen Menge 70 Prozent abgezogen.
	 */
	public static void lagerBrand(){
		
		// Spieler hat eine Versicherung
		if (Planspiel.getAktuellesUnternehmen().getVersicherung().isBrandschutz()) return; 
		
		if (Planspiel.getAktuellesUnternehmen().getLager().getBelegterSpeicher() == 0) return;
		
		String[] lagerInhalt = {
				"mtbStandard","mtbPremium","trekkingradStandard","trekkingradPremium","rennradStandard","rennradPremium",//Fahrräder
				"mtbRahmen","trekkingRahmen","rennradRahmen", //Rahmen
				"mtbLenker","trekkingLenker","rennradLenker", // Lenker
				"mtbPedal", "trekkingPedal", "rennradPedal",  // Pedale
				"mtbRadStandard", "mtbRadPremium", "trekkingRadStandard", "trekkingRadPremium", "rennradRadStandard", "rennradRadPremium", //Räder
				"mtbSattelStandard", "mtbSattelPremium", "trekkingSattelStandard", "trekkingSattelPremium", "rennradSattelStandard", "rennradSattelPremium",//Sattel
				"felgenbremsen", "scheibenbremsen", //Bremsen
				"drehgriffSchaltung", "triggerSchaltung", // Schaltungen
				"kette"
		};
		
		boolean lagerBrand = false;
		while (!lagerBrand) {
			//bestimmt zufällig, welches Material im Lager durch den Brand betroffen wird.
			int materialNummer = (int)(Math.round(Math.random() * 31)); 
			String materialName = lagerInhalt[materialNummer];
			int anzahl = Planspiel.getAktuellesUnternehmen().getLager().getLagerInhalt()[materialNummer];
			
			//material finden, das nicht gleich 0 ist
			if (anzahl > 0){
				int anzahlVerbrannt = (int) Math.round(anzahl * 0.4);
				Planspiel.getAktuellesUnternehmen().getLager().fahrradUndMaterialAuslagern(materialName, anzahlVerbrannt);
				
				Planspiel.getAktuellesUnternehmen().setLagerBrand(1, anzahl, materialNummer);
				lagerBrand = true;
			}				
		}
	}

	/**
	 * Wenn eine Maschine defekt ist, werden dem Spieler Reparaturkosten berechnet, die zwischen 18000€ und 25000€ liegen.
	 */
	public static void maschineDefekt(){
	
		// Spieler hat eine Versicherung
		if (Planspiel.getAktuellesUnternehmen().getVersicherung().isReparaturVertrag()) return; 
		
		int preis = (int) Math.round(Math.random() * (25000 - 18000) + 18000);
		Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
		
		// auch im Cashflow als zahlungswirksamer Aufwand vermerken
		Planspiel.getAktuellesUnternehmen().getCashflow().setSonstige(Planspiel.getAktuellesUnternehmen().getCashflow().getSonstige() + preis);
		
		Planspiel.getAktuellesUnternehmen().setMaschineDefekt(1, preis);
	}
	
	/**
	 * Wenn der Spieler einen Rechtsstreit verliert, werden dem Spieler Kosten berechnet, die zwischen 13000€ und 17000€ liegen.
	 */
	public static void rechtsstreit(){
		
		// Spieler hat eine Versicherung
		if (Planspiel.getAktuellesUnternehmen().getVersicherung().isRechtsschutzVersicherung())	return;
		
		int preis = (int) Math.round(Math.random() * (17000 - 13000) + 13000);
		Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
		
		// auch im Cashflow als zahlungswirksamer Aufwand vermerken
		Planspiel.getAktuellesUnternehmen().getCashflow().setSonstige(Planspiel.getAktuellesUnternehmen().getCashflow().getSonstige() + preis);
		
		Planspiel.getAktuellesUnternehmen().setRechtsstreit(1, preis);
	}

	/** 
	 * Globales Zufallsereignis.
	 * Wenn es eine Wirtschaftskrise gibt, geht die Nachfrage für 3 Runden stark zurück.
	 */
	public static void wirtschaftsKrise(){
		Markt.setWirtschaftsKrise(true);
	}
	
}
