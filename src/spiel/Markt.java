package spiel;
import java.util.ArrayList;

/**
 * In der Klasse Markt wird die Nachfrage berechnet. Jeder Fahrradtyp hat eine eigene Nachfrage. Die Nachfrage eines
 * Fahrradtyps wird nochmal intern aufgeteilt in Nachfrage nach Standard-Modell und Nachfrage nach Premium-Modell.
 * Der Werteberech passt sich an die vorhandenen Produktionskapazitäten der Spieler an.
 */

public final class Markt
{
	private static boolean wirtschaftsKrise = false;
	
	private static int mtbStandardNachfrage;
	private static ArrayList<Integer> mtbStandardNachfrageArr = new ArrayList<Integer>();
	private static int mtbPremiumNachfrage;
	private static ArrayList<Integer> mtbPremiumNachfrageArr = new ArrayList<Integer>();
	private static int trekkingradStandardNachfrage;
	private static ArrayList<Integer> trekkingradStandardNachfrageArr = new ArrayList<Integer>();
	private static int trekkingradPremiumNachfrage;
	private static ArrayList<Integer> trekkingradPremiumNachfrageArr = new ArrayList<Integer>();
	private static int rennradStandardNachfrage;
	private static ArrayList<Integer> rennradStandardNachfrageArr = new ArrayList<Integer>();
	private static int rennradPremiumNachfrage;
	private static ArrayList<Integer> rennradPremiumNachfrageArr = new ArrayList<Integer>();
	
	// Grundpreise der Fahrräder
	private static int mtbStandardPreis = 1135;
	private static int mtbPremiumPreis = 1360;
	private static int trekkingStandardPreis = 880;
	private static int trekkingPremiumPreis = 1095;
	private static int rennradStandardPreis = 1595;
	private static int rennradPremiumPreis = 1890;
		
	// Preise zu denen die Fahrräder maximal abgekauft werden [Grundpreis + Aufschlag]
	private static int mtbStandardMaxPreis;
	private static int mtbPremiumMaxPreis;
	private static int trekkingStandardMaxPreis;
	private static int trekkingPremiumMaxPreis;
	private static int rennradStandardMaxPreis;
	private static int rennradPremiumMaxPreis;
	
	// Grundpreise für die Materialien festlegen
	private static int mtbRahmenStartPreis = 650;
	private static int trekkingRahmenStartPreis = 500;
	private static int rennradRahmenStartPreis = 750;
	private static int mtbLenkerStartPreis = 50;
	private static int trekkingLenkerStartPreis = 25;
	private static int rennradLenkerStartPreis = 130;
	private static int mtbPedalStartPreis = 40;
	private static int trekkingPedalStartPreis = 25;
	private static int rennradPedalStartPreis = 50;
	private static int mtbRadStandardStartPreis = 80;
	private static int mtbRadPremiumStartPreis = 130;
	private static int trekkingRadStandardStartPreis = 60;
	private static int trekkingRadPremiumStartPreis = 110;
	private static int rennradRadStandardStartPreis = 170;
	private static int rennradRadPremiumStartPreis = 300;
	private static int mtbSattelStandardStartPreis = 45;
	private static int mtbSattelPremiumStartPreis = 85;
	private static int trekkingSattelStandardStartPreis = 35;
	private static int trekkingSattelPremiumStartPreis = 65;
	private static int rennradSattelStandardStartPreis = 75;
	private static int rennradSattelPremiumStartPreis = 110;
	private static int felgenbremsenStartPreis = 55;
	private static int scheibenbremsenStartPreis = 90;
	private static int drehgriffSchaltungStartPreis = 70;
	private static int triggerSchaltungStartPreis = 120;
	private static int ketteStartPreis = 25;
	

	/**
	 * Diese Methode berechnet den Wert aller Materialien, die ein Spieler in seinem Lger hat.
	 * Der Wert des Lagers wird für die Bestimmung des Eigenkapitals benötigt. 
	 * Zur Berechnung wird die Anzahl der Materialien mit den einzelnen Grundpreisen multipliziert.
	 * @param lagerInhalt Der gesamte Lagerinhalt wird übergeben.
	 * @return Der Wert aller Materialien wird zurückgegeben.
	 */
	public static int getMaterialWerte(int[] lagerInhalt){
		int wert = 0;
		wert += lagerInhalt[0] *  mtbStandardPreis;
		wert += lagerInhalt[1] *  mtbPremiumPreis;
		wert += lagerInhalt[2] *  trekkingStandardPreis;
		wert += lagerInhalt[3] *  trekkingPremiumPreis;
		wert += lagerInhalt[4] *  rennradStandardPreis;
		wert += lagerInhalt[5] *  rennradPremiumPreis;
		
		wert += lagerInhalt[6] *  mtbRahmenStartPreis;
		wert += lagerInhalt[7] *  trekkingRahmenStartPreis;
		wert += lagerInhalt[8] *  rennradRahmenStartPreis;
		wert += lagerInhalt[9] *  mtbLenkerStartPreis;
		wert += lagerInhalt[10] *  trekkingLenkerStartPreis;
		wert += lagerInhalt[11] *  rennradLenkerStartPreis;
		wert += lagerInhalt[12] *  mtbPedalStartPreis;
		wert += lagerInhalt[13] *  trekkingPedalStartPreis;
		wert += lagerInhalt[14] *  rennradPedalStartPreis;
		wert += lagerInhalt[15] *  mtbRadStandardStartPreis;
		wert += lagerInhalt[16] *  mtbRadPremiumStartPreis;
		wert += lagerInhalt[17] *  trekkingRadStandardStartPreis;
		wert += lagerInhalt[18] *  trekkingRadPremiumStartPreis;
		wert += lagerInhalt[19] *  rennradRadStandardStartPreis;
		wert += lagerInhalt[20] *  rennradRadPremiumStartPreis;
		wert += lagerInhalt[21] *  mtbSattelStandardStartPreis;
		wert += lagerInhalt[22] *  mtbSattelPremiumStartPreis;
		wert += lagerInhalt[23] *  trekkingSattelStandardStartPreis;
		wert += lagerInhalt[24] *  trekkingSattelPremiumStartPreis;
		wert += lagerInhalt[25] *  rennradSattelStandardStartPreis;
		wert += lagerInhalt[26] *  rennradSattelPremiumStartPreis;
		wert += lagerInhalt[27] *  felgenbremsenStartPreis;
		wert += lagerInhalt[28] *  scheibenbremsenStartPreis;
		wert += lagerInhalt[29] *  drehgriffSchaltungStartPreis;
		wert += lagerInhalt[30] *  triggerSchaltungStartPreis;
		wert += lagerInhalt[31] *  ketteStartPreis;
		
		return wert;
	}
	
