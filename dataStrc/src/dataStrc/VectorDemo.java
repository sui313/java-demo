package dataStrc;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
	Vector vector = new Vector(4);
	public void print() {
		System.out.println("size:"+vector.size());
		System.out.println("capacity:"+vector.capacity());
		
		vector.add("abcd");
		vector.add(1234);
		vector.add(3.1415926);
		vector.add(new Enumer());
		vector.add(new Integer(111));
		vector.add(new Double(111));
		
		System.out.println("size:"+vector.size());
		System.out.println("capacity:"+vector.capacity());
		
		
		System.out.println("first:"+vector.firstElement());
		System.out.println("last:"+vector.lastElement());
		System.out.println("index 3:"+vector.get(3));
		
		vector.remove(new Double(3.1415926));
		
		for (int i=0;i<vector.size();i++) {
			System.out.println("index "+i+":"+vector.get(i));
		}
		
		Enumeration vEnum = vector.elements();
		 while(vEnum.hasMoreElements())
	         System.out.print(vEnum.nextElement() + " ");
	}
	
}
