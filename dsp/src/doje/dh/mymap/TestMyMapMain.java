package doje.dh.mymap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMyMapMain {
	
	public static void main(String[] args) {
//		MyMapByDh myMap = new MyMapByDh();	// String 만 받는 Map
		MyGenericMapByDh<String, String> myMap = new MyGenericMapByDh<String, String>("0", "테스트0");
		System.out.println(">> myMap.put 결과: " + myMap.put("1", "테스트1"));
		myMap.put("2", "테스트2");
//		System.out.println(myMap.size());
		
		Set<String> set = myMap.keySet();
		System.out.println(">> map key 목록 : " + set);
		
		for (int i = 0; i < myMap.size(); i++) {
			String key = i+"";
			System.out.println(">> value : " + myMap.get(key));
		}
		System.out.println(">> size : " + myMap.size());
			
		
		System.out.println("============ 삭제 후 =====================");
		myMap.remove("0");
		
		for (int i = 0; i < myMap.size(); i++) {
			String key = i+"";
//			System.out.println(">> value : " + myMap.get(key));
		} 
		
//		System.out.println(">> value : " + myMap.get("0"));
		System.out.println(">> value : " + myMap.get("1"));
		System.out.println(">> value : " + myMap.get("2"));
		System.out.println(">> size : " + myMap.size());
		
//		myMap.clear();
//		System.out.println(myMap.isEmpty());
		
		Map<String, String> tMap = new HashMap<String, String>();
		tMap.put("a", "추가1");
		tMap.put("1", "추가2");
//		tMap.put("2", "추가3");
//		
		myMap.putAll(tMap);
		
		Set<String> keys = myMap.keySet();
		for (String key: keys) {
//			System.out.println(">> key : " + key + ", value : " + myMap.get(key));
		}
		System.out.println(myMap.entrySet());
		
		
		Map<String, String> originMap = new HashMap<String, String>();
		originMap.put("1", "origin1");
		originMap.put("2", "origin2");
		originMap.put("3", "origin3");
		System.out.println(originMap.values());
//		System.out.println(originMap.entrySet());

//		Map<String, String> tMap = new HashMap<String, String>();
//		tMap.put("1", "추가1");
//		tMap.put("2", "추가2");
//		tMap.put("a", "추가3");
//		
//		originMap.putAll(tMap);
//		
//		Set<String> keySet = originMap.keySet();
//		
//		for (String key: keySet) {
//			System.out.println(">> key : " + key + ", value : " + originMap.get(key));
//		}
		
		
		

		
		// MyArrayList remove 이상함 다시 확인하기
//		for (int i = 0; i < 4; i++) {
//			System.out.println(mList.get(i));
//			
//		}
//		System.out.println("================ 삭제후 ======================");
//		mList.remove(0);
//		
//		for (int i = 0; i < mList.size(); i++ ) {
//			System.out.println(i);
//			
//		}
		
	}

}
