import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class bol {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		boolean isSaleProPrm = false;
//		boolean isJointProPrm = false;
//		
//		boolean byProPrm = isSaleProPrm || isJointProPrm;
//		
//		System.out.println(byProPrm);
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("5");
		list1.add("6");
		list1.add("7");
		list1.add("8");
		list1.add("9");
		list1.add("10");
		System.out.println(list1);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("5");
		list2.add("8");
		list2.add("3");
		System.out.println(list2);
		
		list1.removeAll(list2);
		System.out.println(list1.size());
		System.out.println(list1);
		
		
		System.out.println(1 + 1 ==1 );
		
		Map map = new HashMap();
		map.put("test", "test");
		System.out.println(map);
		map.put("test", "test111");
		System.out.println(map);
	}

}
