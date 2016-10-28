package spiel;
import java.util.Vector;


public class Marktplatz
{
	private static Vector<Anbieter> alleAnbieter = new Vector<Anbieter>();
	private static Vector<Verkaufsposten> alleVerkaufsposten = new Vector<Verkaufsposten>();
	
	/** Alle Anbieter werden als Array zurückgegeben **/
	public static Anbieter[] getAlleAnbieter(){
		Anbieter[] anbieter = new Anbieter[alleAnbieter.size()];
		for (int i = 0; i < anbieter.length; i++){
			anbieter[i] = alleAnbieter.get(i);
		}
		return anbieter;
	}
	
	/**
	 * @param spielerName Name des Spielers 
	 * @param fahrradTyp Typ des Fahrrads
	 * @return Gibt zurück wie viel Fahrräder eines Typs von einem Spieler auf dem Marktplatz stehen.
	 */
	public static int getAnzahlFahrraederAufMarktplatz(Unternehmen unternehmen, String fahrradTyp){
		int anzahl = 0;
		for (int i = 0; i < alleVerkaufsposten.size(); i++){
			if (alleVerkaufsposten.get(i).getUnternehmen() == unternehmen && alleVerkaufsposten.get(i).getFahrradTyp() == fahrradTyp){
				anzahl += alleVerkaufsposten.get(i).getAnzahl();
			}
		}
		return anzahl;
	}
	
	/** Liefert Array mit allen Verkaufsposten-Objekten zurück, die zu einem bestimmten Unternehmen gehören. **/
	public static Verkaufsposten[] getVerkaufspostenVonUnternehmen(Unternehmen unternehmen){
		int count = 0;
		for (int i = 0; i < alleVerkaufsposten.size(); i++){
			if (alleVerkaufsposten.get(i).getUnternehmen() == unternehmen)
				count++;
		}
		
		Verkaufsposten[] verkaufsposten = new Verkaufsposten[count];
		
		count = 0;
		for (int i = 0; i < alleVerkaufsposten.size(); i++){
			if (alleVerkaufsposten.get(i).getUnternehmen() == unternehmen){
				verkaufsposten[count] = alleVerkaufsposten.get(i);
				count++;
			}
		}
		
		return verkaufsposten;
	}
	
	/**
	 * Diese Methode wird aus der Methode fahrraederAbkaufen() in der Klasse Markt aufgerufen. 
	 * @param typ Typ des Fahrrads ["mtbStandard", "mtbPremium", "trekkingradStandard", "trekkingradPremium", "rennradStandard", "rennradStandard"].
	 * @return Gibt ein Array mit allen Verkaufsposten-Objekten (nach Preis sortiert) zurück, das zu einem Fahrradtyp gehört.
	 */
	public static Verkaufsposten[] getVerkaufspostenVonFahrradtyp(String typ){
	
		/** zunächst alle Verkaufsposten mit dem entsprechenden FahrradTyp in ein Array laden **/
		
		int count = 0;
		for (int i = 0; i < alleVerkaufsposten.size(); i++){
			if (alleVerkaufsposten.get(i).getFahrradTyp().equals(typ))
				count++;
		}
		
		Verkaufsposten[] verkaufsposten = new Verkaufsposten[count];
		
		count = 0;
		for (int i = 0; i < alleVerkaufsposten.size(); i++){
			if (alleVerkaufsposten.get(i).getFahrradTyp().equals(typ)){
				verkaufsposten[count] = alleVerkaufsposten.get(i);
				count++;
			}
		}
		
		/** Array Einträge nach Preis sortieren, damit in der Methode fahrraederAbkaufen() in der Klasse Markt, die billigsten zu erst abgekauft werden **/
		
		if (verkaufsposten.length <= 1){
			return verkaufsposten;
		}
		else {
			int i = 0;
			int e = 0;
			int arrLen = verkaufsposten.length;
			boolean sortiert = false;
			Verkaufsposten temp;
			
			// Bubblesort
			
			while (!sortiert){
				i = e;
				while (verkaufsposten[i + 1].getPreis() < verkaufsposten[i].getPreis()){
					temp = verkaufsposten[i];
					verkaufsposten[i] = verkaufsposten[i + 1];
					verkaufsposten[i + 1] = temp;
					
					if (i > 0)
						i--;
				}
				e++;
				if ((e + 1) == arrLen)
					sortiert = true;			
			}
		}
		return verkaufsposten;
	}
	
