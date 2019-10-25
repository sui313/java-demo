package dataStrc;

import java.util.Enumeration;
import java.util.Vector;

public class Enumer {
	public void print() {
		Enumeration<String> days;
		Vector<String> dayNames = new Vector<String>();
		dayNames.add("Sunday");
		dayNames.add("Monday");
		dayNames.add("Tuesday");
		dayNames.add("Wednesday");
		dayNames.add("Thursday");
		dayNames.add("Friday");
		dayNames.add("Staurday");
		days = dayNames.elements();

		while (days.hasMoreElements()) {
			String string = ((String) days.nextElement());
			System.out.println(string);
		}
	}

}
