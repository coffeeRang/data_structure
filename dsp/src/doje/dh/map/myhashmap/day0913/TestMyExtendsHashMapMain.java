package doje.dh.map.myhashmap.day0913;


public class TestMyExtendsHashMapMain {
	
	public static void main(String[] args) {
		MyHashMapByDh<Integer, String> hashMap = new MyHashMapByDh<Integer, String>();
		
		for (int i = 0; i < 4; i++) {
			System.out.println(i + "번째 put 결과 : " + hashMap.put(i, "테스트"+i));
		}

		hashMap.put(7, "추가2");
		hashMap.put(10, "추가3");
		
		for (int i = 0; i < 11; i++) {
			System.out.println(i + " : " + hashMap.get(i));
		}

	}

}
