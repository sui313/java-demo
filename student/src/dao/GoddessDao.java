package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
import model.Goddess;

public class GoddessDao {
	public void addGoddess(Goddess g) throws Exception {
		Connection con = DBUtil.getConnection();

		String sql = "" + "insert into goddess" + "(user_name,sex,age,birthday,email,mobile,"
				+ "create_user,create_date,update_user,update_date,is_del)" + "values("
				+ "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";

		PreparedStatement psmt = con.prepareStatement(sql);

		psmt.setString(1, g.getUserName());
		psmt.setInt(2, g.getAge());
		psmt.setInt(3, g.getAge());
		psmt.setDate(4, new Date(g.getBirthday().getTime()));
		psmt.setString(5, g.getEmail());
		psmt.setString(6, g.getMobile());
		psmt.setString(7, g.getCreateUser());
		psmt.setString(8, g.getUpdateUser());
		psmt.setInt(9, g.getIsDel());

		psmt.execute();
		/**
		 * prepareStatement这个方法会将SQL语句加载到驱动程序conn集成程序中，但是并不直接执行
		 * 而是当它调用execute()方法的时候才真正执行；
		 * 
		 * 上面SQL中的参数用?表示，相当于占位符，然后在对参数进行赋值。 当真正执行时，这些参数会加载在SQL语句中，把SQL语句拼接完整才去执行。
		 * 这样就会减少对数据库的操作
		 */
	}

	public void updateGoddess() {
	}

	public void delGoddess() {
	}

	public List<Goddess> query() throws Exception {
		Connection con = DBUtil.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from goddess");

		List<Goddess> gs = new ArrayList<Goddess>();

		Goddess g = null;

		while (rs.next()) {
			g = new Goddess();

			g.setUserName(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			gs.add(g);

		}
		return gs;

	}

	public Goddess get() {
		return null;
	}
}
