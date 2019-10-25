import java.io.*;
 
public class Employee {
    //salary收入
    private static double salary;
    private double ff;
	
    // DEPARTMENT
    public static final String DEPARTMENT = "收入";
    public  double print(double a ){
    	System.out.println("===============Employee class================");	
    	salary = a;
    	double ff=a;
        System.out.println(DEPARTMENT+":"+salary);
        return ff;
    }
       
}