package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL_STRING = "jdbc:mysql://192.168.101.156:3306/java?useSSL=false&serverTimezone=UTC&&characterEncoding=utf-8";
	private static final String NAME_STRING = "root";
	private static final String PASSWORD_STRING = "SuiLiu123456";

	private static Connection conn = null;

	// 静态模块（将加载驱动、连接数据库放入静态块中）
	static {
		try {
			// 1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.获取数据库的连接
			conn = DriverManager.getConnection(URL_STRING, NAME_STRING, PASSWORD_STRING);

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}

//	public static void main(String[] args) throws Exception {
//
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("select * from student");
//		while (rs.next()) {
//			System.out.println(rs.getString("name") + "," + rs.getInt("age"));
//		}
//	}
}
