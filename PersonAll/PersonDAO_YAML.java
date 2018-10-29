package PersonAll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.WriteAbortedException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PersonDAO_YAML implements PersonDAO
{

	ArrayList<Person> pp = new ArrayList<Person>();
	Person tmp;
	String str;
//	File file = new File ("C://", "YAML.yml");
	static File file;

	private int getIndex(ArrayList<Person> pp, int id) 
	{
		int ret = -1;
		for ( int i = 0; i < pp.size(); i++ )
		{
			if ( pp.get(i).id == id )
			{
				ret = i;
				break;
			}
		}
		return ret;
	}

	private String toString(ArrayList<Person> pp) 
	{
		String s = "Person:" + "\n";
		for ( Person p:pp )
		{
			s += "- id: " + p.id + "\n" 
					+ "- fname: " + p.fname + "\n"
					+ "- lname: " + p.lname + "\n"
					+ "- age: " + p.age + "\n";
		}
		return s;
	}

	private void write(String xz) 
	{
		try 
		{
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osr = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osr);
			bw.write(xz);
			bw.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

	@Override
	public void create(Person p) 
	{
		ArrayList<Person> pp = read();
		int index = getIndex(pp, p.id);
		if ( index == -1 )
		{
			pp.add(p);
		}
		else 
			JOptionPane.showMessageDialog(null, "Такой id уже существует, попробуйте еще раз");

		String xz = toString(pp);
		write(xz);
	}

	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		tmp = new Person();

		try 
		{
			FileReader xz = new FileReader(file);
			BufferedReader bfr = new BufferedReader(xz);
			while (( str = bfr.readLine()) != null )
			{
				String[] st = str.split(" ");
				for ( int i = 1; i < st.length; i++ )
				{
					switch (st[i]) 
					{
					case "id:":
						tmp = new Person();
						tmp.id = Integer.parseInt(st[++i]);
						break;
					case "fname:":
						tmp.fname = st[++i];
						break;
					case "lname:":
						tmp.lname = st[++i];
						break;
					case "age:":
						tmp.age = Integer.parseInt(st[++i]);
						pp.add(tmp);
						break;
					}
				}
			}
			bfr.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		ArrayList<Person> pp = read();
		int index = getIndex(pp, p.id);
		if ( index != -1 )
		{
			pp.get(index).fname = p.fname;
			pp.get(index).lname = p.lname;
			pp.get(index).age = p.age;
		}
		else
			JOptionPane.showMessageDialog(null, "Такова id нет, попробуйте еще раз");
		String xz = toString(pp);
		write(xz);
	}

	@Override
	public void delete(Person p) 
	{
		ArrayList<Person> pp = read();
		int index = getIndex(pp, p.id);
		if ( index != -1 )
		{
			pp.remove(index);
		}
		else
			JOptionPane.showMessageDialog(null, "Такова id нет, попробуйте еще раз");
		String xz = toString(pp);
		write(xz);
	}
}
