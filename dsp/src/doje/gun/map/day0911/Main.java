package doje.gun.map.day0911;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		MyMap<Integer, String> map = new MyMap<Integer, String>();
		map.put(31405, "김건");
//		map.remove(31405);
		System.out.println(map.containsValue("김건"));
		
		System.out.println(map.get(31405));
	}
}
