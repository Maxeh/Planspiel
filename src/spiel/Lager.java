package spiel;

public class Lager {
	
	private int lagerKapazitaet;

	// jedes Fahrrad hat den gleichen Platzbedarf
	private int fahrradPlatzbedarf; 
	
	// zu Beginn des Spielers hat jeder Spieler 50 Fahrräder von den Standard-Typen
	private int mtbStandard = 150;
	private int mtbPremium = 0;
	private int trekkingradStandard = 150;
	private int trekkingradPremium = 0;
	private int rennradStandard = 150;
	private int rennradPremium = 0;
	/**
	 * alle Materialien werden als Array gespeichert
	 * erster Wert des Arrays => Anzahl der Materialien
	 * zweiter Wert des Arrays => PLatzbedarf für das jeweilige Material 
	 */
	private int[] mtbRahmen = new int[2];
	private int[] trekkingRahmen = new int[2];
	private int[] rennradRahmen = new int[2];
	
	private int[] mtbLenker = new int[2];
	private int[] trekkingLenker = new int[2];
	private int[] rennradLenker  = new int[2];
	
	private int[] mtbPedal = new int[2];
	private int[] trekkingPedal = new int[2];
	private int[] rennradPedal = new int[2];

	private int[] mtbRadStandard = new int[2];
	private int[] mtbRadPremium = new int[2];
	private int[] trekkingRadStandard = new int[2];
	private int[] trekkingRadPremium = new int[2];
	private int[] rennradRadStandard = new int[2];
	private int[] rennradRadPremium = new int[2];
	
	private int[] mtbSattelStandard = new int[2];
	private int[] mtbSattelPremium = new int[2];
	private int[] trekkingSattelStandard = new int[2];
	private int[] trekkingSattelPremium = new int[2];
	private int[] rennradSattelStandard = new int[2];
	private int[] rennradSattelPremium = new int[2];
	
	private int[] felgenbremsen = new int[2];
	private int[] scheibenbremsen = new int[2];
	
	private int[] drehgriffSchaltung = new int[2];
	private int[] triggerSchaltung = new int[2];
	
	private int[] kette = new int[2];
	

	public int getLagerKapazitaet(){
		return lagerKapazitaet;
	}

	/** KONSTRUKTOR **/
	public Lager(){
		lagerKapazitaet = Planspiel.getStartLagerkapazitaet();
		fahrradPlatzbedarf = Planspiel.getStartFahrradPlatzbedarf();
		int[] materialPlatzbedarf = Planspiel.getStartMaterialPlatzbedarf();
		int materialAnzahl = Planspiel.getStartMaterialAnzahl();
		
		/**
		 *  Jeder Spieler hat am Anfang genügend Materialien um genau:
		 *  100 Mountainbikes
		 *  100 Trekkingräder
		 *  100 Rennräder
		 *  zu produzieren 
		 */
		mtbRahmen[0] = materialAnzahl;
		mtbRahmen[1] = materialPlatzbedarf[0];
		trekkingRahmen[0] = materialAnzahl;
		trekkingRahmen[1] = materialPlatzbedarf[0];
		rennradRahmen[0] = materialAnzahl;
		rennradRahmen[1] = materialPlatzbedarf[0];
		mtbLenker[0] = materialAnzahl;
		mtbLenker[1] = materialPlatzbedarf[1];
		trekkingLenker[0] = materialAnzahl;
		trekkingLenker[1] = materialPlatzbedarf[1];
		rennradLenker [0] = materialAnzahl;
		rennradLenker [1] = materialPlatzbedarf[1];
		mtbPedal[0] = materialAnzahl * 2;
		mtbPedal[1] = materialPlatzbedarf[2];
		trekkingPedal[0] = materialAnzahl * 2;
		trekkingPedal[1] = materialPlatzbedarf[2];
		rennradPedal[0] = materialAnzahl * 2;
		rennradPedal[1] = materialPlatzbedarf[2];
		mtbRadStandard[0] = materialAnzahl * 2;
		mtbRadStandard[1] = materialPlatzbedarf[3];
		mtbRadPremium[0] = 0;
		mtbRadPremium[1] = materialPlatzbedarf[3];
		trekkingRadStandard[0] = materialAnzahl * 2;
		trekkingRadStandard[1] = materialPlatzbedarf[3];
		trekkingRadPremium[0] = 0;
		trekkingRadPremium[1] = materialPlatzbedarf[3];
		rennradRadStandard[0] = materialAnzahl * 2;
		rennradRadStandard[1] = materialPlatzbedarf[3];
		rennradRadPremium[0] = 0;	
		rennradRadPremium[1] = materialPlatzbedarf[3];
		mtbSattelStandard[0] = materialAnzahl;
		mtbSattelStandard[1] = materialPlatzbedarf[4];
		mtbSattelPremium[0] = 0;
		mtbSattelPremium[1] = materialPlatzbedarf[4];
		trekkingSattelStandard[0] = materialAnzahl;
		trekkingSattelStandard[1] = materialPlatzbedarf[4];
		trekkingSattelPremium[0] = 0;
		trekkingSattelPremium[1] = materialPlatzbedarf[4];
		rennradSattelStandard[0] = materialAnzahl;
		rennradSattelStandard[1] = materialPlatzbedarf[4];
		rennradSattelPremium[0] = 0;
		rennradSattelPremium[1] = materialPlatzbedarf[4];
		felgenbremsen[0] = materialAnzahl * 3;
		felgenbremsen[1] = materialPlatzbedarf[5];
		scheibenbremsen[0] = 0;
		scheibenbremsen[1] = materialPlatzbedarf[5];
		drehgriffSchaltung[0] = materialAnzahl * 2;
		drehgriffSchaltung[1] = materialPlatzbedarf[6];
		triggerSchaltung[0] = materialAnzahl;
		triggerSchaltung[1] = materialPlatzbedarf[6];
		kette[0] = materialAnzahl * 3;
		kette[1] = materialPlatzbedarf[7];
	}
	
