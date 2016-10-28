package userInterface;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import spiel.Cashflow;
import spiel.Planspiel;


public class UICashflow {

	private static JDialog dialog;
	private static JTable tableCashflow;
	private static DefaultTableModel tableModel;
	private static JLabel labelEigenkapitalWert;
	private static JLabel labelFremdkapitalWert;
	private static JLabel labelCashflowVorZinsWert;
	private static JLabel labelCashflowNachZinsWert;
	
	/**
	 * @wbp.parser.entryPoint
	 * UI wird erstellt, das die Produktionsliste anzeigt
	 */
	public static void erstellen(JFrame frame){
	
		dialog = new JDialog(frame, Dialog.ModalityType.DOCUMENT_MODAL);   
		dialog.setTitle("Kapitalstruktur / Cashflow");
		dialog.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		dialog.setResizable(false);
		dialog.setBounds(100, 100, 593, 335);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().setLayout(null);
		
		// Fenster zentrieren
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		dialog.setLocation(dim.width/2-dialog.getSize().width/2, dim.height/2-dialog.getSize().height/2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 74, 589, 234);
		dialog.getContentPane().add(scrollPane);
		
		tableCashflow = new JTable();
		tableCashflow.setEnabled(false);
		tableCashflow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCashflow.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableModel = new DefaultTableModel(
				new Object[][] {
						{null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null},
					},
					new String[] {
						"Runde", "Umsatzerl\u00F6se", "Materialkosten", "Geh\u00E4lter", "Fixkosten", "Versicherungen", "Lager Geb\u00FChren", "Marktforschung", "Sonstige", "Zinsen", "Cashflow vor Zins", "Cashflow nach Zins"
					}
				){
					private static final long serialVersionUID = 1L;
					
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
						String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
					};
					
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
			};
		tableCashflow.setModel(tableModel);
		tableCashflow.getColumnModel().getColumn(0).setPreferredWidth(65);
		tableCashflow.getColumnModel().getColumn(1).setPreferredWidth(85);
		tableCashflow.getColumnModel().getColumn(2).setPreferredWidth(87);
		tableCashflow.getColumnModel().getColumn(3).setPreferredWidth(75);
		tableCashflow.getColumnModel().getColumn(4).setPreferredWidth(70);
		tableCashflow.getColumnModel().getColumn(5).setPreferredWidth(93);
		tableCashflow.getColumnModel().getColumn(6).setPreferredWidth(98);
		tableCashflow.getColumnModel().getColumn(7).setPreferredWidth(98);
		tableCashflow.getColumnModel().getColumn(10).setPreferredWidth(105);
		tableCashflow.getColumnModel().getColumn(11).setPreferredWidth(115);
		scrollPane.setViewportView(tableCashflow);
		
		JLabel labelEigenkapital = new JLabel("Eigenkapital:");
		labelEigenkapital.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEigenkapital.setBounds(10, 11, 81, 23);
		dialog.getContentPane().add(labelEigenkapital);
		
		labelEigenkapitalWert = new JLabel("1000000");
		labelEigenkapitalWert.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEigenkapitalWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEigenkapitalWert.setBounds(95, 11, 110, 23);
		dialog.getContentPane().add(labelEigenkapitalWert);
		
		JLabel labelFremdkapital = new JLabel("Fremdkapital:");
		labelFremdkapital.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelFremdkapital.setBounds(10, 37, 93, 23);
		dialog.getContentPane().add(labelFremdkapital);
		
		labelFremdkapitalWert = new JLabel("500000");
		labelFremdkapitalWert.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFremdkapitalWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelFremdkapitalWert.setBounds(105, 37, 100, 23);
		dialog.getContentPane().add(labelFremdkapitalWert);
		
		JLabel labelCashflowVorZins = new JLabel("Durschnittlicher Cashflow vor Zins:");
		labelCashflowVorZins.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCashflowVorZins.setBounds(247, 11, 236, 23);
		dialog.getContentPane().add(labelCashflowVorZins);
		
		labelCashflowVorZinsWert = new JLabel("50000");
		labelCashflowVorZinsWert.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCashflowVorZinsWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCashflowVorZinsWert.setBounds(442, 11, 110, 23);
		dialog.getContentPane().add(labelCashflowVorZinsWert);
		
		JLabel labelCashflowNachZins = new JLabel("Durschnittlicher Cashflow nach Zins:");
		labelCashflowNachZins.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCashflowNachZins.setBounds(247, 37, 236, 23);
		dialog.getContentPane().add(labelCashflowNachZins);
		
		labelCashflowNachZinsWert = new JLabel("50000");
		labelCashflowNachZinsWert.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCashflowNachZinsWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCashflowNachZinsWert.setBounds(442, 37, 110, 23);
		dialog.getContentPane().add(labelCashflowNachZinsWert);
		
	
		tabelleLaden();
		dialog.setVisible(true);
	}
	
	/** Es werden alle Einträge aus der Produktionsliste ausgelesen und im UI angezeigt **/
	private static void tabelleLaden(){
		tableModel.setRowCount(0);
		Cashflow[] cashflow = Planspiel.getAktuellesUnternehmen().getAlleCashflows();
		
		for (int i = 0; i < cashflow.length; i++){
			if (i == tableCashflow.getRowCount())
				tableModel.addRow(new Object[][] {{null, null, null, null, null, null, null, null, null, null, null, null}});
				
			tableCashflow.setValueAt("Runde " + cashflow[i].getRunde(), i, 0);
			tableCashflow.setValueAt(cashflow[i].getUmsatzerloese() + " €", i, 1);
			tableCashflow.setValueAt(cashflow[i].getMaterialKosten() + " €", i, 2);
			tableCashflow.setValueAt(cashflow[i].getGehaelter() + " €", i, 3);
			tableCashflow.setValueAt(cashflow[i].getFixkosten() + " €", i, 4);
			tableCashflow.setValueAt(cashflow[i].getVersicherungen() + " €", i, 5);
			tableCashflow.setValueAt(cashflow[i].getLagerGebuehren() + " €", i, 6);
			tableCashflow.setValueAt(cashflow[i].getMarktforschungsKosten() + " €", i, 7);
			tableCashflow.setValueAt(cashflow[i].getSonstige() + " €", i, 8);
			tableCashflow.setValueAt(cashflow[i].getZinsen() + " €", i, 9);
			tableCashflow.setValueAt(cashflow[i].getCashflowVorZins() + " €", i, 10);
			tableCashflow.setValueAt(cashflow[i].getCashflowNachZins() + " €", i, 11);
		}
		
		if (tableModel.getRowCount() < 3)
			tableModel.setRowCount(3);
		
		
		/** Werte für die Label setzen **/
		
		labelCashflowVorZinsWert.setText((Math.round(Planspiel.getAktuellesUnternehmen().getDurchschnittsCashflowVorZins() * 100) / 100.0) + " €"); // auf 2 Nachkommastellen runden
		labelCashflowNachZinsWert.setText((Math.round(Planspiel.getAktuellesUnternehmen().getDurchschnittsCashflowNachZins() * 100) / 100.0) + " €"); // auf 2 Nachkommastellen runden
		labelEigenkapitalWert.setText((Math.round(Planspiel.getAktuellesUnternehmen().getEigenkapital() * 100) / 100.0) + " €"); // auf 2 Nachkommastellen runden
		labelFremdkapitalWert.setText((Math.round(Planspiel.getAktuellesUnternehmen().getFremdkapital() * 100) / 100.0) + " €"); // auf 2 Nachkommastellen runden
		
	}
}