	/** Zur Darstellung im Diagramm die gespeicherte Nachfrage als Array zurückgeben **/
	public static int[] getMtbStandardNachfrageArr(){
		int[] nachfrage = new int[mtbStandardNachfrageArr.size()];
		for (int i = 0; i < nachfrage.length; i++){
			nachfrage[i] = mtbStandardNachfrageArr.get(i);
		}
		return nachfrage;
	}
	/** Zur Darstellung im Diagramm die gespeicherte Nachfrage als Array zurückgeben **/
	public static int[] getMtbPremiumNachfrageArr(){
		int[] nachfrage = new int[mtbPremiumNachfrageArr.size()];
		for (int i = 0; i < nachfrage.length; i++){
			nachfrage[i] = mtbPremiumNachfrageArr.get(i);
		}
		return nachfrage;
	}
	/** Zur Darstellung im Diagramm die gespeicherte Nachfrage als Array zurückgeben **/
	public static int[] getTrekkingradStandardNachfrageArr(){
		int[] nachfrage = new int[trekkingradStandardNachfrageArr.size()];
		for (int i = 0; i < nachfrage.length; i++){
			nachfrage[i] = trekkingradStandardNachfrageArr.get(i);
		}
		return nachfrage;
	}
	/** Zur Darstellung im Diagramm die gespeicherte Nachfrage als Array zurückgeben **/
	public static int[] getTrekkingradPremiumNachfrageArr(){
		int[] nachfrage = new int[trekkingradPremiumNachfrageArr.size()];
		for (int i = 0; i < nachfrage.length; i++){
			nachfrage[i] = trekkingradPremiumNachfrageArr.get(i);
		}
		return nachfrage;
	}
	/** Zur Darstellung im Diagramm die gespeicherte Nachfrage als Array zurückgeben **/
	public static int[] getRennradStandardNachfrageArr(){
		int[] nachfrage = new int[rennradStandardNachfrageArr.size()];
		for (int i = 0; i < nachfrage.length; i++){
			nachfrage[i] = rennradStandardNachfrageArr.get(i);
		}
		return nachfrage;
	}
	public static int[] getRennradPremiumNachfrageArr(){
		int[] nachfrage = new int[rennradPremiumNachfrageArr.size()];
		for (int i = 0; i < nachfrage.length; i++){
			nachfrage[i] = rennradPremiumNachfrageArr.get(i);
		}
		return nachfrage;
	}
	
	/** Durchschnittsnachfrage für die Skalierung des Diagramms berechnen **/
	public static int getDurchschnittsNachfrage(){
		int nachfrage = mtbStandardNachfrage + mtbPremiumNachfrage + trekkingradStandardNachfrage +
					    trekkingradPremiumNachfrage + rennradStandardNachfrage + rennradPremiumNachfrage;
		
		return (Math.round(nachfrage / 3));		
	}

	/**
	 * Zufallszahl zwischen zwei double Werten berechnen
	 * @param min minimaler Random-Wert
	 * @param max maximaler Random-Wert
	 * @return zufälliger Wert zwischen min und max
	 */
	private static double getRand(double min, double max){
		double rand = Math.random() * (max - min) + min;
		return rand;
	}

	/** 
	 * Methode wird aus der Klasse Zufallserignis aufgerufen.
	 * Mit einer bestimmten Wahrscheinlichkeit gibt es eine Wirtschaftskrise, die 3 Runde andauert, während der die Nachfrage stark zurückgeht.
	 */
	public static void setWirtschaftsKrise(boolean krise){
		wirtschaftsKrise = krise;
	}
	
