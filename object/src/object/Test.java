package object;

public class Test {
	 public static void main(String [] args) {
		 Salary s = new Salary("Ա�� A", "����", 3, 3600.00);
	      Employee e = new SubSalary("Ա�� B", "�Ϻ�", 2, 2400.00);
	      System.out.println("ʹ�� Salary �����õ��� mailCheck -- ");
	      s.mailCheck();
	      System.out.println("\nʹ�� Employee �����õ��� mailCheck--");
	      e.mailCheck();
	      e.computePay();
	    }
}
