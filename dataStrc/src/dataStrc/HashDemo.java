package dataStrc;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HashDemo {
	public static void map() {
		Map m = new HashMap();
		m.put("key1", "value1");
		m.put(2.2, "value2");
		m.put("key3", "value3");
		m.put("key4", "value4");
		m.put(5, 55);
		System.out.println();
		System.out.println(" Map Elements");
		System.out.print("\t" + m);
	}

	public static void table() {
		Hashtable balance = new Hashtable();

		Enumeration names;
		String str;
		double bal;

		balance.put("Zara", new Double(3434.34));
		balance.put("Mahnaz", new Double(123.22));
		balance.put("Ayan", new Double(1378.00));
		balance.put("Daisy", new Double(99.22));
		balance.put("Qadir", new Double(-19.08));

		// Show all balances in hash table.
		names = balance.keys();
		while (names.hasMoreElements()) {
			str = (String) names.nextElement();
			System.out.println(str + ": " + balance.get(str));
		}
		System.out.println();
		// Deposit 1,000 into Zara's account
		bal = ((Double) balance.get("Zara")).doubleValue();
		balance.put("Zara", new Double(bal + 1000));
		System.out.println("Zara's new balance: " + balance.get("Zara"));
	}

	public static void properties() {
		Properties capitals = new Properties();
		Set states;
		String str;

		capitals.put("Illinois", "Srpingfield");
		capitals.put("Missouri", "Jefferson city");
		capitals.put("Washington", "Olympia");
		capitals.put("California", "Sacramento");
		capitals.put("Californiaa", "Sacramentoa");
		capitals.put("Indiana", "Indianapolis");

		states = capitals.keySet();
		Iterator itr = states.iterator();

		while (itr.hasNext()) {
			str = (String) itr.next();
			System.out.println("The capital of " + str + " is " + capitals.getProperty(str) + ".");
		}

		System.out.println();

		str = capitals.getProperty("Florida", "Not found");
		System.out.println("The capital of Florida is " + str + ".");
	}
}
