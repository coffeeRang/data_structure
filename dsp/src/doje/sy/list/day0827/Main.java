package doje.sy.list.day0827;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//MyArrayList3<Integer> list = new MyArrayList3<Integer>(); //형태는 integer
		//List<String> list2 = new ArrayList<String>();
		List<Integer> list2 = new ArrayList<Integer>();
		//MyArrayList list = new MyArrayList();
		MyArrayList_Integer list = new MyArrayList_Integer(); //int로 잡음
		
		list2.add(3); 
		list2.add(101);
		list2.add(103);
//	try {
		list.add(3);
		list.add(100);
		list.add(101);
		list.add(102);
		list.add(103);
		list.add(3);     
		//list.add(0, 8); ㅇ
		//list.addAll(0, list2);
		//list.addAll(list2);ㅇ 
		//list.clear(); ㅇ
		//System.out.println(list.contains(2));  //MyArrayList1 2 3 전부 콘테인스를 다시 봐보자 다음시간.
		//System.out.println(list.containsAll(list2));
		//System.out.println(list.indexOf(3));
		//list.indexOf(3);
		//list.removeAll(list2);ㅇ
		//list.set(1, 6); ㅇ
		
		for(int i = 0;i<list.size();i++) {
			System.out.println("index값:" + i +" ,"+list.get(i));
		}

//		} catch (Exception e) {
//			
//			System.out.println(e.toString());
//		}

	}


}
