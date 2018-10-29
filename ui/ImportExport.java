package ui;

import java.util.ArrayList;
import PersonAll.Person;

public interface ImportExport 
{
	public ArrayList<Person> load ();
	public void save();
}
