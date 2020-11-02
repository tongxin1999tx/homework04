package tools;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.sql.Connection;

public class JdbcUtil {
	private static String username = "root";
	private static String password = "123";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/excise?useSSL=false";
 
	private Connection conn;
	static { 
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	public JdbcUtil() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	public Connection getConn() {
		return conn;
	}

	
	
}
