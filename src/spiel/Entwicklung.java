package spiel;

public class Entwicklung {

	private int levelMaschinen = 0; // Maschinen können maximal 5 Mal aufgerüstet werden
	private int levelLager = 0; // Lager kann beliebig oft erweitert werden
	private boolean mtbStandardMarktforschung = true;
	private boolean mtbPremiumMarktforschung = false;
	private boolean trekkingradStandardMarktforschung = false;
	private boolean trekkingradPremiumMarktforschung = false;
	private boolean rennradStandardMarktforschung = false;
	private boolean rennradPremiumMarktforschung = false;
	private boolean patentMtbPrem = false;
	private boolean patentTrekkingPrem = false;
	private boolean patentRennradPrem = false;
	
	public int getLevelMaschinen() {
		return levelMaschinen;
	}
	public int getLevelLager() {
		return levelLager;
	}
	public boolean isPatentMountainbikePrem() {
		return patentMtbPrem;
	}
	public boolean isPatentTrekkingradPrem() {
		return patentTrekkingPrem;
	}
	public boolean isPatentRennradPrem() {
		return patentRennradPrem;
	}
	public boolean isMtbStandardMarktforschung() {
		return mtbStandardMarktforschung;
	}
	public boolean isMtbPremiumMarktforschung() {
		return mtbPremiumMarktforschung;
	}
	public boolean isTrekkingradStandardMarktforschung() {
		return trekkingradStandardMarktforschung;
	}
	public boolean isTrekkingradPremiumMarktforschung() {
		return trekkingradPremiumMarktforschung;
	}
	public boolean isRennradStandardMarktforschung() {
		return rennradStandardMarktforschung;
	}
	public boolean isRennradPremiumMarktforschung() {
		return rennradPremiumMarktforschung;
	}
	
