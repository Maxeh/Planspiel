package spiel;
import java.util.Vector;


public class Fabrik {
	
	private Lager lager;
	private int anzahlMaschinen;
	private int produktionsKapazitaetProMaschine;
	private int produktionsKapazitaet; // ergibt sich aus anzahlMaschinen * produktionsKapazitaetProMaschine
	private int anzahlInProduktion = 0;
	private Vector<Fahrrad> produktionsliste = new Vector<Fahrrad>();

	public Lager getLager(){
		return lager;
	}
	public int getProduktionsKapazitaet(){
		return produktionsKapazitaet;
	}
	public int getProduktionsKapazitaetProMaschine() {
		return produktionsKapazitaetProMaschine;
	}
	public int getAnzahlMaschinen() {
		return anzahlMaschinen;
	}
	public int getAnzahlInProduktion() {
		return anzahlInProduktion;
	}
	public Fahrrad[] getProduktionsliste() {
		Fahrrad[] produktionsliste = new Fahrrad[this.produktionsliste.size()];
		for (int i = 0; i < this.produktionsliste.size(); i++) {
			produktionsliste[i] = this.produktionsliste.get(i);
		}
		return produktionsliste;		
	}
	
	
	/** KONSTRUKTOR **/
	public Fabrik() {
		anzahlMaschinen = Planspiel.getStartAnzahlMaschinen();
		produktionsKapazitaetProMaschine = Planspiel.getStartProduktionsKapazitaetMaschine();
		produktionsKapazitaet = anzahlMaschinen * produktionsKapazitaetProMaschine;
		lager = new Lager();	
	}

	/**
	 * Methode wird aus der Klasse "Entwicklung" heraus aufgerufen.
	 * Die Produktionskapazitaet der Maschinen wird erhöht.
	 * @param wert Gibt an um wieviel die Produktionskapazität erhöht wird.
	 */
	public void produktionsKapazitaetProMaschineErhoehen(int wert){
		produktionsKapazitaetProMaschine += wert;
		produktionsKapazitaet = anzahlMaschinen * produktionsKapazitaetProMaschine;
	}
	
	/**
	 * Methode wird aus der Klasse "Entwicklung" heraus aufgerufen.
	 * Die Anzahl der Maschinen wird erhöht.
	 * @param anzahl Gibt an um wieviel die Maschinen erhöht werden.
	 */
	public void anzahlMaschinenErhoehen(){
		anzahlMaschinen++;
		produktionsKapazitaet = anzahlMaschinen * produktionsKapazitaetProMaschine;
	}
	
	/**
	 * Methode wird aus der Klasse "Entwicklung" heraus aufgerufen.
	 * Die Anzahl der Maschinen wird verringert.
	 * @param anzahl Gibt an um wieviel die Maschinen verringert werden.
	 */
	public void anzahlMaschinenVerringern(int anzahl){
		anzahlMaschinen -= anzahl;	
		produktionsKapazitaet = anzahlMaschinen * produktionsKapazitaetProMaschine;
	}
	
