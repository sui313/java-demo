package object;

public class SubSalary extends Salary {
	//private double salary;

	public SubSalary(String name, String address, int number, double salary) {
		super(name, address, number, salary);
		setSalary(salary);
	}

	public void mailCheck() {
		System.out.println("SubSalary111 类的 mailCheck 方法 ");
		System.out.println("邮寄支票给：" + getName() + " ，工资为：" + getSalary());
	}

	
}
