package doje.gun.map.hashmap.day0912;

public class Main {

	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();
		map.put(0, "김건0");
		map.put(1, "김건1");
		map.put(2, "김건2");
		map.put(4, "김건4");
		map.put(7, "김건7");
		map.put(10, "김건10");
		map.put(13, "김건13");

		

		
		for (int i = 0; i < 15; i++) {
			System.out.println(map.get(i));
		}
		
		System.out.println(map.containsKey(1));
		
		
		System.out.println(map.keySet());
		
		System.out.println(map.entrySet());

	}
}
