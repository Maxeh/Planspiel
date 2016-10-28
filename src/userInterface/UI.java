package userInterface;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYDataset;

import spiel.Bestellung;
import spiel.Kredit;
import spiel.Markt;
import spiel.Marktplatz;
import spiel.Planspiel;
import spiel.Unternehmen;
import spiel.Verkaufsposten;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class UI {
	
	private static JFrame frame;
	private static JPanel panelStartseite;
	private static JPanel panelMarktplatz;
	private static JPanel panelEntwicklungUndBank;
	private static JPanel panelDiagramm;
	private static JLabel labelSpielername;
	private static JLabel labelKontostandWert;
	private static JLabel labelMitarbeiterWert;
	private static JLabel labelGehaelterWert;
	private static JLabel labelWeitereFixKostenWert;
	private static JLabel labelLagerKapazitaet;
	private static JLabel labelBelegteLagerKapazitaetWert;
	private static JLabel labelProduktionskapazitaetWert;
	private static JLabel labelProduktionsKapazitaetProMachineWert;
	private static JLabel labelAnzahlMaschinenWert;
	private static JLabel labelVerbleibendeProduktionskapazitaetWert;
	private static JLabel labelMaterialGewaehlt;
	private static JTable tableLager;
	private static JTable tableKrediteUebersicht;
	private static JTable tableEinkaufen;
	private static JTable tableAnbieter1;
	private static JTable tableAnbieter2;
	private static JTable tableAnbieter3;
	private static JTable tableBestellungen;
	private static DefaultTableModel tableBestellungenModel;
	private static JTextField textAnzahlAnbieter1;
	private static JTextField textAnzahlAnbieter2;
	private static JTextField textAnzahlAnbieter3;
	private static JTable tableVerkaufen;
	private static JTextField textAnzahl;
	private static JTextField textPreis;
	private static JTable tableMarktplatz;
	private static DefaultTableModel tableMarktplatzModel;
	private static JTextField textNeuerPreis;
	private static JTextField textNeueAnzahl;
	private static JTable tableKredit1;
	private static JTable tableKredit2;
	private static DefaultTableModel tableLaufendeKrediteModel;
	private static JTable tableLaufendeKredite;
	private static JTextField textAnzahlF1;
	private static JTextField textAnzahlF2;
	private static JTextField textAnzahlF3;
	private static JTextField textAnzahlF4;
	private static JTextField textAnzahlF5;
	private static JTextField textAnzahlF6;
	private static JButton btnProduzierenF2;
	private static JButton btnProduzierenF4;
	private static JButton btnProduzierenF6;
	private static JButton buttonUpgradeDurchfuehren;
	private static JButton buttonPatentMtbPrem;
	private static JButton buttonPatentTrekkingPrem;
	private static JButton buttonPatentRennradPrem;
	private static JButton buttonMtbStandardErforschen;
	private static JButton buttonMtbPremiumErforschen;
	private static JButton buttonTrekkingradStandardErforschen;
	private static JButton buttonTrekkingradPremiumErforschen;
	private static JButton buttonRennradStandardErforschen;
	private static JButton buttonRennradPremiumErforschen;
	private static JButton buttonKredit1Nehmen;
	private static JButton buttonKredit2Nehmen;
	private static JPanel panelMarktforschung;
	private static JLabel labelKreditwuerdig;
	private static JCheckBox checkboxBrandschutz;
	private static JCheckBox checkboxReparaturvertrag;
	private static JCheckBox checkboxRechtsschutz;
	private static DefaultTableModel tableEinkaufenModel;
	private static JComboBox<String> comboboxFahrradAuswaehlen;

	public static String getMaterialNameAusLager(int index){
		return tableLager.getValueAt(index, 0).toString();
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void createUI() {
		frame = new JFrame();   
		frame.setTitle("Planspiel - Fahrrad Verkauf");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1233, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Fenster zentrieren
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 0, 1260, 588);
		frame.getContentPane().add(tabbedPane);	

		/**********************************************/
		/**************** STARTSEITE  *****************/
		/**********************************************/
		
		panelStartseite = new JPanel();
		tabbedPane.addTab("Startseite", null, panelStartseite, null);
		panelStartseite.setLayout(null);
		
		JPanel panelInfos = new JPanel();
		panelInfos.setBackground(SystemColor.controlHighlight);
		panelInfos.setBounds(10, 11, 247, 86);
		panelInfos.setLayout(null);
		panelStartseite.add(panelInfos);	
		
					  
					   labelSpielername = new JLabel("Spieler (Runde)");
					   labelSpielername.setBounds(10, 5, 266, 22);
					   labelSpielername.setFont(new Font("Tahoma", Font.BOLD, 16));
					   panelInfos.add(labelSpielername);
					   
					   JLabel labelKontostand = new JLabel("Kontostand");
					   labelKontostand.setFont(new Font("Tahoma", Font.PLAIN, 14));
					   labelKontostand.setBounds(10, 37, 105, 17);
					   panelInfos.add(labelKontostand);
					   
					   labelKontostandWert = new JLabel();
					   labelKontostandWert.setText(Planspiel.getStartKontostand()  + " €"); 
					   labelKontostandWert.setHorizontalAlignment(SwingConstants.RIGHT);
					   labelKontostandWert.setBounds(125, 38, 112, 17);
					   labelKontostandWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
					   panelInfos.add(labelKontostandWert);
					   
					   JLabel labelMitarbeiter = new JLabel("Mitarbeiter");
					   labelMitarbeiter.setFont(new Font("Tahoma", Font.PLAIN, 14));
					   labelMitarbeiter.setBounds(10, 60, 70, 17);
					   panelInfos.add(labelMitarbeiter);
					   
					   labelMitarbeiterWert = new JLabel(String.valueOf(Planspiel.getStartMitarbeiterAnzahl()));
					   labelMitarbeiterWert.setHorizontalAlignment(SwingConstants.RIGHT);
					   labelMitarbeiterWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
					   labelMitarbeiterWert.setBounds(167, 61, 70, 17);
					   panelInfos.add(labelMitarbeiterWert);
					   
					   					   
         JPanel panelKosten = new JPanel();
		 panelKosten.setBackground(SystemColor.controlHighlight);
		 panelKosten.setBounds(10, 103, 247, 86);
		 panelStartseite.add(panelKosten);
		 panelKosten.setLayout(null);
		 			   
					   		   
		 			   JLabel labelGehaelter = new JLabel("Geh\u00E4lter / L\u00F6hne");
					   labelGehaelter.setFont(new Font("Tahoma", Font.PLAIN, 14));
					   labelGehaelter.setBounds(10, 37, 109, 17);
					   panelKosten.add(labelGehaelter);
					   		   
					   labelGehaelterWert = new JLabel();
					   labelGehaelterWert.setText(Planspiel.getStartMitarbeiterAnzahl() * Planspiel.getStartGehaltMitarbeiter() + " €");
					   labelGehaelterWert.setHorizontalAlignment(SwingConstants.RIGHT);
					   labelGehaelterWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
					   labelGehaelterWert.setBounds(167, 36, 70, 17);
					   panelKosten.add(labelGehaelterWert);
					   
					   JLabel labelWeitereFixKosten = new JLabel("Weitere Fixkosten");
					   labelWeitereFixKosten.setFont(new Font("Tahoma", Font.PLAIN, 14));
					   labelWeitereFixKosten.setBounds(10, 60, 136, 17);
					   panelKosten.add(labelWeitereFixKosten);
					   		   
					   labelWeitereFixKostenWert = new JLabel("???");
					   labelWeitereFixKostenWert.setHorizontalAlignment(SwingConstants.RIGHT);
					   labelWeitereFixKostenWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
					   labelWeitereFixKostenWert.setBounds(167, 60, 70, 17);
					   panelKosten.add(labelWeitereFixKostenWert);
					   		   
					   JLabel labelKosten = new JLabel("Laufende Kosten");
					   labelKosten.setBounds(10, 5, 147, 20);
					   labelKosten.setFont(new Font("Tahoma", Font.BOLD, 16));
					   panelKosten.add(labelKosten);
					   		   		
					   
		JPanel panelLager = new JPanel();
		panelLager.setBackground(SystemColor.controlHighlight);
		panelLager.setBounds(10, 195, 247, 355);
		panelStartseite.add(panelLager);
					   panelLager.setLayout(null);
					   		   
					   JLabel labelLager = new JLabel("Lager");
					   labelLager.setBounds(10, 5, 184, 20);
					   labelLager.setFont(new Font("Tahoma", Font.BOLD, 16));
					   panelLager.add(labelLager);

					   labelLagerKapazitaet = new JLabel();
					   labelLagerKapazitaet.setText(String.valueOf(Planspiel.getStartLagerkapazitaet()));
					   labelLagerKapazitaet.setBounds(167, 8, 70, 17);
					   labelLagerKapazitaet.setHorizontalAlignment(SwingConstants.RIGHT);
					   labelLagerKapazitaet.setFont(new Font("Tahoma", Font.PLAIN, 14));
					   panelLager.add(labelLagerKapazitaet);
					   
					   JLabel labelBelegteLagerKapazitaet = new JLabel("Belegte Kapazit\u00E4t");
					   labelBelegteLagerKapazitaet.setFont(new Font("Tahoma", Font.PLAIN, 14));
					   labelBelegteLagerKapazitaet.setBounds(10, 33, 136, 17);
					   panelLager.add(labelBelegteLagerKapazitaet);
					   
					   labelBelegteLagerKapazitaetWert = new JLabel("???");
					   labelBelegteLagerKapazitaetWert.setHorizontalAlignment(SwingConstants.RIGHT);
					   labelBelegteLagerKapazitaetWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
					   labelBelegteLagerKapazitaetWert.setBounds(188, 33, 49, 17);
					   panelLager.add(labelBelegteLagerKapazitaetWert);
					   
					   JScrollPane scrollPane = new JScrollPane();
					   scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					   scrollPane.setBounds(10, 61, 227, 283);
					   panelLager.add(scrollPane);
					   
					   tableLager = new JTable();
					   scrollPane.setViewportView(tableLager);
					   tableLager.setEnabled(false);
					   tableLager.setRowSelectionAllowed(false);
					   int fahrradPlatzbedarf = Planspiel.getStartFahrradPlatzbedarf();
					   int[] materialPlatzbedarf = Planspiel.getStartMaterialPlatzbedarf();
					   tableLager.setModel(new DefaultTableModel(
					   	new Object[][] {
					   		{"Mountainbike St.", null, fahrradPlatzbedarf},
					   		{"Mountainbike Pr.", null, fahrradPlatzbedarf},
					   		{"Trekkingrad St.", null, fahrradPlatzbedarf},
					   		{"Trekkingrad Pr.", null, fahrradPlatzbedarf},
					   		{"Rennrad St.", null, fahrradPlatzbedarf},
					   		{"Rennrad Pr.", null, fahrradPlatzbedarf},
					   		{"Mountainbike Rahmen", null, materialPlatzbedarf[0]},
					   		{"Trekkingrad Rahmen", null, materialPlatzbedarf[0]},
					   		{"Rennrad Rahmen", null, materialPlatzbedarf[0]},
					   		{"Mountainbike Lenker", null, materialPlatzbedarf[1]},
					   		{"Trekkingrad Lenker", null, materialPlatzbedarf[1]},
					   		{"Rennrad Lenker", null, materialPlatzbedarf[1]},
					   		{"Mountainbike Pedal", null, materialPlatzbedarf[2]},
					   		{"Trekkingrad Pedal", null, materialPlatzbedarf[2]},
					   		{"Rennrad Pedal", null, materialPlatzbedarf[2]},
					   		{"Mountainbike Rad St.", null, materialPlatzbedarf[3]},
					 		{"Mountainbike Rad Pr.", null, materialPlatzbedarf[3]},
					   		{"Trekkingrad Rad St.", null, materialPlatzbedarf[3]},
					   		{"Trekkingrad Rad Pr.", null, materialPlatzbedarf[3]},
					   		{"Rennrad Rad St.", null, materialPlatzbedarf[3]},
					   		{"Rennrad Rad Pr.", null, materialPlatzbedarf[3]},
					   		{"Mountainbike Sattel St.", null, materialPlatzbedarf[4]},
					   		{"Mountainbike Sattel Pr.", null, materialPlatzbedarf[4]},
					   		{"Trekkingrad Sattel St.", null, materialPlatzbedarf[4]},
					   		{"Trekkingrad Sattel Pr.", null, materialPlatzbedarf[4]},
					   		{"Rennrad Sattel St.", null, materialPlatzbedarf[4]},
					   		{"Rennrad Sattel Pr.", null, materialPlatzbedarf[4]},
					   		{"Felgenbremsen", null, materialPlatzbedarf[5]},
					   		{"Scheibenbremsen", null, materialPlatzbedarf[5]},
					   		{"Drehgriffschaltung", null, materialPlatzbedarf[6]},
					   		{"Triggerschaltung", null, materialPlatzbedarf[6]},
					   		{"Kette", null, materialPlatzbedarf[7]},
					   	},
					   	new String[] {
					   		"Inhalt", "Stk.", "Platz"
					   	}
					   ) {
						private static final long serialVersionUID = 1L;
						@SuppressWarnings("rawtypes")
						Class[] columnTypes = new Class[] {
					   		String.class, Integer.class, Integer.class
					   	};
					   	@SuppressWarnings({ "unchecked", "rawtypes" })
						public Class getColumnClass(int columnIndex) {
					   		return columnTypes[columnIndex];
					   	}
					   });
					   tableLager.getColumnModel().getColumn(0).setPreferredWidth(110);
					   tableLager.getColumnModel().getColumn(1).setPreferredWidth(25);
					   tableLager.getColumnModel().getColumn(2).setPreferredWidth(15);
					   		   	
					   		   					   
					   				   
					   
		 panelDiagramm = new JPanel();
		 panelDiagramm.setBackground(SystemColor.controlHighlight);
		 panelDiagramm.setBounds(264, 11, 496, 412);
		 panelStartseite.add(panelDiagramm);
		 panelDiagramm.setLayout(null);
		 			   		   					   
		 				// Diagramm wird in der Funktion showDiagram() erstellt
					   
		  
		  
		 JPanel panelBankgeschaefte = new JPanel();
		 panelBankgeschaefte.setBounds(264, 429, 285, 121);
		 panelStartseite.add(panelBankgeschaefte);
		 panelBankgeschaefte.setBackground(SystemColor.controlHighlight);
		 panelBankgeschaefte.setLayout(null);
		  
					  JLabel labelBankgeschaefte = new JLabel("Kredite");
					  labelBankgeschaefte.setBounds(10, 11, 184, 20);
					  labelBankgeschaefte.setFont(new Font("Tahoma", Font.BOLD, 16));
					  panelBankgeschaefte.add(labelBankgeschaefte);		   
					  
					  tableKrediteUebersicht = new JTable();
					  tableKrediteUebersicht.setEnabled(false);
					  tableKrediteUebersicht.setModel(new DefaultTableModel(
					  	new Object[][] {
					  		{"Anzahl Kredite", new Integer(0)},
					  		{"Tilgung am Ende der Runde", new Integer(0)},
					  		{"Zinsen am Ende der Runde", new Integer(0)},
					  		{"Summe", new Integer(0)},
					  	},
					  	new String[] {
					  		"New column", "New column"
					  	}
					  ) {
						private static final long serialVersionUID = 1L;
						@SuppressWarnings("rawtypes")
						Class[] columnTypes = new Class[] {
					  		Object.class, Integer.class
					  	};
					  	@SuppressWarnings({ "unchecked", "rawtypes" })
						public Class getColumnClass(int columnIndex) {
					  		return columnTypes[columnIndex];
					  	}
					  });
					  tableKrediteUebersicht.getColumnModel().getColumn(0).setPreferredWidth(115);
					  tableKrediteUebersicht.getColumnModel().getColumn(1).setPreferredWidth(25);
					  tableKrediteUebersicht.setBounds(10, 46, 265, 64);
					  panelBankgeschaefte.add(tableKrediteUebersicht);
					  
					  
					  
 
						 
		  JPanel panelProduktionsKapazitaet = new JPanel();
	      panelProduktionsKapazitaet.setBackground(SystemColor.controlHighlight);
		  panelProduktionsKapazitaet.setBounds(766, 11, 454, 71);
		  panelStartseite.add(panelProduktionsKapazitaet);
		  panelProduktionsKapazitaet.setLayout(null);
		  
					  JLabel labelAnzahlMaschinen = new JLabel("Anzahl der Maschinen:");
					  labelAnzahlMaschinen.setFont(new Font("Tahoma", Font.PLAIN, 14));
					  labelAnzahlMaschinen.setBounds(10, 11, 144, 17);
					  panelProduktionsKapazitaet.add(labelAnzahlMaschinen);
					  
					  labelAnzahlMaschinenWert = new JLabel();
					  labelAnzahlMaschinenWert.setText(String.valueOf(Planspiel.getStartAnzahlMaschinen()));
					  labelAnzahlMaschinenWert.setHorizontalAlignment(SwingConstants.RIGHT);
					  labelAnzahlMaschinenWert.setFont(new Font("Tahoma", Font.BOLD, 13));
					  labelAnzahlMaschinenWert.setBounds(142, 11, 33, 17);
					  panelProduktionsKapazitaet.add(labelAnzahlMaschinenWert);
					  
					  JLabel labelProduktionsKapazitaetProMachine = new JLabel("Produktionskapazit\u00E4t / Maschine:");
					  labelProduktionsKapazitaetProMachine.setFont(new Font("Tahoma", Font.PLAIN, 14));
					  labelProduktionsKapazitaetProMachine.setBounds(196, 11, 213, 17);
					  panelProduktionsKapazitaet.add(labelProduktionsKapazitaetProMachine);
					  
					  labelProduktionsKapazitaetProMachineWert = new JLabel();
					  labelProduktionsKapazitaetProMachineWert.setText(String.valueOf(Planspiel.getStartProduktionsKapazitaetMaschine()));
					  labelProduktionsKapazitaetProMachineWert.setHorizontalAlignment(SwingConstants.RIGHT);
					  labelProduktionsKapazitaetProMachineWert.setFont(new Font("Tahoma", Font.BOLD, 13));
					  labelProduktionsKapazitaetProMachineWert.setBounds(417, 11, 27, 17);
					  panelProduktionsKapazitaet.add(labelProduktionsKapazitaetProMachineWert);
					  
					  JLabel labelProduktionskapazitaet = new JLabel("Produktionskapazit\u00E4t:");
					  labelProduktionskapazitaet.setFont(new Font("Tahoma", Font.PLAIN, 14));
					  labelProduktionskapazitaet.setBounds(10, 39, 144, 17);
					  panelProduktionsKapazitaet.add(labelProduktionskapazitaet);
					  
					  labelProduktionskapazitaetWert = new JLabel();
					  labelProduktionskapazitaetWert.setText(String.valueOf(Planspiel.getStartProduktionsKapazitaetMaschine() * Planspiel.getStartAnzahlMaschinen()));
					  labelProduktionskapazitaetWert.setHorizontalAlignment(SwingConstants.RIGHT);
					  labelProduktionskapazitaetWert.setFont(new Font("Tahoma", Font.BOLD, 13));
					  labelProduktionskapazitaetWert.setBounds(142, 39, 33, 17);
					  panelProduktionsKapazitaet.add(labelProduktionskapazitaetWert);
					  
					  JLabel labelVerbleibendeProduktionskapazitaet = new JLabel("Verbleibende Produktionskapazit\u00E4t:");
					  labelVerbleibendeProduktionskapazitaet.setFont(new Font("Tahoma", Font.PLAIN, 14));
					  labelVerbleibendeProduktionskapazitaet.setBounds(196, 39, 213, 17);
					  panelProduktionsKapazitaet.add(labelVerbleibendeProduktionskapazitaet);
					  
					  labelVerbleibendeProduktionskapazitaetWert = new JLabel();
					  labelVerbleibendeProduktionskapazitaetWert.setText(String.valueOf(Planspiel.getStartAnzahlMaschinen() * Planspiel.getStartProduktionsKapazitaetMaschine()));
					  labelVerbleibendeProduktionskapazitaetWert.setHorizontalAlignment(SwingConstants.RIGHT);
					  labelVerbleibendeProduktionskapazitaetWert.setFont(new Font("Tahoma", Font.BOLD, 13));
					  labelVerbleibendeProduktionskapazitaetWert.setBounds(417, 39, 27, 17);
					  panelProduktionsKapazitaet.add(labelVerbleibendeProduktionskapazitaetWert);

						 
		    
		  JPanel panelFahrrad1 = new JPanel();
		  panelFahrrad1.setBackground(SystemColor.controlHighlight);
		  panelFahrrad1.setBounds(766, 86, 225, 152);
		  panelStartseite.add(panelFahrrad1);
		  panelFahrrad1.setLayout(null);
		  
					   JLabel labelMountainbikeStd = new JLabel("Mountainbike Standard");
					   labelMountainbikeStd.setBounds(10, 5, 197, 20);
					   labelMountainbikeStd.setFont(new Font("Tahoma", Font.BOLD, 16));
					   panelFahrrad1.add(labelMountainbikeStd);
					   
					   JLabel labelFahrrad1Material1 = new JLabel("Mtb. Rahmen");
					   labelFahrrad1Material1.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad1Material1.setBounds(10, 35, 95, 20);
					   panelFahrrad1.add(labelFahrrad1Material1);
					   
					   JLabel labelFahrrad1Material2 = new JLabel("Mtb. Lenker");
					   labelFahrrad1Material2.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad1Material2.setBounds(10, 55, 95, 20);
					   panelFahrrad1.add(labelFahrrad1Material2);
					   
					   JLabel labelFahrrad1Material3 = new JLabel("Mtb. Pedal (2)");
					   labelFahrrad1Material3.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad1Material3.setBounds(10, 75, 95, 20);
					   panelFahrrad1.add(labelFahrrad1Material3);
					   
					   JLabel labelFahrrad1Material4 = new JLabel("Mtb. Rad St. (2)");
					   labelFahrrad1Material4.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad1Material4.setBounds(10, 95, 95, 20);
					   panelFahrrad1.add(labelFahrrad1Material4);
					   
					   JLabel labelFahrrad1Material5 = new JLabel("Mtb. Sattel St.");
					   labelFahrrad1Material5.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad1Material5.setBounds(115, 36, 92, 20);
					   panelFahrrad1.add(labelFahrrad1Material5);
					   
					   JLabel labelFahrrad1Material6 = new JLabel("Felgenbremsen");
					   labelFahrrad1Material6.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad1Material6.setBounds(115, 55, 92, 20);
					   panelFahrrad1.add(labelFahrrad1Material6);
					   
					   JLabel labelFahrrad1Material7 = new JLabel("Drehgriffschaltung");
					   labelFahrrad1Material7.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad1Material7.setBounds(115, 75, 110, 20);
					   panelFahrrad1.add(labelFahrrad1Material7);
					   
					   JLabel labelFahrrad1Material8 = new JLabel("Kette");
					   labelFahrrad1Material8.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad1Material8.setBounds(115, 95, 92, 20);
					   panelFahrrad1.add(labelFahrrad1Material8);
					   
					   textAnzahlF1 = new JTextField();
					   textAnzahlF1.setText("1");
					   textAnzahlF1.setBounds(10, 122, 51, 22);
					   panelFahrrad1.add(textAnzahlF1);
					   textAnzahlF1.setColumns(10);
					   
					   JButton btnProduzierenF1 = new JButton("Produzieren");
					   btnProduzierenF1.addActionListener(new ActionListener() {
					   	public void actionPerformed(ActionEvent arg0) {
					   		try {
					   			int anzahl = Integer.parseInt(textAnzahlF1.getText());
					   			
					   			if (anzahl <= 0) {
									JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Anzahl ein.");
									return;
								}
					   			
					   			if (Planspiel.getAktuellesUnternehmen().getFabrik().fahrradProduzieren("mtbStandard", anzahl))
					   				UI.updateUI();
					   			else JOptionPane.showMessageDialog(null, "Fahrräder können nicht produziert werden. \nSie haben entweder zu wenig Materialien oder die Produktion ist ausgelastet.");
					   		}
					   		catch (NumberFormatException e){
					   			JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Zahl ein.");		
					   		}
					   		textAnzahlF1.setText("1");
					   	}
					   });
					   btnProduzierenF1.setBounds(71, 121, 144, 23);
					   panelFahrrad1.add(btnProduzierenF1);
					   
		   
		  JPanel panelFahrrad2 = new JPanel();
		  panelFahrrad2.setLayout(null);
		  panelFahrrad2.setBackground(SystemColor.controlHighlight);
		  panelFahrrad2.setBounds(995, 86, 225, 152);
		  panelStartseite.add(panelFahrrad2);
		  
					   JLabel labelMountainbikePrem = new JLabel("Mountainbike Premium");
					   labelMountainbikePrem.setBounds(10, 5, 197, 20);
					   labelMountainbikePrem.setFont(new Font("Tahoma", Font.BOLD, 16));
					   panelFahrrad2.add(labelMountainbikePrem);
					   
					   JLabel labelFahrrad2Material1 = new JLabel("Mtb. Rahmen");
					   labelFahrrad2Material1.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad2Material1.setBounds(10, 35, 95, 20);
					   panelFahrrad2.add(labelFahrrad2Material1);
					   
					   JLabel labelFahrrad2Material2 = new JLabel("Mtb. Lenker");
					   labelFahrrad2Material2.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad2Material2.setBounds(10, 55, 95, 20);
					   panelFahrrad2.add(labelFahrrad2Material2);
					   
					   JLabel labelFahrrad2Material3 = new JLabel("Mtb. Pedal (2)");
					   labelFahrrad2Material3.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad2Material3.setBounds(10, 75, 95, 20);
					   panelFahrrad2.add(labelFahrrad2Material3);
					   
					   JLabel labelFahrrad2Material4 = new JLabel("Mtb. Rad Pr. (2)");
					   labelFahrrad2Material4.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad2Material4.setBounds(10, 95, 95, 20);
					   panelFahrrad2.add(labelFahrrad2Material4);
					   
					   JLabel labelFahrrad2Material5 = new JLabel("Mtb. Sattel Pr.");
					   labelFahrrad2Material5.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad2Material5.setBounds(115, 36, 110, 20);
					   panelFahrrad2.add(labelFahrrad2Material5);
					   
					   JLabel labelFahrrad2Material6 = new JLabel("Scheibenbremsen");
					   labelFahrrad2Material6.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad2Material6.setBounds(115, 55, 110, 20);
					   panelFahrrad2.add(labelFahrrad2Material6);
					   
					   JLabel labelFahrrad2Material7 = new JLabel("Triggerschaltung");
					   labelFahrrad2Material7.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad2Material7.setBounds(115, 75, 92, 20);
					   panelFahrrad2.add(labelFahrrad2Material7);
					   
					   JLabel labelFahrrad2Material8 = new JLabel("Kette");
					   labelFahrrad2Material8.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad2Material8.setBounds(115, 95, 92, 20);
					   panelFahrrad2.add(labelFahrrad2Material8);
					   
					   textAnzahlF2 = new JTextField();
					   textAnzahlF2.setEnabled(false);
					   textAnzahlF2.setText("1");
					   textAnzahlF2.setBounds(10, 122, 51, 20);
					   panelFahrrad2.add(textAnzahlF2);
					   textAnzahlF2.setColumns(10);
					   
					   btnProduzierenF2 = new JButton("Produzieren");
					   btnProduzierenF2.setEnabled(false);
					   btnProduzierenF2.addActionListener(new ActionListener() {
					   	public void actionPerformed(ActionEvent arg0) {
					   		try {
					   			int anzahl = Integer.parseInt(textAnzahlF2.getText());
					   			
					   			if (anzahl <= 0) {
									JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Anzahl ein.");
									return;
								}
					   			
					   			if (Planspiel.getAktuellesUnternehmen().getFabrik().fahrradProduzieren("mtbPremium", anzahl))
					   				UI.updateUI();
					   			else JOptionPane.showMessageDialog(null, "Fahrräder können nicht produziert werden. \nSie haben entweder zu wenig Materialien oder die Produktion ist ausgelastet.");
					   		}
					   		catch (NumberFormatException e){
					   			JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Zahl ein.");		
					   		}
					   		textAnzahlF2.setText("1");
					   	}
					   });
					   btnProduzierenF2.setBounds(71, 121, 144, 23);
					   panelFahrrad2.add(btnProduzierenF2);
					   
					   
		  JPanel panelFahrrad3 = new JPanel();
		  panelFahrrad3.setLayout(null);
		  panelFahrrad3.setBackground(SystemColor.controlHighlight);
		  panelFahrrad3.setBounds(766, 241, 225, 152);
		  panelStartseite.add(panelFahrrad3); 
		  
					   JLabel labelTrekkingradStd = new JLabel("Trekkingrad Standard");
					   labelTrekkingradStd.setBounds(10, 5, 197, 20);
					   labelTrekkingradStd.setFont(new Font("Tahoma", Font.BOLD, 16));
					   panelFahrrad3.add(labelTrekkingradStd);
					   
					   JLabel labelFahrrad3Material1 = new JLabel("Trek. Rahmen");
					   labelFahrrad3Material1.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad3Material1.setBounds(10, 36, 95, 20);
					   panelFahrrad3.add(labelFahrrad3Material1);
					   
					   JLabel labelFahrrad3Material2 = new JLabel("Trek. Lenker");
					   labelFahrrad3Material2.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad3Material2.setBounds(10, 56, 95, 20);
					   panelFahrrad3.add(labelFahrrad3Material2);
					   
					   JLabel labelFahrrad3Material3 = new JLabel("Trek. Pedal (2)");
					   labelFahrrad3Material3.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad3Material3.setBounds(10, 76, 95, 20);
					   panelFahrrad3.add(labelFahrrad3Material3);
					   
					   JLabel labelFahrrad3Material4 = new JLabel("Trek. Rad St. (2)");
					   labelFahrrad3Material4.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad3Material4.setBounds(10, 96, 95, 20);
					   panelFahrrad3.add(labelFahrrad3Material4);
					   
					   JLabel labelFahrrad3Material5 = new JLabel("Trek. Sattel St.");
					   labelFahrrad3Material5.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad3Material5.setBounds(115, 36, 110, 20);
					   panelFahrrad3.add(labelFahrrad3Material5);
					   
					   JLabel labelFahrrad3Material6 = new JLabel("Felgenbremsen");
					   labelFahrrad3Material6.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad3Material6.setBounds(115, 55, 92, 20);
					   panelFahrrad3.add(labelFahrrad3Material6);
					   
					   JLabel labelFahrrad3Material7 = new JLabel("Drehgriffschaltung");
					   labelFahrrad3Material7.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad3Material7.setBounds(115, 75, 110, 20);
					   panelFahrrad3.add(labelFahrrad3Material7);
					   
					   JLabel labelFahrrad3Material8 = new JLabel("Kette");
					   labelFahrrad3Material8.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad3Material8.setBounds(115, 95, 92, 20);
					   panelFahrrad3.add(labelFahrrad3Material8);
					   
					   textAnzahlF3 = new JTextField();
					   textAnzahlF3.setText("1");
					   textAnzahlF3.setBounds(10, 122, 51, 20);
					   panelFahrrad3.add(textAnzahlF3);
					   textAnzahlF3.setColumns(10);
					   
					   JButton btnProduzierenF3 = new JButton("Produzieren");
					   btnProduzierenF3.addActionListener(new ActionListener() {
					   	public void actionPerformed(ActionEvent arg0) {
					   		try {
					   			int anzahl = Integer.parseInt(textAnzahlF3.getText());
					   			
					   			if (anzahl <= 0) {
									JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Anzahl ein.");
									return;
								}
					   			
					   			if (Planspiel.getAktuellesUnternehmen().getFabrik().fahrradProduzieren("trekkingradStandard", anzahl))
					   				UI.updateUI();
					   			else JOptionPane.showMessageDialog(null, "Fahrräder können nicht produziert werden. \nSie haben entweder zu wenig Materialien oder die Produktion ist ausgelastet.");
					   		}
					   		catch (NumberFormatException e){
					   			JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Zahl ein.");		
					   		}
					   		textAnzahlF3.setText("1");
					   	}
					   });
					   btnProduzierenF3.setBounds(71, 121, 144, 23);
					   panelFahrrad3.add(btnProduzierenF3);
					   
					   
		  JPanel panelFahrrad4 = new JPanel();
		  panelFahrrad4.setLayout(null);
		  panelFahrrad4.setBackground(SystemColor.controlHighlight);
		  panelFahrrad4.setBounds(995, 241, 225, 152);
		 
		  panelStartseite.add(panelFahrrad4); 
		  
					  JLabel labelTrekkingradPrem = new JLabel("Trekkingrad Premium");
					  labelTrekkingradPrem.setBounds(10, 5, 197, 20);
					  labelTrekkingradPrem.setFont(new Font("Tahoma", Font.BOLD, 16));
					  panelFahrrad4.add(labelTrekkingradPrem);
					  
					  JLabel labelFahrrad4Material1 = new JLabel("Trek. Rahmen");
					  labelFahrrad4Material1.setFont(new Font("Tahoma", Font.PLAIN, 12));
					  labelFahrrad4Material1.setBounds(10, 35, 95, 20);
					  panelFahrrad4.add(labelFahrrad4Material1);
					  
					  JLabel labelFahrrad4Material2 = new JLabel("Trek. Lenker");
					  labelFahrrad4Material2.setFont(new Font("Tahoma", Font.PLAIN, 12));
					  labelFahrrad4Material2.setBounds(10, 55, 95, 20);
					  panelFahrrad4.add(labelFahrrad4Material2);
					  
					  JLabel labelFahrrad4Material3 = new JLabel("Trek. Pedal (2)");
					  labelFahrrad4Material3.setFont(new Font("Tahoma", Font.PLAIN, 12));
					  labelFahrrad4Material3.setBounds(10, 75, 95, 20);
					  panelFahrrad4.add(labelFahrrad4Material3);
					  
					  JLabel labelFahrrad4Material4 = new JLabel("Trek. Rad Pr. (2)");
					  labelFahrrad4Material4.setFont(new Font("Tahoma", Font.PLAIN, 12));
					  labelFahrrad4Material4.setBounds(10, 95, 95, 20);
					  panelFahrrad4.add(labelFahrrad4Material4);
					  
					  JLabel labelFahrrad4Material5 = new JLabel("Trek. Sattel Pr.");
					  labelFahrrad4Material5.setFont(new Font("Tahoma", Font.PLAIN, 12));
					  labelFahrrad4Material5.setBounds(115, 36, 110, 20);
					  panelFahrrad4.add(labelFahrrad4Material5);
					  
					  JLabel labelFahrrad4Material6 = new JLabel("Scheibenbremsen");
					  labelFahrrad4Material6.setFont(new Font("Tahoma", Font.PLAIN, 12));
					  labelFahrrad4Material6.setBounds(115, 55, 110, 20);
					  panelFahrrad4.add(labelFahrrad4Material6);
					  
					  JLabel labelFahrrad4Material7 = new JLabel("Triggerschaltung");
					  labelFahrrad4Material7.setFont(new Font("Tahoma", Font.PLAIN, 12));
					  labelFahrrad4Material7.setBounds(115, 75, 92, 20);
					  panelFahrrad4.add(labelFahrrad4Material7);
					  
					  JLabel labelFahrrad4Material8 = new JLabel("Kette");
					  labelFahrrad4Material8.setFont(new Font("Tahoma", Font.PLAIN, 12));
					  labelFahrrad4Material8.setBounds(115, 95, 92, 20);
					  panelFahrrad4.add(labelFahrrad4Material8);
					  
					  textAnzahlF4 = new JTextField();
					  textAnzahlF4.setEnabled(false);
					  textAnzahlF4.setText("1");
					  textAnzahlF4.setBounds(10, 122, 51, 20);
					  panelFahrrad4.add(textAnzahlF4);
					  textAnzahlF4.setColumns(10);
					  
					  btnProduzierenF4 = new JButton("Produzieren");
					  btnProduzierenF4.setEnabled(false);
					  btnProduzierenF4.addActionListener(new ActionListener() {
					  	public void actionPerformed(ActionEvent arg0) {
					   		try {
					   			int anzahl = Integer.parseInt(textAnzahlF4.getText());
					   			
					   			if (anzahl <= 0) {
									JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Anzahl ein.");
									return;
								}
					   			
					   			if (Planspiel.getAktuellesUnternehmen().getFabrik().fahrradProduzieren("trekkingradPremium", anzahl))
					   				UI.updateUI();
					   			else JOptionPane.showMessageDialog(null, "Fahrräder können nicht produziert werden. \nSie haben entweder zu wenig Materialien oder die Produktion ist ausgelastet.");	
					   		}
					   		catch (NumberFormatException e){
					   			JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Zahl ein.");		
					   		}
					   		textAnzahlF4.setText("1");
					   	}
					  });
					  btnProduzierenF4.setBounds(71, 121, 144, 23);
					  panelFahrrad4.add(btnProduzierenF4);
		  
		  
		   JPanel panelFahrrad5 = new JPanel();
		   panelFahrrad5.setLayout(null);
		   panelFahrrad5.setBackground(SystemColor.controlHighlight);
		   panelFahrrad5.setBounds(766, 396, 225, 152);
		   panelStartseite.add(panelFahrrad5); 
		   
					   JLabel labeklRennrad = new JLabel("Rennrad Standard");
					   labeklRennrad.setBounds(10, 5, 197, 20);
					   labeklRennrad.setFont(new Font("Tahoma", Font.BOLD, 16));
					   panelFahrrad5.add(labeklRennrad);
					   
					   JLabel labelFahrrad5Material1 = new JLabel("Renn. Rahmen");
					   labelFahrrad5Material1.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad5Material1.setBounds(10, 35, 95, 20);
					   panelFahrrad5.add(labelFahrrad5Material1);
					   
					   JLabel labelFahrrad5Material2 = new JLabel("Renn. Lenker");
					   labelFahrrad5Material2.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad5Material2.setBounds(10, 55, 95, 20);
					   panelFahrrad5.add(labelFahrrad5Material2);
					   
					   JLabel labelFahrrad5Material3 = new JLabel("Renn. Pedal (2)");
					   labelFahrrad5Material3.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad5Material3.setBounds(10, 75, 95, 20);
					   panelFahrrad5.add(labelFahrrad5Material3);
					   
					   JLabel labelFahrrad5Material4 = new JLabel("Renn. Rad St. (2)");
					   labelFahrrad5Material4.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad5Material4.setBounds(10, 95, 110, 20);
					   panelFahrrad5.add(labelFahrrad5Material4);
					   
					   JLabel labelFahrrad5Material5 = new JLabel("Renn. Sattel Std.");
					   labelFahrrad5Material5.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad5Material5.setBounds(115, 36, 110, 20);
					   panelFahrrad5.add(labelFahrrad5Material5);
					   
					   JLabel labelFahrrad5Material6 = new JLabel("Felgenbremsen");
					   labelFahrrad5Material6.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad5Material6.setBounds(115, 55, 92, 20);
					   panelFahrrad5.add(labelFahrrad5Material6);
					   
					   JLabel labelFahrrad5Material7 = new JLabel("Triggerschaltung");
					   labelFahrrad5Material7.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad5Material7.setBounds(115, 75, 92, 20);
					   panelFahrrad5.add(labelFahrrad5Material7);
					   
					   JLabel labelFahrrad5Material8 = new JLabel("Kette");
					   labelFahrrad5Material8.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad5Material8.setBounds(115, 95, 92, 20);
					   panelFahrrad5.add(labelFahrrad5Material8);
					   
					   textAnzahlF5 = new JTextField();
					   textAnzahlF5.setText("1");
					   textAnzahlF5.setBounds(10, 122, 51, 20);
					   panelFahrrad5.add(textAnzahlF5);
					   textAnzahlF5.setColumns(10);
					   
					   JButton btnProduzierenF5 = new JButton("Produzieren");
					   btnProduzierenF5.addActionListener(new ActionListener() {
					   	public void actionPerformed(ActionEvent arg0) {
					   		try {
					   			int anzahl = Integer.parseInt(textAnzahlF5.getText());
					   			
					   			if (anzahl <= 0) {
									JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Anzahl ein.");
									return;
								}
					   			
					   			if (Planspiel.getAktuellesUnternehmen().getFabrik().fahrradProduzieren("rennradStandard", anzahl))
					   				UI.updateUI();
					   			else JOptionPane.showMessageDialog(null, "Fahrräder können nicht produziert werden. \nSie haben entweder zu wenig Materialien oder die Produktion ist ausgelastet.");
					   		}
					   		catch (NumberFormatException e){
					   			JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Zahl ein.");		
					   		}
					   		textAnzahlF5.setText("1");
					   	}
					   });
					   btnProduzierenF5.setBounds(71, 121, 144, 23);
					   panelFahrrad5.add(btnProduzierenF5);
					   
					   
		   JPanel panelFahrrad6 = new JPanel();
		   panelFahrrad6.setLayout(null);
		   panelFahrrad6.setBackground(SystemColor.controlHighlight);
		   panelFahrrad6.setBounds(995, 396, 225, 152);
		   panelStartseite.add(panelFahrrad6);
		   
					   JLabel labeklRennrad2 = new JLabel("Rennrad Premium");
					   labeklRennrad2.setBounds(10, 5, 197, 20);
					   labeklRennrad2.setFont(new Font("Tahoma", Font.BOLD, 16));
					   panelFahrrad6.add(labeklRennrad2);
					   
					   JLabel labelFahrrad6Material1 = new JLabel("Renn. Rahmen");
					   labelFahrrad6Material1.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad6Material1.setBounds(10, 35, 95, 20);
					   panelFahrrad6.add(labelFahrrad6Material1);
					   
					   JLabel labelFahrrad6Material2 = new JLabel("Renn. Lenker");
					   labelFahrrad6Material2.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad6Material2.setBounds(10, 55, 95, 20);
					   panelFahrrad6.add(labelFahrrad6Material2);
					   
					   JLabel labelFahrrad6Material3 = new JLabel("Renn. Pedal (2)");
					   labelFahrrad6Material3.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad6Material3.setBounds(10, 75, 95, 20);
					   panelFahrrad6.add(labelFahrrad6Material3);
					   
					   JLabel labelFahrrad6Material4 = new JLabel("Renn. Rad Pr. (2)");
					   labelFahrrad6Material4.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad6Material4.setBounds(10, 95, 110, 20);
					   panelFahrrad6.add(labelFahrrad6Material4);
					   
					   JLabel labelFahrrad6Material5 = new JLabel("Renn. Sattel Pr.");
					   labelFahrrad6Material5.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad6Material5.setBounds(115, 36, 110, 20);
					   panelFahrrad6.add(labelFahrrad6Material5);
					   
					   JLabel labelFahrrad6Material6 = new JLabel("Felgenbremsen");
					   labelFahrrad6Material6.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad6Material6.setBounds(115, 55, 92, 20);
					   panelFahrrad6.add(labelFahrrad6Material6);
					   
					   JLabel labelFahrrad6Material7 = new JLabel("Triggerschaltung");
					   labelFahrrad6Material7.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad6Material7.setBounds(115, 75, 92, 20);
					   panelFahrrad6.add(labelFahrrad6Material7);
					   
					   JLabel labelFahrrad6Material8 = new JLabel("Kette");
					   labelFahrrad6Material8.setFont(new Font("Tahoma", Font.PLAIN, 12));
					   labelFahrrad6Material8.setBounds(115, 95, 92, 20);
					   panelFahrrad6.add(labelFahrrad6Material8);
					   
					   textAnzahlF6 = new JTextField();
					   textAnzahlF6.setEnabled(false);
					   textAnzahlF6.setText("1");
					   textAnzahlF6.setBounds(10, 122, 51, 20);
					   panelFahrrad6.add(textAnzahlF6);
					   textAnzahlF6.setColumns(10);
					   
					   btnProduzierenF6 = new JButton("Produzieren");
					   btnProduzierenF6.setEnabled(false);
					   btnProduzierenF6.addActionListener(new ActionListener() {
					   	public void actionPerformed(ActionEvent arg0) {
					   		try {
					   			int anzahl = Integer.parseInt(textAnzahlF6.getText());
					   			
					   			if (anzahl <= 0) {
									JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Anzahl ein.");
									return;
								}
					   			
					   			if (Planspiel.getAktuellesUnternehmen().getFabrik().fahrradProduzieren("rennradPremium", anzahl))
					   				UI.updateUI();
					   			else JOptionPane.showMessageDialog(null, "Fahrräder können nicht produziert werden. \nSie haben entweder zu wenig Materialien oder die Produktion ist ausgelastet.");
					   		}
					   		catch (NumberFormatException e){
					   			JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Zahl ein.");		
					   		}
					   		textAnzahlF6.setText("1");
					   	}
					   });
					   btnProduzierenF6.setBounds(71, 121, 144, 23);
					   panelFahrrad6.add(btnProduzierenF6);

		 
		 JPanel panelButtons = new JPanel();
		 panelButtons.setBackground(SystemColor.controlHighlight);
		 panelButtons.setBounds(553, 429, 207, 121);
		 panelStartseite.add(panelButtons);
		 panelButtons.setLayout(null);
		 
 					  JButton buttonVermoegen = new JButton("EK / FK / Cashflow");
 					  buttonVermoegen.addActionListener(new ActionListener() {
 					  	public void actionPerformed(ActionEvent arg0) {
 					  		UICashflow.erstellen(frame);
 					  	}
 					  });
					  buttonVermoegen.setForeground(Color.DARK_GRAY);
					  buttonVermoegen.setBounds(10, 63, 187, 25);
					  panelButtons.add(buttonVermoegen);
					 
					  JButton buttonProduktionslisteAnzeigen = new JButton("Produktionsliste anzeigen");
					  buttonProduktionslisteAnzeigen.addActionListener(new ActionListener() {
					 	 public void actionPerformed(ActionEvent arg0) {
					 		 // neues Fenster mit Produktionsliste wird erzeugt
					 		 UIProduktionsliste.erstellen(frame);
					 	 }
					  });
					  buttonProduktionslisteAnzeigen.setForeground(Color.DARK_GRAY);
					  buttonProduktionslisteAnzeigen.setBounds(10, 5, 187, 25);
					  panelButtons.add(buttonProduktionslisteAnzeigen);
					 
					  JButton buttonVerkaufteFahrraeder = new JButton("Verkaufte Fahrr\u00E4der");
					  buttonVerkaufteFahrraeder.addActionListener(new ActionListener() {
					 	 public void actionPerformed(ActionEvent arg0) {
					 		 UIVerkauft.erstellen(frame);
					 	 }
					  });
					  buttonVerkaufteFahrraeder.setForeground(Color.DARK_GRAY);
					  buttonVerkaufteFahrraeder.setBounds(10, 34, 187, 25);
					  panelButtons.add(buttonVerkaufteFahrraeder);
					 
					  JButton buttonZugBeenden = new JButton("Zug beenden");
					  buttonZugBeenden.addActionListener(new ActionListener() {
					 	 public void actionPerformed(ActionEvent arg0) {
					 		  Planspiel.zugBeenden();
					 		  UI.resetInput(); // Eingabewerte zurücksetzen
					 	      UI.updateUI();
					 	      
					 	      // nach 24 Runden wird das Spiel beendet
					 	      if (Planspiel.getRundenNr()  == 24) 
					 	    	  spielBeenden();
					 	      
					 	      /** Es wird geprüft ob ein Zufallsereignis aufgetreten ist und wenn notwendig eine Meldung ausgegeben **/
					 	      int[] lagerBrand = Planspiel.getAktuellesUnternehmen().getLagerBrand();
					 	      int[] maschineDefekt = Planspiel.getAktuellesUnternehmen().getMaschineDefekt();
					 	      int[] rechtsstreit = Planspiel.getAktuellesUnternehmen().getRechtsstreit();
					 	      
					 	      if (lagerBrand[0] == 1)
					 	    	 JOptionPane.showMessageDialog(null, "Durch einen Brand im Lager wurden " + lagerBrand[1] + " Mal \"" + UI.getMaterialNameAusLager(lagerBrand[2]) + "\" verbrannt.");
					 	
					 	      if (maschineDefekt[0] == 1)
					 			 JOptionPane.showMessageDialog(null, "Reparaturkosten für eine Maschine: " + maschineDefekt[1] + "€.");
					 	      
					 	      if (rechtsstreit[0] == 1)
					 			 JOptionPane.showMessageDialog(null, "Kosten für einen Rechtsstreit: " + rechtsstreit[1] + "€.");
					 	 
					 	 }
					  });
					  buttonZugBeenden.setForeground(new Color(165, 42, 42));
					  buttonZugBeenden.setBounds(10, 92, 187, 25);
					  panelButtons.add(buttonZugBeenden);

		 
		 /**********************************************/
		 /**************** MARKTPLATZ ******************/
		 /**********************************************/
		 
		 
		 panelMarktplatz = new JPanel();
		 tabbedPane.addTab("Marktplatz", null, panelMarktplatz, null);
				panelMarktplatz.setLayout(null);
				
				/****************** EINKAUFEN *****************/
				JPanel panelEinkaufen = new JPanel();
				panelEinkaufen.setBackground(SystemColor.controlHighlight);
				panelEinkaufen.setBounds(10, 11, 687, 526);
				panelMarktplatz.add(panelEinkaufen);
				panelEinkaufen.setLayout(null);
				
				JLabel labelMarktplatzEinkaufen = new JLabel("Einkaufen");
				labelMarktplatzEinkaufen.setBounds(10, 11, 266, 22);
				labelMarktplatzEinkaufen.setFont(new Font("Tahoma", Font.BOLD, 16));
				panelEinkaufen.add(labelMarktplatzEinkaufen);
						

				tableEinkaufenModel = new DefaultTableModel(
					new Object[][] {
					   		{"Mountainbike Rahmen"},
					   		{"Trekkingrad Rahmen"},
					   		{"Rennrad Rahmen"},
					   		{"Mountainbike Lenker"},
					   		{"Trekkingrad Lenker"},
					   		{"Rennrad Lenker"},
					   		{"Mountainbike Pedal"},
					   		{"Trekkingrad Pedal"},
					   		{"Rennrad Pedal"},
					   		{"Mountainbike Rad St."},
					   		{"Mountainbike Rad Pr."},
					   		{"Trekkingrad Rad St."},
					   		{"Trekkingrad Rad Pr."},
					   		{"Rennrad Rad St."},
					   		{"Rennrad Rad Pr."},
					   		{"Mountainbike Sattel St."},
					   		{"Mountainbike Sattel Pr."},
					   		{"Trekkingrad Sattel St."},
					   		{"Trekkingrad Sattel Pr."},
					   		{"Rennrad Sattel St."},
					   		{"Rennrad Sattel Pr."},
					   		{"Felgenbremsen"},
					   		{"Scheibenbremsen"},
					   		{"Drehgriffschaltung"},
					   		{"Triggerschaltung"},
					   		{"Kette"},
					},
					new String[] {
						"New column"
					}
				){			   
					private static final long serialVersionUID = 1L;

					// Zellen sollen nicht editierbar sein
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				tableEinkaufen = new JTable();
				tableEinkaufen.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						updateUI();
					}
				});
				tableEinkaufen.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						updateUI();
					}
				});
				tableEinkaufen.setCellSelectionEnabled(true);
				tableEinkaufen.setBounds(10, 86, 187, 416);
				tableEinkaufen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableEinkaufen.setModel(tableEinkaufenModel);
				tableEinkaufen.changeSelection(0, 0, true, false); // erste Zeile markieren
				panelEinkaufen.add(tableEinkaufen);
				
				/** Combobox mit der nur das Material angezeigt werden kann, das für die einzelnen Fahrräder benötigt wird **/
				comboboxFahrradAuswaehlen = new JComboBox<String>();
				comboboxFahrradAuswaehlen.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent event) {
						if(event.getStateChange() == ItemEvent.SELECTED ) {
							
							// erste Zeile markieren
							if (tableEinkaufen.getSelectedRow() != 0)
								tableEinkaufen.changeSelection(0, 0, true, false); 
							
							int index = comboboxFahrradAuswaehlen.getSelectedIndex();
							switch (index){
								case 0: 
									tableEinkaufenModel.setRowCount(26);
									tableEinkaufen.setValueAt("Mountainbike Rahmen",0 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Rahmen",1 ,0);	
									tableEinkaufen.setValueAt("Rennrad Rahmen",2 ,0);
									tableEinkaufen.setValueAt("Mountainbike Lenker",3 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Lenker",4 ,0);
									tableEinkaufen.setValueAt("Rennrad Lenker",5 ,0);
									tableEinkaufen.setValueAt("Mountainbike Pedal",6 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Pedal",7 ,0);
									tableEinkaufen.setValueAt("Rennrad Pedal",8 ,0);
									tableEinkaufen.setValueAt("Mountainbike Rad St.",9 ,0);
									tableEinkaufen.setValueAt("Mountainbike Rad Pr.",10 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Rad St.",11 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Rad Pr.",12 ,0);
									tableEinkaufen.setValueAt("Rennrad Rad St.",13 ,0);
									tableEinkaufen.setValueAt("Rennrad Rad Pr.",14 ,0);
									tableEinkaufen.setValueAt("Mountainbike Sattel St.",15 ,0);
									tableEinkaufen.setValueAt("Mountainbike Sattel Pr.",16 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Sattel St.",17 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Sattel Pr.",18 ,0);
									tableEinkaufen.setValueAt("Rennrad Sattel St.",19 ,0);
									tableEinkaufen.setValueAt("Rennrad Sattel Pr.",20 ,0);
									tableEinkaufen.setValueAt("Felgenbremsen",21 ,0);
									tableEinkaufen.setValueAt("Scheibenbremsen",22 ,0);
									tableEinkaufen.setValueAt("Drehgriffschaltung",23 ,0);
									tableEinkaufen.setValueAt("Triggerschaltung",24 ,0);
									tableEinkaufen.setValueAt("Kette",25 ,0);
									break;
								case 1: 
									tableEinkaufenModel.setRowCount(8);
									tableEinkaufen.setValueAt("Mountainbike Rahmen",0 ,0);
									tableEinkaufen.setValueAt("Mountainbike Lenker",1 ,0);
									tableEinkaufen.setValueAt("Mountainbike Pedal",2 ,0);
									tableEinkaufen.setValueAt("Mountainbike Rad St.",3 ,0);
									tableEinkaufen.setValueAt("Mountainbike Sattel St.",4 ,0);
									tableEinkaufen.setValueAt("Felgenbremsen",5 ,0);
									tableEinkaufen.setValueAt("Drehgriffschaltung",6 ,0);
									tableEinkaufen.setValueAt("Kette",7 ,0);
									break;
								case 2: 
									tableEinkaufenModel.setRowCount(8);
									tableEinkaufen.setValueAt("Mountainbike Rahmen",0 ,0);
									tableEinkaufen.setValueAt("Mountainbike Lenker",1 ,0);
									tableEinkaufen.setValueAt("Mountainbike Pedal",2 ,0);
									tableEinkaufen.setValueAt("Mountainbike Rad Pr.",3 ,0);
									tableEinkaufen.setValueAt("Mountainbike Sattel Pr.",4 ,0);
									tableEinkaufen.setValueAt("Scheibenbremsen",5 ,0);
									tableEinkaufen.setValueAt("Triggerschaltung",6 ,0);
									tableEinkaufen.setValueAt("Kette",7 ,0);
									break;
								case 3: 
									tableEinkaufenModel.setRowCount(8);
									tableEinkaufen.setValueAt("Trekkingrad Rahmen",0 ,0);	
									tableEinkaufen.setValueAt("Trekkingrad Lenker",1 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Pedal",2 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Rad St.",3 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Sattel St.",4 ,0);
									tableEinkaufen.setValueAt("Felgenbremsen",5 ,0);
									tableEinkaufen.setValueAt("Drehgriffschaltung",6 ,0);
									tableEinkaufen.setValueAt("Kette",7 ,0);
									break;
								case 4: 
									tableEinkaufenModel.setRowCount(8);
									tableEinkaufen.setValueAt("Trekkingrad Rahmen",0 ,0);	
									tableEinkaufen.setValueAt("Trekkingrad Lenker",1 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Pedal",2 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Rad Pr.",3 ,0);
									tableEinkaufen.setValueAt("Trekkingrad Sattel Pr.",4 ,0);
									tableEinkaufen.setValueAt("Scheibenbremsen",5 ,0);
									tableEinkaufen.setValueAt("Triggerschaltung",6 ,0);
									tableEinkaufen.setValueAt("Kette",7 ,0);
									break;
								case 5: 
									tableEinkaufenModel.setRowCount(8);	
									tableEinkaufen.setValueAt("Rennrad Rahmen",0 ,0);
									tableEinkaufen.setValueAt("Rennrad Lenker",1 ,0);
									tableEinkaufen.setValueAt("Rennrad Pedal",2 ,0);
									tableEinkaufen.setValueAt("Rennrad Rad St.",3 ,0);
									tableEinkaufen.setValueAt("Rennrad Sattel St.",4 ,0);
									tableEinkaufen.setValueAt("Felgenbremsen",5 ,0);
									tableEinkaufen.setValueAt("Triggerschaltung",6 ,0);
									tableEinkaufen.setValueAt("Kette",7 ,0);
									break;
								case 6: 
									tableEinkaufenModel.setRowCount(8);	
									tableEinkaufen.setValueAt("Rennrad Rahmen",0 ,0);
									tableEinkaufen.setValueAt("Rennrad Lenker",1 ,0);
									tableEinkaufen.setValueAt("Rennrad Pedal",2 ,0);
									tableEinkaufen.setValueAt("Rennrad Rad Pr.",3 ,0);
									tableEinkaufen.setValueAt("Rennrad Sattel Pr.",4 ,0);
									tableEinkaufen.setValueAt("Felgenbremsen",5 ,0);
									tableEinkaufen.setValueAt("Triggerschaltung",6 ,0);
									tableEinkaufen.setValueAt("Kette",7 ,0);
									break;
							} // end switch
							
							updateUI();
							
					    } // end if
					} 
				}); 
				comboboxFahrradAuswaehlen.setModel(new DefaultComboBoxModel<String>(new String[] {"Alle anzeigen", "Mountainbike Standard", "Mountainbike Premium", "Trekkingrad Standard", "Trekkingrad Premium", "Rennrad Standard", "Rennrad Premium"}));
				comboboxFahrradAuswaehlen.setSelectedIndex(0);
				comboboxFahrradAuswaehlen.setBounds(10, 55, 188, 20);
				panelEinkaufen.add(comboboxFahrradAuswaehlen);
				
				
				labelMaterialGewaehlt = new JLabel("Material bestellen");
				labelMaterialGewaehlt.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelMaterialGewaehlt.setBounds(207, 86, 339, 17);
				panelEinkaufen.add(labelMaterialGewaehlt);

						
				/** ANBIETER 1 **/
				JLabel labelAnbieter1 = new JLabel("Anbieter 1");
				labelAnbieter1.setBounds(207, 128, 136, 17);
				labelAnbieter1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panelEinkaufen.add(labelAnbieter1);
				
				tableAnbieter1 = new JTable();
				tableAnbieter1.setEnabled(false);
				tableAnbieter1.setBounds(207, 160, 150, 47);
				tableAnbieter1.setModel(new DefaultTableModel(
					new Object[][] {
						{"Verf\u00FCgbar", null},
						{"Lieferzeit", null},
						{"Preis", null},
					},
					new String[] {
						"New column", "New column"
					}
				) {
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
						String.class, Object.class
					};
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				panelEinkaufen.add(tableAnbieter1);
				/* Werte die zu Beginn drin stehen */
				tableAnbieter1.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter1"), "mtbRahmen").getAnzahlVerfuegbar(), 0, 1);
				tableAnbieter1.setValueAt(Marktplatz.getAnbieter("anbieter1").getLieferzeit(), 1, 1);
				tableAnbieter1.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter1"), "mtbRahmen").getPreis(), 2, 1);
				
				JButton buttonAnbieter1Kaufen = new JButton("Bestellen");
				buttonAnbieter1Kaufen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							String bezeichnung = tableEinkaufen.getValueAt(tableEinkaufen.getSelectedRow(), 0).toString();
							String material = materialnameErmitteln(bezeichnung);
							int anzahl = Integer.parseInt(textAnzahlAnbieter1.getText());
							
							if (Planspiel.getAktuellesUnternehmen().createBestellung("anbieter1", material, anzahl))
								updateUI();
							else
								JOptionPane.showMessageDialog(null, "Die Bestellung konnte nicht aufgegeben werden. \nSie haben entweder nicht genug Geld"
										+ " oder es sind nicht genug Materialien verfügbar.");
						}
						catch (NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Zahl ein.");								
						}
					}
				});
				buttonAnbieter1Kaufen.setBounds(258, 218, 99, 21);
				panelEinkaufen.add(buttonAnbieter1Kaufen);
				
				textAnzahlAnbieter1 = new JTextField();
				textAnzahlAnbieter1.setHorizontalAlignment(SwingConstants.RIGHT);
				textAnzahlAnbieter1.setText("1");
				textAnzahlAnbieter1.setBounds(207, 218, 48, 20);
				panelEinkaufen.add(textAnzahlAnbieter1);
				textAnzahlAnbieter1.setColumns(10);
				
				/** ANBIETER 2 **/				
				JLabel labelAnbieter2 = new JLabel("Anbieter 2");
				labelAnbieter2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelAnbieter2.setBounds(367, 128, 136, 17);
				panelEinkaufen.add(labelAnbieter2);

				tableAnbieter2 = new JTable();
				tableAnbieter2.setEnabled(false);
				tableAnbieter2.setModel(new DefaultTableModel(
					new Object[][] {
						{"Vef\u00FCgbar", null},
						{"Lieferzeit", null},
						{"Preis", null},
					},
					new String[] {
						"New column", "New column"
					}
				) {
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
						String.class, Object.class
					};
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				tableAnbieter2.setBounds(367, 160, 150, 47);
				panelEinkaufen.add(tableAnbieter2);
				/* Werte die zu Beginn drin stehen */
				tableAnbieter2.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter2"), "mtbRahmen").getAnzahlVerfuegbar(), 0, 1);
				tableAnbieter2.setValueAt(Marktplatz.getAnbieter("anbieter2").getLieferzeit(), 1, 1);
				tableAnbieter2.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter2"), "mtbRahmen").getPreis(), 2, 1);
				
				JButton buttonAnbieter2Kaufen = new JButton("Bestellen");
				buttonAnbieter2Kaufen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							String bezeichnung = tableEinkaufen.getValueAt(tableEinkaufen.getSelectedRow(), 0).toString();
							String material = materialnameErmitteln(bezeichnung);
							int anzahl = Integer.parseInt(textAnzahlAnbieter2.getText());
							
							if (Planspiel.getAktuellesUnternehmen().createBestellung("anbieter2", material, anzahl))
								updateUI();
							else
								JOptionPane.showMessageDialog(null, "Die Bestellung konnte nicht aufgegeben werden. \nSie haben entweder nicht genug Geld"
										+ " oder es sind nicht genug Materialien verfügbar.");
						}
						catch (NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Zahl ein.");								
						}
					}
				});
				buttonAnbieter2Kaufen.setBounds(418, 218, 99, 21);
				panelEinkaufen.add(buttonAnbieter2Kaufen);
				
				textAnzahlAnbieter2 = new JTextField();
				textAnzahlAnbieter2.setHorizontalAlignment(SwingConstants.RIGHT);
				textAnzahlAnbieter2.setText("1");
				textAnzahlAnbieter2.setBounds(367, 218, 48, 20);
				panelEinkaufen.add(textAnzahlAnbieter2);
				textAnzahlAnbieter2.setColumns(10);
				
				/** ANBIETER 3 **/	
				JLabel labelAnbieter3 = new JLabel("Anbieter 3");
				labelAnbieter3.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelAnbieter3.setBounds(527, 128, 136, 17);
				panelEinkaufen.add(labelAnbieter3);
				
				tableAnbieter3 = new JTable();
				tableAnbieter3.setEnabled(false);
				tableAnbieter3.setModel(new DefaultTableModel(
					new Object[][] {
						{"Verf\u00FCgbar", null},
						{"Lieferzeit", null},
						{"Preis", null},
					},
					new String[] {
						"New column", "New column"
					}
				) {
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
						String.class, Object.class
					};
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				tableAnbieter3.setBounds(527, 160, 150, 47);
				panelEinkaufen.add(tableAnbieter3);
				/* Werte die zu Beginn drin stehen */
				tableAnbieter3.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter3"), "mtbRahmen").getAnzahlVerfuegbar(), 0, 1);
				tableAnbieter3.setValueAt(Marktplatz.getAnbieter("anbieter3").getLieferzeit(), 1, 1);
				tableAnbieter3.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter3"), "mtbRahmen").getPreis(), 2, 1);
								
				JButton buttonAnbieter3Kaufen = new JButton("Bestellen");
				buttonAnbieter3Kaufen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							String bezeichnung = tableEinkaufen.getValueAt(tableEinkaufen.getSelectedRow(), 0).toString();
							String material = materialnameErmitteln(bezeichnung);
							int anzahl = Integer.parseInt(textAnzahlAnbieter3.getText());
							
							if (Planspiel.getAktuellesUnternehmen().createBestellung("anbieter3", material, anzahl))
								updateUI();
							else
								JOptionPane.showMessageDialog(null, "Die Bestellung konnte nicht aufgegeben werden. \nSie haben entweder nicht genug Geld"
										+ " oder es sind nicht genug Materialien verfügbar.");							
						}
						catch (NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Zahl ein.");								
						}
					}
				});
				buttonAnbieter3Kaufen.setBounds(578, 218, 99, 21);
				panelEinkaufen.add(buttonAnbieter3Kaufen);
				
				textAnzahlAnbieter3 = new JTextField();
				textAnzahlAnbieter3.setHorizontalAlignment(SwingConstants.RIGHT);
				textAnzahlAnbieter3.setText("1");
				textAnzahlAnbieter3.setBounds(527, 218, 48, 20);
				panelEinkaufen.add(textAnzahlAnbieter3);
				textAnzahlAnbieter3.setColumns(10);
				

				
				/** Table mit Bestellungen **/	
				JLabel labelBestellungen = new JLabel("Bestellungen");
				labelBestellungen.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelBestellungen.setBounds(207, 250, 136, 17);
				panelEinkaufen.add(labelBestellungen);
					
				JScrollPane scrollPaneTableWarenkorb = new JScrollPane();
				scrollPaneTableWarenkorb.setBounds(207, 278, 470, 221);
				panelEinkaufen.add(scrollPaneTableWarenkorb);
				
				tableBestellungen = new JTable();
				tableBestellungen.setEnabled(false);
				tableBestellungen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableBestellungenModel = new DefaultTableModel(
						new Object[][] {
								{null, null, null, null, null, null},
								{null, null, null, null, null, null},
								{null, null, null, null, null, null},
							},
							new String[] {
								"Einzelteil", "Anbieter", "Anzahl", "Stk. Preis", "Preis", "Lieferzeit"
							}
						){
							private static final long serialVersionUID = 1L;
			
							@SuppressWarnings("rawtypes")
							Class[] columnTypes = new Class[] {
								String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class
							};
							@SuppressWarnings({ "unchecked", "rawtypes" })
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						};
				tableBestellungen.setModel(tableBestellungenModel);
				tableBestellungen.getColumnModel().getColumn(0).setPreferredWidth(130);
				tableBestellungen.getColumnModel().getColumn(2).setPreferredWidth(60);
				tableBestellungen.getColumnModel().getColumn(3).setPreferredWidth(60);
				tableBestellungen.getColumnModel().getColumn(4).setPreferredWidth(60);
				tableBestellungen.getColumnModel().getColumn(5).setPreferredWidth(60);
				scrollPaneTableWarenkorb.setViewportView(tableBestellungen);
				
			

				
				
				
				
				/****************** VERKAUFEN *****************/
				JPanel panelVerkaufen = new JPanel();
				panelVerkaufen.setBackground(SystemColor.controlHighlight);
				panelVerkaufen.setBounds(707, 11, 516, 526);
			 	panelMarktplatz.add(panelVerkaufen);
				panelVerkaufen.setLayout(null);
				
				JLabel labelVerkaufen = new JLabel("Verkaufen");
				labelVerkaufen.setFont(new Font("Tahoma", Font.BOLD, 16));
				labelVerkaufen.setBounds(10, 11, 266, 22);
				panelVerkaufen.add(labelVerkaufen);
				
				tableVerkaufen = new JTable();
				tableVerkaufen.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						//Preis Feld mit den Grundpreisen füllen
						switch(tableVerkaufen.getSelectedRow()){
							case 0: textPreis.setText("1135"); break;
							case 1: textPreis.setText("1360"); break;
							case 2: textPreis.setText("880"); break;
							case 3: textPreis.setText("1095"); break;
							case 4: textPreis.setText("1595"); break;
							case 5: textPreis.setText("1890"); break;
						}
					}
				});
				
				tableVerkaufen.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						//Preis Feld mit den Grundpreisen füllen
						switch(tableVerkaufen.getSelectedRow()){
							case 0: textPreis.setText("1135"); break;
							case 1: textPreis.setText("1360"); break;
							case 2: textPreis.setText("880"); break;
							case 3: textPreis.setText("1095"); break;
							case 4: textPreis.setText("1595"); break;
							case 5: textPreis.setText("1890"); break;
						}
					}
				});
				tableVerkaufen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				DefaultTableModel tableVerkaufenModel = new DefaultTableModel(new Object[][] {
						{"Mountainbike Standard"},
						{"Mountainbike Premium"},
						{"Trekkingrad Standard"},
						{"Trekkingrad Premium"},
						{"Rennrad Standard"},
						{"Rennrad Premium"},
					},
					new String[] {
						"New Column"
					}
				){
					private static final long serialVersionUID = 1L;

					// Zellen sollen nicht editierbar sein
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
					}
				};
				
				tableVerkaufen.setModel(tableVerkaufenModel);
				tableVerkaufen.setBounds(10, 86, 193, 96);
				tableVerkaufen.changeSelection(0, 0, true, false); // erste Zeile markieren
				panelVerkaufen.add(tableVerkaufen);
				
				textAnzahl = new JTextField();
				textAnzahl.setHorizontalAlignment(SwingConstants.RIGHT);
				textAnzahl.setText("1");
				textAnzahl.setBounds(376, 86, 103, 20);
				panelVerkaufen.add(textAnzahl);
				textAnzahl.setColumns(10);
				
				textPreis = new JTextField();
				textPreis.setText("1135");
				textPreis.setHorizontalAlignment(SwingConstants.RIGHT);
				textPreis.setBounds(376, 120, 103, 20);
				panelVerkaufen.add(textPreis);
				textPreis.setColumns(10);
				
				JButton buttonVerkaufen = new JButton("Auf den Marktplatz stellen");
				buttonVerkaufen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							int selectedIndex = tableVerkaufen.getSelectedRow();
							String fahrradTyp = "";
							String fahrradBezeichnung = "";
							
							switch (selectedIndex){
								case 0: fahrradTyp = "mtbStandard"; fahrradBezeichnung = "Mountainbike Standard"; break;
								case 1: fahrradTyp = "mtbPremium"; fahrradBezeichnung = "Mountainbike Premium"; break;
								case 2: fahrradTyp = "trekkingradStandard"; fahrradBezeichnung = "Trekkingrad Standard"; break;
								case 3: fahrradTyp = "trekkingradPremium"; fahrradBezeichnung = "Trekkingrad Premium"; break;
								case 4: fahrradTyp = "rennradStandard"; fahrradBezeichnung = "Rennrad Standard"; break;
								case 5: fahrradTyp = "rennradPremium"; fahrradBezeichnung = "Rennrad Premium"; break;
							}
							
							int anzahl = Integer.parseInt(textAnzahl.getText());
							int preis = Integer.parseInt(textPreis.getText());
							
							if (anzahl <= 0) {
								JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Anzahl ein.");
								return;
							}
							
							if (Marktplatz.createVerkaufsposten(Planspiel.getAktuellesUnternehmen(), fahrradTyp, fahrradBezeichnung, anzahl, preis))
								updateUI();
							else JOptionPane.showMessageDialog(null, "Verkaufsposten konnte nicht erstellt werden. \nSie können nicht mehr Fahrräder auf den Marktplatz stellen als Sie besitzen.");
							
						}
						catch(NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Anzahl ein.");
						}
					}
				});
				buttonVerkaufen.setBounds(213, 159, 266, 23);
				panelVerkaufen.add(buttonVerkaufen);
				
				JLabel labelFahrradVerkaufen = new JLabel("Fahrrad verkaufen");
				labelFahrradVerkaufen.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelFahrradVerkaufen.setBounds(10, 58, 226, 17);
				panelVerkaufen.add(labelFahrradVerkaufen);
				
				JLabel labelAnzahl = new JLabel("Anzahl");
				labelAnzahl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelAnzahl.setBounds(213, 86, 122, 17);
				panelVerkaufen.add(labelAnzahl);
				
				JLabel labelPreis = new JLabel("Preis in \u20AC");
				labelPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelPreis.setBounds(213, 120, 128, 17);
				panelVerkaufen.add(labelPreis);
				
				JScrollPane scrollPaneTableMarktplatz = new JScrollPane();
				scrollPaneTableMarktplatz.setBounds(10, 193, 470, 244);
				panelVerkaufen.add(scrollPaneTableMarktplatz);
				
				tableMarktplatzModel = new DefaultTableModel(
						new Object[][] {
								{null, null, null, null},
								{null, null, null, null},
								{null, null, null, null},
							},
							new String[] {
								"Fahrrad", "Anzahl", "St\u00FCckpreis", "Gesamtpreis"
							}
						){
							private static final long serialVersionUID = 1L;

							@SuppressWarnings("rawtypes")
							Class[] columnTypes = new Class[] {
								String.class, Integer.class, Integer.class, Integer.class
							};
							@SuppressWarnings({ "unchecked", "rawtypes" })
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
							
							// Zellen sollen nicht editierbar sein
							@Override
						    public boolean isCellEditable(int row, int column) {
						       //all cells false
						       return false;
						    }
				};
				tableMarktplatz = new JTable();
				tableMarktplatz.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						Object preis = tableMarktplatz.getValueAt(tableMarktplatz.getSelectedRow(), 2);
						Object anzahl = tableMarktplatz.getValueAt(tableMarktplatz.getSelectedRow(), 1);
						
						// Preis ins Textfeld übernehmen
						if (preis != null)
							textNeuerPreis.setText(preis.toString().split(" ")[0]);
						
						// Anzahl ins Textfeld übernehmen
						if (anzahl != null)
							textNeueAnzahl.setText(anzahl.toString().split(" ")[0]);
					}
				});
				tableMarktplatz.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableMarktplatz.setModel(tableMarktplatzModel);
				tableMarktplatz.getColumnModel().getColumn(1).setPreferredWidth(40);
				tableMarktplatz.getColumnModel().getColumn(2).setPreferredWidth(40);
				tableMarktplatz.getColumnModel().getColumn(3).setPreferredWidth(40);
				tableMarktplatz.setBounds(75, 263, 310, 234);
				scrollPaneTableMarktplatz.setViewportView(tableMarktplatz);
				
				JButton buttonVomMarktplatzNehmen = new JButton("Vom Marktplatz nehmen");
				buttonVomMarktplatzNehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int selectedRow = tableMarktplatz.getSelectedRow();

						if (selectedRow >= 0 && tableMarktplatz.getValueAt(selectedRow, 0) != null){
							Marktplatz.deleteVerkaufsposten(Planspiel.getAktuellesUnternehmen(), selectedRow);
							UI.updateUI();
							tableMarktplatz.changeSelection(0, 0, true, false); // erste Zeile markieren
						}
						else JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen korrekten Eintrag aus.");
					}
				});
				buttonVomMarktplatzNehmen.setBounds(10, 476, 469, 23);
				panelVerkaufen.add(buttonVomMarktplatzNehmen);
				
				JLabel labelPreisVeraendern = new JLabel("Preis ver\u00E4ndern");
				labelPreisVeraendern.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelPreisVeraendern.setBounds(10, 448, 112, 17);
				panelVerkaufen.add(labelPreisVeraendern);
				
				JLabel labelAnzahlVeraendern = new JLabel("Anzahl ver\u00E4ndern");
				labelAnzahlVeraendern.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelAnzahlVeraendern.setBounds(253, 448, 112, 17);
				panelVerkaufen.add(labelAnzahlVeraendern);
				
				textNeuerPreis = new JTextField();
				textNeuerPreis.setHorizontalAlignment(SwingConstants.RIGHT);
				textNeuerPreis.setBounds(117, 448, 56, 20);
				panelVerkaufen.add(textNeuerPreis);
				textNeuerPreis.setColumns(10);
				
				textNeueAnzahl = new JTextField();
				textNeueAnzahl.setHorizontalAlignment(SwingConstants.RIGHT);
				textNeueAnzahl.setColumns(10);
				textNeueAnzahl.setBounds(367, 448, 56, 20);
				panelVerkaufen.add(textNeueAnzahl);
				
				JButton buttonNeuerPreis = new JButton("OK");
				buttonNeuerPreis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int selectedRow = tableMarktplatz.getSelectedRow();
						try {
							int preis = Integer.parseInt(textNeuerPreis.getText());
							if (preis > 10000)
								throw new NumberFormatException();
							
							if (selectedRow >= 0 && tableMarktplatz.getValueAt(selectedRow, 0) != null){
								
								if (Marktplatz.changePreisVerkaufsposten(Planspiel.getAktuellesUnternehmen(), selectedRow, preis))
									JOptionPane.showMessageDialog(null, "Der Preis wurde erfolgreich angepasst.");
								else JOptionPane.showMessageDialog(null, "Beim Anpassen des Preises ist ein Fehler aufgetreten.");
								
								UI.updateUI();
								tableMarktplatz.changeSelection(selectedRow, 0, true, false); // Zeile wieder markieren
							}
							else JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen korrekten Eintrag aus.");
						}
						catch (NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Zahl ein.");	
						}
					}
				});
				buttonNeuerPreis.setBounds(178, 448, 51, 20);
				panelVerkaufen.add(buttonNeuerPreis);
				
				JButton buttonNeueAnzahl = new JButton("OK");
				buttonNeueAnzahl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int selectedRow = tableMarktplatz.getSelectedRow();
						try {
							int anzahl = Integer.parseInt(textNeueAnzahl.getText()); 
							if (anzahl > 100000)
								throw new NumberFormatException();
							
							if (selectedRow >= 0 && tableMarktplatz.getValueAt(selectedRow, 0) != null){
								
								if (Marktplatz.changeAnzahlVerkaufsposten(Planspiel.getAktuellesUnternehmen(), selectedRow, anzahl))
									JOptionPane.showMessageDialog(null, "Die Anzahl wurde erfolgreich angepasst.");
								else JOptionPane.showMessageDialog(null, "Die Anzahl konnte nicht angepasst werden. \nBeachten Sie, dass Sie nicht mehr Fahrräder verkaufen können als Sie besitzen.");
								
								UI.updateUI();
								tableMarktplatz.changeSelection(selectedRow, 0, true, false); // Zeile wieder markieren
							}
							else JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen korrekten Eintrag aus.");
						}
						catch (NumberFormatException e){
							JOptionPane.showMessageDialog(null, "Bitte geben Sie eine korrekte Zahl ein.");	
						}
					}
				});
				buttonNeueAnzahl.setBounds(428, 448, 51, 20);
				panelVerkaufen.add(buttonNeueAnzahl);
								

		/**********************************************/
		/************ Entwicklung / Bank **************/
		/**********************************************/		

		 panelEntwicklungUndBank = new JPanel();
		 tabbedPane.addTab("Entwicklung / Bank", null, panelEntwicklungUndBank, null);
		 panelEntwicklungUndBank.setLayout(null);
		 
		 		/********** ENTWICKLUNG *************/
				JPanel panelEntwicklung = new JPanel();
				panelEntwicklung.setBackground(SystemColor.controlHighlight);
				panelEntwicklung.setBounds(10, 11, 634, 523);
				panelEntwicklungUndBank.add(panelEntwicklung);
				panelEntwicklung.setLayout(null);
				
				JLabel labelEntwicklung = new JLabel("Entwicklung");
				labelEntwicklung.setFont(new Font("Tahoma", Font.BOLD, 16));
				labelEntwicklung.setBounds(10, 11, 289, 22);
				panelEntwicklung.add(labelEntwicklung);
				
				
				/***** panel Maschinen *****/
				JPanel panelMaschinen = new JPanel();
				panelMaschinen.setBounds(10, 44, 614, 131);
				panelEntwicklung.add(panelMaschinen);
				panelMaschinen.setLayout(null);
				
				JLabel labelMaschinen = new JLabel("Maschinen");
				labelMaschinen.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelMaschinen.setBounds(10, 11, 207, 17);
				panelMaschinen.add(labelMaschinen);
				
				JLabel labelPreisProMaschine = new JLabel("Preis pro Maschine:");
				labelPreisProMaschine.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelPreisProMaschine.setBounds(10, 39, 136, 17);
				panelMaschinen.add(labelPreisProMaschine);
				
				JLabel labelPreisProMaschineWert = new JLabel();
				labelPreisProMaschineWert.setText(Planspiel.getStartMaschinenPreis() + " €");
				labelPreisProMaschineWert.setHorizontalAlignment(SwingConstants.RIGHT);
				labelPreisProMaschineWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelPreisProMaschineWert.setBounds(139, 39, 78, 17);
				panelMaschinen.add(labelPreisProMaschineWert);
				
				JLabel labelZusaetzlicheMitarbeiter = new JLabel("Zus\u00E4tzliche Mitarbeiter:");
				labelZusaetzlicheMitarbeiter.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelZusaetzlicheMitarbeiter.setBounds(10, 67, 155, 17);
				panelMaschinen.add(labelZusaetzlicheMitarbeiter);
				
				JLabel labelZusaetzlicheMitarbeiterWert = new JLabel();
				labelZusaetzlicheMitarbeiterWert.setText("+ " + Planspiel.getStartMitarbeiterProMaschine());
				labelZusaetzlicheMitarbeiterWert.setHorizontalAlignment(SwingConstants.RIGHT);
				labelZusaetzlicheMitarbeiterWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelZusaetzlicheMitarbeiterWert.setBounds(139, 67, 78, 17);
				panelMaschinen.add(labelZusaetzlicheMitarbeiterWert);

				JButton buttonMaschineKaufen = new JButton("Maschine kaufen");
				buttonMaschineKaufen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um den Kauf abzuschließen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().maschineKaufen()){
								UI.updateUI();
								JOptionPane.showMessageDialog(null, "Die Maschine wurde gekauft.");
							}
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld um eine Maschine zu kaufen.");
						}
					}
				});
				buttonMaschineKaufen.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonMaschineKaufen.setBounds(10, 95, 207, 23);
				panelMaschinen.add(buttonMaschineKaufen);
				
				JLabel labelProduktionskapazitaetVerbessern = new JLabel("Produktionskapazit\u00E4t verbessern:");
				labelProduktionskapazitaetVerbessern.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelProduktionskapazitaetVerbessern.setBounds(255, 67, 221, 17);
				panelMaschinen.add(labelProduktionskapazitaetVerbessern);
				
				JLabel labelProduktionskapazitaetVerbessernWert = new JLabel();
				labelProduktionskapazitaetVerbessernWert.setText("+ " + Planspiel.getStartMaschinenUpgradeWert());
				labelProduktionskapazitaetVerbessernWert.setHorizontalAlignment(SwingConstants.RIGHT);
				labelProduktionskapazitaetVerbessernWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelProduktionskapazitaetVerbessernWert.setBounds(541, 67, 63, 17);
				panelMaschinen.add(labelProduktionskapazitaetVerbessernWert);
				
				JLabel labelPreisProUpgrade = new JLabel("Preis pro Upgrade:");
				labelPreisProUpgrade.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelPreisProUpgrade.setBounds(255, 39, 155, 17);
				panelMaschinen.add(labelPreisProUpgrade);
				
				JLabel labelPreisProUpgradeWert = new JLabel();
				labelPreisProUpgradeWert.setText(Planspiel.getStartMaschinenUpgradePreis() + " €");
				labelPreisProUpgradeWert.setHorizontalAlignment(SwingConstants.RIGHT);
				labelPreisProUpgradeWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelPreisProUpgradeWert.setBounds(512, 39, 92, 17);
				panelMaschinen.add(labelPreisProUpgradeWert);
				
				buttonUpgradeDurchfuehren = new JButton("Upgrade durchf\u00FChren");
				buttonUpgradeDurchfuehren.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um das Upgrade durchzuführen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().maschinenUpgrade()){
								UI.updateUI();
								JOptionPane.showMessageDialog(null, "Das Upgrade wurde erfolgreich durchgeführt.");
							}
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld für das Maschinen-Upgrade.");
						}
					}
				});
				buttonUpgradeDurchfuehren.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonUpgradeDurchfuehren.setBounds(255, 95, 349, 23);
				panelMaschinen.add(buttonUpgradeDurchfuehren);
				
				/****** panel LagerUpgrade *****/
				JPanel panelLagerUpgrade = new JPanel();
				panelLagerUpgrade.setBounds(10, 186, 300, 139);
				panelEntwicklung.add(panelLagerUpgrade);
				panelLagerUpgrade.setLayout(null);
				
				JLabel labelLagerUpgrade = new JLabel("Lager");
				labelLagerUpgrade.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelLagerUpgrade.setBounds(10, 11, 207, 17);
				panelLagerUpgrade.add(labelLagerUpgrade);
				
				JLabel labelLagerkapazitaetErhoehen = new JLabel("Lagerkapazit\u00E4t erh\u00F6hen:");
				labelLagerkapazitaetErhoehen.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelLagerkapazitaetErhoehen.setBounds(10, 39, 159, 17);
				panelLagerUpgrade.add(labelLagerkapazitaetErhoehen);
				
				JLabel labelLagerkapazitaetErhoehenWert = new JLabel();
				labelLagerkapazitaetErhoehenWert.setText("+ " + Planspiel.getStartLagerkapazitaetErhoehenWert());
				labelLagerkapazitaetErhoehenWert.setHorizontalAlignment(SwingConstants.RIGHT);
				labelLagerkapazitaetErhoehenWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelLagerkapazitaetErhoehenWert.setBounds(223, 39, 67, 17);
				panelLagerUpgrade.add(labelLagerkapazitaetErhoehenWert);
				
				JLabel labelPreisProErhoehung = new JLabel("Preis pro Erh\u00F6hung:");
				labelPreisProErhoehung.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelPreisProErhoehung.setBounds(10, 67, 148, 17);
				panelLagerUpgrade.add(labelPreisProErhoehung);
				
				JLabel labelPreisProErhoehungWert = new JLabel();
				labelPreisProErhoehungWert.setText(Planspiel.getStartLagerkapazitaetErhoehenPreis() + " €");
				labelPreisProErhoehungWert.setHorizontalAlignment(SwingConstants.RIGHT);
				labelPreisProErhoehungWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelPreisProErhoehungWert.setBounds(223, 67, 67, 17);
				panelLagerUpgrade.add(labelPreisProErhoehungWert);
				
				JButton buttonLagerkapazitaetErhoehen = new JButton("Lagerkapazit\u00E4t erh\u00F6hen");
				buttonLagerkapazitaetErhoehen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um die Erhöhung der Lagerkapazität zu bestätigen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().lagerKapazitaetErhoehen()){
								JOptionPane.showMessageDialog(null, "Die Lagerkapazität wurde erfolgreich erhöht.");
								UI.updateUI();
							}
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld für die Erhöhung der Lagerkapazität.");
						}
					}
				});
				buttonLagerkapazitaetErhoehen.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonLagerkapazitaetErhoehen.setBounds(10, 104, 280, 23);
				panelLagerUpgrade.add(buttonLagerkapazitaetErhoehen);
				
				
				/***** panel PatenteKaufen *****/
				JPanel panelPatente = new JPanel();
				panelPatente.setBounds(320, 186, 304, 139);
				panelEntwicklung.add(panelPatente);
				panelPatente.setLayout(null);
				
				JLabel labelPatenteKaufen = new JLabel("Patente kaufen");
				labelPatenteKaufen.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelPatenteKaufen.setBounds(10, 11, 207, 17);
				panelPatente.add(labelPatenteKaufen);
				
				JLabel label1MtbPremPatent = new JLabel("Mountainbike");
				label1MtbPremPatent.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label1MtbPremPatent.setBounds(10, 39, 88, 17);
				panelPatente.add(label1MtbPremPatent);
				
				JLabel label2MtbPremPatent = new JLabel("Premium");
				label2MtbPremPatent.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label2MtbPremPatent.setBounds(10, 56, 88, 17);
				panelPatente.add(label2MtbPremPatent);
				
				JLabel labelMtbPremPatentPreis = new JLabel();
				labelMtbPremPatentPreis.setText("[ " + Planspiel.getStartMtbPremPatentPreis() + " € ]");
				labelMtbPremPatentPreis.setHorizontalAlignment(SwingConstants.LEFT);
				labelMtbPremPatentPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelMtbPremPatentPreis.setBounds(10, 78, 85, 17);
				panelPatente.add(labelMtbPremPatentPreis);
				
				buttonPatentMtbPrem = new JButton("Kaufen");
				buttonPatentMtbPrem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um den Kauf abzuschließen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().patentKaufen("mtb"))
								UI.updateUI();
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld um das Patent zu kaufen.");
						}
					}
				});
				buttonPatentMtbPrem.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonPatentMtbPrem.setBounds(10, 104, 79, 23);
				panelPatente.add(buttonPatentMtbPrem);
				
				JLabel label1TrekkingPremPatent = new JLabel("Trekkingrad");
				label1TrekkingPremPatent.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label1TrekkingPremPatent.setBounds(113, 39, 88, 17);
				panelPatente.add(label1TrekkingPremPatent);
				
				JLabel label2TrekkingPremPatent = new JLabel("Premium");
				label2TrekkingPremPatent.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label2TrekkingPremPatent.setBounds(113, 56, 88, 17);
				panelPatente.add(label2TrekkingPremPatent);
				
				JLabel labelTrekkingPremPatentPreis = new JLabel();
				labelTrekkingPremPatentPreis.setText("[ " + Planspiel.getStartTrekkingPremPatentPreis() + " € ]");
				labelTrekkingPremPatentPreis.setHorizontalAlignment(SwingConstants.LEFT);
				labelTrekkingPremPatentPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelTrekkingPremPatentPreis.setBounds(113, 78, 88, 17);
				panelPatente.add(labelTrekkingPremPatentPreis);
				
				buttonPatentTrekkingPrem = new JButton("Kaufen");
				buttonPatentTrekkingPrem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um den Kauf abzuschließen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().patentKaufen("trekking"))
								UI.updateUI();
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld um das Patent zu kaufen.");
						}
					}
				});
				buttonPatentTrekkingPrem.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonPatentTrekkingPrem.setBounds(113, 104, 79, 23);
				panelPatente.add(buttonPatentTrekkingPrem);
				
				JLabel label1RennradPremPatent = new JLabel("Rennrad");
				label1RennradPremPatent.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label1RennradPremPatent.setBounds(207, 39, 88, 17);
				panelPatente.add(label1RennradPremPatent);
				
				JLabel label2RennradPremPatent = new JLabel("Premium");
				label2RennradPremPatent.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label2RennradPremPatent.setBounds(207, 56, 88, 17);
				panelPatente.add(label2RennradPremPatent);
				
				JLabel labelRennradPremPatentPreis = new JLabel();
				labelRennradPremPatentPreis.setText("[ " + Planspiel.getStartRennradPremPatentPreis() + " € ]");
				labelRennradPremPatentPreis.setHorizontalAlignment(SwingConstants.LEFT);
				labelRennradPremPatentPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelRennradPremPatentPreis.setBounds(207, 78, 88, 17);
				panelPatente.add(labelRennradPremPatentPreis);
				
				buttonPatentRennradPrem = new JButton("Kaufen");
				buttonPatentRennradPrem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um den Kauf abzuschließen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().patentKaufen("rennrad"))
								UI.updateUI();
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld um das Patent zu kaufen.");
						}
					}
				});
				buttonPatentRennradPrem.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonPatentRennradPrem.setBounds(207, 104, 79, 23);
				panelPatente.add(buttonPatentRennradPrem);
				
				
				/****** panel MarktErforschung *****/
				panelMarktforschung = new JPanel();
				panelMarktforschung.setBounds(10, 336, 300, 176);
				panelEntwicklung.add(panelMarktforschung);
				panelMarktforschung.setLayout(null);
				
				JLabel labelMarktErforschen = new JLabel("Marktforschung f\u00FCr 3 Runden");
				labelMarktErforschen.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelMarktErforschen.setBounds(10, 11, 207, 17);
				panelMarktforschung.add(labelMarktErforschen);
				
				JLabel labelMtbStandardMarktforschung = new JLabel("Mountainbike St.");
				labelMtbStandardMarktforschung.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelMtbStandardMarktforschung.setBounds(7, 39, 103, 17);
				panelMarktforschung.add(labelMtbStandardMarktforschung);
				
				JLabel labelMtbStandardMarktforschungPreis = new JLabel();
				labelMtbStandardMarktforschungPreis.setText(Planspiel.getStartMtbStandardForschungPreis() + " €");
				labelMtbStandardMarktforschungPreis.setHorizontalAlignment(SwingConstants.LEFT);
				labelMtbStandardMarktforschungPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelMtbStandardMarktforschungPreis.setBounds(7, 56, 85, 17);
				panelMarktforschung.add(labelMtbStandardMarktforschungPreis);

				JLabel labelMtbPremiumMarktforschung = new JLabel("Mountainbike Pr.");
				labelMtbPremiumMarktforschung.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelMtbPremiumMarktforschung.setBounds(7, 105, 103, 17);
				panelMarktforschung.add(labelMtbPremiumMarktforschung);
				
				JLabel labelMtbPremiumMarktforschungPreis = new JLabel();
				labelMtbPremiumMarktforschungPreis.setText(Planspiel.getStartMtbPremiumForschungPreis() + " €");
				labelMtbPremiumMarktforschungPreis.setHorizontalAlignment(SwingConstants.LEFT);
				labelMtbPremiumMarktforschungPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelMtbPremiumMarktforschungPreis.setBounds(7, 122, 85, 17);
				panelMarktforschung.add(labelMtbPremiumMarktforschungPreis);
				
				JLabel labelTrekkingStandardMarktforschung = new JLabel("Trekkingrad St.");
				labelTrekkingStandardMarktforschung.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelTrekkingStandardMarktforschung.setBounds(116, 39, 101, 17);
				panelMarktforschung.add(labelTrekkingStandardMarktforschung);
				
				JLabel labelTrekkingStandardMarktforschungPreis = new JLabel();
				labelTrekkingStandardMarktforschungPreis.setText(Planspiel.getStartTrekkingradStandardForschungPreis() + " €");
				labelTrekkingStandardMarktforschungPreis.setHorizontalAlignment(SwingConstants.LEFT);
				labelTrekkingStandardMarktforschungPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelTrekkingStandardMarktforschungPreis.setBounds(116, 55, 85, 17);
				panelMarktforschung.add(labelTrekkingStandardMarktforschungPreis);
				
				JLabel labelTrekkingradPremiumMarktforschung = new JLabel("Trekkingrad Pr.");
				labelTrekkingradPremiumMarktforschung.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelTrekkingradPremiumMarktforschung.setBounds(116, 105, 103, 17);
				panelMarktforschung.add(labelTrekkingradPremiumMarktforschung);
				
				JLabel labelTrekkingradPremiumMarktforschungPreis = new JLabel();
				labelTrekkingradPremiumMarktforschungPreis.setText(Planspiel.getStartTrekkingradPremiumForschungPreis() + " €");
				labelTrekkingradPremiumMarktforschungPreis.setHorizontalAlignment(SwingConstants.LEFT);
				labelTrekkingradPremiumMarktforschungPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelTrekkingradPremiumMarktforschungPreis.setBounds(116, 122, 85, 17);
				panelMarktforschung.add(labelTrekkingradPremiumMarktforschungPreis);
				
				JLabel labelRennradStandardMarktforschung = new JLabel("Rennrad St.");
				labelRennradStandardMarktforschung.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelRennradStandardMarktforschung.setBounds(218, 39, 88, 17);
				panelMarktforschung.add(labelRennradStandardMarktforschung);
				
				JLabel labelRennradStandardMarktforschungPreis = new JLabel();
				labelRennradStandardMarktforschungPreis.setText(Planspiel.getStartRennradStandardForschungPreis() + " €");
				labelRennradStandardMarktforschungPreis.setHorizontalAlignment(SwingConstants.LEFT);
				labelRennradStandardMarktforschungPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelRennradStandardMarktforschungPreis.setBounds(218, 55, 85, 17);
				panelMarktforschung.add(labelRennradStandardMarktforschungPreis);
				
				JLabel labelRennradPremiumMarktforschung = new JLabel("Rennrad Pr.");
				labelRennradPremiumMarktforschung.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelRennradPremiumMarktforschung.setBounds(218, 105, 103, 17);
				panelMarktforschung.add(labelRennradPremiumMarktforschung);
				
				JLabel labelRennradPremiumMarktforschungPreis = new JLabel();
				labelRennradPremiumMarktforschungPreis.setText(Planspiel.getStartRennradPremiumForschungPreis() + " €");
				labelRennradPremiumMarktforschungPreis.setHorizontalAlignment(SwingConstants.LEFT);
				labelRennradPremiumMarktforschungPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelRennradPremiumMarktforschungPreis.setBounds(218, 122, 85, 17);
				panelMarktforschung.add(labelRennradPremiumMarktforschungPreis);
					
				// Button mtbStandard erforschen
				buttonMtbStandardErforschen = new JButton("Kaufen");
				buttonMtbStandardErforschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um den Kauf abzuschließen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().marktErforschen("mtbStandard"))
								UI.updateUI();
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld für die Marktforschung.");
						}
					}
				});
				buttonMtbStandardErforschen.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonMtbStandardErforschen.setBounds(7, 75, 72, 23);
				panelMarktforschung.add(buttonMtbStandardErforschen);
				
				// Button mtbPremium erforschen
				buttonMtbPremiumErforschen = new JButton("Kaufen");
				buttonMtbPremiumErforschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um den Kauf abzuschließen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().marktErforschen("mtbPremium"))
								UI.updateUI();
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld für die Marktforschung.");
						}
					}
				});
				buttonMtbPremiumErforschen.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonMtbPremiumErforschen.setBounds(7, 142, 72, 23);
				panelMarktforschung.add(buttonMtbPremiumErforschen);
				
				// Button trekkingradStandard erforschen
				buttonTrekkingradStandardErforschen = new JButton("Kaufen");
				buttonTrekkingradStandardErforschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um den Kauf abzuschließen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().marktErforschen("trekkingradStandard"))
								UI.updateUI();
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld für die Marktforschung.");
						}
					}
				});
				buttonTrekkingradStandardErforschen.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonTrekkingradStandardErforschen.setBounds(116, 75, 72, 23);
				panelMarktforschung.add(buttonTrekkingradStandardErforschen);
				
				// Button trekkingradPremium erforschen
				buttonTrekkingradPremiumErforschen = new JButton("Kaufen");
				buttonTrekkingradPremiumErforschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um den Kauf abzuschließen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().marktErforschen("trekkingradPremium"))
								UI.updateUI();
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld für die Marktforschung.");
						}
					}
				});
				buttonTrekkingradPremiumErforschen.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonTrekkingradPremiumErforschen.setBounds(116, 142, 72, 23);
				panelMarktforschung.add(buttonTrekkingradPremiumErforschen);
				
				// Button rennradStandard erforschen
				buttonRennradStandardErforschen = new JButton("Kaufen");
				buttonRennradStandardErforschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um den Kauf abzuschließen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().marktErforschen("rennradStandard"))
								UI.updateUI();
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld für die Marktforschung.");
						}
					}
				});
				buttonRennradStandardErforschen.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonRennradStandardErforschen.setBounds(218, 75, 72, 23);
				panelMarktforschung.add(buttonRennradStandardErforschen);
				
				// Button rennradPremium erforschen
				buttonRennradPremiumErforschen = new JButton("Kaufen");
				buttonRennradPremiumErforschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (0 == JOptionPane.showConfirmDialog(null, "Drücken Sie auf \"OK\" um den Kauf abzuschließen.", "Bestätigung", JOptionPane.OK_CANCEL_OPTION)){
							if (Planspiel.getAktuellesUnternehmen().getEntwicklung().marktErforschen("rennradPremium"))
								UI.updateUI();
							else JOptionPane.showMessageDialog(null, "Sie haben nicht genügend Geld für die Marktforschung.");
						}
					}
				});
				buttonRennradPremiumErforschen.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonRennradPremiumErforschen.setBounds(218, 142, 72, 23);
				panelMarktforschung.add(buttonRennradPremiumErforschen);
				
				
				/****** panel Versicherung *****/
				JPanel panelVersicherung = new JPanel();
				panelVersicherung.setBounds(320, 336, 304, 176);
				panelEntwicklung.add(panelVersicherung);
				panelVersicherung.setLayout(null);
				
				JLabel labelVersicherungen = new JLabel("Versicherungen");
				labelVersicherungen.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelVersicherungen.setBounds(10, 11, 207, 17);
				panelVersicherung.add(labelVersicherungen);
				
				checkboxBrandschutz = new JCheckBox("Brandschutz [ " + Planspiel.getStartBrandschutzPreis() + "€ / Runde ]");
				checkboxBrandschutz.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Planspiel.getAktuellesUnternehmen().getVersicherung().setBrandschutz(checkboxBrandschutz.isSelected());
					}
				});
				checkboxBrandschutz.setFont(new Font("Tahoma", Font.PLAIN, 14));
				checkboxBrandschutz.setBounds(10, 56, 260, 23);
				panelVersicherung.add(checkboxBrandschutz);
				
				checkboxReparaturvertrag = new JCheckBox("Reparaturvertrag [ " + Planspiel.getStartReparaturVertragPreis() + "€ / Runde ]");
				checkboxReparaturvertrag.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Planspiel.getAktuellesUnternehmen().getVersicherung().setReparaturVertrag(checkboxReparaturvertrag.isSelected());
					}
				});
				checkboxReparaturvertrag.setFont(new Font("Tahoma", Font.PLAIN, 14));
				checkboxReparaturvertrag.setBounds(10, 90, 260, 23);
				panelVersicherung.add(checkboxReparaturvertrag);
				
				checkboxRechtsschutz = new JCheckBox("Rechtsschutz [ " + Planspiel.getStartRechtsschutzVersicherungPreis() + "€ / Runde ]");
				checkboxRechtsschutz.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Planspiel.getAktuellesUnternehmen().getVersicherung().setRechtsschutzVersicherung(checkboxRechtsschutz.isSelected());
					}
				});
				checkboxRechtsschutz.setFont(new Font("Tahoma", Font.PLAIN, 14));
				checkboxRechtsschutz.setBounds(10, 126, 260, 23);
				panelVersicherung.add(checkboxRechtsschutz);

				
				
		 		/************* BANK **************/
				JPanel panelBank = new JPanel();
				panelBank.setBackground(SystemColor.controlHighlight);
				panelBank.setBounds(654, 11, 548, 523);
				panelEntwicklungUndBank.add(panelBank);
				panelBank.setLayout(null);
				
				JLabel labelBank = new JLabel("Bank");
				labelBank.setFont(new Font("Tahoma", Font.BOLD, 16));
				labelBank.setBounds(10, 11, 63, 22);
				panelBank.add(labelBank);
				
				labelKreditwuerdig = new JLabel("[ Ihr Unternehmen ist zur Zeit nicht kreditw\u00FCrdig ]");
				labelKreditwuerdig.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelKreditwuerdig.setBounds(76, 13, 364, 17);
				panelBank.add(labelKreditwuerdig);
				
				JLabel labelKredit1 = new JLabel("Kredit 1 (Tilgungsdarlehn)");
				labelKredit1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelKredit1.setBounds(10, 44, 232, 17);
				panelBank.add(labelKredit1);
				
				tableKredit1 = new JTable();
				tableKredit1.setEnabled(false);
				tableKredit1.setModel(new DefaultTableModel(
					new Object[][] {
						{"Kreditsumme", new Integer(0)},
						{"Zinssatz", new Integer(0)},
						{"Laufzeit", new Integer(0)},
						{"Tilgung pro Runde", new Integer(0)},
					},
					new String[] {
						"New column", "New column"
					}
				));
				tableKredit1.getColumnModel().getColumn(0).setPreferredWidth(90);
				tableKredit1.getColumnModel().getColumn(1).setPreferredWidth(35);
				tableKredit1.setBounds(10, 72, 254, 64);
				panelBank.add(tableKredit1);
				
				buttonKredit1Nehmen = new JButton("Kredit nehmen");
				buttonKredit1Nehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// Kredit1 nehmen, Kredit wurde zuvor bereits berechnet. Die Konditionen des Kredis werden im UI angezeigt.
						Planspiel.getAktuellesUnternehmen().getBank().kreditNehmen(1);
						UI.updateUI(); 
					}
				});
				buttonKredit1Nehmen.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonKredit1Nehmen.setBounds(10, 155, 254, 23);
				panelBank.add(buttonKredit1Nehmen);
				
				JLabel labelKredit2 = new JLabel("Kredit 2 (Tilgungsdarlehn)");
				labelKredit2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelKredit2.setBounds(274, 44, 183, 17);
				panelBank.add(labelKredit2);
				
				tableKredit2 = new JTable();
				tableKredit2.setEnabled(false);
				tableKredit2.setModel(new DefaultTableModel(
					new Object[][] {
						{"Kreditsumme", new Integer(0)},
						{"Zinssatz", new Integer(0)},
						{"Laufzeit", new Integer(0)},
						{"Tilgung pro Runde", new Integer(0)},
					},
					new String[] {
						"New column", "New column"
					}
				));
				tableKredit2.getColumnModel().getColumn(0).setPreferredWidth(90);
				tableKredit2.getColumnModel().getColumn(1).setPreferredWidth(35);
				tableKredit2.setBounds(274, 72, 264, 64);
				panelBank.add(tableKredit2);
				
				buttonKredit2Nehmen = new JButton("Kredit nehmen");
				buttonKredit2Nehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// Kredit2 nehmen, Kredit wurde zuvor bereits berechnet. Die Konditionen des Kredis werden im UI angezeigt.
						Planspiel.getAktuellesUnternehmen().getBank().kreditNehmen(2);
						UI.updateUI(); 
					}
				});
				buttonKredit2Nehmen.setFont(new Font("Tahoma", Font.PLAIN, 11));
				buttonKredit2Nehmen.setBounds(274, 155, 264, 23);
				panelBank.add(buttonKredit2Nehmen);

				
				JLabel labelLaufendeKredite = new JLabel("Laufende Kredite");
				labelLaufendeKredite.setFont(new Font("Tahoma", Font.PLAIN, 14));
				labelLaufendeKredite.setBounds(10, 198, 155, 17);
				panelBank.add(labelLaufendeKredite);
				
				JScrollPane scrollPaneKredite = new JScrollPane();
				scrollPaneKredite.setBounds(10, 229, 528, 283);
				panelBank.add(scrollPaneKredite);
				
				tableLaufendeKrediteModel = new DefaultTableModel(
						new Object[][] {
								{null, null, null, null, null},
								{null, null, null, null, null},
								{null, null, null, null, null},
							},
							new String[] {
								"Kreditsumme", "Tilgung", "Zinssatz", "Laufzeit", "Noch zu tilgen"
							}
						) {
						private static final long serialVersionUID = 1L;
						
						@SuppressWarnings("rawtypes")
						Class[] columnTypes = new Class[] {
							Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
						};
						@SuppressWarnings({ "unchecked", "rawtypes" })
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					};
				tableLaufendeKredite = new JTable();
				tableLaufendeKredite.setEnabled(false);
				tableLaufendeKredite.setModel(tableLaufendeKrediteModel);
				tableLaufendeKredite.getColumnModel().getColumn(0).setPreferredWidth(80);
				tableLaufendeKredite.getColumnModel().getColumn(1).setPreferredWidth(80);
				tableLaufendeKredite.getColumnModel().getColumn(2).setPreferredWidth(50);
				tableLaufendeKredite.getColumnModel().getColumn(3).setPreferredWidth(50);
				tableLaufendeKredite.getColumnModel().getColumn(4).setPreferredWidth(50);
				scrollPaneKredite.setViewportView(tableLaufendeKredite);
				

				

		 /********************************************************/
		  
		 frame.setVisible(true);
	}
	
	/**
	 * Die Methode updatet das gesamte UI und lädt die Werte aus den Objekten die zu dem Spieler gehören, der am Zug ist.
	 */
	public static void updateUI() {
		Unternehmen unternehmen = Planspiel.getAktuellesUnternehmen();
		
		/*************** STARTSEITE UPDATEN **********************/
		
		/** Werte werden für das jeweilige Unternehmen angepasst **/
		labelSpielername.setText(unternehmen.getSpielername() + " (Runde " + Planspiel.getRundenNr() + ")");
		labelKontostandWert.setText(Math.round(unternehmen.getBank().getKontostand() * 100) / 100.0 + " €"); // auf 2 Nachkommastellen runden
		labelMitarbeiterWert.setText(String.valueOf(unternehmen.getAnzahlMitarbeiter()));
		labelGehaelterWert.setText(unternehmen.getGehaelter() + " €");
		labelWeitereFixKostenWert.setText(Planspiel.getFixkosten() + " €");
		labelLagerKapazitaet.setText(String.valueOf(unternehmen.getLager().getLagerKapazitaet()));
	    labelBelegteLagerKapazitaetWert.setText(String.valueOf(unternehmen.getLager().getBelegterSpeicher()));
	    labelAnzahlMaschinenWert.setText(String.valueOf(unternehmen.getFabrik().getAnzahlMaschinen()));
		labelProduktionsKapazitaetProMachineWert.setText(String.valueOf(unternehmen.getFabrik().getProduktionsKapazitaetProMaschine()));
		labelProduktionskapazitaetWert.setText(String.valueOf(unternehmen.getFabrik().getProduktionsKapazitaet()));
		labelVerbleibendeProduktionskapazitaetWert.setText(String.valueOf(unternehmen.getFabrik().getProduktionsKapazitaet() - unternehmen.getFabrik().getAnzahlInProduktion()));
		
		textAnzahlF1.setText("1");
		textAnzahlF2.setText("1");
		textAnzahlF3.setText("1");
		textAnzahlF4.setText("1");
		textAnzahlF5.setText("1");
		textAnzahlF6.setText("1");
		
		/** wenn Patente gekauft wurden die Button "enablen" **/
		if (unternehmen.getEntwicklung().isPatentMountainbikePrem()){
			textAnzahlF2.setEnabled(true);
			btnProduzierenF2.setEnabled(true);
		}
		else {
			textAnzahlF2.setEnabled(false);
			btnProduzierenF2.setEnabled(false);
		}
		if (unternehmen.getEntwicklung().isPatentTrekkingradPrem()){
			textAnzahlF4.setEnabled(true);
			btnProduzierenF4.setEnabled(true);
		}
		else {
			textAnzahlF4.setEnabled(false);
			btnProduzierenF4.setEnabled(false);
		}
		if (unternehmen.getEntwicklung().isPatentRennradPrem()){
			textAnzahlF6.setEnabled(true);
			btnProduzierenF6.setEnabled(true);
		}
		else {
			textAnzahlF6.setEnabled(false);
			btnProduzierenF6.setEnabled(false);
		}
		
		
		/** Lager Tabelle updaten **/
		int[] inhalt = unternehmen.getLager().getLagerInhalt();
		for (int i = 0; i < inhalt.length; i++){
			tableLager.setValueAt(inhalt[i], i, 1);
		}
		
		/** tableKrediteUebersicht anpassen **/
		Kredit[] kredite = unternehmen.getBank().getAlleKredite();
		tableKrediteUebersicht.setValueAt(kredite.length + " Kredite", 0, 1);
		double zinsen = 0;
		double tilgung = 0;
		
		for (int i = 0; i < kredite.length; i++){
			kredite[i].berechneZins(); // Zinsen für Kredit neu berechnen
			zinsen += kredite[i].getZins();
			tilgung += kredite[i].getTilgung();			
		}
		tableKrediteUebersicht.setValueAt(tilgung + " €", 1, 1);
		tableKrediteUebersicht.setValueAt(zinsen + " €", 2, 1);
		tableKrediteUebersicht.setValueAt(tilgung + zinsen + " €", 3, 1);
		
		
		/** Diagramm updaten und die Nachfrage-Entwicklung anzeigen **/
		showDiagram();
				
		/*************** MARKTPLATZ UPDATEN **********************/
		
		/** Textfelder / Tabelle zurücksetzen **/
		switch(tableVerkaufen.getSelectedRow()){
			case 0: textPreis.setText("1135"); break;
			case 1: textPreis.setText("1360"); break;
			case 2: textPreis.setText("880"); break;
			case 3: textPreis.setText("1095"); break;
			case 4: textPreis.setText("1595"); break;
			case 5: textPreis.setText("1890"); break;
		}
		textNeuerPreis.setText("");
		textNeueAnzahl.setText("");
		
		/** Anbieter-Tabellen updaten **/
		String bezeichnung = tableEinkaufen.getValueAt(tableEinkaufen.getSelectedRow(), 0).toString(); // aktuell selektierter Eintrag in tableEinkaufen auslesen
		String material = materialnameErmitteln(bezeichnung);
		
		labelMaterialGewaehlt.setText(tableEinkaufen.getValueAt(tableEinkaufen.getSelectedRow(), 0).toString());
		
		tableAnbieter1.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter1"), material).getAnzahlVerfuegbar() + " Stk.", 0, 1);
		tableAnbieter1.setValueAt(Marktplatz.getAnbieter("anbieter1").getLieferzeit() + " Runde", 1, 1);
		tableAnbieter1.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter1"), material).getPreis() + " €", 2, 1);
		
		tableAnbieter2.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter2"), material).getAnzahlVerfuegbar() + " Stk.", 0, 1);
		tableAnbieter2.setValueAt(Marktplatz.getAnbieter("anbieter2").getLieferzeit() + " Runden", 1, 1);
		tableAnbieter2.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter2"), material).getPreis() + " €", 2, 1);
		
		tableAnbieter3.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter3"), material).getAnzahlVerfuegbar() + " Stk.", 0, 1);
		tableAnbieter3.setValueAt(Marktplatz.getAnbieter("anbieter3").getLieferzeit() + " Runden", 1, 1);
		tableAnbieter3.setValueAt(Marktplatz.getMaterial(Marktplatz.getAnbieter("anbieter3"), material).getPreis() + " €", 2, 1);
		
				
		/** Tabelle "Bestellungen" aktualisieren und alle aktuellen Bestellungen anzeigen **/
		Bestellung[] alleBestellungen = Planspiel.getAktuellesUnternehmen().getBestellungen();
		tableBestellungenModel.setRowCount(0);
		
		for (int i = 0; i < alleBestellungen.length; i++){
			if (i == tableBestellungen.getRowCount())
				tableBestellungenModel.addRow(new Object[][] {{null, null, null, null, null, null}});
					
			tableBestellungen.setValueAt(alleBestellungen[i].getMaterialBezeichnung(), i, 0);
			tableBestellungen.setValueAt(alleBestellungen[i].getAnbieter(), i, 1);
			tableBestellungen.setValueAt(alleBestellungen[i].getAnzahl() + " Stk.", i, 2);
			tableBestellungen.setValueAt(alleBestellungen[i].getStkPreis() + " €", i, 3);
			tableBestellungen.setValueAt(alleBestellungen[i].getGesamtPreis() + " €", i, 4);
			tableBestellungen.setValueAt(alleBestellungen[i].getLieferzeit() + " [ in " + alleBestellungen[i].getTageBisAnkunft() + " ] ", i, 5);
		}
			
		if (tableBestellungenModel.getRowCount() < 3)
			tableBestellungenModel.setRowCount(3);
		
		
		/** Tabelle "Marktplatz" aktualisieren und alle aktuellen Verkaufsposten des jeweiligen Unternehmens anzeigen anzeigen **/
		Verkaufsposten[] alleVerkaufspostenVonUnternehmen = Marktplatz.getVerkaufspostenVonUnternehmen(Planspiel.getAktuellesUnternehmen());
		tableMarktplatzModel.setRowCount(0);
		
		for (int i = 0; i < alleVerkaufspostenVonUnternehmen.length; i++){
			if (i == tableMarktplatzModel.getRowCount())
				tableMarktplatzModel.addRow(new Object[][] {{null, null, null, null, null, null}});
			
			tableMarktplatzModel.setValueAt(alleVerkaufspostenVonUnternehmen[i].getFahrradBezeichnung(), i, 0);
			tableMarktplatzModel.setValueAt(alleVerkaufspostenVonUnternehmen[i].getAnzahl() + " Stk.", i, 1);
			tableMarktplatzModel.setValueAt(alleVerkaufspostenVonUnternehmen[i].getPreis() + " €", i, 2);
			tableMarktplatzModel.setValueAt(alleVerkaufspostenVonUnternehmen[i].getAnzahl() * alleVerkaufspostenVonUnternehmen[i].getPreis() + " €", i, 3);
		}
		
		if (tableMarktplatz.getRowCount() < 3)
			tableMarktplatzModel.setRowCount(3);	
		
		
		/*************** ENTWICKLUNG / BANK UPDATEN **********************/
		
		/************************ ENTWICKLUNG ****************************/		
		
		/** maximal 5 Maschinen-Updates zulassen **/
		if (unternehmen.getEntwicklung().getLevelMaschinen() > 4){
			buttonUpgradeDurchfuehren.setEnabled(false);
		} else buttonUpgradeDurchfuehren.setEnabled(true);
		
		/** wenn Patente bereits gekauft wurde werden die Buttons ausgegraut **/
		if (unternehmen.getEntwicklung().isPatentMountainbikePrem()){
			buttonPatentMtbPrem.setEnabled(false);
		} else buttonPatentMtbPrem.setEnabled(true);
		if (unternehmen.getEntwicklung().isPatentTrekkingradPrem()){
			buttonPatentTrekkingPrem.setEnabled(false);
		} else buttonPatentTrekkingPrem.setEnabled(true);
		if (unternehmen.getEntwicklung().isPatentRennradPrem()){
			buttonPatentRennradPrem.setEnabled(false);
		} else buttonPatentRennradPrem.setEnabled(true);
		
		/** 
		 * Marktforschung kann nur gekauft werden, wenn in der Runde auch die Nachfrage berechnet wurde.
		 * Andernfalls würde sich die Marktforschung für den Spieler nicht lohnen.
		 */
		if ((Planspiel.getRundenNr() == 1) || ((Planspiel.getRundenNr() - 1) % 3 == 0)) {
			buttonMtbStandardErforschen.setEnabled(true);
			buttonMtbPremiumErforschen.setEnabled(true);
			buttonTrekkingradStandardErforschen.setEnabled(true);
			buttonTrekkingradPremiumErforschen.setEnabled(true);
			buttonRennradStandardErforschen.setEnabled(true);
			buttonRennradPremiumErforschen.setEnabled(true);
			
			/** wenn Markt für den Fahhradtyp bereits erforscht ist werden die Buttons ausgegraut **/
			if (unternehmen.getEntwicklung().isMtbStandardMarktforschung()){
				buttonMtbStandardErforschen.setEnabled(false);
			} else buttonMtbStandardErforschen.setEnabled(true);
			if (unternehmen.getEntwicklung().isMtbPremiumMarktforschung()){
				buttonMtbPremiumErforschen.setEnabled(false);
			} else buttonMtbPremiumErforschen.setEnabled(true);
			if (unternehmen.getEntwicklung().isTrekkingradStandardMarktforschung()){
				buttonTrekkingradStandardErforschen.setEnabled(false);
			} else buttonTrekkingradStandardErforschen.setEnabled(true);
			if (unternehmen.getEntwicklung().isTrekkingradPremiumMarktforschung()){
				buttonTrekkingradPremiumErforschen.setEnabled(false);
			} else buttonTrekkingradPremiumErforschen.setEnabled(true);
			if (unternehmen.getEntwicklung().isRennradStandardMarktforschung()){
				buttonRennradStandardErforschen.setEnabled(false);
			} else buttonRennradStandardErforschen.setEnabled(true);
			if (unternehmen.getEntwicklung().isRennradPremiumMarktforschung()){
				buttonRennradPremiumErforschen.setEnabled(false);
			} else buttonRennradPremiumErforschen.setEnabled(true);
		}
		else {
			buttonMtbStandardErforschen.setEnabled(false);
			buttonMtbPremiumErforschen.setEnabled(false);
			buttonTrekkingradStandardErforschen.setEnabled(false);
			buttonTrekkingradPremiumErforschen.setEnabled(false);
			buttonRennradStandardErforschen.setEnabled(false);
			buttonRennradPremiumErforschen.setEnabled(false);
		}
		
		/** Versicherungs Checkboxen updaten **/
		if (unternehmen.getVersicherung().isBrandschutz())
			checkboxBrandschutz.setSelected(true);
		else checkboxBrandschutz.setSelected(false);
		
		if (unternehmen.getVersicherung().isReparaturVertrag())
			checkboxReparaturvertrag.setSelected(true);
		else checkboxReparaturvertrag.setSelected(false);
		
		if (unternehmen.getVersicherung().isRechtsschutzVersicherung())
			checkboxRechtsschutz.setSelected(true);
		else checkboxRechtsschutz.setSelected(false);
		
		/**************************** BANK ********************************/
		
		
		/** Kredit1 berechnen und Kreditkonditionen anzeigen **/
		Kredit kredit1 = unternehmen.getBank().berechneKredit(1, 8, 5.0); // 8 Monate Laufzeit und 5% Zinssatz
		if (kredit1 == null){ // wenn man nicht kreditwürdig ist
			for (int i = 0; i < tableKredit1.getRowCount(); i++){
				tableKredit1.setValueAt("0", i, 1);
			}
			buttonKredit1Nehmen.setEnabled(false);
		}
		else {
			tableKredit1.setValueAt(kredit1.getKreditSumme(), 0, 1);
			tableKredit1.setValueAt(kredit1.getZinsSatz(), 1, 1);
			tableKredit1.setValueAt(kredit1.getLaufzeit(), 2, 1);
			tableKredit1.setValueAt(kredit1.getTilgung(), 3, 1);
			tableKredit1.setValueAt(kredit1.getKreditSumme(), 0, 1);
			
			buttonKredit1Nehmen.setEnabled(true);
		}
		
		
		/** Kredit2 berechnen und Kreditkonditionen anzeigen **/
		Kredit kredit2 = unternehmen.getBank().berechneKredit(2, 14, 7.5); // 14 Monate Laufzeit und 7.5% Zinsatz
		if (kredit2 == null){ // wenn man nicht kreditwürdig ist
			for (int i = 0; i < tableKredit2.getRowCount(); i++){
				tableKredit2.setValueAt("0", i, 1);
			}
			buttonKredit2Nehmen.setEnabled(false);
		}
		else {
			tableKredit2.setValueAt(kredit2.getKreditSumme(), 0, 1);
			tableKredit2.setValueAt(kredit2.getZinsSatz(), 1, 1);
			tableKredit2.setValueAt(kredit2.getLaufzeit(), 2, 1);
			tableKredit2.setValueAt(kredit2.getTilgung(), 3, 1);
			tableKredit2.setValueAt(kredit2.getKreditSumme(), 0, 1);
			
			buttonKredit2Nehmen.setEnabled(true);
		}
		
		/** Ist ein Unternehmen nicht kreditwürdig, wird das angezeigt **/
		if (kredit1 == null && kredit2 == null)
			labelKreditwuerdig.setVisible(true);
		else labelKreditwuerdig.setVisible(false);
		
		/** tableLaufendeKredite anpassen **/
		kredite = unternehmen.getBank().getAlleKredite();
		tableLaufendeKrediteModel.setRowCount(0);
		
		for (int i = 0; i < kredite.length; i++){
			if (i == tableLaufendeKrediteModel.getRowCount()){
				tableLaufendeKrediteModel.addRow(new Object[][] {{null, null, null, null, null, null, null, null, null, null}});
					
				tableLaufendeKredite.setValueAt(kredite[i].getKreditSumme() + " €", i, 0);
				tableLaufendeKredite.setValueAt(kredite[i].getTilgung()+ " €", i, 1);
				tableLaufendeKredite.setValueAt(kredite[i].getZinsSatz() + " %", i, 2);
				tableLaufendeKredite.setValueAt(kredite[i].getLaufzeit() + " Runden", i, 3);
				tableLaufendeKredite.setValueAt(kredite[i].getAnzahlNochZuTilgen() + " Mal", i, 4);
				
			}
		}
		
		if (tableLaufendeKrediteModel.getRowCount() < 3)
			tableLaufendeKrediteModel.setRowCount(3);
	}


	/**
	 * Eingabewerte zurücksetzen.
	 * Methode wird in der Klasse Planspiel in der Methode zugBeenden() aufgerufen.
	 */
	public static void resetInput(){
		comboboxFahrradAuswaehlen.setSelectedIndex(0);
		
		if (tableEinkaufen.getSelectedRow() != 0)
			tableEinkaufen.changeSelection(0, 0, true, false); // erste Zeile markieren 
		if (tableVerkaufen.getSelectedRow() != 0)
			tableVerkaufen.changeSelection(0, 0, true, false); // erste Zeile markieren 
		
		textAnzahlAnbieter1.setText("1");
		textAnzahlAnbieter2.setText("1");
		textAnzahlAnbieter3.setText("1");
		
		textAnzahl.setText("1");
	}
	

	/**
	 * Die Methode ermittelt aus der ausführlichen Bezeichnung des Materials den Materialnamen.
	 * @param bezeichnung Ausführliche Bezeichnung des Materials, wie sie in der tableEinkaufen steht.
	 * @return Gibt den materialnamen zurück, mit dem das Programm arbeiten kann.
	 */
	public static String materialnameErmitteln(String bezeichnung){
		String materialname = "";
		
		switch (bezeichnung){
			case "Mountainbike Rahmen": materialname = "mtbRahmen"; break;
			case "Trekkingrad Rahmen": materialname = "trekkingRahmen"; break;
			case "Rennrad Rahmen": materialname = "rennradRahmen"; break;
			case "Mountainbike Lenker": materialname = "mtbLenker"; break;
			case "Trekkingrad Lenker": materialname = "trekkingLenker"; break;
			case "Rennrad Lenker": materialname = "rennradLenker"; break;
			case "Mountainbike Pedal": materialname = "mtbPedal"; break;
			case "Trekkingrad Pedal": materialname = "trekkingPedal"; break;
			case "Rennrad Pedal": materialname = "rennradPedal"; break;
			case "Mountainbike Rad St.": materialname = "mtbRadStandard"; break;
			case "Mountainbike Rad Pr.": materialname = "mtbRadPremium"; break;
			case "Trekkingrad Rad St.": materialname = "trekkingRadStandard"; break;
			case "Trekkingrad Rad Pr.": materialname = "trekkingRadPremium"; break;
			case "Rennrad Rad St.": materialname = "rennradRadStandard"; break;
			case "Rennrad Rad Pr.": materialname = "rennradRadPremium"; break;
			case "Mountainbike Sattel St.": materialname = "mtbSattelStandard"; break;
			case "Mountainbike Sattel Pr.": materialname = "mtbSattelPremium"; break;
			case "Trekkingrad Sattel St.": materialname = "trekkingSattelStandard"; break;
			case "Trekkingrad Sattel Pr.": materialname = "trekkingSattelPremium"; break;
			case "Rennrad Sattel St.": materialname = "rennradSattelStandard"; break;
			case "Rennrad Sattel Pr.": materialname = "rennradSattelPremium"; break;
			case "Felgenbremsen": materialname = "felgenbremsen"; break;
			case "Scheibenbremsen": materialname = "scheibenbremsen"; break;
			case "Drehgriffschaltung": materialname = "drehgriffSchaltung"; break;
			case "Triggerschaltung": materialname = "triggerSchaltung"; break;
			case "Kette": materialname = "kette"; break;
		}
		
		return materialname;
	}
	
	
	private static double[][] createSeries(String typ) {
    	// the data (must be an array with length 2, containing two arrays of equal length, the first containing the x-values and the second containing the y-values
       
		int[] nachfrage = new int[0];
		
		switch (typ){
			case "mtbStandard":  nachfrage = Markt.getMtbStandardNachfrageArr(); break;
			case "mtbPremium":  nachfrage = Markt.getMtbPremiumNachfrageArr(); break;
			case "trekkingradStandard":  nachfrage = Markt.getTrekkingradStandardNachfrageArr(); break;
			case "trekkingradPremium":  nachfrage = Markt.getTrekkingradPremiumNachfrageArr(); break;
			case "rennradStandard":  nachfrage = Markt.getRennradStandardNachfrageArr(); break;
			case "rennradPremium":  nachfrage = Markt.getRennradPremiumNachfrageArr(); break;
		}
		
		double[][] series = new double[2][nachfrage.length];

		for (int i = 0; i < nachfrage.length; i++){
			series[0][i] = i + 1;
			series[1][i] = nachfrage[i];
		}
		return series;
    }

	
	private static void showDiagram() {
		
		   // alte Chart entfernen -> update Chart
		   panelDiagramm.removeAll();
		   panelDiagramm.revalidate(); 
			
		   // Add the series to your data set
		   DefaultXYDataset dataset = new DefaultXYDataset();
		   
		   /** abhängig von der freigeschalteten Entwicklung, einzelne Graphen anzeigen oder nicht **/
		   if (Planspiel.getAktuellesUnternehmen().getEntwicklung().isMtbStandardMarktforschung()) 
			   dataset.addSeries("Mountainbike Standard", createSeries("mtbStandard")); // bereits zu Beginn erforscht
		   if (Planspiel.getAktuellesUnternehmen().getEntwicklung().isMtbPremiumMarktforschung()) 
			   dataset.addSeries("Mountainbike Premium", createSeries("mtbPremium")); 
		   if (Planspiel.getAktuellesUnternehmen().getEntwicklung().isTrekkingradStandardMarktforschung()) 
			   dataset.addSeries("Trekkingrad Standard", createSeries("trekkingradStandard"));
		   if (Planspiel.getAktuellesUnternehmen().getEntwicklung().isTrekkingradPremiumMarktforschung()) 
			   dataset.addSeries("Trekkingrad Premium", createSeries("trekkingradPremium"));
		   if (Planspiel.getAktuellesUnternehmen().getEntwicklung().isRennradStandardMarktforschung()) 
			   dataset.addSeries("Rennrad Standard", createSeries("rennradStandard"));
		   if (Planspiel.getAktuellesUnternehmen().getEntwicklung().isRennradPremiumMarktforschung()) 
			   dataset.addSeries("Rennrad Premium", createSeries("rennradPremium"));

		   // Generate the first graph
		   JFreeChart chart = ChartFactory.createXYLineChart("Nachfrage auf dem Markt", /* Title */ "Monate", /* x-axis Label */ "Nachfrage", /* y-axis Label */ dataset, /* Dataset */ PlotOrientation.VERTICAL, /* Plot Orientation */
				   			  true, /* Show Legend */ true, /* Use tooltips */ false /* Configure chart to generate URLs? */  );
		 
		   XYPlot plot = chart.getXYPlot();
		   
		   // Abstand auf x-Ache
		   NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
		   xAxis.setTickUnit(new NumberTickUnit(1)); 
		   
		   // Abstand auf Y-Achse, abhängig von Nachfrage die Skalierung anpassen
		   int durchschnittsNachfrage = Markt.getDurchschnittsNachfrage();
		   int scale = Math.round(durchschnittsNachfrage / 6); 

		   NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
		   yAxis.setTickUnit(new NumberTickUnit(scale)); 
		   
		   ChartPanel CP = new ChartPanel(chart);
		   CP.setBounds(5, 5, 481, 396);
		   panelDiagramm.add(CP);
		   
		   panelDiagramm.repaint(); // Diagramm neu zeichnen -> update Chart
	}
	
	/**
	 * Methode wird nach 24 Runden aufgerufen und das Spiel wird beendet.
	 * Der Sieger wird ermittelt.
	 */
	private static void spielBeenden(){
		int unternehmenAnzahl = Planspiel.getAlleUnternehmen().size();
		Unternehmen[] unternehmen = new Unternehmen[unternehmenAnzahl];
		for (int i = 0; i < unternehmenAnzahl; i++){
			unternehmen[i] = Planspiel.getAlleUnternehmen().get(i);
		}
		int i = 0;
		int e = 0;
		boolean sortiert = false;
		Unternehmen temp;
			
		while (!sortiert){
			i = e;
			while (unternehmen[i + 1].getEigenkapital() > unternehmen[i].getEigenkapital()){
				temp = unternehmen[i];
				unternehmen[i] = unternehmen[i + 1];
				unternehmen[i + 1] = temp;
					
				if (i > 0)
					i--;
			}
			e++;
			if ((e + 1) == unternehmenAnzahl)
				sortiert = true;			
		}
		
		String ausgabe = "";
		for (int k = 1; k < unternehmen.length+1; k++){
			ausgabe += "Spieler \"" + unternehmen[k-1].getSpielername() + "\" hat mit einem EK von " + unternehmen[k-1].getEigenkapital() + " den " + k + ". Platz erreicht. \n";
		}
		ausgabe += "\nDas Spiel wird durch \"OK\" beendet. Vielen Dank.";
		
		JOptionPane.showMessageDialog(null, ausgabe);
		System.exit(0);	
	}
}



