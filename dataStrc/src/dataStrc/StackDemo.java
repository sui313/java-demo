package dataStrc;


import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo {
	static void showpush(Stack<Integer> st,int a) {
		st.push(new Integer(a));
		System.out.println("push: ( "+a+" )");
		System.out.println("stack:"+st);
	}
	
	static void showpop(Stack<Integer> st) {
		System.out.println("pop-> ");
		Integer a = (Integer)st.pop();
		System.out.println(a);
		System.out.println("stack:"+st);
	}
	
	public static void print() {
		Stack<Integer> st = new Stack<Integer>();
		System.out.println("stack:"+st);
		showpush(st,42);
		showpush(st,43);
		showpush(st,44);
		showpush(st,45);
		showpop(st);
		showpop(st);
		showpop(st);
		showpop(st);
		try {
			showpop(st);
		} catch (EmptyStackException e) {
			// TODO: handle exception
			  System.out.println("empty stack"+e.getStackTrace()[0]);
		}
	}
} 