	/**
	 * @param anbieterName Name des Anbieters.
	 * @return Gibt ein Anbieter-Objekt zurück, das den Namen "anbieterName" hat.
	 */
	public static Anbieter getAnbieter(String anbieterName){
		Anbieter anbieter = null;
		for (int i = 0; i < alleAnbieter.size(); i++){
			if (alleAnbieter.get(i).getAnbieterName() == anbieterName){
				anbieter = alleAnbieter.get(i);
			}
		}
		return anbieter;
	}
	
	/**
	 * @param anbieter Anbieter-Objekt zu dem das Material gehört.
	 * @param materialName Name des Materials.
	 * @return Gibt ein Material-Objekt des jeweiligen Anbieters zurück, das den Namen "materialName" hat.
	 */
	public static Material getMaterial(Anbieter anbieter, String materialName){
		Material material = anbieter.getMaterial(materialName);
		return material;
	}

	/**
	 * Fügt dem Marktplatz einen Anbieter hinzu. 
	 * @param anbieter Name des Anbieters.
	 */
	public static void addAnbieter(Anbieter anbieter){
		alleAnbieter.add(anbieter);
	}
	
	/**
	 * In dieser Methode wird die Bestellung durchgeführt und ein neues Bestellung-Objekt erzeugt.
	 * Dabei wird geprüft ob genügend Material vorhanden ist und ob das Konto des Unternehmens gedeckt ist.
	 * @param unternehmen Das Unternehmen-Objekt, welches die Bestellung in Auftrag gegeben hat.
	 * @param anbieterName Name des Anbieters, bei dem bestellt werden soll.
	 * @param materialName Name des Materials, das bestellt werden soll.
	 * @param anzahl Bestellmenge.
	 * @return das erstellte Bestellung-Objekt wird in der Klasse Unternehmen im Vector "alleBestellungen" gespeichert.
	 */
	public static Bestellung createBestellung(Unternehmen unternehmen, String anbieterName, String materialName, int anzahl){
		Bestellung bestellung = null;
		Anbieter anbieter = getAnbieter(anbieterName);
		Material material = getMaterial(anbieter, materialName);
		
		if (material.isVerfuegbar(anzahl)){
			if (unternehmen.getBank().getKontostand() >= (material.getPreis() * anzahl)){
				bestellung = new Bestellung(unternehmen, anbieter.getAnbieterName(), anbieter.getLieferzeit(), material.getMaterialName(), material.getMaterialBezeichnung(), material.getPreis(), anzahl);
				unternehmen.getBank().kontostandVerringern(bestellung.getGesamtPreis());
				
				// auch im Cashflow vermerken, Materialien die zur Produktion dienen sind zahlungswirksame Aufwendungen
				unternehmen.getCashflow().setMaterialKosten(unternehmen.getCashflow().getMaterialKosten() + bestellung.getGesamtPreis());
				
				material.setAnzahlVerfuegbar(material.getAnzahlVerfuegbar() - anzahl);
			}
		}	
		return bestellung;
	}
	
	/**
	 * Methode wird aufgerufen wenn Fahrräder auf den Marktplatz gestellt und verkauft werden sollen.
	 * Alle Verkaufsposten werden in der Klasse Marktplatz im Vektor "alleVerkaufsposten" gespeichert.
	 * @param unternehmen Unternehmen-Objekt zu dem der Verkaufsposten gehört.
	 * @param fahrradTyp Name des Fahrrads (Fahrradtyp).
	 * @param fahrradBezeichnung Ausführlicher Name des Fahrrads.
	 * @param anzahl Menge die verkauft werden soll.
	 * @param preis Stückpreis.
	 * @return true wenn Verkaufsposten erstellt werden konnte, sonst false
	 */
	public static boolean createVerkaufsposten(Unternehmen unternehmen, String fahrradTyp, String fahrradBezeichnung, int anzahl, int preis){
		if (anzahl <= 0) return false;
		
		int fahrraederAufMarktplatz = getAnzahlFahrraederAufMarktplatz(unternehmen, fahrradTyp);
		
		if (unternehmen.getLager().materialUndFahrradVerfuegbarkeitPruefen(fahrradTyp, anzahl + fahrraederAufMarktplatz)){
			Verkaufsposten verkaufsposten = new Verkaufsposten(unternehmen, fahrradTyp, fahrradBezeichnung, anzahl, preis);
			alleVerkaufsposten.add(verkaufsposten);
			return true;
		}
		return false;
	}
	
