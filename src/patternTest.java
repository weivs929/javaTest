import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * 正式表达式测试
 * @author jijw
 *
 */
public class patternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String patternStr = "[a-zA-Z0-9]{1,6}";
		Pattern p = Pattern.compile(patternStr);
		String code = "EMP_00";
		Matcher m = p.matcher(code);
		System.out.println(m.matches());
		if(m.matches()){
			System.out.println("匹配正确");
			System.out.println(m.group());
		} else{
			System.out.println("匹配错误");
		}
	
	}
	
	

}
