package doje.dh.map.myhashmap.day0911;

public class TestMyHashMapMain {
	
	public static void main(String[] args) {
		int size = 3;
//		MyHashMapByDh<String, String> myHashMap = new MyHashMapByDh<String, String>(size);
		MyHashMapByDh<Integer, String> myHashMap = new MyHashMapByDh<Integer, String>(size);
		System.out.println("========== 더하기 시작 ================");
		myHashMap.put(1, "테스트1");
		myHashMap.put(2, "테스트2");
		myHashMap.put(3, "테스트3");
//		System.out.println(myHashMap.put(4, "테스트4");
		myHashMap.put(1, "cahnge1");
		System.out.println("========== 더하기 완료 ================");
		
		System.out.println(myHashMap.get(1));
		System.out.println(myHashMap.get(2));
		System.out.println(myHashMap.get(3));

		System.out.println("========= 기타기능 테스트 ===============");
//		System.out.println(myHashMap.containsKey("테스트2"));
		
		

		
		

		
	
		
		
		
//		MyMap<Integer, String> myMap = new MyMap<Integer, String>();
//		
//		for (int i = 0; i < 3; i ++) {
//			myMap.put(i, "테스트"+i);
//		}
//		
//		System.out.println("=============== 수정 전 ====================");
//		for (int i = 0 ; i < 6; i ++) {			
//			System.out.println("key값 : " +i + "	| 존재여부 : " + myMap.containsKey(i) + "	| value : " +  myMap.get(i));
//		}
//
//		myMap.put(4, "추가데이터1");
////		myMap.clear();
//		System.out.println("=============== 수정 이후 ====================");
//		for (int i = 0 ; i < 6; i ++) {
//			System.out.println("key값 : " +i + "	| 존재여부 : " + myMap.containsKey(i) + "	| value : " +  myMap.get(i));
//		}
//
//		System.out.println(myMap.isEmpty());
//		System.out.println(myMap.keySet());
//		System.out.println(myMap.entrySet());
//		System.out.println(myMap.values());
		

		
	}

}