	/** 
	 * Berechnet ob noch genug Material im Lager für eine beliebige Aktion (z.B. Verkauf oder Produktion von Fahrrädern) vorhanden ist.
	 * @param materialOderFahrrad Name des Materials oder des Fahrradtyps
	 * @param anzahl Wie viel von dem Material gebraucht wird.
	 * @return Gibt true zurück, wenn noch genug Material im Lager ist und false falls nicht genug vorhanden ist.
	*/
	public boolean materialUndFahrradVerfuegbarkeitPruefen(String materialOderFahrrad, int anzahl){
		switch (materialOderFahrrad){
			case "mtbStandard": if(mtbStandard >=  anzahl) return true; break;
			case "mtbPremium": if(mtbPremium >=  anzahl) return true; break;
			case "trekkingradPremium": if(trekkingradPremium >=  anzahl) return true; break;
			case "trekkingradStandard": if(trekkingradStandard >=  anzahl) return true; break;
			case "rennradPremium": if(rennradPremium >=  anzahl) return true; break;
			case "rennradStandard": if(rennradStandard >=  anzahl) return true; break;
			case "mtbRahmen": if(mtbRahmen[0] >=  anzahl) return true; break;
			case "trekkingRahmen": if(trekkingRahmen[0] >= anzahl) return true; break;
			case "rennradRahmen": if(rennradRahmen[0] >= anzahl) return true; break;
			case "mtbLenker": if(mtbLenker[0] >= anzahl) return true; break;
			case "trekkingLenker": if(trekkingLenker[0] >= anzahl) return true; break;
			case "rennradLenker": if(rennradLenker[0] >= anzahl) return true; break;
			case "mtbPedal": if(mtbPedal[0] >= anzahl) return true; break;
			case "trekkingPedal": if(trekkingPedal[0] >= anzahl) return true; break;
			case "rennradPedal": if(rennradPedal[0] >= anzahl) return true; break;
			case "mtbRadStandard": if(mtbRadStandard[0] >= anzahl) return true; break;
			case "mtbRadPremium": if(mtbRadPremium[0] >= anzahl) return true; break;
			case "trekkingRadStandard": if(trekkingRadStandard[0] >= anzahl) return true; break;
			case "trekkingRadPremium": if(trekkingRadPremium[0] >= anzahl) return true; break;
			case "rennradRadStandard": if(rennradRadStandard[0] >= anzahl) return true; break;
			case "rennradRadPremium": if(rennradRadPremium[0] >= anzahl) return true; break;
			case "mtbSattelStandard": if(mtbSattelStandard[0] >= anzahl) return true; break;
			case "mtbSattelPremium": if(mtbSattelPremium[0] >= anzahl) return true; break;
			case "trekkingSattelStandard": if(trekkingSattelStandard[0] >= anzahl) return true; break;
			case "trekkingSattelPremium": if(trekkingSattelPremium[0] >= anzahl) return true; break;
			case "rennradSattelStandard": if(rennradSattelStandard[0] >= anzahl) return true; break;
			case "rennradSattelPremium": if(rennradSattelPremium[0] >= anzahl) return true; break;
			case "felgenbremsen": if(felgenbremsen[0] >= anzahl)return true; break;
			case "scheibenbremsen": if(scheibenbremsen[0] >= anzahl) return true; break;
			case "drehgriffSchaltung": if(drehgriffSchaltung[0] >= anzahl) return true; break;
			case "triggerSchaltung": if(triggerSchaltung[0] >= anzahl) return true; break;
			case "kette": if(kette[0] >= anzahl) return true; break;
		}
		return false;		
	}
	
