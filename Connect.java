package Login1;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Connect {
	static Connection getConnection()
	{
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/projectnewspaper","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String args[])
	{
		getConnection();
	}

}
