package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

	private static final String URL = "jdbc:mysql://192.168.101.156:3306/java";

	private static final String URL2 = "jdbc:mysql://192.168.101.156:3306/java?useSSL=false&serverTimezone=UTC";

	private static final String NAME = "root";

	private static final String PASSWORD = "SuiLiu123456";

	public static void main(String[] args) {
		try {

			// Class.forName("com.mysql.jdbc.Driver"); // com.mysql.jdbc.Driver
			// Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);

			Class.forName("com.mysql.cj.jdbc.Driver");

			// conn =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/test_demo?useSSL=false&serverTimezone=UTC","root","password");
			Connection connection = DriverManager.getConnection(URL2, NAME, PASSWORD);

			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("select * from student");

			while (rs.next()) {

				System.out.println(rs.getString("name") + "," + rs.getInt("age"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