	/**
	 * Fuegt produzierte Fahrräder und neu gekaufte Einzelteile dem Lager hinzu
	 * @param materialOderFahrrad Name des Fahrradtyps bzw. des Materials das eingelagert werden soll
	 * @param anzahl Anzahl des Materials bzw. der Fahrräder
	 */
	public void fahrradUndMaterialEinlagern(String materialOderFahrrad, int anzahl){
		switch (materialOderFahrrad){
			case "mtbStandard": mtbStandard += anzahl; break;
			case "mtbPremium": mtbPremium += anzahl; break;
			case "trekkingradPremium": trekkingradPremium += anzahl; break;
			case "trekkingradStandard": trekkingradStandard += anzahl; break;
			case "rennradPremium": rennradPremium += anzahl; break;
			case "rennradStandard": rennradStandard += anzahl; break;
			case "mtbRahmen": mtbRahmen[0] += anzahl; break;
			case "trekkingRahmen": trekkingRahmen[0] += anzahl; break;
			case "rennradRahmen": rennradRahmen[0] += anzahl; break;
			case "mtbLenker": mtbLenker[0] += anzahl; break;
			case "trekkingLenker": trekkingLenker[0] += anzahl; break;
			case "rennradLenker": rennradLenker[0] += anzahl; break;
			case "mtbPedal": mtbPedal[0] += anzahl; break;
			case "trekkingPedal": trekkingPedal[0] += anzahl; break;
			case "rennradPedal": rennradPedal[0] += anzahl; break;
			case "mtbRadStandard": mtbRadStandard[0] += anzahl; break;
			case "mtbRadPremium": mtbRadPremium[0] += anzahl; break;
			case "trekkingRadStandard": trekkingRadStandard[0] += anzahl; break;
			case "trekkingRadPremium": trekkingRadPremium[0] += anzahl; break;
			case "rennradRadStandard": rennradRadStandard[0] += anzahl; break;
			case "rennradRadPremium": rennradRadPremium[0] += anzahl; break;
			case "mtbSattelStandard": mtbSattelStandard[0] += anzahl; break;
			case "mtbSattelPremium": mtbSattelPremium[0] += anzahl; break;
			case "trekkingSattelStandard": trekkingSattelStandard[0] += anzahl; break;
			case "trekkingSattelPremium": trekkingSattelPremium[0] += anzahl; break;
			case "rennradSattelStandard": rennradSattelStandard[0] += anzahl; break;
			case "rennradSattelPremium": rennradSattelPremium[0] += anzahl; break;
			case "felgenbremsen": felgenbremsen[0] += anzahl; break;
			case "scheibenbremsen": scheibenbremsen[0] += anzahl; break;
			case "drehgriffSchaltung": drehgriffSchaltung[0] += anzahl; break;
			case "triggerSchaltung": triggerSchaltung[0] += anzahl; break;
			case "kette": kette[0]+= anzahl; break;
		}
	}
	
