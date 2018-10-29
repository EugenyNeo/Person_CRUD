package ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import PersonAll.PersonAD;

public class pMenu extends JMenuBar
{
	JMenu mFile = new JMenu("File");
	JMenuItem menuOpenFile = new JMenuItem("Open File");
	JMenuItem menuSaveFile = new JMenuItem("Save File");

	public pMenu(PersonAD dm) 
	{
		menuSaveFile.addActionListener(dm.aSave);
		menuOpenFile.addActionListener(dm.aOpen);
		
		mFile.add(menuSaveFile);
		mFile.add(menuOpenFile);
		
		add(mFile);
	}
}
