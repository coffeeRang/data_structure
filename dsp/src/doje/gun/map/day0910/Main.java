package doje.gun.map.day0910;

public class Main {

	public static void main(String[] args) {
		MyMap<Integer, String> map = new MyMap<Integer, String>();
//		map.put("김건 학번", 31405);
//		map.put("남상엽 학번", 31408);
//		
//		map.put("남상엽 학번", 21408);
		map.put(31405, "남상엽");
		map.put(31405, "김건");
		map.put(31408, "남상엽");
		System.out.println(map.containsKey(31405));
		System.out.println(map.containsValue("남상엽"));
//		map.clear();
		map.remove(31408);
		System.out.println(map.get(31405));
		System.out.println(map.get(31408));
	}

}
