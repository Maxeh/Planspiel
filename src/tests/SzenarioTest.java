package tests;

import static org.junit.Assert.*;

import org.junit.Test;




import spiel.Markt;
import spiel.Marktplatz;
import spiel.Planspiel;
import spiel.Unternehmen;


public class SzenarioTest {

	private Unternehmen  HochFahrrad;
	private Unternehmen ZukunftsFahrrad;
	private Unternehmen FreiRad;
	@Test
	public void test() {
		Planspiel.starteSpiel("HochFahrrad", "ZukunftsFahrrad", "FreiRad");
		/* RUNDE 1:
		 * ZUG: HochFahrrad
		 * Spieler 1 kauft sich die nötigen Materialien in der ersten Runde um
		 * 100 Mountainbikes Produzieren zu können. Anbieter 1 hat eine Lieferzeit von 1 Runde.
		 */
		HochFahrrad=Planspiel.getAktuellesUnternehmen();
		//Anfangskontostand ermitteln:
		int istKontostandHochFahrrad=(int)HochFahrrad.getBank().getKontostand();
		//Stellt seine Anfangsfahrräder auf den Markt:
		Marktplatz.createVerkaufsposten(HochFahrrad, "mtbStandard", "Mountainbike Standard", 150, 1135);
		Marktplatz.createVerkaufsposten(HochFahrrad, "trekkingradStandard", "Trekkingrad Standard", 150, 880);
		Marktplatz.createVerkaufsposten(HochFahrrad, "rennradStandard", "Rennrad Standard", 150, 1595);
		//Dadurch kann er auf Diagramm erkennen, wie es mit der Nachfrage aussieht:
		HochFahrrad.getEntwicklung().marktErforschen("trekkingradStandard");
		HochFahrrad.getEntwicklung().marktErforschen("rennradStandard");
		//Bestellt Fahrradteile für Mountainbike Standard:
		HochFahrrad.createBestellung("anbieter1", "mtbRahmen", 150); 
		HochFahrrad.createBestellung("anbieter1", "mtbLenker", 150);
		HochFahrrad.createBestellung("anbieter1", "mtbPedal", 300);
		HochFahrrad.createBestellung("anbieter1", "mtbRadStandard", 300);
		HochFahrrad.createBestellung("anbieter1", "mtbSattelStandard", 150);
		HochFahrrad.createBestellung("anbieter1", "drehgriffSchaltung", 150);
		HochFahrrad.createBestellung("anbieter1", "felgenbremsen", 150);
		HochFahrrad.createBestellung("anbieter1", "kette", 150);
		//Bestellt Fahrradteile Trekkingrad:
		HochFahrrad.createBestellung("anbieter1", "trekkingRahmen", 150);
		HochFahrrad.createBestellung("anbieter1", "trekkingLenker", 150);
		HochFahrrad.createBestellung("anbieter1", "trekkingPedal", 300);
		HochFahrrad.createBestellung("anbieter1", "trekkingRadStandard", 300);
		HochFahrrad.createBestellung("anbieter1", "trekkingSattelStandard", 150);
		HochFahrrad.createBestellung("anbieter1", "drehgriffSchaltung", 150);
		HochFahrrad.createBestellung("anbieter1", "felgenbremsen", 150);
		HochFahrrad.createBestellung("anbieter1", "kette", 150);
		//Bestellt Fahrradteile Rennrad
		HochFahrrad.createBestellung("anbieter1", "rennradRahmen", 150); 
		HochFahrrad.createBestellung("anbieter1", "rennradLenker", 150);
		HochFahrrad.createBestellung("anbieter1", "rennradPedal", 300);
		HochFahrrad.createBestellung("anbieter1", "rennradRadStandard", 300);
		HochFahrrad.createBestellung("anbieter1", "rennradSattelStandard", 150);
		HochFahrrad.createBestellung("anbieter1", "triggerSchaltung", 150);
		HochFahrrad.createBestellung("anbieter1", "felgenbremsen", 150);
		HochFahrrad.createBestellung("anbieter1", "kette", 150);
		//Kann dank der Fahrradteile zu beginn direkt 150 Stück von allen 3 Standardfahrrädern Produzieren:
		HochFahrrad.getFabrik().fahrradProduzieren("mtbStandard", 150);
		HochFahrrad.getFabrik().fahrradProduzieren("trekkingradStandard", 150);
		HochFahrrad.getFabrik().fahrradProduzieren("rennradStandard", 150);
		//Abschluss der Versicherungen:
		HochFahrrad.getVersicherung().setBrandschutz(true);
		HochFahrrad.getVersicherung().setReparaturVertrag(true);
		HochFahrrad.getVersicherung().setRechtsschutzVersicherung(true);
		//Berechnung der Kosten (Die Preise der Anbieter ändern sich, daher müssen die extra berechnet werden):
		int runde1KostenHochFahrrad=20000;// die Markforschung kostet 20000
		for(int i=0; i<HochFahrrad.getBestellungen().length;i++){
			runde1KostenHochFahrrad+=HochFahrrad.getBestellungen()[i].getGesamtPreis();
			
		}
		//Berechnen, wie hoch der Kontostand nach den Einkäufen sein sollte:
		int sollKontoStandHochFahrrad= istKontostandHochFahrrad-runde1KostenHochFahrrad;
		//Um Vergleichen zu können, fragen wir den tatsächlichen aktuellen Kontostand nach den Einkäufen ab:
		istKontostandHochFahrrad=(int)HochFahrrad.getBank().getKontostand();
		//Der sollKontostand nach den Einkäufen wird mit dem tatsächlichen Kontostand nach den Einkäufen verglichen. Falls alles geklappt hat, müsste der Test funktionieren.
		assertEquals(sollKontoStandHochFahrrad,istKontostandHochFahrrad);
		Planspiel.zugBeenden();
		
		/* RUNDE 1:
		 * ZUG: ZukunftsFahrrad
		 * ZukunftsFahrrad kauft sich die billigeren Materialien von Anbieter 2.
		 * Diese brauchen allerdings 2 Runden. Die Ketter ist von Anbieter 1.
		 */
		ZukunftsFahrrad=Planspiel.getAktuellesUnternehmen();
		//Kontostand zu Beginn der Runde
		int istKontostandZukunftsFahrrad=(int)ZukunftsFahrrad.getBank().getKontostand();
		//Dadurch kann er auf Diagramm erkennen, wie es mit der Nachfrage aussieht:
		ZukunftsFahrrad.getEntwicklung().marktErforschen("trekkingradPremium");
		ZukunftsFahrrad.getEntwicklung().marktErforschen("rennradPremium");
		ZukunftsFahrrad.getEntwicklung().marktErforschen("mtbPremium");
		//Erwirbt Patente für Premiumräder:
		ZukunftsFahrrad.getEntwicklung().patentKaufen("mtb");
		ZukunftsFahrrad.getEntwicklung().patentKaufen("trekking");
		ZukunftsFahrrad.getEntwicklung().patentKaufen("rennrad");
		//Stellt seine Anfangsfahrräder auf den Markt:
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "mtbStandard", "Mountainbike Standard", 150, 1135);
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "trekkingradStandard", "Trekkingrad Standard", 150, 880);
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "rennradStandard", "Rennrad Standard", 150, 1595);
		//Kann dank der Fahrradteile zu beginn direkt 150 Stück von allen 3 Standardfahrrädern Produzieren:
		ZukunftsFahrrad.getFabrik().fahrradProduzieren("mtbStandard", 150);
		ZukunftsFahrrad.getFabrik().fahrradProduzieren("trekkingradStandard", 150);
		ZukunftsFahrrad.getFabrik().fahrradProduzieren("rennradStandard", 150);
		//Bestellt Fahrradteile für Mountainbike Premium:
		ZukunftsFahrrad.createBestellung("anbieter2", "mtbRahmen", 100); 
		ZukunftsFahrrad.createBestellung("anbieter2", "mtbLenker", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "mtbPedal", 200);
		ZukunftsFahrrad.createBestellung("anbieter2", "mtbRadPremium", 200);
		ZukunftsFahrrad.createBestellung("anbieter2", "mtbSattelPremium", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "triggerSchaltung", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "scheibenbremsen", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "kette", 100);
		//Bestellt Fahrradteile Trekkingrad Premium:
		ZukunftsFahrrad.createBestellung("anbieter2", "trekkingRahmen", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "trekkingLenker", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "trekkingPedal", 200);
		ZukunftsFahrrad.createBestellung("anbieter2", "trekkingRadPremium", 200);
		ZukunftsFahrrad.createBestellung("anbieter2", "trekkingSattelPremium", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "triggerSchaltung", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "scheibenbremsen", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "kette", 100);
		//Bestellt Fahrradteile Rennrad Premium:
		ZukunftsFahrrad.createBestellung("anbieter2", "rennradRahmen", 100); 
		ZukunftsFahrrad.createBestellung("anbieter2", "rennradLenker", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "rennradPedal", 200);
		ZukunftsFahrrad.createBestellung("anbieter2", "rennradRadPremium", 200);
		ZukunftsFahrrad.createBestellung("anbieter2", "rennradSattelPremium", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "triggerSchaltung", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "felgenbremsen", 100);
		ZukunftsFahrrad.createBestellung("anbieter2", "kette", 100);
		//Abschluss der Versicherung:
		ZukunftsFahrrad.getVersicherung().setBrandschutz(true);
		//Berechnung der Kosten (Die Preise der Anbieter ändern sich, daher müssen die extra berechnet werden):
		//die Kosten die Aufgrund von Forschung und Entwicklung anfallen:
		int runde1KostenZukunftsFahrrad=30000+120000+100000+180000;// pro Marktforschung 10.000, Patente 120.000,100.000 und 180.000
		for(int i=0; i<ZukunftsFahrrad.getBestellungen().length;i++){
			runde1KostenZukunftsFahrrad+=ZukunftsFahrrad.getBestellungen()[i].getGesamtPreis();
			
		}
		//Berechnen, wie hoch der Kontostand nach den Einkäufen sein sollte:
		int sollKontoStandZukunftsFahrrad= istKontostandZukunftsFahrrad-runde1KostenZukunftsFahrrad;
		//Um Vergleichen zu können, fragen wir den tatsächlichen aktuellen Kontostand nach den Einkäufen ab:
		istKontostandZukunftsFahrrad=(int)ZukunftsFahrrad.getBank().getKontostand();
		//Der sollKontostand nach den Einkäufen wird mit dem tatsächlichen Kontostand nach den Einkäufen verglichen. Falls alles geklappt hat, müsste der Test funktionieren.
		assertEquals(sollKontoStandZukunftsFahrrad,istKontostandZukunftsFahrrad);
		Planspiel.zugBeenden();
		
		/* RUNDE 1:
		 * ZUG: FreiRad
		 * 
		 */
		FreiRad = Planspiel.getAktuellesUnternehmen();
		int istKontostandFreiRad=(int)FreiRad.getBank().getKontostand();
		//Dadurch kann er auf Diagramm erkennen, wie es mit der Nachfrage aussieht
		FreiRad.getEntwicklung().marktErforschen("trekkingradStandard");
		FreiRad.getEntwicklung().marktErforschen("rennradStandard");
		FreiRad.getEntwicklung().maschineKaufen(); // Spieler 3 kauft eine weiter Maschine zur Erhöhung der Produktionskapazität
		//Die Produktion wird in Auftrag gegeben
		FreiRad.getFabrik().fahrradProduzieren("mtbStandard", 150);
		FreiRad.getFabrik().fahrradProduzieren("trekkingradStandard", 150);
		FreiRad.getFabrik().fahrradProduzieren("rennradStandard", 150);
		FreiRad.createBestellung("anbieter3", "mtbRahmen", 200); // Spieler 3 kauft Mountainbike Rahmen bei Anbiter 3: billig aber 3 Runden Lieferzeit
		FreiRad.createBestellung("anbieter3", "mtbLenker", 200);
		FreiRad.createBestellung("anbieter3", "mtbPedal", 400);
		FreiRad.createBestellung("anbieter3", "mtbRadStandard", 400);
		FreiRad.createBestellung("anbieter3", "mtbSattelStandard", 200);
		FreiRad.createBestellung("anbieter3", "drehgriffSchaltung", 200);
		FreiRad.createBestellung("anbieter3", "felgenbremsen",200);		
		FreiRad.createBestellung("anbieter3", "kette", 200);
		//Bestellt Fahrradteile Trekkingrad:
		FreiRad.createBestellung("anbieter3", "trekkingRahmen", 200);
		FreiRad.createBestellung("anbieter3", "trekkingLenker", 200);
		FreiRad.createBestellung("anbieter3", "trekkingPedal", 400);
		FreiRad.createBestellung("anbieter3", "trekkingRadStandard", 400);
		FreiRad.createBestellung("anbieter3", "trekkingSattelStandard", 200);
		FreiRad.createBestellung("anbieter3", "drehgriffSchaltung", 200);
		FreiRad.createBestellung("anbieter3", "felgenbremsen", 200);
		FreiRad.createBestellung("anbieter3", "kette", 200);
		//Bestellt Fahrradteile Rennrad
		FreiRad.createBestellung("anbieter3", "rennradRahmen", 200); 
		FreiRad.createBestellung("anbieter3", "rennradLenker", 200);
		FreiRad.createBestellung("anbieter3", "rennradPedal", 400);
		FreiRad.createBestellung("anbieter3", "rennradRadStandard", 400);
		FreiRad.createBestellung("anbieter3", "rennradSattelStandard", 200);
		FreiRad.createBestellung("anbieter3", "triggerSchaltung", 200);
		FreiRad.createBestellung("anbieter3", "felgenbremsen", 200);
		FreiRad.createBestellung("anbieter3", "kette", 200);
		Marktplatz.createVerkaufsposten(FreiRad, "mtbStandard", "Mountainbike Standard", 150, 1100); 
		Marktplatz.createVerkaufsposten(FreiRad, "trekkingradStandard", "Trekkingrad Standard", 150, 850);
		Marktplatz.createVerkaufsposten(FreiRad, "rennradStandard", "Rennrad Standard", 150, 1500);
		int runde1KostenFreiRad=100000;// die Markforschung kostet 15000 + der Maschinenpreis von 80000
		for(int i=0; i<FreiRad.getBestellungen().length;i++){
			runde1KostenFreiRad+=FreiRad.getBestellungen()[i].getGesamtPreis();
		}
		
		//Berechnen, wie hoch der Kontostand nach den Einkäufen sein sollte:
		int sollKontoStandFreiRad= istKontostandFreiRad-runde1KostenFreiRad;
		//Um Vergleichen zu können, fragen wir den tatsächlichen aktuellen Kontostand nach den Einkäufen ab:
		istKontostandFreiRad=(int)FreiRad.getBank().getKontostand();
		//Der sollKontostand nach den Einkäufen wird mit dem tatsächlichen Kontostand nach den Einkäufen verglichen. Falls alles geklappt hat, müsste der Test funktionieren.
		assertEquals(sollKontoStandFreiRad,istKontostandFreiRad);
		Planspiel.zugBeenden();
		
