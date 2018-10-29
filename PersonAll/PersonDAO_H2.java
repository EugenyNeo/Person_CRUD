package PersonAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO_H2 implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();
	
	@Override
	public void create(Person p) 
	{
		 String arg = "INSERT INTO person (id, fname, lname, age) \n" +
	                " VALUES ("+p.id+", "+p.fname+", "+p.lname+", "+p.age+");";

	  try
	  {
	   Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	   Statement stmt = con.createStatement();
	   stmt.executeUpdate(arg);
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
		   Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		   Statement stmn = (Statement) con.createStatement();
		   ResultSet rs = stmn.executeQuery("select * from person");

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
		String arg = "UPDATE person SET fname='"+p.fname+"', lname='"+p.lname+"', age="+p.age+" WHERE person.id="+p.id+";";

		  try
		  {
		   Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		   Statement stmt = con.createStatement();
		   stmt.executeUpdate(arg);
		  }
		  catch (SQLException e)
		  {
		   e.printStackTrace();
		  }
	}

	@Override
	public void delete(Person p) 
	{
		String arg = "DELETE FROM person WHERE person.id="+p.id+";";

		  try
		  {
		   Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		   Statement stmt = con.createStatement();
		   stmt.executeUpdate(arg);
		  }
		  catch (SQLException e)
		  {
		   e.printStackTrace();
		  }
		 }
	}


