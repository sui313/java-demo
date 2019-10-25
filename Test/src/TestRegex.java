import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TestRegex {
	
	public void phoneNum(String str) {
		System.out.println("----------------------------------------------");
		String regString = "\\d+";
		
		//String regString = "((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}";
		
		Pattern r = Pattern.compile(regString);
		Matcher m = r.matcher(str);
		
		if (m.find()) {
			System.out.println("找到号码:"+m.group(0));
		}else {
			System.out.println("没找到号码："+str);
		}
		
		Pattern p = Pattern.compile(regString);
        Matcher m2 = p.matcher(str);
        boolean isMatch = m2.matches();
       
        if (!isMatch) {
        	System.out.println("请填入正确的手机号");
        }else {
        	System.out.println("找到了");
		}
        
        PatternSyntaxException pp = new PatternSyntaxException(str,regString,0);
        System.out.println("找到了"+ pp.getIndex());
        System.out.println("找到了"+ pp.getDescription());
        System.out.println("找到了"+ pp.getMessage());
	}
}
