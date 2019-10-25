import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintDate {
	
	public void print() {
		System.out.println("===============date class================");	
		Date date = new Date();
		System.out.println(date);
		Long time=date.getTime();
		System.out.println(time);
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss z"); // hh:mm:ss
		System.out.println(ft.format(date));
		
		SimpleDateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
		System.out.println(ft2.format(date));
		
		 //c的使用  
	    System.out.printf("全部日期和时间信息：%tc%n",date);          
	    //f的使用  
	    System.out.printf("年-月-日格式：%tF%n",date);  
	    //d的使用  
	    System.out.printf("月/日/年格式：%tD%n",date);  
	    //r的使用  
	    System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);  
	    //t的使用  
	    System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);  
	    //R的使用  
	    System.out.printf("HH:MM格式（24时制）：%tR",date);  
	}
}
