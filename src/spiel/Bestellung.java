package spiel;

public class Bestellung
{
	private Unternehmen unternehmen;
	private String anbieter;
	private String materialName;
	private String materialBezeichnung;
	private int anzahl;
	private int stkPreis;
	private int gesamtPreis;
	private int lieferzeit;	
	private int tageBisAnkunft;	
	
	public String getAnbieter() {
		return anbieter;
	}
	public int getLieferzeit() {
		return lieferzeit;
	}
	public int getTageBisAnkunft() {
		return tageBisAnkunft;
	}
	public String getMaterialName() {
		return materialName;
	}
	public String getMaterialBezeichnung() {
		return materialBezeichnung;
	}
	public int getAnzahl() {
		return anzahl;
	}
	public int getStkPreis() {
		return stkPreis;
	}
	public int getGesamtPreis() {
		return gesamtPreis;
	}
	
	/** KONSTRUKTOR **/
	public Bestellung(Unternehmen unternehmen, String anbieter, int lieferzeit, String materialName, String materialBezeichnung, int preis, int anzahl)
	{
		this.unternehmen = unternehmen;
		this.anbieter = anbieter;
		this.materialName = materialName;
		this.materialBezeichnung = materialBezeichnung;
		this.anzahl = anzahl;
		this.stkPreis = preis;
		this.gesamtPreis = preis * anzahl;
		this.lieferzeit = lieferzeit;
		this.tageBisAnkunft = lieferzeit;
	}
	
	/**
	 * Wird zu Beginn jeden Zugs für jedes Bestellung-Objekt aufgerufen.
	 * Bei jedem Aufruf wird die Eigenschaft "tageBisAnkunft" runtergezählt.
	 * Hat die Eigenschaft "tageBisAnkunft" den Wert 0, dann ist die Bestellung angekommen.
	 * Wenn die  Bestellung angekommen ist, wird diese ins Lager eingelagert.
	 * @return true: Bestellung erhalten.
	 * 		   false: Bestellung nicht erhalten.
	 */
	public boolean pruefeBestellungErhalten(){
		tageBisAnkunft--;
		
		if(tageBisAnkunft == 0){
			unternehmen.getLager().fahrradUndMaterialEinlagern(materialName, anzahl);
			return true;
		}
		return false;
	}
}
