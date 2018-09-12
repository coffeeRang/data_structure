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
			myHashMap.put(i, "테스트"+i);	
		}
		

		System.out.println("========== 더하기 완료 ================\n");
		
		for (int i = 0 ; i < 6; i ++) {
			System.out.println("key값 : " +i + "	| 존재여부 : " + myHashMap.containsKey(i) + "	| value : " +  myHashMap.get(i));
		}
		
		
		System.out.println(myHashMap.entrySet());
		

		

		
		

		
	}

}
