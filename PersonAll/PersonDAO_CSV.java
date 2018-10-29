package PersonAll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PersonDAO_CSV implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();
	Person tmp;
	String str;
	File file = new File ("C://", "CSV.csv");

	private int getIndex(ArrayList<Person> pp, int id)
	{
		int ret = -1;
		for (int i = 0; i < pp.size(); i++)
		{
			if(pp.get(i).id == id)
			{
				ret = i;
				break;
			}
		}
		return ret;
	}

	private String toString ( ArrayList<Person> pp )
	{
		String s = "{\\\"Persons\\\":[";
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
			FileOutputStream fos = new FileOutputStream(file);
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

	@Override
	public void create(Person p) 
	{
		ArrayList<Person> pp = read();
		int index = getIndex(pp, p.id);
		if ( index == -1)
			pp.add(p);
		else 
			JOptionPane.showMessageDialog(null, " Такой id уже существует, попробуйте еще раз ");
		String xz = toString(pp);
		write(xz);
	}

	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		tmp = null;
		try 
		{
			FileInputStream fin = new FileInputStream(file);
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
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		ArrayList<Person> pp = read();
		int index = getIndex(pp, p.id);
		if ( index != -1)
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
