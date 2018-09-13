package doje.dh.map.myhashmap.day0911;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Map;

public class TestMyHashMapMain {
	
	public static void main(String[] args) {
		int size = 3;

		MyHashMapByDh<Integer, String> myHashMap = new MyHashMapByDh<Integer, String>(size);
		System.out.println("========== 더하기 시작 ================");
		for (int i = 0; i < 4; i++) {
			myHashMap.put(i, "테스트"+i);	// 0, 1, 2, 3	
		}
		// 4, 5, 6, 7, 8, 
		myHashMap.put(4, "추가1");
		myHashMap.put(9, "추가2");
		System.out.println(myHashMap.get(4));
		System.out.println(myHashMap.get(9));
		

		System.out.println("========== 더하기 완료 ================\n");
		
//		for (int i = 0 ; i < 6; i ++) {
//			System.out.println("key값 : " +i + "	| 존재여부 : " + myHashMap.containsKey(i) + "	| value : " +  myHashMap.get(i));
//		}
		
		
		System.out.println(myHashMap.entrySet());
		

		

		
		

		
	}

}
