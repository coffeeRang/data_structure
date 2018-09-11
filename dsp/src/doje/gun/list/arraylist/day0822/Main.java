package doje.gun.list.arraylist.day0822;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		List<String> list2 = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
				list2.add("TEST" + (i + 1));
		}
		for (int i = 0; i < 15; i++) {
			list.add("TEST" + i);
		}
		System.out.println(list.containsAll(list2));
		// list.retainAll(list2);
		// list.removeAll(list2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ":" + list.get(i));
		}
		System.out.println("=========");
		System.out.println("size:" + list.size());
		System.out.println("=========");
	}
}
