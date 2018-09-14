package doje.dh.map.myhashmap.day0914;


public class TestMyExtendsHashMapMain {
	
	public static void main(String[] args) {
		MyHashMapByDh<Integer, String> hashMap = new MyHashMapByDh<Integer, String>();
		
//		for (int i = 0; i < 3; i++) {
//			System.out.println(i + "번째 put 결과 : " + hashMap.put(i, "테스트"+i));
//		}
//
////		hashMap.put(7, "추가2");
////		hashMap.put(10, "추가3");
//		
//		for (int i = 0; i < 11; i++) {
//			System.out.println(i + " : " + hashMap.get(i));
//		}
		
		
		System.out.println("실행결과 : " + hashMap.put(1, "테스트1"));

//		System.out.println("실행결과 : " + hashMap.put(2, "테스트2"));
		
		System.out.println(">> get : " + hashMap.get(1));
		System.out.println(">> findIndexByKey : " + hashMap.findIndexByKey(1));
		System.out.println(">> findIndexByIndex : " + hashMap.getEntryByIndex(0));
//		System.out.println(hashMap.keySet());
		

	}

}
