package doje.dh.map.mymap.day0911;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import doje.gun.map.day0910.MyMap;

public class TestMyMapMain {
	
	public static void main(String[] args) {
		MyMap<Integer, String> myMap = new MyMap<Integer, String>();
		
		for (int i = 0; i < 3; i ++) {
			myMap.put(i, "테스트"+i);
		}
		
		System.out.println("=============== 수정 전 ====================");
		for (int i = 0 ; i < 6; i ++) {			
			System.out.println("key값 : " +i + "	| 존재여부 : " + myMap.containsKey(i) + "	| value : " +  myMap.get(i));
		}

		myMap.put(4, "추가데이터1");
//		myMap.clear();
		System.out.println("=============== 수정 이후 ====================");
		for (int i = 0 ; i < 6; i ++) {
			System.out.println("key값 : " +i + "	| 존재여부 : " + myMap.containsKey(i) + "	| value : " +  myMap.get(i));
		}
//		myMap.clear();
//		System.out.println(myMap.isEmpty());
//		System.out.println(myMap.keySet());
//		System.out.println(myMap.entrySet());
		System.out.println(myMap.values().get(0));
		
		
//		Map<String, String> originMap = new HashMap<String, String>();
//		originMap.put("1", "origin1");
//		originMap.put("2", "origin2");
//		originMap.put("3", "origin3");
//		System.out.println(originMap.values());
		
	}

}
