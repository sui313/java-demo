package object;

public class SubSalary extends Salary {
	//private double salary;

	public SubSalary(String name, String address, int number, double salary) {
		super(name, address, number, salary);
		setSalary(salary);
	}

	public void mailCheck() {
		System.out.println("SubSalary111 ��� mailCheck ���� ");
		System.out.println("�ʼ�֧Ʊ����" + getName() + " ������Ϊ��" + getSalary());
	}

	
}
