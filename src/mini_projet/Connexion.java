package mini_projet;


import java.sql.Connection;
import java.sql.DriverManager;


public class Connexion {
	Connection connection;
	
	public Connexion()
	{
		
		
		String url="jdbc:mysql://localhost:3307/Base1";
		try {
		connection=DriverManager.getConnection(url,"root","1A2Z3E4R5T");
		
		}
		
		catch(Exception exp)
		{
			System.out.println(exp);
		}
		
		
	}
	
	 public Connection getConnect() {
	        return connection;
	    }

}
