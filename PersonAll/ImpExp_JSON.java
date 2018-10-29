package PersonAll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import ui.ImportExport;

public class ImpExp_JSON implements ImportExport
{
	static ArrayList<Person> pp = null;
	File f = null;

	public ImpExp_JSON ( ArrayList<Person> pp, File f )
	{
		this.pp = pp;
		this.f = f;
	}
	
	@Override
	public ArrayList<Person> load()
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		Person tmp = null;
		String str = null;
		try 
		{
			FileInputStream fin = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fin);
			BufferedReader br = new BufferedReader(isr);
			str = br.readLine();
			br.close();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		} 

		if ( str.equals("")) return pp;

		String[] st = str.split("[\\W]+");
//		String[] st = str.split(" ");
		if ( !st[1].equals("Persons")) {}
		else 
		{
			for ( int i = 1; i < st.length; i++ )
			{
				switch (st[i]) 
				{
				case "id":
					tmp = new Person();
					tmp.id = Integer.parseInt(st[++i]);
					break;
				case "fname":
					tmp.fname = st[++i];
					break;
				case "lname":
					tmp.lname = st[++i];
					break;
				case "age":
					tmp.age = Integer.parseInt(st[++i]);
					pp.add(tmp);
					break;
				}
			}
		}
		return pp;
	}
	
	@Override
	public void save() 
	{
		String xz = toString(pp);
		write(xz);
	}
	
	private String toString(ArrayList<Person> pp) 
	{
		String s = "{\"Persons\":[";
		for ( Person p:pp )
		{
			s = s + "{\"id\":" + p.id + ",\"fname\":" + p.fname + ",\"lname\":" + p.lname + ",\"age\":" + p.age + "},";
		}
		s = s.substring(0, s.length()-1);
		s = s + "]}";
		return s;
	}

	private void write(String xz) 
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osr = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osr);
			bw.write(xz);
			bw.flush();
			bw.close();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		} 
	}
}
