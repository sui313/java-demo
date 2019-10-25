package object;

public class Salary extends Employee {
	private double salary; // ȫ�깤��
	   public Salary(String name, String address, int number, double salary) {
	       super(name, address, number);
	       setSalary(salary);
	   }
	   public void mailCheck() {
	       System.out.println("Salary ��� mailCheck ���� ");
	       System.out.println("�ʼ�֧Ʊ����" + getName()
	       + " ������Ϊ��" + salary);
	   }
	   public double getSalary() {
	       return salary;
	   }
	   public void setSalary(double newSalary) {
	       if(newSalary >= 0.0) {
	          salary = newSalary;
	       }
	   }
	   public double computePay() {
			System.out.println("class Salary ���㹤�ʣ�������" + getName());
			return salary / 52;
		}
}
