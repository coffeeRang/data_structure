package day0823;

import java.util.ArrayList;
import java.util.List;

public class TestMainByDh {
	
	public static void main(String[] args) {
		
		TestMyArrayListByDh originList = new TestMyArrayListByDh();
		
		// add 테스트
		originList.add("111");
		originList.add("222");
//		tList.add(3, "333");
		
		System.out.print(">> 기존 값들 : ");
		for (int i = 0; i < originList.size(); i++ ) {
			System.out.print("[" + i + ":" + originList.get(i) + "] ");
		}
			
		// addAll 테스트
		List<String> list1 = new ArrayList<String>();
//		for (int i = 0; i < 3; i ++) {
//			list1.add("string" + i);
//		}
		list1.add("111");
		list1.add("222");
		list1.add("333");
//		list1.add("333");
		
		System.out.print("\n>> 입력할 값들 : ");
		for (int i = 0; i < list1.size(); i ++) {
			System.out.print("["+i + ":" + list1.get(i) + "] ");
		}
		System.out.println();
		
		// 테스트 항목
//		originList.addAll(0, list1);
//		originList.clear();
//		System.out.println(originList.contains(null));
//		System.out.println(originList.containsAll(list1));
//		System.out.println(originList.indexOf("112"));
//		System.out.println(originList.isEmpty());
//		System.out.println(originList.lastIndexOf("111"));
		System.out.println(originList.remove(1));
		
		
		
		System.out.println();
		System.out.println(">> 결과 : ");
		for (int i = 0; i < originList.size(); i++ ) {
			System.out.print(i + " : " + originList.get(i) + " | ");
		}
		System.out.println("");
	}

}
