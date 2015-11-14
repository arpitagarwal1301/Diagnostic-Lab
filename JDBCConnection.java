import java.sql.*;

class JDBCConnection
{
   private static Connection con=null;
   private JDBCConnection(){}
   public static Connection getConnection()
   {
   	if(con==null)
   	{
   		try
   		{
   			Class.forName("oracle.jdbc.driver.OracleDriver");
   			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","dlab","dlab");
	   	}
	   	catch(ClassNotFoundException ce)
	   	{
	   		ce.printStackTrace();
	   	}	
   		catch(SQLException sqe)
   		{
   				sqe.printStackTrace();
   		}	
   	}
   	return con;
   }
}