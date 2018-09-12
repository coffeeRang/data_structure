package doje.gun.map.hashmap.day0911;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();
		System.out.println(map.put(31401, "김건1"));
//		System.out.println(map.get("31401"));
		
		System.out.println(map.entrySet());


		//		map.test();
//		System.out.println(map.get(31402));
//		System.out.println(map.keySet());
//		System.out.println(map.entrySet());
	}
}
