package PersonAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO_SQL implements PersonDAO
{
	ArrayList <Person> pp = new ArrayList<Person>();

	@Override
	public void create(Person p)
	{
		String arg = "INSERT INTO xyz (id, fname, lname, age) \n" +
				" VALUES ("+p.id+", '"+p.fname+"', '"+p.lname+"', "+p.age+");";

		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz", "root", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(arg);
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read()
	{
		pp = new ArrayList<Person>();
		
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz", "root", "");
			Statement stmn = (Statement) con.createStatement();
			ResultSet rs = stmn.executeQuery("select * from xyz");

			while(rs.next())
			{
				pp.add(new Person(rs.getInt(1), rs.getString("fname"), rs.getString("lname"), rs.getInt(4)));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return pp;
	}

	@Override
	public void update(Person p)
	{
		String arg = "UPDATE xyz SET fname='"+p.fname+"', lname='"+p.lname+"', age="+p.age+" WHERE xyz.id="+p.id+";";

		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz", "root", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(arg);
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p)
	{
		String arg = "DELETE FROM `xyz` WHERE `id`=" + p.id;
		
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz", "root", "");
			Statement stmt = (Statement) con.createStatement();
			stmt.executeUpdate(arg);
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

}