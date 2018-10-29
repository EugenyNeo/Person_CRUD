package ui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import PersonAll.PersonAD;


public class pPanel extends JPanel 
{	
	public static JTable tb;
	public pPanel()
	{
		setLayout(null);
		PersonAD dm = new PersonAD();

		tb = new JTable(dm);
		JScrollPane scr = new JScrollPane(tb);
		scr.setBounds(10, 10, 500, 580);
		add( scr );
		
		pButton pb = new pButton(dm);
		pb.setBounds(550, 110, 300, 380);
		add( pb );

		setBackground(Color.LIGHT_GRAY);
		setBounds(10, 10, 2000, 2000);
	}
}
