package controller;

import java.util.Date;
import java.util.List;

import dao.GoddessDao;
import model.Goddess;

public class GoddessAction {
	public static void main(String[] args) throws Exception {
		GoddessDao gd = new GoddessDao();
		List<Goddess> gs = gd.query();

		for (Goddess goddess : gs) {
			System.out.println(goddess.getUserName() + "," + goddess.getAge());
		}
		System.out.println("============end=============");

	}

	static void adduser() {
		GoddessDao gd = new GoddessDao();
		Goddess g1 = new Goddess();
		g1.setUserName("小夏");
		g1.setAge(22);
		g1.setSex(1);
		g1.setBirthday(new Date());
		g1.setEmail("xiaoxia@qq.com");
		g1.setMobile("123456789");
		g1.setCreateUser("admin");
		g1.setUpdateUser("admin");
		g1.setIsDel(1);
		// 添加女神
		try {
			gd.addGoddess(g1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
