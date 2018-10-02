package doje.dh.map.treemap.day0927;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapMain {

	public static void main(String[] args) {
		
		MyTreeMap<Integer, String> mMap = new MyTreeMap<Integer, String>();
//		for (int i = 0; i < 5; i++ ) {
//			mMap.put(i,  "테스트"+i);
//		}
//		System.out.println(">>>>>> size : " + mMap.size());
//		
//		
//		for (int i = 0; i < 5; i++ ) {
//			System.out.println(i + " : " + mMap.get(i));
//		}

//		mMap.put(1,  "테스트1");
//		mMap.put(3,  "테스트3");
//		mMap.put(0,  "테스트0");
//		mMap.put(2,  "테스트2");		
//		System.out.println("조회결과 : " + mMap.get(1));
//		System.out.println("조회결과 : " + mMap.get(3));
//		System.out.println("조회결과 : " + mMap.get(0));
//		System.out.println("조회결과 : " + mMap.get(2));
		
		
//		System.out.println(mMap.put(1,  "테스트1"));
//		System.out.println(mMap.put(3,  "테스트3"));
//		System.out.println(mMap.put(0,  "테스트0"));
//		System.out.println(mMap.put(2,  "테스트2"));

		
		System.out.println(mMap.put(1,  "테스트1"));
		System.out.println(mMap.put(5,  "테스트5"));
		System.out.println("조회결과 : " + mMap.get(1));
		System.out.println("조회결과 : " + mMap.get(5));
		
		System.out.println("=================================");
		System.out.println(mMap.put(1, "change!!!"));
		System.out.println("조회결과 : " + mMap.get(1));
		System.out.println("조회결과 : " + mMap.get(5));
		System.out.println(mMap.remove(5));
		System.out.println("조회결과 : " + mMap.get(5));
		
		TreeMap tMap = new TreeMap();
		
		
//		mMap.put(3,  "테스트3");
//		mMap.put(7,  "테스트7");
//		mMap.put(0,  "테스트0");
//		mMap.put(0,  "change1");
//		System.out.println("조회결과 : " + mMap.get(1));
//		System.out.println("조회결과 : " + mMap.get(5));
//		System.out.println("조회결과 : " + mMap.get(3));
//		System.out.println("조회결과 : " + mMap.get(7));
//		System.out.println("조회결과 : " + mMap.get(0));
//		System.out.println(mMap.size());
//		System.out.println(mMap.containsKey(0));
//		System.out.println(mMap.containsValue("test1"));
//		System.out.println(mMap.containsValue("change1"));
//		System.out.println(mMap.isEmpty());
//		System.out.println(mMap.keySet());
		
		


		
	}

}
