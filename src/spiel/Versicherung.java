package spiel;

/**
 * Jeder Spieler kann sich gegen Zufallsereignisse versichern. 
 * Ist ein Spieler versichert während ein Zufallsereignis eintritt, übernimmt die Versicherung den Schaden und der Spieler bekommt davon nichts mit.
 */
public class Versicherung {
	
	private boolean brandschutz = false;
	private boolean reparaturVertrag = false;
	private boolean rechtsschutzVersicherung = false;
	
	public boolean isBrandschutz(){
		return brandschutz;
	}
	public boolean isReparaturVertrag() {
		return reparaturVertrag;
	}
	public boolean isRechtsschutzVersicherung() {
		return rechtsschutzVersicherung;
	}
	public void setBrandschutz(boolean brandschutz){
		this.brandschutz = brandschutz;
	}
	public void setReparaturVertrag(boolean reparaturVertrag) {
		this.reparaturVertrag = reparaturVertrag;
	}
	public void setRechtsschutzVersicherung(boolean rechtsschutzVersicherung) {
		this.rechtsschutzVersicherung = rechtsschutzVersicherung;
	}


	/** Zu Beginn jeden Zugs werden die Gebühren für die genommenen Versicherungen berechnet. **/
	public void gebuehrBerechnen(){
		if (isBrandschutz()) {
			// vom Kontostand abziehen
			Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(Planspiel.getStartBrandschutzPreis());
			
			// auch im Cashflow als zahlungswirksame Aufwendung vermerken
			Planspiel.getAktuellesUnternehmen().getCashflow().setVersicherungen(Planspiel.getAktuellesUnternehmen().getCashflow().getVersicherungen() + Planspiel.getStartBrandschutzPreis());
		}
		if (isReparaturVertrag()) {
			// vom Kontostand abziehen
			Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(Planspiel.getStartReparaturVertragPreis());
			
			// auch im Cashflow als zahlungswirksame Aufwendung vermerken
			Planspiel.getAktuellesUnternehmen().getCashflow().setVersicherungen(Planspiel.getAktuellesUnternehmen().getCashflow().getVersicherungen() + Planspiel.getStartReparaturVertragPreis());
		}
		if (isRechtsschutzVersicherung()) {
			// vom Kontostand abziehen
			Planspiel.getAktuellesUnternehmen().getBank().kontostandVerringern(Planspiel.getStartRechtsschutzVersicherungPreis());
			
			// auch im Cashflow als zahlungswirksame Aufwendung vermerken
			Planspiel.getAktuellesUnternehmen().getCashflow().setVersicherungen(Planspiel.getAktuellesUnternehmen().getCashflow().getVersicherungen() + Planspiel.getStartRechtsschutzVersicherungPreis());
		}
	}
}