	/**
	 * Mit dieser Methode kann der Stückpreis eines Verkaufsposten verändert werden. 
	 * @param unternehmen Unternehmen-Objekt zu dem der Verkaufsposten gehört.
	 * @param nr Nummer des Verkaufsposten in der Liste aller Verkaufsposten des Unternehmens/Spielers.
	 * @param preis Neuer Preis des Verkaufsposten.
	 * @return true wenn Preis angepasst werden konnte, false wenn Preis nicht angepasst werden konnte.
	 */
	public static boolean changePreisVerkaufsposten(Unternehmen unternehmen, int nr, int preis){
		int count = -1;
		for (int i = 0; i < alleVerkaufsposten.size(); i++){
			if (alleVerkaufsposten.get(i).getUnternehmen() == unternehmen){
				count++;
			}
			if (count == nr){
				alleVerkaufsposten.get(i).setPreis(preis);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Mit dieser Methode kann die Anzahl eines Verkaufsposten verändert werden.
	 * @param unternehmen Unternehmen-Objekt zu dem der Verkaufsposten gehört.
	 * @param nr Nummer des Verkaufsposten in der Liste aller Verkaufsposten des Unternehmens/Spielers.
	 * @param neueAnzahl Neue Anzahl des Verkaufsposten.
	 * @return true wenn Anzahl angepasst werden konnte, false wenn Anzahl nicht angepasst werden konnte.
	 */
	public static boolean changeAnzahlVerkaufsposten(Unternehmen unternehmen, int nr, int neueAnzahl){
		int count = -1;
		for (int i = 0; i < alleVerkaufsposten.size(); i++){
			if (alleVerkaufsposten.get(i).getUnternehmen() == unternehmen){
				count++;
			}
			if (count == nr){
				int alteAnzahl = alleVerkaufsposten.get(i).getAnzahl();

				// wenn Anzahl erhöht wird muss geprüft werden, ob genug Fahrräder zum Verkaufen vorhanden sind
				if (neueAnzahl >= alteAnzahl){
					int differenz = neueAnzahl - alteAnzahl;
					int fahrraederAufMarktplatz = getAnzahlFahrraederAufMarktplatz(unternehmen, alleVerkaufsposten.get(i).getFahrradTyp());
					
					if (unternehmen.getLager().materialUndFahrradVerfuegbarkeitPruefen(alleVerkaufsposten.get(i).getFahrradTyp(), differenz + fahrraederAufMarktplatz)){
						alleVerkaufsposten.get(i).setAnzahl(neueAnzahl);
						return true;
					}
					else return false;			
				}
				else if (neueAnzahl < alteAnzahl){
					alleVerkaufsposten.get(i).setAnzahl(neueAnzahl);
					return true;
				}
				
				break;
				
			}// end if
		}// end for
		return false;
	}
	
	/**
	 * Methode wird aus der Klasse Markt heraus (von der Methode fahrraederAbkaufen()) aufgerufen.
	 * Alle Verkaufsposten, deren Anzahl 0 entspricht werden gelöscht.
	 */
	public static void leereVerkaufspostenLoeschen(){
		int i = 0;
		
		while (i < alleVerkaufsposten.size()){
			if (alleVerkaufsposten.get(i).getAnzahl() == 0)
				alleVerkaufsposten.removeElementAt(i);
			else i++;
		}
	}
	
	/**
	 * Mit dieser Methode kann ein Verkaufsposten eines Spielers vom Marktplatz gelöscht werden.
	 * @param spielerName Name des Spielers
	 * @param nr Nummer des Verkaufsposten in der Liste aller Verkaufsposten des Unternemens/Spielers.
	 */
	public static void deleteVerkaufsposten(Unternehmen unternehmen, int nr){
		int count = -1;
		for (int i = 0; i < alleVerkaufsposten.size(); i++){
			if (alleVerkaufsposten.get(i).getUnternehmen() == unternehmen){
				count++;
			}
			
			if (count == nr){
				alleVerkaufsposten.removeElementAt(nr);
				break;
			}
		}
	}
}
