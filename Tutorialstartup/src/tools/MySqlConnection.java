package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	public static Connection con = null;

public static Connection getconnectionmysql() {
try {
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionemployees","root","1234");
} catch (ClassNotFoundException | SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return con;
}

	public static void main(String[] args) {
		Connection c = getconnectionmysql();
		System.out.println("salamo ");
	}
}