	/**
	 * Methode wird alle 3 Runden aufgerufen.
	 * Die Methode berechnet die Nachfrage für die einzelnen Fahrradmodelle.
	 * Die berechnete Nachfrage bleibt für 3 Runden bestehen.
	 */
	public static void nachfrageBerechnen(){
		
		/** 
		 * Es wird zunächst der Preis berechnet, den der Markt maximal für die Fahrräder zahlt. 
		 * Dieser maximale Preis setzt sich aus dem Grundpreis + Gewinnaufschlag zusammen.
		 * Der maximale Gewinnaufschlag, den der Markt erlaubt, liegt bei den Standard-Modellen zwischen 250€ und 400€.
		 * Der maximale Gewinnaufschlag, den der Markt erlaubt, liegt bei den Premium-Modellen zwischen 350€ und 500€.
		 */
		mtbStandardMaxPreis = mtbStandardPreis + (int) Math.round(getRand(250, 400));
		mtbPremiumMaxPreis = mtbPremiumPreis + (int) Math.round(getRand(350, 500));
		trekkingStandardMaxPreis = trekkingStandardPreis + (int) Math.round(getRand(250, 400));
		trekkingPremiumMaxPreis = trekkingPremiumPreis + (int) Math.round(getRand(350, 500));
		rennradStandardMaxPreis = rennradStandardPreis + (int) Math.round(getRand(250, 400));
		rennradPremiumMaxPreis = rennradPremiumPreis + (int) Math.round(getRand(350, 500));
		
		/** 
		 * Die Marktforschung aller Spieler wird zurückgesetzt.
		 * Um die neu berechnete Nachfrage zu sehen, müssen die Spieler die Marktforschung wieder freischalten.
		 */
		if (Planspiel.getRundenNr() != 1){
			for (int i = 0; i < Planspiel.getAlleUnternehmen().size(); i++){
				Planspiel.getAlleUnternehmen().get(i).getEntwicklung().resetMarktforschung();
			}
		}
		
		/** Produktionskapazität von allen Spielern zusammenzählen **/
	    int gesamtProduktionsKapazitaet = 0;
	    for (int i = 0; i < Planspiel.getAlleUnternehmen().size(); i++){
			gesamtProduktionsKapazitaet += Planspiel.getAlleUnternehmen().get(i).getFabrik().getProduktionsKapazitaet();
		}
		
	    /** 
	     * Die minimale und maximale Nachfrage für Mountainbikes, Trekkingräder und Rennräder festlegen.
	     * Die Nachfrage für Mountainbikes, Trekkingräder und Rennräder berechnet sich aus einem Zufallswert zwischen minimaler und maximaler Nachfrage.
	     */
		int minGesamtNachfrage;
		int maxGesamtNachfrage;
		
		if (!wirtschaftsKrise){
			minGesamtNachfrage = (int)(0.25 * gesamtProduktionsKapazitaet); 
			maxGesamtNachfrage = (int)(0.65 * gesamtProduktionsKapazitaet);
		}
		else{
			// bei einer Wirtschaftskrise sinkt die Nachfrage nach allen Fahrrädern
			minGesamtNachfrage = (int)(0.15 * gesamtProduktionsKapazitaet);
			maxGesamtNachfrage = (int)(0.25 * gesamtProduktionsKapazitaet);
			wirtschaftsKrise = false;
		}
		/** Die Nachfrage für Mountainbikes, Trekkingräder und Rennräder wird festgelegt. **/
		int mtbNachfrage = (int) Math.round(getRand(minGesamtNachfrage, maxGesamtNachfrage));
		int trekkingNachfrage = (int) Math.round(getRand(minGesamtNachfrage, maxGesamtNachfrage));
		int rennradNachfrage = (int) Math.round(getRand(minGesamtNachfrage, maxGesamtNachfrage));
		
		
		/**
		 * Nachdem die Nachfrage für Mountainbikes, Trekkingräder und Rennräder berechnet wurde,
		 * wird diese aufgeteilt in Nachfrage nach Standard-Modelle und Nachfrage nach Premium-Modelle.
		 * Die Nachfrage nach Premium-Modellen liegt dabei immer unter der Nachfrage nach Standard-Modellen.
		 */
		double anteilPremium = getRand(0.2, 0.35);
		mtbPremiumNachfrage = (int) (mtbNachfrage * anteilPremium);
	    mtbStandardNachfrage = mtbNachfrage - mtbPremiumNachfrage;
	     
	    anteilPremium = getRand(0.2, 0.35);
	    trekkingradPremiumNachfrage = (int)(trekkingNachfrage * anteilPremium);
	    trekkingradStandardNachfrage = trekkingNachfrage - trekkingradPremiumNachfrage;
	    
	    anteilPremium = getRand(0.2, 0.35);
	    rennradPremiumNachfrage = (int)(rennradNachfrage * anteilPremium);
	    rennradStandardNachfrage = rennradNachfrage - rennradPremiumNachfrage;
		
	    
	    /**
	     * Die berechnete Nachfrage wird in der Array-Liste vermerkt.
	     * Es werden allerdings nur 8 Einträge in der Array-Liste zugelassen.
	     */
	    if (mtbStandardNachfrageArr.size() == 8){
	    	mtbStandardNachfrageArr.remove(0);
	    }
	    if (mtbPremiumNachfrageArr.size() == 8){
	    	mtbPremiumNachfrageArr.remove(0);
	    }
	    if (trekkingradStandardNachfrageArr.size() == 8){
	    	trekkingradStandardNachfrageArr.remove(0);
	    }
	    if (trekkingradPremiumNachfrageArr.size() == 8){
	    	trekkingradPremiumNachfrageArr.remove(0);
	    }
	    if (rennradStandardNachfrageArr.size() == 8){
	    	rennradStandardNachfrageArr.remove(0);
	    }
	    if (rennradPremiumNachfrageArr.size() == 8){
	    	rennradPremiumNachfrageArr.remove(0);
	    }
	    mtbStandardNachfrageArr.add(mtbStandardNachfrage);
	    mtbPremiumNachfrageArr.add(mtbPremiumNachfrage);
	    trekkingradStandardNachfrageArr.add(trekkingradStandardNachfrage);
	    trekkingradPremiumNachfrageArr.add(trekkingradPremiumNachfrage);
	    rennradStandardNachfrageArr.add(rennradStandardNachfrage);
	    rennradPremiumNachfrageArr.add(rennradPremiumNachfrage);
	}
	
	/**
	 * Methode wird einmal pro Runde aufgerufen.
	 * Die Fahrräder, die auf dem Marktplatz stehen, werden den Spielern abgekauft.
	 * Den Spielern werden so viele Fahrräder abgekauft, wie die Nachfrage verlangt.
	 * Die Fahrräder, die am billigsten sind, werden bevorzugt gekauft.
	 * Liegen die angebotenen Fahrräder über dem zuvor berechneten maximalen Preis, werden diese nicht abgekauft.
	 */
	public static void fahrraederAbkaufen(){
		
		Verkaufsposten[] verkaufsposten; 
		int anzahlGekauft;
		int anzahlRest;
		
		/** Mountainbike Standard abkaufen **/
		
		// alle Verkaufsposten vom angegebenen Fahrradtyp beziehen (nach Preis sortiert)
		verkaufsposten = Marktplatz.getVerkaufspostenVonFahrradtyp("mtbStandard"); 
		anzahlGekauft = 0;
		
		for (int i = 0; i < verkaufsposten.length; i++){
			// Fahrräder aus dem Verkaufsposten werden nur abgekauft, wenn der Preis unter dem maximalen Preis liegt, den der Markt zahlt
			if (verkaufsposten[i].getPreis() <= mtbStandardMaxPreis){
				//alle Fahrräder aus Verkaufsposten kaufen
				if ((anzahlGekauft + verkaufsposten[i].getAnzahl()) <= mtbStandardNachfrage){
						anzahlGekauft += verkaufsposten[i].getAnzahl();
						verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("mtbStandard", verkaufsposten[i].getAnzahl());
						verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
						
						// verkaufte Fahrräder als Umsatzerlöse (zahlungswirksame Erträge) im Cashflow vermerken
						verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
						
						// Anzahl der gekauften Fahrräder im Unternehmen speichern
						verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), verkaufsposten[i].getAnzahl()); 
						
						verkaufsposten[i].setAnzahl(0); // Anzahl auf 0 setzen, alle Verkaufsposten mit Anzahl 0 werden später gelöscht
				}
				// bietet der Verkaufsposten mehr Fahrräder als die Nachfrage verlangt, dann werden nur die benötigten Fahrräder abgekauft
				else {
					anzahlRest = mtbStandardNachfrage - anzahlGekauft;
					verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("mtbStandard", anzahlRest);
					verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(anzahlRest * verkaufsposten[i].getPreis());
					
					// verkaufte Fahrräder als Umsatzerlöse (zahlungswirksame Erträge) im Cashflow vermerken
					verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// Anzahl der gekauften Fahrräder im Unternehmen speichern
					verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), anzahlRest); 
					
