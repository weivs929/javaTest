import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class grouplist {
	public static void main(String[] args) {
		List<Map<String,Object>> listor = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("id", "code111");
		map1.put("name", "code111name01");
		
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("id", "code111");
		map2.put("name", "code111name02");
		
		Map<String,Object> map3 = new HashMap<String, Object>();
		map3.put("id", "code111");
		map3.put("name", "code111name02");
		
		Map<String,Object> map4 = new HashMap<String, Object>();
		map4.put("id", "code112");
		map4.put("name", "code112name01");
		
		Map<String,Object> map5 = new HashMap<String, Object>();
		map5.put("id", "code112");
		map5.put("name", "code112name02");
		
		Map<String,Object> map6 = new HashMap<String, Object>();
		map6.put("id", "code113");
		map6.put("name", "code113name01");
		
		Map<String,Object> map7 = new HashMap<String, Object>();
		map7.put("id", "code114");
		map7.put("name", "code114name01");
		
		Map<String,Object> map8 = new HashMap<String, Object>();
		map8.put("id", "code114");
		map8.put("name", "code114name02");
		
		Map<String,Object> map9 = new HashMap<String, Object>();
		map9.put("id", "code111");
		map9.put("name", "code111name04");
		
		listor.add(map1);
		listor.add(map2);
		listor.add(map3);
		listor.add(map4);
		listor.add(map5);
		listor.add(map6);
		listor.add(map7);
		listor.add(map8);
		listor.add(map9);
		
		grouplist test = new grouplist();
		
		
		test.getSameArrayList(listor);
		println(test.getRetList());
	}

	private static void println(List<List<Map<String,Object>>> retList2) {
		for (List<Map<String,Object>> listItem : retList2) {
			System.out.print("list : ");
			for (Map<String,Object> item : listItem) {
				System.out.print(item);
				System.out.print(",");
			}
			System.out.println("");
		}
	}


	List<List<Map<String,Object>>> retList = new ArrayList<List<Map<String,Object>>>();
	/**
	 * 根据billCode对发货单据接口表的数据进行分组
	 * @param arrayList
	 * @return
	 */
	public void getSameArrayList(List<Map<String,Object>> arrayList) {
		
		List<Map<String,Object>> sameList = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> diffList = new ArrayList<Map<String,Object>>();
		sameList.add(arrayList.get(0));
		for (int i = 1, len = arrayList.size(); i < len; i++) {
			if (arrayList.get(i).get("id") == sameList.get(0).get("id")) {
				sameList.add(arrayList.get(i));
			} else {
				diffList.add(arrayList.get(i));
			}
		}
		retList.add(sameList);
		if (!diffList.isEmpty()) {
			getSameArrayList(diffList);
		}
	}

	public List<List<Map<String,Object>>> getRetList() {
		return retList;
	}
}