	/**
	 * Diese Methode wird verwendet, falls Fahrräder verkauft oder Einzelteile für die Produktion verwendet
	 * werden. Die Anzahl wird jeweils um die angegebene Anzahl reduziert.
	 * @param materialOderFahrrad Einzelteile oder Fahrräder im Lager
	 * @param anzahl Anzahl zu entnehmenden Güter.
	 */
	public void fahrradUndMaterialAuslagern(String materialOderFahrrad, int anzahl){
		switch (materialOderFahrrad){
			case "mtbStandard": mtbStandard -= anzahl; break;
			case "mtbPremium": mtbPremium -= anzahl; break;
			case "trekkingradPremium": trekkingradPremium -= anzahl; break;
			case "trekkingradStandard": trekkingradStandard -= anzahl; break;
			case "rennradPremium": rennradPremium -= anzahl; break;
			case "rennradStandard": rennradStandard -= anzahl; break;
			case "mtbRahmen": mtbRahmen[0] -= anzahl; break;
			case "trekkingRahmen": trekkingRahmen[0] -= anzahl; break;
			case "rennradRahmen": rennradRahmen[0] -= anzahl; break;
			case "mtbLenker": mtbLenker[0] -= anzahl; break;
			case "trekkingLenker": trekkingLenker[0] -= anzahl; break;
			case "rennradLenker": rennradLenker[0] -= anzahl; break;
			case "mtbPedal": mtbPedal[0] -= anzahl; break;
			case "trekkingPedal": trekkingPedal[0] -= anzahl; break;
			case "rennradPedal": rennradPedal[0] -= anzahl; break;
			case "mtbRadStandard": mtbRadStandard[0] -= anzahl; break;
			case "mtbRadPremium": mtbRadPremium[0] -= anzahl; break;
			case "trekkingRadStandard": trekkingRadStandard[0] -= anzahl; break;
			case "trekkingRadPremium": trekkingRadPremium[0] -= anzahl; break;
			case "rennradRadStandard": rennradRadStandard[0] -= anzahl; break;
			case "rennradRadPremium": rennradRadPremium[0] -= anzahl; break;
			case "mtbSattelStandard": mtbSattelStandard[0] -= anzahl; break;
			case "mtbSattelPremium": mtbSattelPremium[0] -= anzahl; break;
			case "trekkingSattelStandard": trekkingSattelStandard[0] -= anzahl; break;
			case "trekkingSattelPremium": trekkingSattelPremium[0] -= anzahl; break;
			case "rennradSattelStandard": rennradSattelStandard[0] -= anzahl; break;
			case "rennradSattelPremium": rennradSattelPremium[0] -= anzahl; break;
			case "felgenbremsen": felgenbremsen[0] -= anzahl; break;
			case "scheibenbremsen": scheibenbremsen[0] -= anzahl; break;
			case "drehgriffSchaltung": drehgriffSchaltung[0] -= anzahl; break;
			case "triggerSchaltung": triggerSchaltung[0] -= anzahl; break;
			case "kette": kette[0]-= anzahl; break;
		}
	}
	
	/** 
	 * Methode berechnet den belegten Speicher.
	 * Es wird dabei der unterschiedliche Platzbedarf der einzelnen Materialien beachtet.
	 * @return Als Wert wird der belegte Speicher zurückgegeben
	 */
	public int getBelegterSpeicher(){
		int belegt = 0;
		
		belegt += (mtbStandard + mtbPremium + trekkingradStandard + trekkingradPremium + rennradStandard + rennradPremium) * fahrradPlatzbedarf;
		belegt += mtbRahmen[0] * mtbRahmen[1] + trekkingRahmen[0] * trekkingRahmen[1] + rennradRahmen[0] * rennradRahmen[1] + mtbLenker[0] * mtbLenker[1] + trekkingLenker[0] * trekkingLenker[1] + 
					  rennradLenker[0] * rennradLenker[1] + mtbPedal[0] * mtbPedal[1] + trekkingPedal[0] * trekkingPedal[1] + rennradPedal[0] * rennradPedal[1] + mtbRadStandard[0] * mtbRadStandard[1] +
					  mtbRadPremium[0] * mtbRadPremium[1] + trekkingRadStandard[0] * trekkingRadStandard[1] + trekkingRadPremium[0] * trekkingRadPremium[1] + rennradRadStandard[0] * rennradRadStandard[1] +
					  rennradRadPremium[0] * rennradRadPremium[1] + mtbSattelStandard[0] * mtbSattelStandard[1] + mtbSattelPremium[0] * mtbSattelPremium[1] + trekkingSattelStandard[0] * trekkingSattelStandard[1] +
					  trekkingSattelPremium[0] * trekkingSattelPremium[1] + rennradSattelStandard[0] * rennradSattelStandard[1] + rennradSattelPremium[0] * rennradSattelPremium[1] + felgenbremsen[0] * felgenbremsen[1] +
					  scheibenbremsen[0] * scheibenbremsen[1] + drehgriffSchaltung[0] * drehgriffSchaltung[1] + triggerSchaltung[0] * triggerSchaltung[1] + kette[0] * kette[1];
		
		return belegt;
	}
	
