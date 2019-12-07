package reflectDemo;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {

		Person p1 = new Person();
		Class c1 = p1.getClass();

		Person p2 = new Person();
		Class c2 = p2.getClass();

		Class c3 = Person.class;

		System.out.println(c1 == c2);
		System.out.println(c2 == c3);

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		Class c4 = Class.forName("reflectDemo.Person");
		System.out.println(c3 == c4);
		System.out.println(c4);
	}

}
