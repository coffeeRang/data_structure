package doje.gun.list.day0828;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		List<String> list2 = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			list.add(""+1);
		}
		list2.add("1");
//		for (int i = 0; i < 3; i++) {
//			list2.add("테스트 값입니다" + i);
//		}
		list.removeAll(list2);

		System.out.println("list2값들 ======");
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + "," + list2.get(i));
		}
		System.out.println("list값들 ======");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "," + list.get(i));
		}
	}
}