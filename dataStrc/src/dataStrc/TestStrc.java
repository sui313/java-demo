package dataStrc;

import java.io.*;

public class TestStrc {

	public static void ser() {
		Employee e = new Employee();
		e.name = "Reyan Ali";
		e.address = "Phokka Kuan, Ambehta Peer";
		e.SSN = 11122333;
		e.number = 101;
		try {
			FileOutputStream fileOut = new FileOutputStream("./employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /tmp/employee.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static void deser() {
		Employee e = null;
		try {
			FileInputStream fileIn = new FileInputStream("./employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (Employee) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized Employee...");
		System.out.println("Name: " + e.name);
		System.out.println("Address: " + e.address);
		System.out.println("SSN: " + e.SSN);
		System.out.println("Number: " + e.number);
	}

	public static void main(String args[]) {

		Enumer enumer = new Enumer();
		enumer.print();

		VectorDemo eDemo = new VectorDemo();
		eDemo.print();

		StackDemo sd = new StackDemo();
		sd.print();

		HashDemo hash = new HashDemo();
		hash.map();
		System.out.println();
		hash.table();
		System.out.println();
		hash.properties();
		ser();
		deser();
	}

}
