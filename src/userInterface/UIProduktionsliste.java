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
import javax.swing.JButton;

import spiel.Fahrrad;
import spiel.Planspiel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UIProduktionsliste {


	private static JDialog dialog;
	private static JTable tableProduktionsliste;
	private static DefaultTableModel tableModel;
	
	/**
	 * @wbp.parser.entryPoint
	 * UI wird erstellt, das die Produktionsliste anzeigt
	 */
	public static void erstellen(JFrame frame){
	
		dialog = new JDialog(frame, Dialog.ModalityType.DOCUMENT_MODAL);   
		dialog.setTitle("Produktionsliste");
		dialog.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		dialog.setResizable(false);
		dialog.setBounds(100, 100, 345, 182);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().setLayout(null);
		
		// Fenster zentrieren
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		dialog.setLocation(dim.width/2-dialog.getSize().width/2, dim.height/2-dialog.getSize().height/2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 343, 119);
		dialog.getContentPane().add(scrollPane);
		
		tableProduktionsliste = new JTable();
		tableProduktionsliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableModel = new DefaultTableModel(
				new Object[][] {
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null},
						{null, null}
					},
					new String[] {
						"Fahrrad", "Anzahl"
					}
				){
					private static final long serialVersionUID = 1L;
					
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
					String.class, String.class
					};
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					// Zellen sollen nicht editierbar sein
					@Override
				    public boolean isCellEditable(int row, int column) {
				       return false;
				    }
				};
		tableProduktionsliste.setModel(tableModel);
		tableProduktionsliste.getColumnModel().getColumn(1).setPreferredWidth(30);
		scrollPane.setViewportView(tableProduktionsliste);
		
		JButton buttonProduktionsauftragLoeschen = new JButton("Ausgew\u00E4hlten Produktionsauftrag l\u00F6schen");
		buttonProduktionsauftragLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int selectedRow = tableProduktionsliste.getSelectedRow();
					Planspiel.getAktuellesUnternehmen().getFabrik().deleteEintragInProduktionsliste(selectedRow);
					UI.updateUI();
					produktionslisteHinzufuegen();
				}
				catch (IndexOutOfBoundsException e){
					
				}
			}
		});
		buttonProduktionsauftragLoeschen.setBounds(10, 125, 319, 23);
		dialog.getContentPane().add(buttonProduktionsauftragLoeschen);
	
		produktionslisteHinzufuegen();
		
		dialog.setVisible(true);
	}
	
	/**
	 * Es werden alle Einträge aus der Produktionsliste ausgelesen und im UI angezeigt.
	 */
	private static void produktionslisteHinzufuegen(){
		tableModel.setRowCount(0);
		Fahrrad[] f = Planspiel.getAktuellesUnternehmen().getFabrik().getProduktionsliste();
		
		for (int i = 0; i < f.length; i++){
			if (i == tableProduktionsliste.getRowCount())
				tableModel.addRow(new Object[][] {{null, null}});
				
			tableProduktionsliste.setValueAt(f[i].getName(), i, 0);
			tableProduktionsliste.setValueAt(f[i].getAnzahl(), i, 1);
		}
		
		if (tableModel.getRowCount() == 0)
			tableModel.setRowCount(3);
	}
}
