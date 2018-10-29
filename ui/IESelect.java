package ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;

import PersonAll.ImpExp_JSON;
import PersonAll.Person;

public class IESelect 
{
	public static ImportExport getIE ( File file, ArrayList<Person> pp )
	{
		ImportExport ie = null;
		
		String name = file.getName();
																////		name = name.toLowerCase(Locale.ENGLISH); - для преобразования в нижний регистр eng
		if ( name.endsWith("json"))
		{
			ie = new ImpExp_JSON(pp, file);
		}
		else 
			JOptionPane.showMessageDialog(null, "xz");
		return ie;
	}
}
