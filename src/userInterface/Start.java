package userInterface;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Toolkit;

import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import spiel.Planspiel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Start {

	private JFrame frame;
	private JTextField textSpieler1;
	private JTextField textSpieler2;
	private JTextField textSpieler3;
	
	public JFrame getFrame(){
		return frame;
	}
	
	
	/** MAIN - Programm startet mit dieser Methode **/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start startWindow = new Start();
					startWindow.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/** KONSTRUKTOR **/
	public Start() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Planspiel - Fahrrad Verkauf");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		frame.setBounds(100, 100, 735, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Fenster zentrieren
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(0, 255, 232, 138);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textSpieler1 = new JTextField();
		textSpieler1.setBounds(71, 11, 152, 20);
		textSpieler1.setColumns(10);
		panel.add(textSpieler1);
		
		textSpieler2 = new JTextField();
		textSpieler2.setBounds(71, 42, 152, 20);
		textSpieler2.setColumns(10);
		panel.add(textSpieler2);
		
		textSpieler3 = new JTextField();
		textSpieler3.setBounds(71, 73, 152, 20);
		textSpieler3.setColumns(10);
		panel.add(textSpieler3);
		
		JLabel labelSpieler1 = new JLabel("Spieler 1");
		labelSpieler1.setBounds(10, 11, 51, 20);
		labelSpieler1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(labelSpieler1);
		
		JLabel labelSpieler2 = new JLabel("Spieler 2");
		labelSpieler2.setBounds(10, 42, 51, 20);
		labelSpieler2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(labelSpieler2);
		
		JLabel labelSpieler3 = new JLabel("Spieler 3");
		labelSpieler3.setBounds(10, 73, 51, 20);
		labelSpieler3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(labelSpieler3);
		
		JButton btnStarten = new JButton("Spiel starten");
		btnStarten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if ((!textSpieler1.getText().equals("")) && (!textSpieler2.getText().equals("")) && (!textSpieler3.getText().equals(""))) {
					frame.dispose();
					Planspiel.starteSpiel(textSpieler1.getText(), textSpieler2.getText(), textSpieler3.getText());
					UI.createUI(); // UI wird erstellt
					UI.updateUI(); // Werte des ersten Unternehmens ins UI laden
				} else JOptionPane.showMessageDialog(null, "Jeder Spieler benötigt einen Namen!");

			}
		});
		btnStarten.setBounds(10, 104, 213, 23);
		panel.add(btnStarten);
		
		// Label für den background
		JLabel labelBackground = new JLabel("");
		labelBackground.setIcon(new ImageIcon("bg.png"));
		labelBackground.setBounds(0, -49, 961, 525);
		frame.getContentPane().add(labelBackground);

	}	
}
