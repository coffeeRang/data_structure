package doje.gun.map.hashmap.day0916;

public class Main {

	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();
		
		System.out.println(map.put(31401, "김건1"));
		System.out.println(map.put(31402, "김건2"));
		System.out.println(map.size());
		System.out.println(map.keySet());
		System.out.println(map.entrySet());
		
		System.out.println(map.containsKey(31401));
		System.out.println(map.containsValue("김건1"));
		
		
		
//		System.out.println(map.keySet());
//		map.put(31402, "김건2");
//		map.put(31404, "김건3");
//		map.put(31405, "김건4");
//		map.put(31406, "김건5");
//		map.put(31407, "김건6");
//		map.put(31408, "김건7");
//		map.put(31409, "김건8");
		//		map.put(31410, "김건9");
		//		map.test();
//		System.out.println(map.get(31405));
//		System.out.println(map.containsKey(31405));
//		System.out.println(map.entrySet());
	}
}