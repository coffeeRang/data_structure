package doje.dh.map.myhashmap.day0914;

import java.util.HashMap;

public class TestMyExtendsHashMapMain {
	
	public static void main(String[] args) {
		MyHashMapByDh<Integer, String> hashMap = new MyHashMapByDh<Integer, String>();
		
		hashMap.put(0, "테스트0");
		hashMap.put(1, "테스트1");
		hashMap.put(2, "테스트2");
		hashMap.put(3, "테스트3");
		hashMap.put(4, "테스트4");
		hashMap.put(7, "테스트7");
		hashMap.put(10, "테스트10");

		
		System.out.println(">> get : " + hashMap.get(0));
		System.out.println(">> get : " + hashMap.get(1));
		System.out.println(">> get : " + hashMap.get(2));
		System.out.println(">> get : " + hashMap.get(3));
		

		System.out.println(hashMap.keySet());
		System.out.println(hashMap.entrySet());
		System.out.println(hashMap.values());

	}

}
