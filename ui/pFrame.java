package ui;

import javax.swing.JFrame;

import PersonAll.PersonAD;

public class pFrame extends JFrame
{
	public pFrame()
	{
		setLayout(null);
		setBounds( 10, 10, 1280, 720 );
		setTitle(" Person Data Base ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add( new pPanel() );
		PersonAD dm = new PersonAD();
		pMenu mnu = new pMenu(dm);
		setJMenuBar(mnu);
		setVisible(true);
		
	}

}