	/**
	 * Methode wird aus der Klasse Entwicklung heraus aufgerufen.
	 * @param wert Gibt an um wieviel die Lagerkapazität erhöht werden soll.
	 */
	public void lagerKapazitaetErhoehen(int wert){
		lagerKapazitaet += wert;
	}
	
	/**
	 * Falls durch eine Bestellung oder eine Produktion das Lager überschritten wurde, müssen die Güter extern gelagert und 
	 * dafür eine Gebühr erhoben werden. Die Gebuehr bezieht sich auf die Anzahl der überschrittenen Lagereinheiten.
	 */
	public void gebuehrBerechnen(Unternehmen unternehmen){
		if (lagerKapazitaet < getBelegterSpeicher()){
			int gebuehrProUeberschritteneEinheit = Planspiel.getStartGebuehrProUeberschritteneEinheit();
			int ueberschuss = getBelegterSpeicher() - lagerKapazitaet;
			unternehmen.getBank().kontostandVerringern(ueberschuss * gebuehrProUeberschritteneEinheit);
			
			// auch im Cashflow vermerken
			unternehmen.getCashflow().setLagerGebuehren((int) ueberschuss * gebuehrProUeberschritteneEinheit);
		}
	}
	
	/** Gibt eine Liste der im Lager befindlichen Einzelteile und Fahrräder als int-Array zurück **/
	public int[] getLagerInhalt(){
		int[] inhalt = new int[32];
		
		// Fahrräder
		inhalt[0] = mtbStandard;
		inhalt[1] = mtbPremium;
		inhalt[2] = trekkingradStandard;
		inhalt[3] = trekkingradPremium;
		inhalt[4] = rennradStandard;
		inhalt[5] = rennradPremium;
		
		// Einzelteile
		inhalt[6] = mtbRahmen[0];
		inhalt[7] = trekkingRahmen[0];
		inhalt[8] = rennradRahmen[0];
		
		inhalt[9] = mtbLenker[0];
		inhalt[10] = trekkingLenker[0];
		inhalt[11] = rennradLenker[0];
		
		inhalt[12] = mtbPedal[0];
		inhalt[13] = trekkingPedal[0];
		inhalt[14] = rennradPedal[0];

		inhalt[15] = mtbRadStandard[0];
		inhalt[16] = mtbRadPremium[0];
		inhalt[17] = trekkingRadStandard[0];
		inhalt[18] = trekkingRadPremium[0];
		inhalt[19] = rennradRadStandard[0];
		inhalt[20] = rennradRadPremium[0];
		
		inhalt[21] = mtbSattelStandard[0];
		inhalt[22] = mtbSattelPremium[0];
		inhalt[23] = trekkingSattelStandard[0];
		inhalt[24] = trekkingSattelPremium[0];
		inhalt[25] = rennradSattelStandard[0];
		inhalt[26] = rennradSattelPremium[0];
		
		inhalt[27] = felgenbremsen[0];
		inhalt[28] = scheibenbremsen[0];
		
		inhalt[29] = drehgriffSchaltung[0];
		inhalt[30] = triggerSchaltung[0];
		
		inhalt[31] = kette[0];
		
		return inhalt;
	}
}
