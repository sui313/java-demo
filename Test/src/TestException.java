import java.io.*;
public class TestException {
	public  void ex(){
	      try{
	         int a[] = new int[2];
	         System.out.println("Access element three :" + a[3]);
	      }catch(ArrayIndexOutOfBoundsException e){
	         System.out.println("Exception thrown  :" + e);
	      }
	      System.out.println("Out of the block");
	   }
	public void ex2() {
		try {
			int a[] = new int[2];
	         System.out.println("Access element three :" + a[3]);
		} catch (Exception e) {
			// TODO: handle exception
			 System.out.println("Exception thrown  :" + e);
			 StackTraceElement stackTraceElement= e.getStackTrace()[0];
			 System.out.println("stackTraceElement  :" + stackTraceElement);
			 System.out.println("line  :" + stackTraceElement.getLineNumber());
			 System.out.println("method  :" + stackTraceElement.getMethodName());
			 System.out.println("getFileName  :" + stackTraceElement.getFileName());
			 
		}
		 
	}
}
