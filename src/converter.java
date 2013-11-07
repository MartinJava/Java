package jAVAproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Currencyconverter implements ActionListener {
    JFrame converterFrame;
    JPanel converterPanel;
    JTextField Eur;
    JLabel Label1, Label2;
    JButton convertcurr;
    public Currencyconverter() {
	converterFrame = new JFrame("Convert Eur to Usd");
	converterPanel = new JPanel();
	converterPanel.setLayout(new GridLayout(2, 2));
	addWidgets();
	converterFrame.getContentPane().add(converterPanel, BorderLayout.CENTER);
        converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	converterFrame.pack();
	converterFrame.setVisible(true);
    }
    private void addWidgets() {
	Eur = new JTextField(2);
	Label1 = new JLabel("Eur", SwingConstants.LEFT);
	convertcurr = new JButton("Convert...");
	Label2 = new JLabel("Usd", SwingConstants.LEFT);
	convertcurr.addActionListener(this);
	converterPanel.add(Eur);
	converterPanel.add(Label1);
	converterPanel.add(convertcurr);
	converterPanel.add(Label2);
        Label1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	Label2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
    public void actionPerformed(ActionEvent event) {
        int USD = (int)((Double.parseDouble(Eur.getText()))
                             * 1.43);
	Label2.setText(USD + " Dollars");
    }
    public static void main(String[] args) {
	try {
	    UIManager.setLookAndFeel(
		UIManager.getCrossPlatformLookAndFeelClassName());
	} catch(Exception e) {}

	Currencyconverter converter = new Currencyconverter();
    }
}
