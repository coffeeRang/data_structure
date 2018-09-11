package doje.gun.list.ringlinkedlist.day0904;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		MyRingLinkedList list = new MyRingLinkedList();
		List<String> list2 = new ArrayList<String>();

		list.add("테스트1");
		list.add("테스트2");
		list.add("테스트3");
		list.add("테스트4");
		
		for (int i = 0; i < 3; i ++) {
			list2.add("항목" + i);
		}
		
		list.addAll(2, list2);
		
		list.addAll(list2);
		
//		list.removeAll(list2);
		
		list.remove(9);


		for (int i = 0; i < list.size(); i++) {
			System.out.println("[" + i + "]:" + list.get(i));
		}
	}
}