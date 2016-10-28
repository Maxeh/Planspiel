package spiel;
public class Material
{
	private String materialName;
	private String materialBezeichnung; // ausführlicher Name
	private int preis;
	private int anzahlVerfuegbar;

	public void setPreis(int preis){
		this.preis = preis;
	}
	public int getPreis(){
		return preis;
	}
	public String getMaterialName(){
		return materialName;
	}
	public int getAnzahlVerfuegbar() {
		return anzahlVerfuegbar;
	}
	public void setAnzahlVerfuegbar(int wert) {
		anzahlVerfuegbar = wert;
	}
	public String getMaterialBezeichnung() {
		return materialBezeichnung;
	}
	public boolean isVerfuegbar(int anzahl){
		if(this.anzahlVerfuegbar < anzahl)
			return false;
		return true;
	}
	
	/** KONSTRUKTOR **/
	public Material(String name, String materialBezeichnung){
		this.materialName = name;
		this.materialBezeichnung = materialBezeichnung;
	}
	
	
}