	/**
	 * Diese Methode speichert die Anzahl der zu produzierenden Fahrräder als Fahrrad-Objekt im Vektor "produktionsliste".
	 * @param typ Typ des Fahrrads.
	 * @param anzahl Anzahl der Fahrräder, die produziert werden sollen.
	 * @return true wenn Fahrrad/Fahrräder produziert werden kann, sonst false
	 */
	public boolean fahrradProduzieren(String typ, int anzahl){
		if (anzahl <= 0) return false;
		
		if ((anzahlInProduktion + anzahl) <= produktionsKapazitaet) {
			@SuppressWarnings("unused")
			boolean materialVerfuegbar;
			Fahrrad fahrrad;
				
			switch(typ){
				case "mtbStandard" : 
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("mtbRahmen", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("mtbLenker", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("mtbPedal", 2 * anzahl))) return false; 
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("mtbRadStandard", 2 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("mtbSattelStandard", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("felgenbremsen", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("drehgriffSchaltung", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("kette", 1 * anzahl))) return false;
					
					lager.fahrradUndMaterialAuslagern("mtbRahmen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("mtbLenker", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("mtbPedal", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("mtbRadStandard", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("mtbSattelStandard", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("felgenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("drehgriffSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("kette", 1 * anzahl);
					
					fahrrad = new Fahrrad("mtbStandard", "Mountainbike Standard", anzahl);
					produktionsliste.add(fahrrad);
					anzahlInProduktion += anzahl;
					return true;
					
				case "mtbPremium" :
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("mtbRahmen", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("mtbLenker", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("mtbPedal", 2 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("mtbRadPremium", 2 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("mtbSattelPremium", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("scheibenbremsen", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("triggerSchaltung", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("kette", 1 * anzahl))) return false;
					
					lager.fahrradUndMaterialAuslagern("mtbRahmen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("mtbLenker", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("mtbPedal", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("mtbRadPremium", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("mtbSattelPremium", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("scheibenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("triggerSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("kette", 1 * anzahl);		
					
					fahrrad = new Fahrrad("mtbPremium", "Mountainbike Premium", anzahl);
					produktionsliste.add(fahrrad);
					anzahlInProduktion += anzahl;
					return true;
					
			    case "trekkingradStandard" :
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("trekkingRahmen", 1 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("trekkingLenker", 1 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("trekkingPedal", 2 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("trekkingRadStandard", 2 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("trekkingSattelStandard", 1 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("felgenbremsen", 1 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("drehgriffSchaltung", 1 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("kette", 1 * anzahl))) return false;
								
					lager.fahrradUndMaterialAuslagern("trekkingRahmen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("trekkingLenker", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("trekkingPedal", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("trekkingRadStandard", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("trekkingSattelStandard", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("felgenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("drehgriffSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("kette", 1 * anzahl);		
						
					fahrrad = new Fahrrad("trekkingradStandard", "Trekkingrad Standard", anzahl);
					produktionsliste.add(fahrrad);
					anzahlInProduktion += anzahl;
					return true;
				
				case "trekkingradPremium" :
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("trekkingRahmen", 1 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("trekkingLenker", 1 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("trekkingPedal", 2 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("trekkingRadPremium", 2 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("trekkingSattelPremium", 1 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("scheibenbremsen", 1 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("triggerSchaltung", 1 * anzahl))) return false;
			    	if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("kette", 1 * anzahl))) return false;
						
					lager.fahrradUndMaterialAuslagern("trekkingRahmen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("trekkingLenker", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("trekkingPedal", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("trekkingRadPremium", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("trekkingSattelPremium", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("scheibenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("triggerSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("kette", 1 * anzahl);		
						
					fahrrad = new Fahrrad("trekkingradPremium", "Trekkingrad Premium", anzahl);
					produktionsliste.add(fahrrad);
					anzahlInProduktion += anzahl;
					return true;
					
				case "rennradStandard" :
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("rennradRahmen", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("rennradLenker", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("rennradPedal", 2 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("rennradRadStandard", 2 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("rennradSattelStandard", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("felgenbremsen", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("triggerSchaltung", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("kette", 1 * anzahl))) return false;
							
					lager.fahrradUndMaterialAuslagern("rennradRahmen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("rennradLenker", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("rennradPedal", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("rennradRadStandard", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("rennradSattelStandard", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("felgenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("triggerSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("kette", 1 * anzahl);		
						
					fahrrad = new Fahrrad("rennradStandard", "Rennrad Standard", anzahl);
					produktionsliste.add(fahrrad);
					anzahlInProduktion += anzahl;
					return true;
					
				case "rennradPremium" :
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("rennradRahmen", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("rennradLenker", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("rennradPedal", 2 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("rennradRadPremium", 2 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("rennradSattelPremium", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("felgenbremsen", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("triggerSchaltung", 1 * anzahl))) return false;
					if (!(materialVerfuegbar = lager.materialUndFahrradVerfuegbarkeitPruefen("kette", 1 * anzahl))) return false;
						
					lager.fahrradUndMaterialAuslagern("rennradRahmen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("rennradLenker", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("rennradPedal", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("rennradRadPremium", 2 * anzahl);
					lager.fahrradUndMaterialAuslagern("rennradSattelPremium", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("felgenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("triggerSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialAuslagern("kette", 1 * anzahl);		
						
					fahrrad = new Fahrrad("rennradPremium", "Rennrad Premium", anzahl);
					produktionsliste.add(fahrrad);
					anzahlInProduktion += anzahl;
					return true;
			}
		} // if
		
		return false;
	}

	/**
	 * Diese Methode löscht einen Eintrag aus der Produktionsliste.
	 * @param index Gibt die Stelle an, die aus der Produktionsliste entfernt werden soll.
	 */
	public void deleteEintragInProduktionsliste(int index){
		if (produktionsliste.size() > index){
			Fahrrad auftrag = produktionsliste.get(index);
			int anzahl = auftrag.getAnzahl();
			
			switch(auftrag.getTyp()){
				case "mtbStandard": 
					lager.fahrradUndMaterialEinlagern("mtbRahmen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("mtbLenker", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("mtbPedal", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("mtbRadStandard", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("mtbSattelStandard", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("felgenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("drehgriffSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("kette", 1 * anzahl);
					break;
				case "mtbPremium":
					lager.fahrradUndMaterialEinlagern("mtbRahmen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("mtbLenker", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("mtbPedal", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("mtbRadPremium", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("mtbSattelPremium", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("scheibenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("triggerSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("kette", 1 * anzahl);	
					break;
				case "trekkingradStandard": 
					lager.fahrradUndMaterialEinlagern("trekkingRahmen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("trekkingLenker", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("trekkingPedal", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("trekkingRadStandard", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("trekkingSattelStandard", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("felgenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("drehgriffSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("kette", 1 * anzahl);	
					break;
				case "trekkingradPremium":
					lager.fahrradUndMaterialEinlagern("trekkingRahmen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("trekkingLenker", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("trekkingPedal", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("trekkingRadPremium", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("trekkingSattelPremium", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("scheibenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("triggerSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("kette", 1 * anzahl);	
					break;
				case "rennradStandard":
					lager.fahrradUndMaterialEinlagern("rennradRahmen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("rennradLenker", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("rennradPedal", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("rennradRadStandard", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("rennradSattelStandard", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("felgenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("triggerSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("kette", 1 * anzahl);	
					break;
				case "rennradPremium":
					lager.fahrradUndMaterialEinlagern("rennradRahmen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("rennradLenker", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("rennradPedal", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("rennradRadPremium", 2 * anzahl);
					lager.fahrradUndMaterialEinlagern("rennradSattelPremium", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("felgenbremsen", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("triggerSchaltung", 1 * anzahl);
					lager.fahrradUndMaterialEinlagern("kette", 1 * anzahl);	
					break;
			}

			anzahlInProduktion -= anzahl;
			produktionsliste.removeElementAt(index);
		}
	}	
	
	/**
	 *  Methode wird zu Beginn des Zugs aufgerufen, in der Methode neuerZug() der Klasse Unternehmen.
	 *  Produzierte Fahrräder aus der Produktionsliste werden dem Lager hinzugefügt.
	 */
	public void produktionFertig(){
		anzahlInProduktion = 0;
		
		for (int i = 0; i < produktionsliste.size(); i++)
			lager.fahrradUndMaterialEinlagern(produktionsliste.get(i).getTyp(), produktionsliste.get(i).getAnzahl());
		
		produktionsliste.clear();
	}	
}
