package doje.dh.map.treemap.day0927;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapMain {

	public static void main(String[] args) {
//		MyTreeMap<Integer, String, String> mTreeMap = new MyTreeMap<Integer, String, String>();
//		
//		for (int i = 0; i < 4; i++) {
//			mTreeMap.put(i, "테스트"+i);
//		}
//		mTreeMap.put(1, "덮어쓰기1");
//		System.out.println(mTreeMap.entrySet());
//		System.out.println(mTreeMap.values());
//		
//		Map<Integer, String> tMap = new TreeMap<Integer, String>();
//		
//		for (int i = 0; i < 4; i++) {
//			tMap.put(i, "TreeMap"+i);
//		}
//		
//		tMap.co
		
		MyTreeMap<Integer, String> mMap = new MyTreeMap<Integer, String>();
		for (int i = 0; i < 5; i++ ) {
//			System.out.println(mMap.put(i, "테스트"+i));
			mMap.put(i,  "테스트"+i);
		}
		System.out.println(">>>>>> size : " + mMap.size());
		
		for (int i = 0; i < 5; i++ ) {
			System.out.println(i + " : " + mMap.get(i));
		}
		
		
		
		

		
	}

}
