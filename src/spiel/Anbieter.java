package spiel;
import java.util.Vector;

public class Anbieter
{
	private String anbieterName;
	private int lieferzeit;
	private Vector<Material> alleMaterialien = new Vector<Material>();
	
	public String getAnbieterName(){
		return anbieterName;
	}
	public int getLieferzeit(){
		return lieferzeit;
	}
	public Material getMaterial(String materialName){
		for (int i = 0; i < alleMaterialien.size(); i++){
			if (alleMaterialien.get(i).getMaterialName() == materialName){
				return alleMaterialien.get(i);
			};			
		}
		return null;
	}
	
	/** KONSTRUKTOR **/
	public Anbieter(String anbieterName, int lieferzeit){
		this.anbieterName = anbieterName;
		this.lieferzeit = lieferzeit;		
	}
	
	/**
	 * Durch diese Methode werden dem Anbieter Materialien hinzugefügt. 
	 * Die Methode wird nur zu Beginn bei der Initialisierung aufgerufen.
	 * @param materialName Name des Materials.
	 * @param bezeichnung Bezeichnung des Materials (ausführlicher Name).
	 */
	public void addMaterial(String materialName, String bezeichnung){
		Material material = new Material(materialName, bezeichnung);
		alleMaterialien.add(material);		
	}
}
