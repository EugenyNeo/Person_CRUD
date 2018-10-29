package PersonAll;

import java.util.ArrayList;

public interface PersonDAO 
{
	void create ( Person p );
	ArrayList<Person> read();
	void update ( Person p );
	void delete ( Person p );

}
