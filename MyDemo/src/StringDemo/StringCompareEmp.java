package StringDemo;

import java.util.regex.*;

import com.sun.org.apache.bcel.internal.generic.AALOAD;


public class StringCompareEmp {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str = "Hello world";
		String anotherString = "hello world";

		Object objstr = str;

		System.out.println(str.compareTo(anotherString));
		System.out.println(str.compareToIgnoreCase(anotherString));
		System.out.println(str.compareTo(objstr.toString()));
		System.out.println('h' - 'g');
//		SearchlastString();
//		substring();
//		replace();
//		strReverse();
//		splitAndJoin();
	}

	/**
	 * 字符串搜索
	 * 
	 */
	public static void SearchlastString() {
		String strorig = "Hello world, Hello Runoob";
		String findStr = "world";
		int lastIndex = strorig.indexOf(findStr);
		if (lastIndex == -1) {
			System.out.println("没有找到字符串 " + findStr);
		} else {
			System.out.println(findStr + " 字符串最后出现的位置： " + lastIndex);
		}
	}

	/**
	 * 字符串删除
	 */
	public static void substring() {
		String str = "this is Java";
		System.out.println(str.substring(0, 3) + str.substring(3 + 1));
		System.out.println(str);
	}

	/**
	 * 字符替换
	 */

	public static void replace() {
		String str = " Hello world ";
		System.out.println(str.replace("He", "aa"));
		System.out.println(str.replaceAll("l", "nn"));
		System.out.println(str.replaceFirst("l", "M"));

		String regStr = "[abcdHor]";
	
		Pattern pattern   =   Pattern.compile(regStr);
        Matcher matcher   =   pattern.matcher(str); // 替换 a、b、c、d、H 为空，即删除这几个字母
        String reStr = matcher.replaceAll("2").trim();
        System.out.println( reStr+"_" );
	}
	
	//字符串反转
	public static void strReverse() {
		String str = "hello world";
		String str2 = new StringBuffer(str).reverse().toString();
		System.out.println(str2);
	}
	
	public static void splitAndJoin() {
		String str = "abc.aaa-bbb.ccc-eee";
		String []strArr = str.split("-");
		for (String s : strArr) {
			System.out.println(s);
		}
		String str3=String.join("+", strArr);
		System.out.println(str3);
	}
	
	public static void StringConcatenate() {
		
	}
}
