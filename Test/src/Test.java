import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.tools.javac.util.Log;

public class Test {
	static String l = "急急急";
	String s = "dasdfs第三方付多少";

	public void print() {
		System.out.println("222222222:" + s);
	}

	public static void main(String[] args) throws IOException {
		char c1 = 'a';
		int i1 = c1;
		System.out.println("char121212:" + i1);
		Test t = new Test();
		System.out.println("111111111:" + t.l);
		t.print();
		System.out.println("111111111:" + t.s);
		Employee ep = new Employee();
		double ss = ep.print(100000);
		System.out.println("111111111:" + ss);
		Integer a = 0;
		a += 10;
		System.out.println(a);
		System.out.println(Math.sin(Math.PI / 2));

		TestString testString = new TestString();
		testString.print();

		PrintDate pDate = new PrintDate();
		pDate.print();

		TestRegex tRegex = new TestRegex();
		tRegex.phoneNum("a1533880829888a");

		TestMethod tMethod1 = new TestMethod(1);
		TestMethod tMethod2 = new TestMethod(2);
		TestMethod tMethod3 = new TestMethod(3);
		tMethod2 = tMethod3 = null;
		tMethod1 = null;
		System.gc();

//		char c;
//		String str;
//        // 使用 System.in 创建 BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("输入字符, 按下 'q' 键退出。");
//        // 读取字符
//        do {
//            c = (char) br.read();
//            str = br.readLine();
//            System.out.println(c);
//            System.out.println(str);
//        } while (!str.equals("end"));
//        BufferedReader rBufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(rBufferedReader.readLine());
		
		TestFile tf =new TestFile();
		tf.print();
		tf.print2();
		//tf.printDir("E:\\gitcode\\JMF\\gocron");
		TestException te = new TestException();
		te.ex();
		te.ex2();
		
	}
}