					verkaufsposten[i].setAnzahl(verkaufsposten[i].getAnzahl() - anzahlRest); // Anzahl verringern
					break; // Schleife verlassen
				}
			}
			// wenn der Verkaufsposten über dem maximalen Preis liegt => Schleife verlassen.
			// alle weiteren Verkaufsposten werden auch über dem maximalen Preis liegen, da die Verkaufsposten nach Preis sortiert sind
			else break; 
		}

		/** Mountainbike Premium abkaufen **/
		
		verkaufsposten = Marktplatz.getVerkaufspostenVonFahrradtyp("mtbPremium"); // alle Verkaufsposten vom angegebenen Fahrradtyp beziehen (nach Preis sortiert)
		anzahlGekauft = 0;
		
		for (int i = 0; i < verkaufsposten.length; i++){
			// Fahrräder aus dem Verkaufsposten werden nur abgekauft, wenn der Preis unter dem maximalen Preis liegt, den der Markt zahlt
			if (verkaufsposten[i].getPreis() <= mtbPremiumMaxPreis){
				//alle Fahrräder aus Verkaufsposten kaufen
				if ((anzahlGekauft + verkaufsposten[i].getAnzahl()) <= mtbPremiumNachfrage){
					anzahlGekauft += verkaufsposten[i].getAnzahl();
					verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("mtbPremium", verkaufsposten[i].getAnzahl());
					verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// verkaufte Fahrräder als Umsatzerlöse (zahlungswirksame Erträge) im Cashflow vermerken
					verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// Anzahl der gekauften Fahrräder im Unternehmen speichern
					verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), verkaufsposten[i].getAnzahl());
					
					verkaufsposten[i].setAnzahl(0); // Anzahl auf 0 setzen, alle Verkaufsposten mit Anzahl 0 werden später gelöscht
				}
				// bietet der Verkaufsposten mehr Fahrräder als die Nachfrage verlangt, dann werden nur die benötigten Fahrräder abgekauft
				else {
					anzahlRest = mtbPremiumNachfrage - anzahlGekauft;
					verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("mtbPremium", anzahlRest);
					verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(anzahlRest * verkaufsposten[i].getPreis());
					
					// verkaufte Fahrräder als Umsatzerlöse (zahlungswirksame Erträge) im Cashflow vermerken
					verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// Anzahl der gekauften Fahrräder im Unternehmen speichern
					verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), anzahlRest); 
					
					verkaufsposten[i].setAnzahl(verkaufsposten[i].getAnzahl() - anzahlRest); // Anzahl verringern
					break; // Schleife verlassen
				}
			} 
			// wenn der Verkaufsposten über dem maximalen Preis liegt => Schleife verlassen
			// alle weiteren Verkaufsposten werden auch über dem maximalen Preis liegen, da die Verkaufsposten nach Preis sortiert sind
			else break; 
		}
		
		/** Trekkingrad Standard abkaufen **/
		
		verkaufsposten = Marktplatz.getVerkaufspostenVonFahrradtyp("trekkingradStandard"); // alle Verkaufsposten vom angegebenen Fahrradtyp beziehen (nach Preis sortiert)
		anzahlGekauft = 0;
		
		for (int i = 0; i < verkaufsposten.length; i++){
			// Fahrräder aus dem Verkaufsposten werden nur abgekauft, wenn der Preis unter dem maximalen Preis liegt, den der Markt zahlt
			if (verkaufsposten[i].getPreis() <= trekkingStandardMaxPreis){
				//alle Fahrräder aus Verkaufsposten kaufen
				if ((anzahlGekauft + verkaufsposten[i].getAnzahl()) <= trekkingradStandardNachfrage){
					anzahlGekauft += verkaufsposten[i].getAnzahl();
					verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("trekkingradStandard", verkaufsposten[i].getAnzahl());
					verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// verkaufte Fahrräder als Umsatzerlöse (zahlungswirksame Erträge) im Cashflow vermerken
					verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// Anzahl der gekauften Fahrräder im Unternehmen speichern
					verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), verkaufsposten[i].getAnzahl());
					
					verkaufsposten[i].setAnzahl(0); // Anzahl auf 0 setzen, alle Verkaufsposten mit Anzahl 0 werden später gelöscht
				}
				// bietet der Verkaufsposten mehr Fahrräder als die Nachfrage verlangt, dann werden nur die benötigten Fahrräder abgekauft
				else {
					anzahlRest = trekkingradStandardNachfrage - anzahlGekauft;
					verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("trekkingradStandard", anzahlRest);
					verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(anzahlRest * verkaufsposten[i].getPreis());
					
					// verkaufte Fahrräder als Umsatzerlöse (zahlungswirksame Erträge) im Cashflow vermerken
					verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// Anzahl der gekauften Fahrräder im Unternehmen speichern
					verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), anzahlRest); 
					
					verkaufsposten[i].setAnzahl(verkaufsposten[i].getAnzahl() - anzahlRest); // Anzahl verringern
					break; // Schleife verlassen
				}
			}
			// wenn der Verkaufsposten über dem maximalen Preis liegt => Schleife verlassen
			// alle weiteren Verkaufsposten werden auch über dem maximalen Preis liegen, da die Verkaufsposten nach Preis sortiert sind
			else break;
		}
		
		/** Trekkingrad Premium abkaufen **/
		
		verkaufsposten = Marktplatz.getVerkaufspostenVonFahrradtyp("trekkingradPremium"); // alle Verkaufsposten vom angegebenen Fahrradtyp beziehen (nach Preis sortiert)
		anzahlGekauft = 0;
		
		for (int i = 0; i < verkaufsposten.length; i++){
			// Fahrräder aus dem Verkaufsposten werden nur abgekauft, wenn der Preis unter dem maximalen Preis liegt, den der Markt zahlt
			if (verkaufsposten[i].getPreis() <= trekkingPremiumMaxPreis){
				//alle Fahrräder aus Verkaufsposten kaufen
				if ((anzahlGekauft + verkaufsposten[i].getAnzahl()) <= trekkingradPremiumNachfrage){
					anzahlGekauft += verkaufsposten[i].getAnzahl();
					verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("trekkingradPremium", verkaufsposten[i].getAnzahl());
					verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// verkaufte Fahrräder als Umsatzerlöse (zahlungswirksame Erträge) im Cashflow vermerken
					verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// Anzahl der gekauften Fahrräder im Unternehmen speichern
					verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), verkaufsposten[i].getAnzahl());
					
					verkaufsposten[i].setAnzahl(0); // Anzahl auf 0 setzen, alle Verkaufsposten mit Anzahl 0 werden später gelöscht
				}
				// bietet der Verkaufsposten mehr Fahrräder als die Nachfrage verlangt, dann werden nur die benötigten Fahrräder abgekauft
				else {
					anzahlRest = trekkingradPremiumNachfrage - anzahlGekauft;
					verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("trekkingradPremium", anzahlRest);
					verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(anzahlRest * verkaufsposten[i].getPreis());
					
					// verkaufte Fahrräder als Umsatzerlöse (zahlungswirksame Erträge) im Cashflow vermerken
					verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// Anzahl der gekauften Fahrräder im Unternehmen speichern
					verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), anzahlRest); 
					
					verkaufsposten[i].setAnzahl(verkaufsposten[i].getAnzahl() - anzahlRest); // Anzahl verringern
					break; // Schleife verlassen
				}
			}
			// wenn der Verkaufsposten über dem maximalen Preis liegt => Schleife verlassen
			// alle weiteren Verkaufsposten werden auch über dem maximalen Preis liegen, da die Verkaufsposten nach Preis sortiert sind
			else break; 
		}
		
		/** Rennrad Standard abkaufen **/
		
		verkaufsposten = Marktplatz.getVerkaufspostenVonFahrradtyp("rennradStandard"); // alle Verkaufsposten vom angegebenen Fahrradtyp beziehen (nach Preis sortiert)
		anzahlGekauft = 0;
		
		for (int i = 0; i < verkaufsposten.length; i++){
			// Fahrräder aus dem Verkaufsposten werden nur abgekauft, wenn der Preis unter dem maximalen Preis liegt, den der Markt zahlt
			if (verkaufsposten[i].getPreis() <= rennradStandardMaxPreis){
				//alle Fahrräder aus Verkaufsposten kaufen
				if ((anzahlGekauft + verkaufsposten[i].getAnzahl()) <= rennradStandardNachfrage){
					anzahlGekauft += verkaufsposten[i].getAnzahl();
					verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("rennradStandard", verkaufsposten[i].getAnzahl());
					verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// verkaufte Fahrräder als Umsatzerlöse (zahlungswirksame Erträge) im Cashflow vermerken
					verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// Anzahl der gekauften Fahrräder im Unternehmen speichern
					verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), verkaufsposten[i].getAnzahl());
					
					verkaufsposten[i].setAnzahl(0); // Anzahl auf 0 setzen, alle Verkaufsposten mit Anzahl 0 werden später gelöscht
				}
				// bietet der Verkaufsposten mehr Fahrräder als die Nachfrage verlangt, dann werden nur die benötigten Fahrräder abgekauft
				else {
					anzahlRest = rennradStandardNachfrage - anzahlGekauft;
					verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("rennradStandard", anzahlRest);
					verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(anzahlRest * verkaufsposten[i].getPreis());
					
					// verkaufte Fahrräder als Umsatzerlöse (zahlungswirksame Erträge) im Cashflow vermerken
					verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// Anzahl der gekauften Fahrräder im Unternehmen speichern
					verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), anzahlRest); 
					
					verkaufsposten[i].setAnzahl(verkaufsposten[i].getAnzahl() - anzahlRest); // Anzahl verringern
					break; // Schleife verlassen
				}
			}
			// wenn der Verkaufsposten über dem maximalen Preis liegt => Schleife verlassen
			// alle weiteren Verkaufsposten werden auch über dem maximalen Preis liegen, da die Verkaufsposten nach Preis sortiert sind
			else break;
		}
		
		/** Rennrad Premium abkaufen **/
		
		verkaufsposten = Marktplatz.getVerkaufspostenVonFahrradtyp("rennradPremium"); // alle Verkaufsposten vom angegebenen Fahrradtyp beziehen (nach Preis sortiert)
		anzahlGekauft = 0;
		
		for (int i = 0; i < verkaufsposten.length; i++){
			// Fahrräder aus dem Verkaufsposten werden nur abgekauft, wenn der Preis unter dem maximalen Preis liegt, den der Markt zahlt
			if (verkaufsposten[i].getPreis() <= rennradPremiumMaxPreis){
				//alle Fahrräder aus Verkaufsposten kaufen
				if ((anzahlGekauft + verkaufsposten[i].getAnzahl()) <= rennradPremiumNachfrage){
					anzahlGekauft += verkaufsposten[i].getAnzahl();
					verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("rennradPremium", verkaufsposten[i].getAnzahl());
					verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// auch im Cashflow vermerken
					verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// Anzahl der gekauften Fahrräder im Unternehmen speichern
					verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), verkaufsposten[i].getAnzahl());
					
					verkaufsposten[i].setAnzahl(0); // Anzahl auf 0 setzen, alle Verkaufsposten mit Anzahl 0 werden später gelöscht
				}
				// bietet der Verkaufsposten mehr Fahrräder als die Nachfrage verlangt, dann werden nur die benötigten Fahrräder abgekauft
				else {
					anzahlRest = rennradPremiumNachfrage - anzahlGekauft;
					verkaufsposten[i].getUnternehmen().getLager().fahrradUndMaterialAuslagern("rennradPremium", anzahlRest);
					verkaufsposten[i].getUnternehmen().getBank().kontostandErhoehen(anzahlRest * verkaufsposten[i].getPreis());
					
					// auch im Cashflow vermerken
					verkaufsposten[i].getUnternehmen().getCashflow().setUmsatzerloese(verkaufsposten[i].getUnternehmen().getCashflow().getUmsatzerloese() + verkaufsposten[i].getAnzahl() * verkaufsposten[i].getPreis());
					
					// Anzahl der gekauften Fahrräder im Unternehmen speichern
					verkaufsposten[i].getUnternehmen().addVerkaufteFahrraeder(verkaufsposten[i].getFahrradBezeichnung(), verkaufsposten[i].getPreis(), anzahlRest); 
					
					verkaufsposten[i].setAnzahl(verkaufsposten[i].getAnzahl() - anzahlRest); // Anzahl verringern
					break; // Schleife verlassen
				}
			}
			// wenn der Verkaufsposten über dem maximalen Preis liegt => Schleife verlassen
			// alle weiteren Verkaufsposten werden auch über dem maximalen Preis liegen, da die Verkaufsposten nach Preis sortiert sind
			else break;
		}
	
		// Alle Verkaufsposten, deren Anzahl auf 0 gesetzt wurde, löschen
		Marktplatz.leereVerkaufspostenLoeschen();
	}
	
	/**
	 * Methode wird jede Runde einmal aufgerufen.
	 * Die Verfügbarkeit der Materialien wird in Abhängigkeit von der Nachfrage angepasst.
	 * Des Weiteren ist die Verfügbarkeit der Materialien abhängig davon, wie viel Fahrrad-Modelle diese Materialien benötigen.
	 */
	public static void angeboteVerfuegbarkeitAnpassen(){
		Anbieter[] alleAnbieter = Marktplatz.getAlleAnbieter();
		double min = 0.8;
		double max = 1.2;
		
		alleAnbieter[0].getMaterial("mtbRahmen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + mtbPremiumNachfrage)));
		alleAnbieter[1].getMaterial("mtbRahmen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + mtbPremiumNachfrage)));
		alleAnbieter[2].getMaterial("mtbRahmen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + mtbPremiumNachfrage)));
		
    	alleAnbieter[0].getMaterial("trekkingRahmen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (trekkingradStandardNachfrage + trekkingradPremiumNachfrage)));
		alleAnbieter[1].getMaterial("trekkingRahmen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (trekkingradStandardNachfrage + trekkingradPremiumNachfrage)));
		alleAnbieter[2].getMaterial("trekkingRahmen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (trekkingradStandardNachfrage + trekkingradPremiumNachfrage)));
		
		alleAnbieter[0].getMaterial("rennradRahmen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (rennradStandardNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[1].getMaterial("rennradRahmen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (rennradStandardNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[2].getMaterial("rennradRahmen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (rennradStandardNachfrage + rennradPremiumNachfrage)));
		
		alleAnbieter[0].getMaterial("mtbLenker").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + mtbPremiumNachfrage)));
		alleAnbieter[1].getMaterial("mtbLenker").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + mtbPremiumNachfrage)));
		alleAnbieter[2].getMaterial("mtbLenker").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + mtbPremiumNachfrage)));
		
		alleAnbieter[0].getMaterial("trekkingLenker").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (trekkingradStandardNachfrage + trekkingradPremiumNachfrage)));
		alleAnbieter[1].getMaterial("trekkingLenker").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (trekkingradStandardNachfrage + trekkingradPremiumNachfrage)));
		alleAnbieter[2].getMaterial("trekkingLenker").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (trekkingradStandardNachfrage + trekkingradPremiumNachfrage)));
		
		alleAnbieter[0].getMaterial("rennradLenker").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (rennradStandardNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[1].getMaterial("rennradLenker").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (rennradStandardNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[2].getMaterial("rennradLenker").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (rennradStandardNachfrage + rennradPremiumNachfrage)));
		
		alleAnbieter[0].getMaterial("mtbPedal").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * (mtbStandardNachfrage + mtbPremiumNachfrage)));
		alleAnbieter[1].getMaterial("mtbPedal").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * (mtbStandardNachfrage + mtbPremiumNachfrage)));
		alleAnbieter[2].getMaterial("mtbPedal").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * (mtbStandardNachfrage + mtbPremiumNachfrage)));
		
		alleAnbieter[0].getMaterial("trekkingPedal").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * (trekkingradStandardNachfrage + trekkingradPremiumNachfrage)));
		alleAnbieter[1].getMaterial("trekkingPedal").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * (trekkingradStandardNachfrage + trekkingradPremiumNachfrage)));
		alleAnbieter[2].getMaterial("trekkingPedal").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * (trekkingradStandardNachfrage + trekkingradPremiumNachfrage)));
		
		alleAnbieter[0].getMaterial("rennradPedal").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * (rennradStandardNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[1].getMaterial("rennradPedal").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * (rennradStandardNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[2].getMaterial("rennradPedal").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * (rennradStandardNachfrage + rennradPremiumNachfrage)));
		
		alleAnbieter[0].getMaterial("mtbRadStandard").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * mtbStandardNachfrage));
		alleAnbieter[1].getMaterial("mtbRadStandard").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * mtbStandardNachfrage));
		alleAnbieter[2].getMaterial("mtbRadStandard").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * mtbStandardNachfrage));
		
		alleAnbieter[0].getMaterial("mtbRadPremium").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * mtbPremiumNachfrage));
		alleAnbieter[1].getMaterial("mtbRadPremium").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * mtbPremiumNachfrage));
		alleAnbieter[2].getMaterial("mtbRadPremium").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * mtbPremiumNachfrage));
		
		alleAnbieter[0].getMaterial("trekkingRadStandard").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * trekkingradStandardNachfrage));
		alleAnbieter[1].getMaterial("trekkingRadStandard").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * trekkingradStandardNachfrage));
		alleAnbieter[2].getMaterial("trekkingRadStandard").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * trekkingradStandardNachfrage));
		
		alleAnbieter[0].getMaterial("trekkingRadPremium").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * trekkingradPremiumNachfrage));
		alleAnbieter[1].getMaterial("trekkingRadPremium").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * trekkingradPremiumNachfrage));
		alleAnbieter[2].getMaterial("trekkingRadPremium").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * trekkingradPremiumNachfrage));
		
		alleAnbieter[0].getMaterial("rennradRadStandard").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * rennradStandardNachfrage));
		alleAnbieter[1].getMaterial("rennradRadStandard").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * rennradStandardNachfrage));
		alleAnbieter[2].getMaterial("rennradRadStandard").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * rennradStandardNachfrage));
		
		alleAnbieter[0].getMaterial("rennradRadPremium").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * rennradPremiumNachfrage));
		alleAnbieter[1].getMaterial("rennradRadPremium").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * rennradPremiumNachfrage));
		alleAnbieter[2].getMaterial("rennradRadPremium").setAnzahlVerfuegbar((int) Math.round(2 * getRand(min, max) * rennradPremiumNachfrage));
		
		alleAnbieter[0].getMaterial("mtbSattelStandard").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * mtbStandardNachfrage));
		alleAnbieter[1].getMaterial("mtbSattelStandard").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * mtbStandardNachfrage));
		alleAnbieter[2].getMaterial("mtbSattelStandard").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * mtbStandardNachfrage));
		
		alleAnbieter[0].getMaterial("mtbSattelPremium").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * mtbPremiumNachfrage));
		alleAnbieter[1].getMaterial("mtbSattelPremium").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * mtbPremiumNachfrage));
		alleAnbieter[2].getMaterial("mtbSattelPremium").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * mtbPremiumNachfrage));
		
		alleAnbieter[0].getMaterial("trekkingSattelStandard").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * trekkingradStandardNachfrage));
		alleAnbieter[1].getMaterial("trekkingSattelStandard").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * trekkingradStandardNachfrage));
		alleAnbieter[2].getMaterial("trekkingSattelStandard").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * trekkingradStandardNachfrage));
		
		alleAnbieter[0].getMaterial("trekkingSattelPremium").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * trekkingradPremiumNachfrage));
		alleAnbieter[1].getMaterial("trekkingSattelPremium").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * trekkingradPremiumNachfrage));
		alleAnbieter[2].getMaterial("trekkingSattelPremium").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * trekkingradPremiumNachfrage));
		
		alleAnbieter[0].getMaterial("rennradSattelStandard").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * rennradStandardNachfrage));
		alleAnbieter[1].getMaterial("rennradSattelStandard").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * rennradStandardNachfrage));
		alleAnbieter[2].getMaterial("rennradSattelStandard").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * rennradStandardNachfrage));
		
		alleAnbieter[0].getMaterial("rennradSattelPremium").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * rennradPremiumNachfrage));
		alleAnbieter[1].getMaterial("rennradSattelPremium").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * rennradPremiumNachfrage));
		alleAnbieter[2].getMaterial("rennradSattelPremium").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * rennradPremiumNachfrage));
		
		alleAnbieter[0].getMaterial("felgenbremsen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + trekkingradStandardNachfrage + rennradStandardNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[1].getMaterial("felgenbremsen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + trekkingradStandardNachfrage + rennradStandardNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[2].getMaterial("felgenbremsen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + trekkingradStandardNachfrage + rennradStandardNachfrage + rennradPremiumNachfrage)));
		
		alleAnbieter[0].getMaterial("scheibenbremsen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbPremiumNachfrage + trekkingradPremiumNachfrage)));
		alleAnbieter[1].getMaterial("scheibenbremsen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbPremiumNachfrage + trekkingradPremiumNachfrage)));
		alleAnbieter[2].getMaterial("scheibenbremsen").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbPremiumNachfrage + trekkingradPremiumNachfrage)));
		
		alleAnbieter[0].getMaterial("drehgriffSchaltung").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + trekkingradStandardNachfrage)));
		alleAnbieter[1].getMaterial("drehgriffSchaltung").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + trekkingradStandardNachfrage)));
		alleAnbieter[2].getMaterial("drehgriffSchaltung").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + trekkingradStandardNachfrage)));
		
		alleAnbieter[0].getMaterial("triggerSchaltung").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (rennradStandardNachfrage + mtbPremiumNachfrage + trekkingradPremiumNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[1].getMaterial("triggerSchaltung").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (rennradStandardNachfrage + mtbPremiumNachfrage + trekkingradPremiumNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[2].getMaterial("triggerSchaltung").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (rennradStandardNachfrage + mtbPremiumNachfrage + trekkingradPremiumNachfrage + rennradPremiumNachfrage)));
		
		alleAnbieter[0].getMaterial("kette").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + trekkingradStandardNachfrage + rennradStandardNachfrage + mtbPremiumNachfrage + trekkingradPremiumNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[1].getMaterial("kette").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + trekkingradStandardNachfrage + rennradStandardNachfrage + mtbPremiumNachfrage + trekkingradPremiumNachfrage + rennradPremiumNachfrage)));
		alleAnbieter[2].getMaterial("kette").setAnzahlVerfuegbar((int) Math.round(getRand(min, max) * (mtbStandardNachfrage + trekkingradStandardNachfrage + rennradStandardNachfrage + mtbPremiumNachfrage + trekkingradPremiumNachfrage + rennradPremiumNachfrage)));
	}
	
	/**
	 * Methode wird jede Runde einmal aufgerufen.
	 * Die Preise der Materialien orientieren sich an den zu Beginn festgelegten Grundpreisen.
	 * Anbieter, welche eine längere Lieferzeit haben, bieten die Materialien billiger an.
	 */
	public static void angebotePreiseAnpassen(){
		Anbieter[] alleAnbieter = Marktplatz.getAlleAnbieter();
		double min = 0.9;
		double max = 1.1;
		double rabatt1 = 0.8; // 20% Rabatt auf ermittelten Preis
		double rabatt2 = 0.65; // 35% Rabatt auf ermittelten Preis
		
		alleAnbieter[0].getMaterial("mtbRahmen").setPreis((int) Math.round(getRand(min, max) * mtbRahmenStartPreis));
		alleAnbieter[1].getMaterial("mtbRahmen").setPreis((int) Math.round(getRand(min, max) * mtbRahmenStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("mtbRahmen").setPreis((int) Math.round(getRand(min, max) * mtbRahmenStartPreis * rabatt2));
		
    	alleAnbieter[0].getMaterial("trekkingRahmen").setPreis((int) Math.round(getRand(min, max) * trekkingRahmenStartPreis));
		alleAnbieter[1].getMaterial("trekkingRahmen").setPreis((int) Math.round(getRand(min, max) * trekkingRahmenStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("trekkingRahmen").setPreis((int) Math.round(getRand(min, max) * trekkingRahmenStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("rennradRahmen").setPreis((int) Math.round(getRand(min, max) * rennradRahmenStartPreis));
		alleAnbieter[1].getMaterial("rennradRahmen").setPreis((int) Math.round(getRand(min, max) * rennradRahmenStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("rennradRahmen").setPreis((int) Math.round(getRand(min, max) * rennradRahmenStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("mtbLenker").setPreis((int) Math.round(getRand(min, max) * mtbLenkerStartPreis));
		alleAnbieter[1].getMaterial("mtbLenker").setPreis((int) Math.round(getRand(min, max) * mtbLenkerStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("mtbLenker").setPreis((int) Math.round(getRand(min, max) * mtbLenkerStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("trekkingLenker").setPreis((int) Math.round(getRand(min, max) * trekkingLenkerStartPreis));
		alleAnbieter[1].getMaterial("trekkingLenker").setPreis((int) Math.round(getRand(min, max) * trekkingLenkerStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("trekkingLenker").setPreis((int) Math.round(getRand(min, max) * trekkingLenkerStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("rennradLenker").setPreis((int) Math.round(getRand(min, max) * rennradLenkerStartPreis));
		alleAnbieter[1].getMaterial("rennradLenker").setPreis((int) Math.round(getRand(min, max) * rennradLenkerStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("rennradLenker").setPreis((int) Math.round(getRand(min, max) * rennradLenkerStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("mtbPedal").setPreis((int) Math.round(getRand(min, max) * mtbPedalStartPreis));
		alleAnbieter[1].getMaterial("mtbPedal").setPreis((int) Math.round(getRand(min, max) * mtbPedalStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("mtbPedal").setPreis((int) Math.round(getRand(min, max) * mtbPedalStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("trekkingPedal").setPreis((int) Math.round(getRand(min, max) * trekkingPedalStartPreis));
		alleAnbieter[1].getMaterial("trekkingPedal").setPreis((int) Math.round(getRand(min, max) * trekkingPedalStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("trekkingPedal").setPreis((int) Math.round(getRand(min, max) * trekkingPedalStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("rennradPedal").setPreis((int) Math.round(getRand(min, max) * rennradPedalStartPreis));
		alleAnbieter[1].getMaterial("rennradPedal").setPreis((int) Math.round(getRand(min, max) * rennradPedalStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("rennradPedal").setPreis((int) Math.round(getRand(min, max) * rennradPedalStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("mtbRadStandard").setPreis((int) Math.round(getRand(min, max) * mtbRadStandardStartPreis));
		alleAnbieter[1].getMaterial("mtbRadStandard").setPreis((int) Math.round(getRand(min, max) * mtbRadStandardStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("mtbRadStandard").setPreis((int) Math.round(getRand(min, max) * mtbRadStandardStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("mtbRadPremium").setPreis((int) Math.round(getRand(min, max) * mtbRadPremiumStartPreis));
		alleAnbieter[1].getMaterial("mtbRadPremium").setPreis((int) Math.round(getRand(min, max) * mtbRadPremiumStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("mtbRadPremium").setPreis((int) Math.round(getRand(min, max) * mtbRadPremiumStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("trekkingRadStandard").setPreis((int) Math.round(getRand(min, max) * trekkingRadStandardStartPreis));
		alleAnbieter[1].getMaterial("trekkingRadStandard").setPreis((int) Math.round(getRand(min, max) * trekkingRadStandardStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("trekkingRadStandard").setPreis((int) Math.round(getRand(min, max) * trekkingRadStandardStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("trekkingRadPremium").setPreis((int) Math.round(getRand(min, max) * trekkingRadPremiumStartPreis));
		alleAnbieter[1].getMaterial("trekkingRadPremium").setPreis((int) Math.round(getRand(min, max) * trekkingRadPremiumStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("trekkingRadPremium").setPreis((int) Math.round(getRand(min, max) * trekkingRadPremiumStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("rennradRadStandard").setPreis((int) Math.round(getRand(min, max) * rennradRadStandardStartPreis));
		alleAnbieter[1].getMaterial("rennradRadStandard").setPreis((int) Math.round(getRand(min, max) * rennradRadStandardStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("rennradRadStandard").setPreis((int) Math.round(getRand(min, max) * rennradRadStandardStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("rennradRadPremium").setPreis((int) Math.round(getRand(min, max) * rennradRadPremiumStartPreis));
		alleAnbieter[1].getMaterial("rennradRadPremium").setPreis((int) Math.round(getRand(min, max) * rennradRadPremiumStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("rennradRadPremium").setPreis((int) Math.round(getRand(min, max) * rennradRadPremiumStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("mtbSattelStandard").setPreis((int) Math.round(getRand(min, max) * mtbSattelStandardStartPreis));
		alleAnbieter[1].getMaterial("mtbSattelStandard").setPreis((int) Math.round(getRand(min, max) * mtbSattelStandardStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("mtbSattelStandard").setPreis((int) Math.round(getRand(min, max) * mtbSattelStandardStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("mtbSattelPremium").setPreis((int) Math.round(getRand(min, max) * mtbSattelPremiumStartPreis));
		alleAnbieter[1].getMaterial("mtbSattelPremium").setPreis((int) Math.round(getRand(min, max) * mtbSattelPremiumStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("mtbSattelPremium").setPreis((int) Math.round(getRand(min, max) * mtbSattelPremiumStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("trekkingSattelStandard").setPreis((int) Math.round(getRand(min, max) * trekkingSattelStandardStartPreis));
		alleAnbieter[1].getMaterial("trekkingSattelStandard").setPreis((int) Math.round(getRand(min, max) * trekkingSattelStandardStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("trekkingSattelStandard").setPreis((int) Math.round(getRand(min, max) * trekkingSattelStandardStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("trekkingSattelPremium").setPreis((int) Math.round(getRand(min, max) * trekkingSattelPremiumStartPreis));
		alleAnbieter[1].getMaterial("trekkingSattelPremium").setPreis((int) Math.round(getRand(min, max) * trekkingSattelPremiumStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("trekkingSattelPremium").setPreis((int) Math.round(getRand(min, max) * trekkingSattelPremiumStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("rennradSattelStandard").setPreis((int) Math.round(getRand(min, max) * rennradSattelStandardStartPreis));
		alleAnbieter[1].getMaterial("rennradSattelStandard").setPreis((int) Math.round(getRand(min, max) * rennradSattelStandardStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("rennradSattelStandard").setPreis((int) Math.round(getRand(min, max) * rennradSattelStandardStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("rennradSattelPremium").setPreis((int) Math.round(getRand(min, max) * rennradSattelPremiumStartPreis));
		alleAnbieter[1].getMaterial("rennradSattelPremium").setPreis((int) Math.round(getRand(min, max) * rennradSattelPremiumStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("rennradSattelPremium").setPreis((int) Math.round(getRand(min, max) * rennradSattelPremiumStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("felgenbremsen").setPreis((int) Math.round(getRand(min, max) * felgenbremsenStartPreis));
		alleAnbieter[1].getMaterial("felgenbremsen").setPreis((int) Math.round(getRand(min, max) * felgenbremsenStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("felgenbremsen").setPreis((int) Math.round(getRand(min, max) * felgenbremsenStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("scheibenbremsen").setPreis((int) Math.round(getRand(min, max) * scheibenbremsenStartPreis));
		alleAnbieter[1].getMaterial("scheibenbremsen").setPreis((int) Math.round(getRand(min, max) * scheibenbremsenStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("scheibenbremsen").setPreis((int) Math.round(getRand(min, max) * scheibenbremsenStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("drehgriffSchaltung").setPreis((int) Math.round(getRand(min, max) * drehgriffSchaltungStartPreis));
		alleAnbieter[1].getMaterial("drehgriffSchaltung").setPreis((int) Math.round(getRand(min, max) * drehgriffSchaltungStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("drehgriffSchaltung").setPreis((int) Math.round(getRand(min, max) * drehgriffSchaltungStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("triggerSchaltung").setPreis((int) Math.round(getRand(min, max) * triggerSchaltungStartPreis));
		alleAnbieter[1].getMaterial("triggerSchaltung").setPreis((int) Math.round(getRand(min, max) * triggerSchaltungStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("triggerSchaltung").setPreis((int) Math.round(getRand(min, max) * triggerSchaltungStartPreis * rabatt2));
		
		alleAnbieter[0].getMaterial("kette").setPreis((int) Math.round(getRand(min, max) * ketteStartPreis));
		alleAnbieter[1].getMaterial("kette").setPreis((int) Math.round(getRand(min, max) * ketteStartPreis * rabatt1));
		alleAnbieter[2].getMaterial("kette").setPreis((int) Math.round(getRand(min, max) * ketteStartPreis * rabatt2));
		
	}
}
