package doje.sy.list.day0828;

import java.util.LinkedList;
import java.util.List;

public class Main2 {
	 	public static void main(String args[]) {
		MyLinkedList list = new MyLinkedList();
		List<String> list2 = new LinkedList<String>();
		list2.add("테스트1");
		list2.add("테스트2");
		
		list.add("테스트1");
		list.add("테스트2");
		list.add("테스트3");
		list.add("테스트1");
		list.add("테스트2");
		list.add("테스트4");
		list.removeAll(list2);
		//System.out.println(list.lastIndexOf("테스트6"));
		//list.addAll(2,list2);
		//System.out.println(list.containsAll(list2));
		for(int i = 0; i<list.size(); i++) {
			
			System.out.println(i+","+list.get(i));
		}
		
	}

}
