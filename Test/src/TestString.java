
public class TestString {
	public void print() {
		System.out.println("===============string class================");	
		String str1="abldldldladfd";
		char []arr= {'f','d','a','d','d','a','d'};
		String  str2 ="";
		String str3= str2.copyValueOf(arr,2,3);
		System.out.println(str3);	
		
		
		//StringBuffer sBuffer = new StringBuffer("aaabbbccc");
		StringBuilder sBuffer = new StringBuilder("aaabbbccc");
		System.out.println(sBuffer.capacity());
		sBuffer.append(".1111");
		sBuffer.append(".2222");
		System.out.println(sBuffer);
		System.out.println(sBuffer.capacity());
		sBuffer.reverse();
		System.out.println(sBuffer);
		sBuffer.delete(0, 4);
		System.out.println(sBuffer);
		
		sBuffer.replace(0, 5, "333");		
		System.out.println(sBuffer);
		
		sBuffer.reverse();
		System.out.println(sBuffer);
		
		System.out.println(sBuffer.capacity());
	}
}
