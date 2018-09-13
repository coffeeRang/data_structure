package doje.dh.map.myhashmap.day0913;


public class TestMyExtendsHashMapMain {
	
	public static void main(String[] args) {
		MyHashMapByDh<Integer, String> hashMap = new MyHashMapByDh<Integer, String>();
		
		// 0, 1, 2, 3
		for (int i = 0; i < 4; i++) {
			hashMap.put(i, "테스트"+i);
		}
		
		hashMap.put(1, "추가1");
//		hashMap.put(7, "추가2");
//		hashMap.put(10, "추가3");
		

		
	}

}