	/**
	 * Die Anzahl der Maschinen, die gekauft werden kann, ist nicht begrenzt.
	 * Je mehr Maschinen ein Spieler hat, desto mehr laufende Kosten entstehen (neue Mitarbeiter).
	 * @param wert Gibt an wieviele Maschinen gekauft werden sollen.
	 * @return true wenn Maschine gekauft werden konnte, sonst false
	 */
	public boolean maschineKaufen(){
		int preis = Planspiel.getStartMaschinenPreis();
		int mitarbeiter = Planspiel.getStartMitarbeiterProMaschine();
		
		if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
			Planspiel.getAktuellesUnternehmen().getFabrik().anzahlMaschinenErhoehen();
			Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
	
			// neue Mitarbeiter einstellen
			Planspiel.getAktuellesUnternehmen().setAnzahlMitarbeiter(Planspiel.getAktuellesUnternehmen().getAnzahlMitarbeiter() + mitarbeiter);
			return true;
		}
		return false;
	}
	
	/**
	 * Die Produktionskapazität der Maschinen kann bis zu 5 Mal erhöht werden.
	 * Der Preis pro Erhöhunug sowie der Wert der Erhöhung wird zu Beginn in der Klasse Planspiel festgelegt.
	 * Je öfter ein Upgrade durchgeführt wird, desto teurer wird dieses.
	 * @return true wenn Maschinen-Upgrade durchgeführt werden konnte, sonst false
	 */
	public boolean maschinenUpgrade(){
		if (levelMaschinen < 5){
			int preis = Planspiel.getStartMaschinenUpgradePreis();
			int wert = Planspiel.getStartMaschinenUpgradeWert();
			
			if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
				levelMaschinen++;
				Planspiel.getAktuellesUnternehmen().getFabrik().produktionsKapazitaetProMaschineErhoehen(wert);
				Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Die Anzahl der Lager-Upgrades ist nicht begrenzt.
	 * Die Lagerkapazität kann nicht mehr verringert werden.
	 * @return true wenn Kapazität erhöht werden konnte, sonst false
	 */
	public boolean lagerKapazitaetErhoehen(){
		int preis = Planspiel.getStartLagerkapazitaetErhoehenPreis();
		int wert = Planspiel.getStartLagerkapazitaetErhoehenWert();
		
		if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
			levelLager++;
			Planspiel.getAktuellesUnternehmen().getLager().lagerKapazitaetErhoehen(wert);
			Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
			
			return true;
		}
		return false;
	}
	
	/**
	 * Jeder Spieler kann den Markt erforschen, um bessere Prognosen für die Entwicklung der Nachfrage zu bekommen.
	 * Die Nachfrage des Mountainbikes ist bereits zu Beginn erforscht.
	 * @param typ ["mtbStandard", "mtbPremium", "trekkingradStandard", "trekkingradPremium", "rennradStandard", "rennradPremium"] Fahrradtyp, der am Markt erforscht werden soll.
	 * @return true wenn Markt erforscht werden konnte, sonst false
	 */
	public boolean marktErforschen(String typ){
		int preis;
		switch(typ){
		
			case "mtbStandard": 
				if (isMtbStandardMarktforschung()) return false;
				preis = Planspiel.getStartMtbStandardForschungPreis(); 
				if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
					Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
					mtbStandardMarktforschung = true;
					
					/** Marktforschung geht als zahlungswirksamer Aufwand in den Cashflow ein **/
					Planspiel.getAktuellesUnternehmen().getCashflow().setMarktforschungsKosten(Planspiel.getAktuellesUnternehmen().getCashflow().getMarktforschungsKosten() + preis);
					return true;
				}
				return false;
				
			case "mtbPremium": 
				if (isMtbPremiumMarktforschung()) break;
				preis = Planspiel.getStartMtbPremiumForschungPreis(); 
				if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
					Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
					mtbPremiumMarktforschung = true;
					
					/** Marktforschung geht als zahlungswirksamer Aufwand in den Cashflow ein **/
					Planspiel.getAktuellesUnternehmen().getCashflow().setMarktforschungsKosten(Planspiel.getAktuellesUnternehmen().getCashflow().getMarktforschungsKosten() + preis);
					return true;
				}
				return false;
			
			case "trekkingradStandard": 
				if (isTrekkingradStandardMarktforschung()) break;
				preis = Planspiel.getStartTrekkingradStandardForschungPreis(); 
				if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
					Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
					trekkingradStandardMarktforschung = true;
					
					/** Marktforschung geht als zahlungswirksamer Aufwand in den Cashflow ein **/
					Planspiel.getAktuellesUnternehmen().getCashflow().setMarktforschungsKosten(Planspiel.getAktuellesUnternehmen().getCashflow().getMarktforschungsKosten() + preis);
					return true;
				}
				return false;
				
			case "trekkingradPremium": 
				if (isTrekkingradPremiumMarktforschung()) break;
				preis = Planspiel.getStartTrekkingradPremiumForschungPreis(); 
				if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
					Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
					trekkingradPremiumMarktforschung = true;
					
					/** Marktforschung geht als zahlungswirksamer Aufwand in den Cashflow ein **/
					Planspiel.getAktuellesUnternehmen().getCashflow().setMarktforschungsKosten(Planspiel.getAktuellesUnternehmen().getCashflow().getMarktforschungsKosten() + preis);
					return true;
				}
				return false;
					
			case "rennradStandard":
				if (isRennradStandardMarktforschung()) break;
				preis = Planspiel.getStartRennradStandardForschungPreis(); 
				if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
					Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
					rennradStandardMarktforschung = true;
					
					/** Marktforschung geht als zahlungswirksamer Aufwand in den Cashflow ein **/
					Planspiel.getAktuellesUnternehmen().getCashflow().setMarktforschungsKosten(Planspiel.getAktuellesUnternehmen().getCashflow().getMarktforschungsKosten() + preis);
					return true;
				}
				return false;
				
			case "rennradPremium":
				if (isRennradPremiumMarktforschung()) break;
				preis = Planspiel.getStartRennradPremiumForschungPreis(); 
				if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
					Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
					rennradPremiumMarktforschung = true;
					
					/** Marktforschung geht als zahlungswirksamer Aufwand in den Cashflow ein **/
					Planspiel.getAktuellesUnternehmen().getCashflow().setMarktforschungsKosten(Planspiel.getAktuellesUnternehmen().getCashflow().getMarktforschungsKosten() + preis);
					return true;
				}
				return false;
		}
		return false;
	}
	
	/**
	 * Die Methode wird alle 3 Runden aufgerufen.
	 * Die Spieler kaufen die Marktforschung immer nur für den Zeitraum bis zur nächsten Nachfrageberechnung.
	 */
	public void resetMarktforschung(){
		 if (Planspiel.getRundenNr() != 1) mtbStandardMarktforschung = false; // in der ersten Runde hat jeder Spieler bereits mtbStandardMarktforschung = true
		 mtbPremiumMarktforschung = false;
		 trekkingradStandardMarktforschung = false;
		 trekkingradPremiumMarktforschung = false;
		 rennradStandardMarktforschung = false;
		 rennradPremiumMarktforschung = false;
	}
	
	/**
	 * Für jedes Premium-Modell eines Fahrrads muss ein Patent gekauft werden.
	 * @param typ ["mtb","trekking","rennrad"] Gibt an welches Patent gekauft wird.
	 * @return true wenn das Patent gekauft werden konnte, sonst false
	 */
	public boolean patentKaufen(String typ){
		int preis;
		switch(typ){
			case "mtb": 
				preis = Planspiel.getStartMtbPremPatentPreis(); 
				if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
					Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
					patentMtbPrem = true;
					return true;
				}
				
			case "trekking":
				preis = Planspiel.getStartTrekkingPremPatentPreis(); 
				if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
					Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
					patentTrekkingPrem = true;
					return true;
				}
				
			case "rennrad":
				preis = Planspiel.getStartRennradPremPatentPreis(); 
				if (Planspiel.getAktuellesUnternehmen().getBank().getKontostand() >= preis){
					Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(preis);
					patentRennradPrem = true;
					return true;
				}
		}	
		return false;
	}
}
