package day0823;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		 MyArrayList list = new MyArrayList();
		 for (int i = 0; i < 10; i++) {
		 list.add("TEST"+i);
		 }
		 List<String> list2 = new ArrayList<String>();
		
		 for (int i = 0; i < 5; i++) {
		 list2.add("TEST"+i);
		 }
		 list2.add("TEST"+8);
		 
		 list.removeAll(list2);
//		 list.retainAll(list2);
		 for (int i = 0; i < list.size(); i++) {
		 System.out.println(list.get(i));
		 }

//		List<String> list = new ArrayList<String>();
//
//		for (int i = 0; i < 10; i++) {
//			list.add("TEST" + i);
//		}
//
//		List<String> list2 = new ArrayList<String>();
//
//		for (int i = 0; i < 5; i++) {
//			list2.add("TEST" + i);
//		}
//		for(int i = 0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
	}
}
