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

import spiel.Planspiel;
import spiel.Verkauft;


public class UIVerkauft {


	private static JDialog dialog;
	private static JTable tableProduktionsliste;
	private static DefaultTableModel tableModel;
	
	/**
	 * @wbp.parser.entryPoint
	 * UI wird erstellt, das die Produktionsliste anzeigt
	 */
	public static void erstellen(JFrame frame){
	
		dialog = new JDialog(frame, Dialog.ModalityType.DOCUMENT_MODAL);   
		dialog.setTitle("Verkaufte Fahrräder");
		dialog.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		dialog.setResizable(false);
		dialog.setBounds(100, 100, 434, 148);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().setLayout(null);
		
		// Fenster zentrieren
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		dialog.setLocation(dim.width/2-dialog.getSize().width/2, dim.height/2-dialog.getSize().height/2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 428, 123);
		dialog.getContentPane().add(scrollPane);
		
		tableProduktionsliste = new JTable();
		tableProduktionsliste.setEnabled(false);
		tableProduktionsliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableModel = new DefaultTableModel(
				new Object[][] {
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
					},
					new String[] {
						"Runde", "Fahrrad", "Anzahl", "St\u00FCckpreis", "Gesamtpreis"
					}
				) {
					private static final long serialVersionUID = 1L;
					
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
							String.class, String.class, Integer.class, Integer.class, Integer.class
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
		tableProduktionsliste.setModel(tableModel);
		tableProduktionsliste.getColumnModel().getColumn(0).setPreferredWidth(55);
		tableProduktionsliste.getColumnModel().getColumn(1).setPreferredWidth(115);
		tableProduktionsliste.getColumnModel().getColumn(2).setPreferredWidth(45);
		tableProduktionsliste.getColumnModel().getColumn(3).setPreferredWidth(45);
		tableProduktionsliste.getColumnModel().getColumn(4).setPreferredWidth(55);
		scrollPane.setViewportView(tableProduktionsliste);
		
		addVerkaufsposten();
		
		dialog.setVisible(true);
	}
	
	/**
	 * Es werden alle Einträge aus der Produktionsliste ausgelesen und im UI angezeigt.
	 */
	private static void addVerkaufsposten(){
		tableModel.setRowCount(0);
		Verkauft[] verkauft = Planspiel.getAktuellesUnternehmen().getVerkaufteFahrraeder();
		
		for (int i = 0; i < verkauft.length; i++){
			if (i == tableProduktionsliste.getRowCount())
				tableModel.addRow(new Object[][] {{null, null, null, null, null}});
				
			tableProduktionsliste.setValueAt(verkauft[i].getRunde() + ". Runde", i, 0);
			tableProduktionsliste.setValueAt(verkauft[i].getFahrradBezeichnung(), i, 1);
			tableProduktionsliste.setValueAt(verkauft[i].getAnzahl() + " Stk.", i, 2);
			tableProduktionsliste.setValueAt(verkauft[i].getPreis() + " €", i, 3);
			tableProduktionsliste.setValueAt(verkauft[i].getAnzahl() * verkauft[i].getPreis() + " €", i, 4);
		}
		
		if (tableModel.getRowCount() == 0)
			tableModel.setRowCount(3);
	}
}