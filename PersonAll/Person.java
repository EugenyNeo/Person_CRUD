package PersonAll;

public class Person 
{
	public int id;
	public String fname;
	public String lname;
	public int age;
	
	public Person ()
	{
		
	}
	
	public Person (int id, String fname, String lname, int age)
	{
		init ( id, fname, lname , age );
	}
	
	public void init ( int id, String fname, String lname,  int age )
	{
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	
	@Override
	public String toString()
	{
		String s = "id = " + id + " fname = " + fname + " lname = " + lname + " age = "+age;
		return s;
	}

}