//#####################################################################################################################################		
		/* RUNDE 2:
		 * ZUG: HochFahrrad
		 */
		istKontostandHochFahrrad=(int)HochFahrrad.getBank().getKontostand();
		HochFahrrad.getEntwicklung().maschinenUpgrade();
		Marktplatz.createVerkaufsposten(HochFahrrad, "mtbStandard", "Mountainbike Standard", 150, 1135);
		Marktplatz.createVerkaufsposten(HochFahrrad, "trekkingradStandard", "Trekkingrad Standard", 150, 880);
		Marktplatz.createVerkaufsposten(HochFahrrad, "rennradStandard", "Rennrad Standard", 150, 1595);
		HochFahrrad.getFabrik().fahrradProduzieren("mtbStandard", 150);
		HochFahrrad.getFabrik().fahrradProduzieren("trekkingradStandard", 150);
		HochFahrrad.getFabrik().fahrradProduzieren("rennradStandard", 150);
		HochFahrrad.getEntwicklung().lagerKapazitaetErhoehen();
		HochFahrrad.createBestellung("anbieter1", "mtbRahmen", 50); 
		HochFahrrad.createBestellung("anbieter1", "mtbLenker", 50);
		HochFahrrad.createBestellung("anbieter1", "mtbPedal", 100);
		HochFahrrad.createBestellung("anbieter1", "mtbRadStandard", 100);
		HochFahrrad.createBestellung("anbieter1", "mtbSattelStandard", 50);
		HochFahrrad.createBestellung("anbieter1", "drehgriffSchaltung", 50);
		HochFahrrad.createBestellung("anbieter1", "felgenbremsen",50);
		HochFahrrad.createBestellung("anbieter1", "kette",50);
		//Bestellt Fahrradteile Trekkingrad:
		HochFahrrad.createBestellung("anbieter1", "trekkingRahmen", 50);
		HochFahrrad.createBestellung("anbieter1", "trekkingLenker", 50);
		HochFahrrad.createBestellung("anbieter1", "trekkingPedal", 100);
		HochFahrrad.createBestellung("anbieter1", "trekkingRadStandard", 100);
		HochFahrrad.createBestellung("anbieter1", "trekkingSattelStandard", 50);
		HochFahrrad.createBestellung("anbieter1", "drehgriffSchaltung", 50);
		HochFahrrad.createBestellung("anbieter1", "felgenbremsen", 50);
		HochFahrrad.createBestellung("anbieter1", "kette", 50);
		//Bestellt Fahrradteile Rennrad
		HochFahrrad.createBestellung("anbieter1", "rennradRahmen", 50); 
		HochFahrrad.createBestellung("anbieter1", "rennradLenker", 50);
		HochFahrrad.createBestellung("anbieter1", "rennradPedal", 100);
		HochFahrrad.createBestellung("anbieter1", "rennradRadStandard", 100);
		HochFahrrad.createBestellung("anbieter1", "rennradSattelStandard", 50);
		HochFahrrad.createBestellung("anbieter1", "triggerSchaltung", 50);
		HochFahrrad.createBestellung("anbieter1", "felgenbremsen", 50);
		HochFahrrad.createBestellung("anbieter1", "kette", 50);
		assertEquals(24,HochFahrrad.getBestellungen().length);
		//Überprüfung des Kontostandes:
		int runde2KostenHochFahrrad=220000;//Maschinenupgrade und LagerKapazität erhöhen
		for(int i=0; i<HochFahrrad.getBestellungen().length;i++){
			runde2KostenHochFahrrad+=HochFahrrad.getBestellungen()[i].getGesamtPreis();
			
		}
		//Berechnen, wie hoch der Kontostand nach den Einkäufen sein sollte:
		sollKontoStandHochFahrrad= istKontostandHochFahrrad-runde2KostenHochFahrrad;
		//Um Vergleichen zu können, fragen wir den tatsächlichen aktuellen Kontostand nach den Einkäufen ab:
		istKontostandHochFahrrad=(int)HochFahrrad.getBank().getKontostand();
		//Der sollKontostand nach den Einkäufen wird mit dem tatsächlichen Kontostand nach den Einkäufen verglichen. Falls alles geklappt hat, müsste der Test funktionieren.
		assertEquals(sollKontoStandHochFahrrad,istKontostandHochFahrrad);
		Planspiel.zugBeenden();
	
		/* RUNDE 2:
		 * ZUG: ZukunftsFahrrad
		 */
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "mtbStandard", "Mountainbike Standard", 150, 1135);
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "trekkingradStandard", "Trekkingrad Standard", 150, 880);
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "rennradStandard", "Rennrad Standard", 150, 1595);
		Planspiel.zugBeenden();
		
		/* RUNDE 2:
		 * ZUG: FreiRad
		 * 
		 */
		// Spieler 3 kauft nur Maschinen hinzu, weil er bis Runde 4 auf eine Produktionskapazität von 800 Fahrrädern kommen muss.
		FreiRad.getEntwicklung().maschineKaufen();
		FreiRad.getEntwicklung().maschineKaufen();
		Marktplatz.createVerkaufsposten(FreiRad, "mtbStandard", "Mountainbike Standard", 150, 1135);
		Marktplatz.createVerkaufsposten(FreiRad, "trekkingradStandard", "Trekkingrad Standard", 150, 880);
		Marktplatz.createVerkaufsposten(FreiRad, "rennradStandard", "Rennrad Standard", 150, 1595);
	    FreiRad.createBestellung("anbieter2", "mtbRahmen",50);
		FreiRad.createBestellung("anbieter2", "mtbLenker", 50);
		FreiRad.createBestellung("anbieter2", "mtbPedal", 100);
		FreiRad.createBestellung("anbieter2", "mtbRadStandard", 100);
		FreiRad.createBestellung("anbieter2", "mtbSattelStandard", 50);
		FreiRad.createBestellung("anbieter2", "drehgriffSchaltung", 50);
		FreiRad.createBestellung("anbieter2", "felgenbremsen",50);		
		FreiRad.createBestellung("anbieter2", "kette", 50);
		//Bestellt Fahrradteile Trekkingrad:
		FreiRad.createBestellung("anbieter2", "trekkingRahmen", 50);
		FreiRad.createBestellung("anbieter2", "trekkingLenker", 50);
		FreiRad.createBestellung("anbieter2", "trekkingPedal", 100);
		FreiRad.createBestellung("anbieter2", "trekkingRadStandard", 100);
		FreiRad.createBestellung("anbieter2", "trekkingSattelStandard", 50);
		FreiRad.createBestellung("anbieter2", "drehgriffSchaltung", 50);
		FreiRad.createBestellung("anbieter2", "felgenbremsen", 50);
		FreiRad.createBestellung("anbieter2", "kette", 50);
		//Bestellt Fahrradteile Rennrad
		FreiRad.createBestellung("anbieter2", "rennradRahmen", 50); 
		FreiRad.createBestellung("anbieter2", "rennradLenker", 50);
		FreiRad.createBestellung("anbieter2", "rennradPedal", 100);
		FreiRad.createBestellung("anbieter2", "rennradRadStandard", 100);
		FreiRad.createBestellung("anbieter2", "rennradSattelStandard", 50);
		FreiRad.createBestellung("anbieter2", "triggerSchaltung", 50);
		FreiRad.createBestellung("anbieter2", "felgenbremsen", 50);
		FreiRad.createBestellung("anbieter2", "kette", 50);
		Planspiel.zugBeenden();
		
		/* RUNDE 3:
		 * ZUG: HochFahrrad
		 * 
		 */
		HochFahrrad.getFabrik().fahrradProduzieren("mtbStandard", 50);
		HochFahrrad.getFabrik().fahrradProduzieren("trekkingradStandard", 50);
		HochFahrrad.getFabrik().fahrradProduzieren("rennradStandard", 50);
		Marktplatz.createVerkaufsposten(HochFahrrad, "mtbStandard", "Mountainbike Standard", 150, 1135);
		Marktplatz.createVerkaufsposten(HochFahrrad, "trekkingradStandard", "Trekkingrad Standard", 150, 880);
		Marktplatz.createVerkaufsposten(HochFahrrad, "rennradStandard", "Rennrad Standard", 150, 1595);	
		Planspiel.zugBeenden();
		/* RUNDE 3:
		 * ZUG: ZukunftsFahrrad
		 */
		ZukunftsFahrrad.getFabrik().fahrradProduzieren("mtbPremium", 100);
		ZukunftsFahrrad.getFabrik().fahrradProduzieren("trekkingradbPremium", 100);
		ZukunftsFahrrad.getFabrik().fahrradProduzieren("rennradPremium", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "mtbRahmen", 100); 
		ZukunftsFahrrad.createBestellung("anbieter1", "mtbLenker", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "mtbPedal", 200);
		ZukunftsFahrrad.createBestellung("anbieter1", "mtbRadPremium", 200);
		ZukunftsFahrrad.createBestellung("anbieter1", "mtbSattelPremium", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "triggerSchaltung", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "scheibenbremsen", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "kette", 100);
		//Bestellt Fahrradteile Trekkingrad Premium:
		ZukunftsFahrrad.createBestellung("anbieter1", "trekkingRahmen", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "trekkingLenker", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "trekkingPedal", 200);
		ZukunftsFahrrad.createBestellung("anbieter1", "trekkingRadPremium", 200);
		ZukunftsFahrrad.createBestellung("anbieter1", "trekkingSattelPremium", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "triggerSchaltung", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "scheibenbremsen", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "kette", 100);
		//Bestellt Fahrradteile Rennrad Premium:
		ZukunftsFahrrad.createBestellung("anbieter1", "rennradRahmen", 100); 
		ZukunftsFahrrad.createBestellung("anbieter1", "rennradLenker", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "rennradPedal", 200);
		ZukunftsFahrrad.createBestellung("anbieter1", "rennradRadPremium", 200);
		ZukunftsFahrrad.createBestellung("anbieter1", "rennradSattelPremium", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "triggerSchaltung", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "felgenbremsen", 100);
		ZukunftsFahrrad.createBestellung("anbieter1", "kette", 100);
		Planspiel.zugBeenden();
		/* RUNDE 3:
		 * ZUG: FreiRad
		 */
		Planspiel.zugBeenden();
		/* RUNDE 4:
		 * Nach 3 Runden wird die Nachfrage neu gerechnet. Entsprechen muss die Marktforschung neu betrieben werden.
		 * ZUG: HochFahrrad
		 * 
		 */

		Marktplatz.createVerkaufsposten(HochFahrrad, "mtbStandard", "Mountainbike Standard", 50, 1135);
		Marktplatz.createVerkaufsposten(HochFahrrad, "trekkingradStandard", "Trekkingrad Standard", 50, 880);
		Marktplatz.createVerkaufsposten(HochFahrrad, "rennradStandard", "Rennrad Standard", 50, 1595);
		HochFahrrad.getEntwicklung().marktErforschen("trekkingradStandard");
		HochFahrrad.getEntwicklung().marktErforschen("rennradStandard");
		HochFahrrad.getEntwicklung().marktErforschen("mtbStandard");
		Planspiel.zugBeenden();
		
		/*RUNDE 4:
		 * ZUG: ZukunftsFahrrad
		 */
		ZukunftsFahrrad.getFabrik().fahrradProduzieren("mtbPremium", 100);
		ZukunftsFahrrad.getFabrik().fahrradProduzieren("trekkingradbPremium", 100);
		ZukunftsFahrrad.getFabrik().fahrradProduzieren("rennradPremium", 100);
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "mtbPremium", "Mountainbike Premium", 100, 1500);
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "trekkingradPremium", "Trekkingrad Premium", 100, 1200);
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "rennradPremium", "Rennrad Premium", 100, 2000);
		Planspiel.zugBeenden();
		/*RUNDE 4:
		 * ZUG: FreiRad
		 */
		FreiRad.getFabrik().fahrradProduzieren("mtbStandard", 250);
		FreiRad.getFabrik().fahrradProduzieren("trekkingradStandard", 250);
		FreiRad.getFabrik().fahrradProduzieren("rennradStandard", 250);
		Planspiel.zugBeenden();
		/*RUNDE 5:
		 * ZUG: HochFahrrad
		 */
		HochFahrrad.getVersicherung().setBrandschutz(false);
		Planspiel.zugBeenden();
		/*RUNDE 5:
		 * ZUG: ZukunftsFahrrad
		 */
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "mtbPremium", "Mountainbike Premium", 100, 1500);
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "trekkingradPremium", "Trekkingrad Premium", 100, 1200);
		Marktplatz.createVerkaufsposten(ZukunftsFahrrad, "rennradPremium", "Rennrad Premium", 100, 2000);
		Planspiel.zugBeenden();
		/*RUNDE 5:
		 * ZUG: FreiRad
		 */
		Marktplatz.createVerkaufsposten(FreiRad, "mtbStandard", "Mountainbike Standard", 250, 1135);
		Marktplatz.createVerkaufsposten(FreiRad, "trekkingradStandard", "Trekkingrad Standard", 250, 880);
		Marktplatz.createVerkaufsposten(FreiRad, "rennradStandard", "Rennrad Standard", 250, 1595);
		Planspiel.zugBeenden();
		/*
		 * RUNDE 6: GEWINNER ERMTTELN:
		 */
		String gewinner="noch niemand";
		if(HochFahrrad.getEigenkapital()>ZukunftsFahrrad.getEigenkapital()&&HochFahrrad.getEigenkapital()>FreiRad.getEigenkapital()){
			gewinner="HochFahrrad";
		}
		if(FreiRad.getEigenkapital()>HochFahrrad.getEigenkapital()&&FreiRad.getEigenkapital()>ZukunftsFahrrad.getEigenkapital()){
			gewinner="FreiRad";
		}
		if(ZukunftsFahrrad.getEigenkapital()>HochFahrrad.getEigenkapital()&&ZukunftsFahrrad.getEigenkapital()>FreiRad.getEigenkapital()){
			gewinner="ZukunftsFahrrad";
		}
		assertEquals("FreiRad",gewinner);
	}
}


