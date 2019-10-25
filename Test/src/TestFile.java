import java.io.*;

import com.sun.org.apache.xpath.internal.functions.FunctionDef1Arg;
import com.sun.tools.classfile.Annotation.element_value;

import sun.jvm.hotspot.debugger.win32.coff.DataDirectory;


public class TestFile {
	public void print() {
		try {

			byte bwrite[] = { 11, 21, 3, 40, 5 };
			OutputStream os = new FileOutputStream("test.txt");
			for (int i = 0; i < bwrite.length; i++) {
				os.write(bwrite[i]);
			}

			os.close();

			InputStream is = new FileInputStream("test.txt");
			int size = is.available();

			for (int i = 0; i < size; i++) {
				System.out.printf("%d\t", is.read());
			}
			is.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Exception");
		}

	}

	public void print2() {
		try {
		 File f = new File("a.txt");
		 
		 FileOutputStream fop= new FileOutputStream(f);
		 
		 OutputStreamWriter writer=new OutputStreamWriter(fop,"utf-8");
		 
		 writer.append("中文输入");
		 
		 writer.append("\r\n");
		 
		 writer.append("English");
		 
		 writer.close();
		 
		 fop.close();
		 
		 FileInputStream fip = new FileInputStream(f);
		 
		 InputStreamReader reader = new InputStreamReader(fip);
		 
		 StringBuffer sb = new StringBuffer();
		 
		 while(reader.ready()) {
			 sb.append((char)reader.read());
		 }
		 System.out.println("===============");
		 System.out.println(sb.toString());
		 reader.close();
		 fip.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Exception");
		}
	}
	
	public void printDir(String dir) {
		File f = new File(dir);
		if (f.isDirectory()) {
			System.out.println("目录 "+dir);
			String s[]= f.list();
			for(int i=0;i<s.length;i++) {
				File f1 = new File(dir+"/"+s[i]);
				if (f1.isDirectory()) {
					System.out.println(dir+"\\"+s[i] + " 是一个目录");
					this.printDir(f1.toString());
				}else {
					System.out.println(dir+"\\"+s[i] + " 是一个文件");
				}
			}
		}else {
			System.out.println(dir + " 不是一个目录");
		}
	}
}
